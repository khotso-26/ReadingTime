package com.readingtime.restservice.model.calculator;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TextAnalyzer {

    private final String text;

    private final int readingSpeed;

    @Getter
    private int seconds;
    @Getter
    private int minutes;

    public TextAnalyzer(String text, int readingSpeed) {
        this.text = text;
        this.readingSpeed = readingSpeed;
    }

    public void calculateReadingTime() {
        String[] sentences = splitIntoSentences(text);
        double totalMinutes = countWords(sentences) / readingSpeed;
        this.minutes = (int) totalMinutes;
        this.seconds = (int) ((totalMinutes - this.minutes) * 60);
    }

    private String[] splitIntoSentences(String text) {
        List<String> sentencesList = new ArrayList<>();

        BreakIterator iterator = BreakIterator.getSentenceInstance();
        iterator.setText(text);

        int start = iterator.first();
        int end;

        Pattern abbreviationPattern = Pattern.compile("([A-Z][a-z]{0,2}\\.\\s?)+");

        while ((end = iterator.next()) != BreakIterator.DONE) {
            String sentence = text.substring(start, end).trim();

            while (end < text.length() - 1 && abbreviationPattern.matcher(sentence).matches()) {
                end = iterator.next();
                sentence = text.substring(start, end).trim();
            }

            if (!sentence.isEmpty()) {
                sentencesList.add(sentence);
            }
            start = end;
        }

        return sentencesList.toArray(new String[0]);
    }

    private double countWords(String[] sentences) {
        long wordCount = 0;
        for (String sentence : sentences) {
            String[] words = sentence.split("\\s+");
            wordCount += words.length;
        }
        return (double) wordCount;
    }
}
