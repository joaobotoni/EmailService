package com.example.demo.controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/mail/{id}")
    public ResponseEntity<Void> mailSendByUser(@PathVariable Long id) {
        try {
            UserDTO user = findUserById(id);
            service.sendEmail(user, "Ola", "Mundo", "Hello");
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
