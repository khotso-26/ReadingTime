package com.readingtime.restservice.controller;

import com.readingtime.restservice.model.readingtime.ReadingTime;
import com.readingtime.restservice.service.request_response.ReadingTimeResponse;
import com.readingtime.restservice.service.ReadingTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping("/api.readingtime/v1")
public class ReadingTimeController{

    @Autowired
    private ReadingTimeService readingTimeService;

    @GetMapping("/getall")
    public  List<ReadingTime> getAllContent() {
        return readingTimeService.getAllContent();
    }

    @PostMapping("/calculate")
    public ReadingTimeResponse CalculateReadingTime(@RequestBody ReadingTimeRequest readingTimeRequest){
        return readingTimeService.calculateReadingTime(readingTimeRequest);
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
