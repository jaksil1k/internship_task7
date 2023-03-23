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
            select m.meter_id, m.meter_type,
            (select max(reading) from readings r where m.meter_id = r.meter_id),
            (select min(reading) from readings r where m.meter_id = r.meter_id),
            m.current_reading from meters m
            where m.meter_group = ?;
            """,
            nativeQuery = true)
    List<MeterDto> getAllByMeterGroup(MeterGroup meterGroup);
}
