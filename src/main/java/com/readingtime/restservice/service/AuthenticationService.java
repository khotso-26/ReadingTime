package com.readingtime.restservice.service;

import com.readingtime.restservice.controller.AuthenticationRequest;
import com.readingtime.restservice.controller.AuthenticationResponse;
import com.readingtime.restservice.controller.RegisterRequest;


public interface AuthenticationService {


    public AuthenticationResponse register(RegisterRequest request);

    public AuthenticationResponse authenticate(AuthenticationRequest request);

    public AuthenticationResponse refresh(RegisterRequest request);

}
