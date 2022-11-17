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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public String showCategoryNewForm(@Valid @ModelAttribute("post") Post post , BindingResult bindingResult , Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object o = authentication.getPrincipal();
        if(o instanceof String && "anonymousUser".equals(String.valueOf(o))) {
        } else {
            CustomerUserDtls customerUserDtls = (CustomerUserDtls) authentication.getPrincipal();
            User user = customerUserDtls.getU();
            post.setUser_id(user);
            post.setDateTime(LocalDateTime.now());
            postService.save(post);
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("post", post);
            List<Topic> listTopic = topicService.findAll();
            model.addAttribute("listTopic", listTopic);
            return "/post/new";
        } else {

            post.setDateTime(LocalDateTime.now());
            postService.save(post);
        }
        return "redirect:/";
    }

    @PostMapping("home/post/save")
    public String savePostIndex(Post post){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object o = authentication.getPrincipal();
        List<Topic> listTopic = topicService.findAll();
        if(o instanceof String && "anonymousUser".equals(String.valueOf(o))) {
            //chua login
        } else {
            CustomerUserDtls customerUserDtls = (CustomerUserDtls) authentication.getPrincipal();
            User user = customerUserDtls.getU();
            post.setTopic(listTopic.get(3));
            post.setUser_id(user);
            post.setDateTime(LocalDateTime.now());
            postService.save(post);
        }

        return "redirect:/";
    }

    @GetMapping("/category")
    public String postCategory(Model model){
        List<Post> listPost = postService.findAll();
        model.addAttribute("listPostDetail", listPost);
        return "user/Category";
    }

    @GetMapping("/details/{id}")
    public String postDetail(@PathVariable("id") int id, Model model){
        Post listPost = postService.finById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("listPostDetail", listPost);
        return "Guide";
    }

}
