package com.example.carforum.repository;


import com.example.carforum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
     public User findByUserName(String username);

}
