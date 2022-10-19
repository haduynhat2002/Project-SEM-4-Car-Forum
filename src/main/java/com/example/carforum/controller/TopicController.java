package com.example.carforum.controller;

import com.example.carforum.entity.Topics;
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
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Topics> save(@RequestBody Topics topics){
        return ResponseEntity.ok(topicService.save(topics));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Topics>> findAll(){
        return ResponseEntity.ok(topicService.findAll());
    }
}
