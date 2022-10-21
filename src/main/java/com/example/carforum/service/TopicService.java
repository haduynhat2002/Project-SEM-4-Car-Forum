package com.example.carforum.service;


import com.example.carforum.entity.Topic;
import com.example.carforum.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    TopicRepository topicRepository;

    public Topic save(Topic topic) {
        return topicRepository.save(topic);
    }
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }
}
