package com.example.carforum.repository;


import com.example.carforum.entity.Post;
import com.example.carforum.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query(nativeQuery = true, value = "SELECT * from Posts p where p.topic_id = ?1 ORDER BY id DESC limit ?2")
    List<Post> listPost(int id, int limit);
    @Query(value = "select p from Post p where p.user_id.id = :id")
    List<Post> findAllByUserId(int id);

    @Query(value = "select * from Posts p where p.topic_id = :id order by id DESC ", nativeQuery = true)
    List<Post> listPostOrderBy(int id);

}
