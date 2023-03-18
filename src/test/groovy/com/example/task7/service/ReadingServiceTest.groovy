package com.example.task7.service

import com.example.task7.dao.ReadingDao
import com.example.task7.entity.Reading
import spock.lang.Specification
import spock.lang.Subject

class ReadingServiceTest extends Specification {
    @Subject ReadingService readingService;

    ReadingDao readingDao = Mock();


    void setup() {
        readingService = new ReadingService(readingDao)
    }

    def "Create"() {
        when:
        readingService.create(new Reading())
        then:
        1 * readingDao.create(_)
    }
}
