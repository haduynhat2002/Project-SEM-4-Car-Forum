package com.example.carforum.service;

import com.example.carforum.entity.Role;
import com.example.carforum.entity.Topic;
import com.example.carforum.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
