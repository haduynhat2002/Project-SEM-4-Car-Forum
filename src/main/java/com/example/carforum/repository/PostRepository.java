package com.example.carforum.repository;


import com.example.carforum.entity.Post;
import com.example.carforum.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query(value = "select * from User u where u.topic_id = ?4", nativeQuery = true)
    Post myCustomQuery(int topic_id);

    @Query(value = "select p from Post p where p.user_id.id = :id")
    List<Post> findAllByUserId(int id);
}
