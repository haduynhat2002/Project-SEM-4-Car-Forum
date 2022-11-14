package com.example.carforum.repository;


import com.example.carforum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
     User findById(int id);
     public User findByEmail(String email);

     Optional<User> findUserById(Integer id);
}
