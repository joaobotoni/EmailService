package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.from.address}")
    private String fromAddress;

    @Value("${mail.subject}")
    private String subject;

    public void createUserAndSendEmail(User user) {
        try {

            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom(fromAddress);
            msg.setTo(user.getEmail());
            msg.setSubject(subject);
            msg.setText(user.getName() + ", thank you for placing an order.");

            mailSender.send(msg);
        } catch (Exception e) {

            throw new RuntimeException("Error sending email to " + user.getEmail(), e);
        }
    }
}
