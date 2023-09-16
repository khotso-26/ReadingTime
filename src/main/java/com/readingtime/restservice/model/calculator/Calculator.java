package com.readingtime.restservice.model.calculator;

public class Calculator {

    private final int seconds;
    private final int minutes;

    public Calculator(String[] words) {
        String[] wordCount = String.valueOf(words.length / 200d).split("\\.");
        this.seconds = Integer.parseInt(String.valueOf(Integer.parseInt(wordCount[1]) * 60).substring(0,2));
        this.minutes = Integer.parseInt(wordCount[0]);
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }



}