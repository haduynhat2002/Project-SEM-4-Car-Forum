package com.example.carforum.controller;

import com.example.carforum.entity.CategoryCar;
import com.example.carforum.entity.Post;
import com.example.carforum.entity.Topic;
import com.example.carforum.entity.User;
import com.example.carforum.service.CategoryCarService;
import com.example.carforum.service.PostService;
import com.example.carforum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private TopicService topicService;

    @Autowired
    private CategoryCarService categoryCarService;

    @GetMapping("/post/new")
    public String showCategoryNewForm(Model model){
        List<Topic> listTopic = topicService.findAll();
        model.addAttribute("listTopic", listTopic);
        model.addAttribute("post", new Post());

        return "user/LongPost";
    }
    @PostMapping("/post/save")
    public String showCategoryNewForm(Post post){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        user.getId();
        post.setUser_id(user);
        post.setDateTime(LocalDateTime.now());
        postService.save(post);
        return "redirect:/";
    }

    @GetMapping("/")
    public String listPost(Model model){
        List<Post> listPost = postService.findAll();
        List<CategoryCar> listCategoryCar = categoryCarService.findAll();
        model.addAttribute("listCategoryCar",listCategoryCar );
        model.addAttribute("listPost", listPost);
        return "user/index";
    }

    @GetMapping("/category")
    public String postDetail(Model model){
        List<Post> listPost = postService.findAll();
        model.addAttribute("listPostDetail", listPost);
        return "user/Category";
    }

}
