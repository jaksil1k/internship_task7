package com.example.task7.dto;

import com.example.task7.entity.Meter;
import com.example.task7.entity.MeterGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportDto {
    private List<GroupDto> groups;

    public ReportDto(List<GroupDto> groups) {
        this.groups = groups;
    }

    public ReportDto() {
    }

    public void addGroupDto(GroupDto groupDto) {
        if (groups == null) {
            groups = new ArrayList<>();
        }
        groups.add(groupDto);
    }

    public List<GroupDto> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupDto> groups) {
        this.groups = groups;
    }
}
