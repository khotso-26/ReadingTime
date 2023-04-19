package com.readingtime.restservice.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {

    private final String message;
    private final HttpStatus httpstatus;
    private final ZonedDateTime zonedDateTime;

    public ApiException(String message, HttpStatus httpstatus, ZonedDateTime zonedDateTime) {
        this.message = message;
        this.httpstatus = httpstatus;
        this.zonedDateTime = zonedDateTime;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpstatus() {
        return httpstatus;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

}
