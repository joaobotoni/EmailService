package com.example.demo.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Properties;

@Service
public class EmailService {


    @Value("${spring.mail.port}")
    private int port;

    @Transactional(readOnly = true)
    public JavaMailSenderImpl mailSend(String host, String username, String password){
        JavaMailSenderImpl mail = new JavaMailSenderImpl();
        mail.setHost(host);
        mail.setUsername(username);
        mail.setPassword(password);

        Properties props = mail.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        if (port == 465) { props.put("mail.smtp.ssl.enable", "true"); }

        return mail;
    }
}
