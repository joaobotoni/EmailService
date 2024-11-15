package com.example.demo.controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<UserDTO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public UserDTO findUserById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping(value = "mail/{id}")
    public void mail(@PathVariable Long id){
        service.sendEmailTo(id);
    }

}
