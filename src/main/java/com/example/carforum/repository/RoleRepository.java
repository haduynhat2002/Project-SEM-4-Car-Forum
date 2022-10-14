package com.example.carforum.repository;

import com.example.carforum.entity.Role;
import com.example.carforum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
