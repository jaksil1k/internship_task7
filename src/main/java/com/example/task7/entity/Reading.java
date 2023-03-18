package com.example.task7.entity;

import java.sql.Date;

public class Reading {
    private Long id;
    private Long meterId;
    private Double reading;

    private Date date;

    public Reading(Long id, Long meterId, Double reading, Date date) {
        this.id = id;
        this.meterId = meterId;
        this.reading = reading;
        this.date = date;
    }

    public Reading(Long meterId, Double reading, Date date) {
        this.meterId = meterId;
        this.reading = reading;
        this.date = date;

    }

    public Reading() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMeterId() {
        return meterId;
    }

    public void setMeterId(Long meterId) {
        this.meterId = meterId;
    }

    public Double getReading() {
        return reading;
    }

    public void setReading(Double reading) {
        this.reading = reading;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
