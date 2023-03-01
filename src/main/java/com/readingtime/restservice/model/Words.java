package com.readingtime.restservice.model;

public class Words {

    private String[] ArrayOfWords;

    public Words(String words) {
        this.ArrayOfWords = words.split("\\W+");
    }

    public String[] getArrayOfWords() {
        return ArrayOfWords;
    }
}
