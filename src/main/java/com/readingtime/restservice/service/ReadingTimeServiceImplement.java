package com.readingtime.restservice.service;

import com.readingtime.restservice.model.Calculator;
import com.readingtime.restservice.model.ReadingTime;
import com.readingtime.restservice.model.Words;
import com.readingtime.restservice.repository.ReadingTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReadingTimeServiceImplement implements ReadingTimeService {

    @Autowired
    private ReadingTimeRepository readingTimeRepository;

    @Override
    public void calculateReadingTime(ReadingTime readTime) {
        Optional<ReadingTime> content = readingTimeRepository.findWords(readTime.getContent());
        if (content.isPresent()) {
            Words words = new Words(content.toString());
            Calculator calculator = new Calculator(words.getArrayOfWords());
//            readingTimeRepository.saveAndFlush(calculator.toString());
        }
    }

    @Override
    public List<ReadingTime> getAllContent() {
        return readingTimeRepository.findAll();
    }

    @Override
    public void deleteReadingTime(Long id) {

    }
}
