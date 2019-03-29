package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreeterController {


    @GetMapping("/greet/{user}")
    public String greet(@PathVariable("user") String user) {
        String prefix = System.getenv().getOrDefault("GREETING_PREFIX", "Hi");
        System.out.println("Prefix :" + prefix + " and User :" + user);
        if (prefix == null) {
            prefix = "Hello!";
        }

        return String.format("%s %s! Welcome to Configuring Spring Boot on Kubernetes!", prefix, user);
    }
}