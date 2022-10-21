package com.example.carforum.controller;


import com.example.carforum.entity.Topic;
import com.example.carforum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TopicController {
    @Autowired
    private TopicService topicService;
    @GetMapping("/topics")
    public String listCategory(Model model){
        List<Topic> listTopic = topicService.findAll();
        model.addAttribute("listTopic", listTopic);
        return "topics";
    }
    @GetMapping("/topic/new")
    public String showCategoryNewForm(Model model){
        model.addAttribute("topic", new Topic());
        return "topicForm";
    }
    @PostMapping("/topic/save")
    public String showCategoryNewForm(Topic topic){
        topicService.save(topic);
        return "redirect:/topics";
    }
}
