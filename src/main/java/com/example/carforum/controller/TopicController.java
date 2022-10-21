package com.example.carforum.controller;

import com.example.carforum.entity.Topic;
import com.example.carforum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@CrossOrigin("*")
@Controller
@RequestMapping("api/v1/topic")
public class TopicController {
    @Autowired
    TopicService topicService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Topic>> findAll(){
        return ResponseEntity.ok(topicService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Topic> save(@RequestBody Topic district){
        return ResponseEntity.ok(topicService.save(district));
    }
}
