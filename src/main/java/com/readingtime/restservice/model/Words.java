package com.readingtime.restservice.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Words {

    private List<String> words;

    public Words(String words) {
        this.words = new ArrayList<String>(Collections.singleton(words));
        System.out.println(words);
    }

    public List<String> getWords() {
        return words;
    }
}
