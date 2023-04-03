package com.example.task7.controller;

import com.example.task7.auth.AuthenticationService;
import com.example.task7.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final AuthenticationService service;

    @GetMapping("/")
    public String main() {

        return "main";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerRequest", new RegisterRequest());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("registerRequest") RegisterRequest request) {
        service.register(request);

        return "redirect:/";
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }
}
