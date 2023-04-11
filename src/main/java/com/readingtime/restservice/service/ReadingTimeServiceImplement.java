package com.readingtime.restservice.service;

import com.readingtime.restservice.model.readingtime.ReadingTime;
import com.readingtime.restservice.repository.ReadingTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReadingTimeServiceImplement implements ReadingTimeService {

    @Autowired
    private ReadingTimeRepository readingTimeRepository;

    @Override
    public List<ReadingTime> getAllContent() {
        return readingTimeRepository.findAll();
    }

    @Override
    public void deleteReadingTime(Long id) {
        if ( readingTimeRepository.existsById(id) ) readingTimeRepository.deleteById(id);
    }

    @Override
    public void getById(long id) {
        if (readingTimeRepository.existsById(id)) readingTimeRepository.findById(id);
    }

    @Override
    public void calculateReadingTime(ReadingTime reading) {
        readingTimeRepository.save(reading);
    }
}
