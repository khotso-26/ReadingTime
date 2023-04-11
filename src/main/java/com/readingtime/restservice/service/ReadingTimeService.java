package com.readingtime.restservice.service;

import com.readingtime.restservice.model.readingtime.ReadingTime;
import java.util.List;

public interface ReadingTimeService {

    List<ReadingTime> getAllContent();

    void deleteReadingTime(Long id);

    void getById(long id);

    void calculateReadingTime(ReadingTime reading);
}
