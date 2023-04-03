package com.example.task7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserWebController {


    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }
}
