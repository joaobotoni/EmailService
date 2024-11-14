package com.example.demo.controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping(value = "/{id}")
    public UserDTO findUserById(@PathVariable Long id) {
        return service.findById(id);
    }


}
