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
import jakarta.validation.Valid;
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
    public Meter meterReading(@Valid @RequestBody Meter meter) {

        if (!meterGroupService.isPresent(meter.getMeterGroup())) {
            meterGroupService.create(meter.getMeterGroup());
        }

        if (!meterService.isPresent(meter.getMeterId())) {
            meter = meterService.create(meter);
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
            List<MeterDto> meters = meterService.getAllByMeterGroup(meterGroup.getName());

            GroupDto group = new GroupDto(meterGroup, meters, findSumOfMeters(meters));
            report.addGroupDto(group);
        }

        return report;
    }

    @GetMapping("/meterGroup/{name}")
    public GroupDto getMetersByMeterGroupByName(@PathVariable String name) {
        List<MeterDto> meters = meterService.getAllByMeterGroup(name);

        GroupDto groupDto = new GroupDto();
        groupDto.setNumberOfMeters(meters.size());
        groupDto.setMeterGroup(new MeterGroup(name));
        groupDto.setMeters(meters);
        groupDto.setGroupReading(findSumOfMeters(meters));

        return groupDto;

    }

    private Double findSumOfMeters(List<MeterDto> meters) {
        Double sum = 0.0;
        for (MeterDto meter : meters) {
            sum += meter.getCurrentReading();
        }
        return sum;
    }

}
