package com.example.task7.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "meter_groups")
public class MeterGroup {
    @Id
    private String name;

    public MeterGroup(String name) {
        this.name = name;
    }

    public MeterGroup() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
