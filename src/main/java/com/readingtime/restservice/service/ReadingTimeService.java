package com.readingtime.restservice.service;

import com.readingtime.restservice.controller.ReadingTimeRequest;
import com.readingtime.restservice.model.readingtime.ReadingTime;
import com.readingtime.restservice.service.request_response.ReadingTimeResponse;

import java.util.List;

public interface ReadingTimeService {

    List<ReadingTime> getAllContent();

    void deleteReadingTime(Long id);

    void getById(long id);

    ReadingTimeResponse calculateReadingTime(ReadingTimeRequest reading);

}
