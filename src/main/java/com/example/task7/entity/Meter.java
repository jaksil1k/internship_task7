package com.example.task7.entity;


import java.sql.Date;

public class Meter {
    private Long meterId;
    private String type;
    private String meterGroup;
    private Date timestamp;
    private Double currentReading;

    public Meter(Long meterId, String type, String meterGroup, Date timestamp, Double currentReading) {
        this.meterId = meterId;
        this.type = type;
        this.meterGroup = meterGroup;
        this.timestamp = timestamp;
        this.currentReading = currentReading;
    }

    public Meter(String type, String meterGroup, Date timestamp, Double currentReading) {
        this.type = type;
        this.meterGroup = meterGroup;
        this.timestamp = timestamp;
        this.currentReading = currentReading;
    }

    public Meter() {
    }

    public Long getMeterId() {
        return meterId;
    }

    public void setMeterId(Long meterId) {
        this.meterId = meterId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMeterGroup() {
        return meterGroup;
    }

    public void setMeterGroup(String meterGroup) {
        this.meterGroup = meterGroup;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Double getCurrentReading() {
        return currentReading;
    }

    public void setCurrentReading(Double currentReading) {
        this.currentReading = currentReading;
    }
}
