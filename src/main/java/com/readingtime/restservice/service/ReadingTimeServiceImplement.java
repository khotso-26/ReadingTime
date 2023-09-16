package com.readingtime.restservice.service;

import com.readingtime.restservice.controller.ReadingTimeRequest;
import com.readingtime.restservice.exception.ApiRequestException;
import com.readingtime.restservice.model.calculator.TextAnalyzer;
import com.readingtime.restservice.model.readingtime.ReadingTime;
import com.readingtime.restservice.repository.ReadingTimeRepository;
import com.readingtime.restservice.service.request_response.ReadingTimeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReadingTimeServiceImplement implements ReadingTimeService {

    @Autowired
    private ReadingTimeRepository readingTimeRepository;

    @Override
    public List<ReadingTime> getAllContent() {

        if (readingTimeRepository.count() == 0)
            throw new ApiRequestException("Oops! There are no readings");
        return readingTimeRepository.findAll();
    }

    @Override
    public void deleteReadingTime(Long id) {
        if ( readingTimeRepository.existsById(id) )
            readingTimeRepository.deleteById(id);
        else throw new ApiRequestException("reading does not exist");
    }

    @Override
    public void getById(long id) {
        if (readingTimeRepository.existsById(id))
            readingTimeRepository.findById(id);
        else throw new ApiRequestException("reading does not exist");
    }

    @Override
    public ReadingTimeResponse calculateReadingTime(ReadingTimeRequest reading) {
        ReadingTime readingTime = new ReadingTime();
        String text = reading.body();
        TextAnalyzer textAnalyzer = new TextAnalyzer(text, reading.speed());
        textAnalyzer.calculateReadingTime();

        readingTime.setTitle(reading.title());
        readingTime.setBody(text);
        readingTime.setMinutes(textAnalyzer.getMinutes());
        readingTime.setSeconds(textAnalyzer.getSeconds());

        ReadingTime savedReadingTime = readingTimeRepository.save(readingTime);

        return new ReadingTimeResponse((int) savedReadingTime.getId(), savedReadingTime.getMinutes(), savedReadingTime.getSeconds());
    }

}