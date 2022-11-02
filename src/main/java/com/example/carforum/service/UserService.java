package com.example.carforum.service;


import com.example.carforum.entity.Topic;
import com.example.carforum.entity.User;
import com.example.carforum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User userDtls) {return userRepository.save(userDtls);}
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
