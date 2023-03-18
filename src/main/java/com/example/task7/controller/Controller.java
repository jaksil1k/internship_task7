package com.example.task7.controller;

import com.example.task7.dto.GroupDto;
import com.example.task7.dto.MeterDto;
import com.example.task7.dto.ReportDto;
import com.example.task7.entity.Meter;
import com.example.task7.entity.MeterGroup;
import com.example.task7.entity.Reading;
import com.example.task7.service.MeterGroupService;
import com.example.task7.service.MeterService;
import com.example.task7.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/meters")
public class Controller {

    private final MeterService meterService;
    private final MeterGroupService meterGroupService;
    private final ReadingService readingService;

    @Autowired
    public Controller(MeterService meterService, MeterGroupService meterGroupService, ReadingService readingService) {
        this.meterService = meterService;
        this.meterGroupService = meterGroupService;
        this.readingService = readingService;
    }

    @PostMapping
    public Meter meterReading(@RequestBody Meter meter) {

        if (!meterGroupService.isPresent(meter.getMeterGroup())) {
            meterGroupService.create(meter.getMeterGroup());
        }

        if (!meterService.isPresent(meter.getMeterId())) {
            meter.setMeterId(meterService.create(meter).getMeterId());
        } else {
            meterService.update(meter);
        }

        readingService.create(new Reading(meter.getMeterId(), meter.getCurrentReading(), meter.getTimestamp()));
        return meter;
    }

    @GetMapping("/report")
    public ReportDto getReport() {

        ReportDto report = new ReportDto();
        List<MeterGroup> meterGroups = meterGroupService.getAll();

        for (MeterGroup meterGroup: meterGroups) {
            List<MeterDto> meters = meterService.getAllByMeterGroup(meterGroup);

            GroupDto group = new GroupDto(meterGroup, meters, findSumOfMeters(meters));
            report.addGroupDto(group);
        }

        return report;
    }

    private Double findSumOfMeters(List<MeterDto> meters) {
        Double sum = 0.0;
        for (MeterDto meter : meters) {
            sum += meter.getCurrentReading();
        }
        return sum;
    }
}
