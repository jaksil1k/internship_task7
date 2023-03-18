package com.example.task7.service

import com.example.task7.dao.MeterDao
import com.example.task7.entity.Meter
import com.example.task7.entity.MeterGroup
import spock.lang.Specification
import spock.lang.Subject

import java.sql.Date

class MeterServiceTest extends Specification {
    @Subject MeterService meterService

    MeterDao meterDao = Mock()

    void setup() {
        meterService = new MeterService(meterDao)
    }

    def "Create"() {
        setup:
        Meter meter = new Meter(123, "ELM777", "room1", new Date(123), 125.67)
        1 * meterDao.create(meter) >> meter
        expect:
        meter == meterService.create(meter)
    }

    def "IsPresent"() {
        when:
        meterService.isPresent(0)
        then:
        thrown(RuntimeException)
    }

    def "Update"() {
        when:
        meterService.update(new Meter())
        then:
        1 * meterDao.update(_)
    }

    def "GetAllByMeterGroup"() {
        when:
        meterService.getAllByMeterGroup(new MeterGroup())
        then:
        1 * meterDao.getAllByMeterGroup(_) >> List.of()
    }
}
