package com.example.task7.service;

import com.example.task7.dto.MeterDto;
import com.example.task7.entity.Meter;
import com.example.task7.entity.MeterGroup;
import com.example.task7.repository.MeterDtoRepository;
import com.example.task7.repository.MeterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeterService {

    private MeterRepository meterRepository;
    private MeterDtoRepository meterDtoRepository;

    @Autowired
    public MeterService(MeterRepository meterRepository, MeterDtoRepository meterDtoRepository) {
        this.meterRepository = meterRepository;
        this.meterDtoRepository = meterDtoRepository;
    }

    public MeterService() {
    }

    public Meter create(Meter meter) {
        return meterRepository.save(meter);
    }

    public boolean isPresent(Long meterId) {
        if (meterId < 1) {
            throw new RuntimeException("meterId must me more than 0");
        }
        return meterRepository.existsById(meterId);
    }

    public void update(Meter meter) {
        meterRepository.update(meter.getTimestamp(), meter.getCurrentReading(), meter.getMeterId());
    }

    public List<MeterDto> getAllByMeterGroup(MeterGroup meterGroup) {
        return meterDtoRepository.getAllByMeterGroup(meterGroup);
    }
}
