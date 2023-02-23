package com.readingtime.restservice.service;

import com.readingtime.restservice.model.ReadingTime;
import com.readingtime.restservice.repository.ReadingTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadingTimeServiceImplement implements ReadingTimeService {

    @Autowired
    private ReadingTimeRepository readingTimeRepository;

    @Override
    public ReadingTime saveReadingTime(ReadingTime readingTime) {
        return readingTimeRepository.saveAndFlush(readingTime);
    }
}
