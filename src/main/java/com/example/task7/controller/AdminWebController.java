package com.example.task7.controller;

import com.example.task7.dao.UserCreationDto;
import com.example.task7.entity.User;
import com.example.task7.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminWebController {

    private final UserService userService;

    @GetMapping("/panel")
    public String getAdminPanel(Model model) {
        List<User> users = userService.getAll();
        UserCreationDto userCreationDto = new UserCreationDto(users);
        model.addAttribute("form", userCreationDto);
        return "admin-panel";
    }

    @PostMapping("/save")
    public String updateUsers(@ModelAttribute UserCreationDto dto) {
        userService.updateAll(dto.getUsers());
        return "redirect:/admin/panel";
    }
}
