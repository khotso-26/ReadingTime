package com.readingtime.restservice.controller;

import com.readingtime.restservice.model.Calculator;
import com.readingtime.restservice.model.ReadingTime;
import com.readingtime.restservice.model.Words;
import com.readingtime.restservice.service.ReadingTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/readingtime")
public class ReadingTimeController{

    @Autowired
    private ReadingTimeService readingTimeService;

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/get")
    public ReadingTime get(@RequestParam(value = "words") String words) {
        Words word = new Words(words);
        return new ReadingTime(counter.incrementAndGet(), new Calculator(word.getArrayOfWords()));
    }

    @PostMapping("/add")
    public void ass(@RequestBody ReadingTime readingTime){
        readingTimeService.saveReadingTime(readingTime);
    }
}
