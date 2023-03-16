package com.example.task7.entity;


import java.util.Date;

public class Meter {
    private Long meterId;
    private String meterType;
    private String meterGroup;
    private Date date;
    private Double currentReading;

    public Meter(Long meterId, String meterType, String meterGroup, Date date, Double currentReading) {
        this.meterId = meterId;
        this.meterType = meterType;
        this.meterGroup = meterGroup;
        this.date = date;
        this.currentReading = currentReading;
    }

    public Meter(String meterType, String meterGroup, Date date, Double currentReading) {
        this.meterType = meterType;
        this.meterGroup = meterGroup;
        this.date = date;
        this.currentReading = currentReading;
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

    public String getMeterGroup() {
        return meterGroup;
    }

    public void setMeterGroup(String meterGroup) {
        this.meterGroup = meterGroup;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getCurrentReading() {
        return currentReading;
    }

    public void setCurrentReading(Double currentReading) {
        this.currentReading = currentReading;
    }
}
