package com.readingtime.restservice.model;

import java.util.List;

import static java.lang.Math.*;

public class Calculator {

    private String wordCount[];
    private String seconds;
    private String minutes;

    public Calculator( String[] words) {

        this.wordCount = String.valueOf(words.length/200d).split("\\.");
        this.seconds = String.valueOf(Integer.parseInt(wordCount[1]) * 60).substring(0,2);
        this.minutes = wordCount[0];
    }

    public String getSeconds() {
        if (Integer.parseInt(seconds) > 50)
            this.minutes = String.valueOf(Integer.parseInt(minutes) + 1);
        return this.seconds;
    }

    public String getMinutes() {
        return this.minutes;
    }


}
