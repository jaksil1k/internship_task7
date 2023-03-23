package com.example.task7.service;

import com.example.task7.dao.ReadingDao;
import com.example.task7.entity.Reading;
import com.example.task7.repository.ReadingRepository;
import org.springframework.stereotype.Service;

@Service
public class ReadingService {
    private ReadingRepository readingRepository;


    public ReadingService() {
    }

    public ReadingService(ReadingRepository readingRepository) {
        this.readingRepository = readingRepository;
    }

    public Reading create(Reading reading) {
        return readingRepository.save(reading);
    }
}
