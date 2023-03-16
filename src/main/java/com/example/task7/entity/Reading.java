package com.example.task7.entity;

public class Reading {
    private Long id;
    private Long meterId;
    private Double reading;

    public Reading(Long id, Long meterId, Double reading) {
        this.id = id;
        this.meterId = meterId;
        this.reading = reading;
    }

    public Reading(Long meterId, Double reading) {
        this.meterId = meterId;
        this.reading = reading;
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
}
