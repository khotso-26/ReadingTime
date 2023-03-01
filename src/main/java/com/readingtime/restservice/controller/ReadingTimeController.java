package com.readingtime.restservice.controller;

import com.readingtime.restservice.model.ReadingTime;
import com.readingtime.restservice.model.ReadingTimeRequest;
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

    @GetMapping("/getAll")
    public  List<ReadingTime> getAllContent() {
        return readingTimeService.getAllContent();
    }

    @PostMapping("/calculate")
    public void CalculateReadingTime(@RequestBody ReadingTimeRequest readingTimeRequest){
        ReadingTime reading = new ReadingTime();
        reading.setContent(readingTimeRequest.content());
        readingTimeService.calculateReadingTime(reading);
    }

    @DeleteMapping("{readingTimeId}")
        public void DeleteReading(@PathVariable("readingTimeId") Long id) {
        readingTimeService.deleteReadingTime(id);
    }

    @GetMapping("{getById}")
    public void GetById(@PathVariable("getById") long id) {
        readingTimeService.getById(id);
    }

}
