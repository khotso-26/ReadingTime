package com.readingtime.restservice.service.request_response;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ReadingTimeResponse {

    private int minutes;
    private int seconds;
    private int id;


    public ReadingTimeResponse(int id, int minutes, int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
        this.id = id;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
    public void setid(int id) { this.id = id; }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
