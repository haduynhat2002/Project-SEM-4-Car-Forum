package com.example.carforum.controller;

import com.example.carforum.entity.*;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public String showCategoryNewForm(Model model) {
        List<Topic> listTopic = topicService.findAll();
        model.addAttribute("listTopic", listTopic);
        model.addAttribute("post", new Post());

        return "user/LongPost";
    }
    @PostMapping("/post/save")
    public String showCategoryNewForm(Post post){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object o = authentication.getPrincipal();

        List<Post> listPost = new ArrayList<>();
        if(o instanceof String && "anonymousUser".equals(String.valueOf(o))) {
            //chua login
        } else {
            CustomerUserDtls customerUserDtls = (CustomerUserDtls) authentication.getPrincipal();
            User user = customerUserDtls.getU();
            post.setUser_id(user);
            post.setDateTime(LocalDateTime.now());
            postService.save(post);
        }

        return "redirect:/";
    }

    @GetMapping("/")
    public String listPost(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object o = authentication.getPrincipal();

        List<Post> listPost = new ArrayList<>();
        if(o instanceof String && "anonymousUser".equals(String.valueOf(o))) {
            //chua login
        } else {
            CustomerUserDtls customerUserDtls = (CustomerUserDtls) authentication.getPrincipal();
            User user = customerUserDtls.getU();
            listPost = postService.findAllByUserId(user.getId());
        }

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
