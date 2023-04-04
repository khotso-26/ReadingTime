package com.readingtime.restservice.controller;

import com.readingtime.restservice.model.Calculator;
import com.readingtime.restservice.model.ReadingTime;
import com.readingtime.restservice.model.ReadingTimeRequest;
import com.readingtime.restservice.model.Words;
import com.readingtime.restservice.service.ReadingTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/readingtime")
public class ReadingTimeController{

    @Autowired
    private ReadingTimeService readingTimeService;

    @GetMapping("/getall")
    public  List<ReadingTime> getAllContent() {
        return readingTimeService.getAllContent();
    }

    @PostMapping("/calculate")
    public void CalculateReadingTime(@RequestBody ReadingTimeRequest readingTimeRequest){

        ReadingTime reading = new ReadingTime();
        Words words = new Words(readingTimeRequest.body());
        Calculator calculator = new Calculator(words.getArrayOfWords());

        reading.setSeconds(calculator.getSeconds());
        reading.setMinutes(calculator.getMinutes());
        reading.setTitle(readingTimeRequest.title());
        reading.setBody(readingTimeRequest.body());

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
