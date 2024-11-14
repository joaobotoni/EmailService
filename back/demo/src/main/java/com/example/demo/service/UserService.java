package com.example.demo.service;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        var users = repository.findAll();
        return users.stream().map(UserDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        Optional<User> result = repository.findById(id);
        if (result.isPresent()) {
            return new UserDTO(result.get());
        } else {
            throw new IllegalArgumentException("Usuário não encontrado com o ID: " + id);
        }
    }
}
