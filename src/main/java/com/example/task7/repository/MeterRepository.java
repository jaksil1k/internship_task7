package com.example.task7.repository;

import com.example.task7.entity.Meter;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface MeterRepository extends CrudRepository<Meter, Long> {

    @Modifying
    @Query("update meters m set m.meter_timestamp = ?1, m.current_reading = ?2 where m.meter_id = ?3")
    void update(Date timestamp, Double currentReading, Long meterId);
}
