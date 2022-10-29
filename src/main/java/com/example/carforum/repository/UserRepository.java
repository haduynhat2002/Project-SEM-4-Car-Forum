package com.example.carforum.repository;


import com.example.carforum.entity.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {

     public UserDtls findByEmail(String email);
}
