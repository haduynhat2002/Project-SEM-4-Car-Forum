package com.example.carforum.repository;


import com.example.carforum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
     User findById(int id);
     public User findByEmail(String email);
}
