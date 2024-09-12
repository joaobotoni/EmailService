package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser() {
        User user = new User("Test", "testbootb@gmail.com");
        userService.createUserAndSendEmail(user);
        return "Registered user and email sent successfully!";
    }
}
