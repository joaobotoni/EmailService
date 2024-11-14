package com.example.demo.service;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private EmailService emailService;
    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll() {
        var user = repository.findAll();
        return user.stream().map(UserDTO::new).toList();
    }

    public User findUserById(Long id) {
        return repository.findById(id).get();
    }

    public void sendEmail(User user, String to, String subject, String text, String host, String password) {
        var userByEmail = user.getEmail();
        var userByPassword = user.getPassword();

        JavaMailSenderImpl mailSender = emailService.mailSend(host, userByEmail, userByPassword);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
}
