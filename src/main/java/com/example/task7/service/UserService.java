package com.example.task7.service;

import com.example.task7.entity.User;
import com.example.task7.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void updateAll(List<User> users) {
        userRepository.saveAll(users);
    }
}
