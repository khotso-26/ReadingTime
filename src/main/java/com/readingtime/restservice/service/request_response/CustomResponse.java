package com.readingtime.restservice.service.request_response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomResponse {
    private final String message;
}
