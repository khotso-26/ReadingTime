package com.readingtime.restservice.service;
import com.readingtime.restservice.controller.request_response.AuthenticationRequest;
import com.readingtime.restservice.controller.request_response.AuthenticationResponse;
import com.readingtime.restservice.controller.request_response.RefreshRequest;
import com.readingtime.restservice.controller.request_response.RegisterRequest;
import com.readingtime.restservice.model.user.Role;
import com.readingtime.restservice.model.user.User;
import com.readingtime.restservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImplement implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        User user = buildUserFromRequest(request);
        userRepository.save(user);

        String accessToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        return AuthenticationResponse.builder()
                .AccessToken(accessToken)
                .RefreshToken(refreshToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String accessToken = jwtService.generateToken(user);
        return buildAuthenticationResponse(accessToken);
    }

    @Override
    public AuthenticationResponse refresh(RefreshRequest request) {
        String username = jwtService.extractUsername(request.getRefreshToken());
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String newRefreshToken = jwtService.generateRefreshToken(user);

        return AuthenticationResponse.builder()
                .AccessToken(newRefreshToken)
                .build();
    }



    private User buildUserFromRequest(RegisterRequest request) {
        return User.builder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
    }

    private AuthenticationResponse buildAuthenticationResponse(String accessToken) {
        return AuthenticationResponse.builder()
                .AccessToken(accessToken)
                .build();
    }
}
