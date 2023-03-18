package com.example.task7.service;

import com.example.task7.dao.MeterGroupDao;
import com.example.task7.entity.MeterGroup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeterGroupService {

    private final MeterGroupDao meterGroupDao = MeterGroupDao.getInstance();
    public boolean isPresent(String meterGroup) {
        return meterGroupDao.isPresent(meterGroup);
    }

    public void create(String meterGroup) {
        meterGroupDao.create(meterGroup);
    }

    public List<MeterGroup> getAll() {
        return meterGroupDao.getAll();
    }
}
