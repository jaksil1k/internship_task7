package com.example.task7.dto;

import com.example.task7.entity.Meter;
import com.example.task7.entity.MeterGroup;

import java.util.List;

public class GroupDto {
    private MeterGroup meterGroup;
    private Integer numberOfMeters;
    private List<MeterDto> meters;
    private Double groupReading;

    public GroupDto(MeterGroup meterGroup, List<MeterDto> meters, Double groupReading) {
        this.meterGroup = meterGroup;
        this.meters = meters;
        this.groupReading = groupReading;
    }

    public GroupDto() {
    }

    public MeterGroup getMeterGroup() {
        return meterGroup;
    }

    public void setMeterGroup(MeterGroup meterGroup) {
        this.meterGroup = meterGroup;
    }

    public List<MeterDto> getMeters() {
        return meters;
    }

    public void setMeters(List<MeterDto> meters) {
        this.meters = meters;
    }

    public Double getGroupReading() {
        return groupReading;
    }

    public void setGroupReading(Double groupReading) {
        this.groupReading = groupReading;
    }

    public Integer getNumberOfMeters() {
        return numberOfMeters;
    }

    public void setNumberOfMeters(Integer numberOfMeters) {
        this.numberOfMeters = numberOfMeters;
    }
}
