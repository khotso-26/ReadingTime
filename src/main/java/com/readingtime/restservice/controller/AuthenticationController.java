package com.readingtime.restservice.controller;

import com.readingtime.restservice.controller.request_response.AuthenticationRequest;
import com.readingtime.restservice.controller.request_response.AuthenticationResponse;
import com.readingtime.restservice.controller.request_response.RefreshRequest;
import com.readingtime.restservice.controller.request_response.RegisterRequest;
import com.readingtime.restservice.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api.readingtime/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        AuthenticationResponse response = service.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity <AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        AuthenticationResponse response = service.authenticate(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<AuthenticationResponse> refreshToken(@RequestBody RefreshRequest request) {
        AuthenticationResponse response = service.refresh(request);
        return ResponseEntity.ok(response);
    }
}
