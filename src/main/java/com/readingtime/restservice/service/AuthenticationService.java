package com.readingtime.restservice.service;

import com.readingtime.restservice.controller.request_response.AuthenticationRequest;
import com.readingtime.restservice.controller.request_response.AuthenticationResponse;
import com.readingtime.restservice.controller.request_response.RefreshRequest;
import com.readingtime.restservice.controller.request_response.RegisterRequest;


public interface AuthenticationService {


    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    AuthenticationResponse refresh(RefreshRequest request);

}
