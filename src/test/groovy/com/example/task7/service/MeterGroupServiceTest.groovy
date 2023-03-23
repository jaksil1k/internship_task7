package com.example.task7.service


import com.example.task7.repository.MeterGroupRepository
import spock.lang.Specification
import spock.lang.Subject

class MeterGroupServiceTest extends Specification {
    @Subject MeterGroupService meterGroupService;

    MeterGroupRepository meterGroupRepository = Mock()

    void setup() {
        meterGroupService = new MeterGroupService(meterGroupRepository)
    }

    def "IsPresent"() {
        setup:
        1 * meterGroupRepository.existsById("room1") >> true
        expect:
        meterGroupService.isPresent("room1")

    }

    def "Create"() {
        when:
        meterGroupService.create("room1")
        then:
        1 * meterGroupRepository.save(_)
    }

    def "GetAll"() {
        when:
        meterGroupService.getAll()
        then:
        1 * meterGroupRepository.findAll() >> List.of()
    }
}
