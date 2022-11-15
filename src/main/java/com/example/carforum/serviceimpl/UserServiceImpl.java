package com.example.carforum.serviceimpl;

import com.example.carforum.entity.User;
import com.example.carforum.repository.UserRepository;
import com.example.carforum.service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserInterface {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getAccounById(Integer id) {
        Optional<User> optionalUser = userRepository.findUserById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }
}
