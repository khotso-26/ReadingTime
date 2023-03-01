package com.readingtime.restservice.model;

public class Calculator {

    private final String seconds;
    private String minutes;

    public Calculator( String[] words) {

        String[] wordCount = String.valueOf(words.length / 200d).split("\\.");
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

    @Override
    public String toString() {
        return "Calculator{" +
                "seconds='" + seconds + '\'' +
                ", minutes='" + minutes + '\'' +
                '}';
    }
}
