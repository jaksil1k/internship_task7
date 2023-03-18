package com.example.task7.service;

import com.example.task7.dao.MeterDao;
import com.example.task7.dto.MeterDto;
import com.example.task7.entity.Meter;
import com.example.task7.entity.MeterGroup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeterService {

    private final MeterDao meterDao = MeterDao.getInstance();

    public Meter create(Meter meter) {
        return meterDao.create(meter);
    }

    public boolean isPresent(Long meterId) {
        return meterDao.isPresent(meterId);
    }

    public void update(Meter meter) {
        if (meter.getMeterId() < 1) {
            throw new RuntimeException("id must be more than 0");
        }
        meterDao.update(meter);
    }

    public List<MeterDto> getAllByMeterGroup(MeterGroup meterGroup) {
        return meterDao.getAllByMeterGroup(meterGroup);
    }
}
