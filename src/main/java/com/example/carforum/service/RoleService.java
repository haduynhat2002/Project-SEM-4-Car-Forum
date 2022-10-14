package com.example.carforum.service;

import com.example.carforum.entity.Role;
import com.example.carforum.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Role save(Role role) {
        return roleRepository.save(role);
    }
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
