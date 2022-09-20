package com.example.AppDemo;

import com.example.AppDemo.Restaurant;
import com.example.AppDemo.RestaurantRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome to Spring!";
    }
}

