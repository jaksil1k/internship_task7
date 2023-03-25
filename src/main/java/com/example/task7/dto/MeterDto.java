package com.example.task7.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "meters")
public class MeterDto {
    @Id
    private Long meterId;
    private String meterType;
    private Double minReading;
    private Double maxReading;
    private Double currentReading;

    public MeterDto(Long meterId, String meterType, Double minReading, Double maxReading, Double currentReading) {
        this.meterId = meterId;
        this.meterType = meterType;
        this.minReading = minReading;
        this.maxReading = maxReading;
        this.currentReading = currentReading;
    }

    public MeterDto() {
    }

    public Long getMeterId() {
        return meterId;
    }

    public void setMeterId(Long meterId) {
        this.meterId = meterId;
    }

    public String getMeterType() {
        return meterType;
    }

    public void setMeterType(String meterType) {
        this.meterType = meterType;
    }

    public Double getMinReading() {
        return minReading;
    }

    public void setMinReading(Double minReading) {
        this.minReading = minReading;
    }

    public Double getMaxReading() {
        return maxReading;
    }

    public void setMaxReading(Double maxReading) {
        this.maxReading = maxReading;
    }

    public Double getCurrentReading() {
        return currentReading;
    }

    public void setCurrentReading(Double currentReading) {
        this.currentReading = currentReading;
    }
}
