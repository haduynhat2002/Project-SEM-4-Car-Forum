package com.example.carforum.service;

import com.example.carforum.entity.Role;
import com.example.carforum.entity.User;
import com.example.carforum.exception.NotFoundException;
import com.example.carforum.repository.RoleRepository;
import com.example.carforum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public User save(User user) {
        Role role = roleRepository.findById(user.getRole_id()).orElse(null);
        if (role == null) {
            throw new NotFoundException("No district found!");
        }
        else {
            user.setRole(role);
            userRepository.save(user);
        }
        return user;

    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
