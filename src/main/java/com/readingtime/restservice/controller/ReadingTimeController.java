package com.readingtime.restservice.controller;

import com.readingtime.restservice.model.Calculator;
import com.readingtime.restservice.model.ReadingTime;
import com.readingtime.restservice.model.Words;
import com.readingtime.restservice.service.ReadingTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/readingtime")
public class ReadingTimeController{

    @Autowired
    private ReadingTimeService readingTimeService;

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/get")
    public List<ReadingTime> getAllContent() {
        return readingTimeService.getAllContent();
    }


    @PostMapping("/calculate")
    public void CalculateReadingTime(@RequestBody ReadingTime readingTime){
        readingTimeService.calculateReadingTime(readingTime);
    }

    @DeleteMapping(path = "{readingTimeId}")
        public void DeleteReading(@PathVariable("radingTimeId") Long id){
            readingTimeService.deleteReadingTime(id);
        }

}
