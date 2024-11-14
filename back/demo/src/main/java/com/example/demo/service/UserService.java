package com.example.demo.service;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserRepository repository;

    @Value("${mail.from.address}")
    private String fromAddress;

    @Value("${mail.subject}")
    private String subject;

    public List<UserDTO> findAll(){
        var user = repository.findAll();
        return user.stream().map(UserDTO::new).toList();
    }

    public User findUserById(Long id){
        return repository.findById(id).get();
    }

//    public void createUserAndSendEmail(UserDTO userDTO) {
//        User user = findUserById(userDTO.getId());
//        try {
//            SimpleMailMessage msg = new SimpleMailMessage();
//            msg.setFrom(fromAddress);
//            msg.setTo(user.getEmail());
//            msg.setSubject(subject);
//
//            mailSender.send(msg);
//        } catch (Exception e) {
//
//            throw new RuntimeException("Error sending email to " + user.getEmail(), e);
//        }
//    }
}
