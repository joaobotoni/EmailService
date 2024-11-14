package com.example.demo.DTO;

import com.example.demo.entities.User;

public class UserDTO {

    private Long id;
    private String email;

    public UserDTO(User user) {
        id = user.getId();
        email = user.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
