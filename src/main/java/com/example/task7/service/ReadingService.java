package com.example.task7.service;

import com.example.task7.dao.ReadingDao;
import com.example.task7.entity.Reading;
import com.example.task7.util.ConnectionManager;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class ReadingService {
    private final ReadingDao readingDao = ReadingDao.getInstance();



    public Reading create(Reading reading) {
        return readingDao.create(reading);
    }
}
