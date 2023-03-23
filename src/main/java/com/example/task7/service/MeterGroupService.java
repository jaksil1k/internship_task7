package com.example.task7.service;

import com.example.task7.dao.MeterGroupDao;
import com.example.task7.entity.MeterGroup;
import com.example.task7.repository.MeterGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeterGroupService {

    private MeterGroupRepository meterGroupRepository;

    public MeterGroupService() {
    }

    @Autowired
    public MeterGroupService(MeterGroupRepository meterGroupRepository) {
        this.meterGroupRepository = meterGroupRepository;
    }

    public boolean isPresent(String meterGroup) {
        return meterGroupRepository.existsById(meterGroup);
    }

    public void create(String meterGroup) {
        meterGroupRepository.save(new MeterGroup(meterGroup));
    }

    public List<MeterGroup> getAll() {
        return (List<MeterGroup>) meterGroupRepository.findAll();
    }
}
