package com.readingtime.restservice.service;

import com.readingtime.restservice.controller.request_response.AuthenticationRequest;
import com.readingtime.restservice.controller.request_response.AuthenticationResponse;
import com.readingtime.restservice.controller.request_response.RefreshRequest;
import com.readingtime.restservice.controller.request_response.RegisterRequest;
import com.readingtime.restservice.model.user.Role;
import com.readingtime.restservice.model.user.User;
import com.readingtime.restservice.repository.UserRepository;
import com.readingtime.restservice.service.request_response.CustomResponse;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImplement implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public CustomResponse register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email address already registered");
        }

        User user = buildUserFromRequest(request);
        userRepository.save(user);

        return CustomResponse.builder()
                .message("User registered successfully.")
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        user.setActive(true);
        userRepository.save(user);

        String accessToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        return AuthenticationResponse.builder()
                .AccessToken(accessToken)
                .RefreshToken(refreshToken)
                .build();
    }

    @Override
    public AuthenticationResponse reauthenticate(AuthenticationRequest request) {
        String userEmail = request.getEmail();
        String userPassword = request.getPassword();

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!passwordEncoder.matches(userPassword, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String newAccessToken = jwtService.generateToken(user);
        String newRefreshToken = jwtService.generateRefreshToken(user);

        return AuthenticationResponse.builder()
                .AccessToken(newAccessToken)
                .RefreshToken(newRefreshToken)
                .build();
    }

    @Override
    public AuthenticationResponse refresh(RefreshRequest request) {
        String refreshToken = request.getRefreshToken();

        Claims claims;
        try {
            claims = jwtService.parseToken(refreshToken);
        } catch (Exception e) {
            throw new RuntimeException("Invalid refresh token", e);
        }

        Date expirationDate = claims.getExpiration();
        Date currentDate = new Date();
        if (expirationDate.before(currentDate)) {
            throw new RuntimeException("Refresh token has expired");
        }

        String username = claims.getSubject();
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!user.isActive()) {
            throw new RuntimeException("User is not in an allowed state to refresh tokens");
        }

        String newAccessToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .AccessToken(newAccessToken)
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
}

