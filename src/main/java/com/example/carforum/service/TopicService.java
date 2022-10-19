package com.example.carforum.service;

import com.example.carforum.entity.Topics;
import com.example.carforum.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    TopicRepository topicRepository;
    public Topics save(Topics topics) {
        return topicRepository.save(topics);
    }
    public List<Topics> findAll() {
        return topicRepository.findAll();
    }
}
