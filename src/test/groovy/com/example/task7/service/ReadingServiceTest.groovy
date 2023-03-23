package com.example.task7.service

import com.example.task7.dao.ReadingDao
import com.example.task7.entity.Reading
import com.example.task7.repository.ReadingRepository
import spock.lang.Specification
import spock.lang.Subject

class ReadingServiceTest extends Specification {
    @Subject ReadingService readingService;

    ReadingRepository readingRepository = Mock();


    void setup() {
        readingService = new ReadingService(readingRepository)
    }

    def "Create"() {
        when:
        readingService.create(new Reading())
        then:
        1 * readingRepository.save(_)
    }
}
