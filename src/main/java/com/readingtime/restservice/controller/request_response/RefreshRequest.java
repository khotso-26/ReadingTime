package com.readingtime.restservice.controller.request_response;

import lombok.Getter;

@Getter
public class RefreshRequest {
    private String refreshToken;

    public RefreshRequest() {}

    public RefreshRequest(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
