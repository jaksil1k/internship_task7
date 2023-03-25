package com.example.task7.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.sql.Date;


@Entity
@Table(name = "meters")
public class Meter {
    @NotNull
    @Id
    private Long meterId;
    @NotBlank
    private String type;
    @NotBlank
    private String meterGroup;
    @Valid
    private Date timestamp;
    @Positive(message = "Must be positive")
    @Valid
    private Double currentReading;

    public Meter(Long meterId, String type, String meterGroup, Date timestamp, Double currentReading) {
        this.meterId = meterId;
        this.type = type;
        this.meterGroup = meterGroup;
        this.timestamp = timestamp;
        this.currentReading = currentReading;
    }

    public Meter(Long meterId, Date timestamp, Double currentReading) {
        this.meterId = meterId;
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

    @Override
    public String toString() {
        return "Meter{" +
                "meterId=" + meterId +
                ", type='" + type + '\'' +
                ", meterGroup='" + meterGroup + '\'' +
                ", timestamp=" + timestamp +
                ", currentReading=" + currentReading +
                '}';
    }
}
