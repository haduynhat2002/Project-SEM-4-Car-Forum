package com.example.carforum.repository;


import com.example.carforum.entity.Post;
import com.example.carforum.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query(value = "select * from Posts p where p.topic_id = :id", nativeQuery = true)
    List<Post> listPost(int id);
    @Query(value = "select p from Post p where p.user_id.id = :id")
    List<Post> findAllByUserId(int id);

    @Query(value = "select * from Posts p where p.topic_id = :id order by a desc", nativeQuery = true)
    List<Post> listPostOrderBy(int id);

}
