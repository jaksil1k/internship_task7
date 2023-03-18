package com.example.task7.service

import com.example.task7.dao.MeterGroupDao
import spock.lang.Specification
import spock.lang.Subject

class MeterGroupServiceTest extends Specification {
    @Subject MeterGroupService meterGroupService;

    MeterGroupDao meterGroupDao = Mock()

    void setup() {
        meterGroupService = new MeterGroupService(meterGroupDao)
    }

    def "IsPresent"() {
        setup:
        1 * meterGroupDao.isPresent("room1") >> true
        expect:
        meterGroupService.isPresent("room1")

    }

    def "Create"() {
        when:
        meterGroupService.create("room1")
        then:
        1 * meterGroupDao.create(_)
    }

    def "GetAll"() {
        when:
        meterGroupService.getAll()
        then:
        1 * meterGroupDao.getAll() >> List.of()
    }
}
