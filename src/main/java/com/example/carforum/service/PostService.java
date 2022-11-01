package com.example.carforum.service;

import com.example.carforum.entity.Post;
import com.example.carforum.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public Post save(Post post) {
        return postRepository.save(post);
    }
    public List<Post> findAll() {
        return postRepository.findAll();
    }
    public Optional<Post> finById(int id) {
        return postRepository.findById(id);
    }


    public List<Post> findAllByUserId(int userId) {
        return postRepository.findAllByUserId(userId);
    }
}
