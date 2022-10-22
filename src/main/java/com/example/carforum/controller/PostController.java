package com.example.carforum.controller;

import com.example.carforum.entity.Post;
import com.example.carforum.entity.Topic;
import com.example.carforum.service.PostService;
import com.example.carforum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private TopicService topicService;

    @GetMapping("/post/new")
    public String showCategoryNewForm(Model model){
        List<Topic> listTopic = topicService.findAll();
        model.addAttribute("listTopic", listTopic);
        model.addAttribute("post", new Post());

        return "user/LongPost";
    }
    @PostMapping("/post/save")
    public String showCategoryNewForm(Post post){
       postService.save(post);
        return "redirect:/";
    }

    @GetMapping("/")
    public String listPost(Model model){
        List<Post> listPost = postService.findAll();
        model.addAttribute("listPost", listPost);
        return "user/index";
    }
}
