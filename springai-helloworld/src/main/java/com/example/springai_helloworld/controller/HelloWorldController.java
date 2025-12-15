package com.example.springai_helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    // Endpoint pertama: Hello World
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World from Spring AI!";
    }

    // Endpoint kedua: Welcome message
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring AI Application - Simple Demo";
    }

    // Endpoint ketiga: Info
    @GetMapping("/info")
    public String info() {
        return "This is a simple Spring Boot REST API for learning Spring AI";
    }
}