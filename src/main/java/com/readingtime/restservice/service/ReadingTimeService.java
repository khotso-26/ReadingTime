package com.readingtime.restservice.service;

import com.readingtime.restservice.model.ReadingTime;

import java.util.List;

public interface ReadingTimeService {

    void calculateReadingTime(ReadingTime readTime);

    List<ReadingTime> getAllContent();

    void deleteReadingTime(Long id);
}
