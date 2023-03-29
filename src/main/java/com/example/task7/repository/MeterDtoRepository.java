package com.example.task7.repository;

import com.example.task7.dto.MeterDto;
import com.example.task7.entity.MeterGroup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeterDtoRepository extends CrudRepository<MeterDto, Long> {
    @Query(value = """
            select m.meterId, m.meterType,
            (select max(r.reading) from Reading r where m.meterId = r.meterId),
            (select min(r.reading) from Reading r where m.meterId = r.meterId),
            m.currentReading from Meter m
            where m.meterGroup = :meterGroup
            """)
    List<MeterDto> getAllByMeterGroup(String meterGroup);
}
