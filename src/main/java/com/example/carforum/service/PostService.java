package com.example.carforum.service;

import com.example.carforum.entity.Post;
import com.example.carforum.entity.Topic;
import com.example.carforum.exception.NotFoundException;
import com.example.carforum.repository.PostRepository;
import com.example.carforum.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    TopicRepository topicRepository;
    public Post save(Post post) {
        Topic topic = topicRepository.findById(post.getTopic_id()).orElse(null);
        if (topic == null) {
            throw new NotFoundException("No topic found!");
        }
        else {
            post.setTopic(topic);
            postRepository.save(post);
        }
        return post;

    }
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}

