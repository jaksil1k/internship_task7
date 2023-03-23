package com.example.task7.service

import com.example.task7.dao.MeterDao
import com.example.task7.entity.Meter
import com.example.task7.entity.MeterGroup
import com.example.task7.repository.MeterDtoRepository
import com.example.task7.repository.MeterRepository
import spock.lang.Specification
import spock.lang.Subject

import java.sql.Date

class MeterServiceTest extends Specification {
    @Subject MeterService meterService

    MeterRepository meterRep = Mock()
    MeterDtoRepository meterDtoRepository =  Mock()

    void setup() {
        meterService = new MeterService(meterRep, meterDtoRepository)
    }

    def "Create"() {
        setup:
        Meter meter = new Meter(123, "ELM777", "room1", new Date(123), 125.67)
        1 * meterRep.save(meter) >> meter
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
        meterService.update(new Meter(1, new Date(1), 100))
        then:
        1 * meterRep.update(_, _, _)
    }

    def "GetAllByMeterGroup"() {
        when:
        meterService.getAllByMeterGroup(new MeterGroup())
        then:
        1 * meterDtoRepository.getAllByMeterGroup(_) >> List.of()
    }
}
