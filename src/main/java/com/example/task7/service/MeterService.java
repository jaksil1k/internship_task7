package com.example.task7.service;

import com.example.task7.dao.MeterDao;
import com.example.task7.dto.MeterDto;
import com.example.task7.entity.Meter;
import com.example.task7.entity.MeterGroup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeterService {

    private MeterDao meterDao = MeterDao.getInstance();

    public MeterService(MeterDao meterDao) {
        this.meterDao = meterDao;
    }

    public MeterService() {
    }

    public Meter create(Meter meter) {
        return meterDao.create(meter);
    }

    public boolean isPresent(Long meterId) {
        if (meterId < 1) {
            throw new RuntimeException("meterId must me more than 0");
        }
        return meterDao.isPresent(meterId);
    }

    public void update(Meter meter) {
        meterDao.update(meter);
    }

    public List<MeterDto> getAllByMeterGroup(MeterGroup meterGroup) {
        return meterDao.getAllByMeterGroup(meterGroup);
    }
}
