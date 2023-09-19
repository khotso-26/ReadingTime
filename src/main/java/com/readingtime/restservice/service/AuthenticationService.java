package com.readingtime.restservice.service;

import com.readingtime.restservice.controller.request_response.AuthenticationRequest;
import com.readingtime.restservice.controller.request_response.AuthenticationResponse;
import com.readingtime.restservice.controller.request_response.RefreshRequest;
import com.readingtime.restservice.controller.request_response.RegisterRequest;
import com.readingtime.restservice.service.request_response.CustomResponse;


public interface AuthenticationService {


    CustomResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    AuthenticationResponse reauthenticate(AuthenticationRequest request);

    AuthenticationResponse refresh(RefreshRequest request);

}
