package com.example.task7.dao;

import com.example.task7.entity.User;
import lombok.Data;

import java.util.List;


public class UserCreationDto {
    private List<User> users;

    public UserCreationDto(List<User> users) {
        this.users = users;
    }

    public UserCreationDto() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
