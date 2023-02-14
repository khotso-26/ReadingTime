package com.readingtime.restservice.model;

import java.util.List;

import static java.lang.Math.*;

public class Calculator {

    private String wordCount[];
    private String seconds;
    private String minutes;

    public String getMinutes() {
        return minutes;
    }

    private int totalReadingTime;

    public Calculator() {
    }

    public Calculator( List<String> words) {

        this.wordCount = String.valueOf(words.size()/200d).split("\\.");
        this.seconds = String.valueOf(Integer.parseInt(wordCount[1]) * 60).substring(0,2);
        this.minutes = wordCount[0];
        calculateTotalReadingTime();
    }

    public String getSeconds() {
        if (Integer.parseInt(seconds) > 50)
            this.minutes = String.valueOf(Integer.parseInt(minutes) + 1);
        return this.seconds;
    }

    public int getTotalReadingTime() {
        return totalReadingTime =  round(Float.parseFloat(minutes + "." + seconds));
    }

    public void calculateTotalReadingTime() {

        if (minutes.equals("0")) 
            getSeconds();
        else {
            getSeconds();
            getTotalReadingTime();
        }
    }

}