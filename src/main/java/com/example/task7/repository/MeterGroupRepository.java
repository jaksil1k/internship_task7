package com.example.task7.repository;

import com.example.task7.entity.MeterGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeterGroupRepository extends CrudRepository<MeterGroup, String> {

}
