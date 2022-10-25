package com.example.carforum.controller.admin;


import com.example.carforum.entity.Topic;
import com.example.carforum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TopicAdminController {
    @Autowired
    private TopicService topicService;
    @GetMapping("admin/topics")
    public String listCategory(Model model){
        List<Topic> listTopic = topicService.findAll();
        model.addAttribute("listTopic", listTopic);
        return "admin/topic/ListTopic";
    }
    @GetMapping("/admin/topic/create")
    public String showCategoryNewForm(Model model){
        model.addAttribute("topic", new Topic());
        return "admin/topic/CreateTopic";
    }
    @PostMapping("/topic/save")
    public String showCategoryNewForm(Topic topic){
        topicService.save(topic);
        return "redirect:/admin/topics";
    }
}
