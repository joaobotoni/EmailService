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

    public UserDTO findUserById(Long id) {
        var user = repository.findById(id).get();
        return new UserDTO(user);
    }

    private String getDomainFromEmail(String email) {
        if (email != null && email.contains("@")) {
            return email.substring(email.indexOf("@") + 1);
        }
        throw new IllegalArgumentException("E-mail inválido");
    }

    public void sendEmail(UserDTO user, String to, String subject, String text, String host, String password) {
        String userByEmail = user.getEmail();
        String userByPassword = user.getPassword();
        String userByHost = getDomainFromEmail(userByEmail);

        JavaMailSenderImpl mailSender = emailService.mailSend(host, userByEmail, userByPassword);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
}
