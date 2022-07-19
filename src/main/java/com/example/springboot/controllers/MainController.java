package com.example.springboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String get() {
        return "jfaekjfd";
    }
    @PostMapping("/")
    public String Post(){
        return "yes";
    }
}
