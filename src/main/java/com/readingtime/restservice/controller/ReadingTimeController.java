package com.readingtime.restservice.controller;

import com.readingtime.restservice.model.Calculator;
import com.readingtime.restservice.model.Time;
import com.readingtime.restservice.model.Words;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ReadingTimeController{

    private Calculator calculator = new Calculator();

    private final AtomicLong counter = new AtomicLong();


    @GetMapping("/reading_time")
    public Time readingTime(@RequestParam(value = "words", defaultValue = "World") String words) {
        Words word = new Words(words);
        return new Time(counter.incrementAndGet(), new Calculator(word.getWords()));
    }
}
