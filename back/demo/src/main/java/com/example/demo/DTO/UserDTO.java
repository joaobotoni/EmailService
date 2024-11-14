package com.example.demo.DTO;

import com.example.demo.entities.User;

public class UserDTO {

    private Long id;
    private String email;
    private String password;

    public UserDTO(User user) {
        id = user.getId();
        email = user.getEmail();
        password = user.getPassword();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
