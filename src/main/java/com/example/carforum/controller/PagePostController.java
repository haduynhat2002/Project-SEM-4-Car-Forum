package com.example.carforum.controller;

import com.example.carforum.entity.Post;
import com.example.carforum.repository.PostRepository;
import com.example.carforum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class PagePostController {
    @Autowired
    PostService postService;

    @GetMapping("/home/postForum")
    public String postForum(Model model,
                            @RequestParam("page") Optional<Integer> page,
                            @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Page<Post> listPost = postService.findPaginatedByTopic(PageRequest.of(currentPage - 1, pageSize), 3);
        int totalPages = listPost.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("postForum", listPost);
        return "user/page/PostForum";
    }

    @GetMapping("/home/postNew")
    public String postNews(Model model,
                           @RequestParam("page") Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Page<Post> listPost = postService.findPaginatedByTopic(PageRequest.of(currentPage - 1, pageSize), 1);
        int totalPages = listPost.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("postPage", listPost);
        return "user/page/ExperienceCar";
    }
    @Autowired
    PostRepository postRepository;
    @GetMapping("/home/postExperience")
    public String postExperience(Model model,
                                 @RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Page<Post> listPost = postService.findPaginatedByTopic(PageRequest.of(currentPage - 1, pageSize), 5);
        int totalPages = listPost.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("postPage", listPost);
        return "user/page/ExperienceCar";
    }


    @GetMapping("/home/postMaintenance")
    public String postMaintenance(Model model,
                                  @RequestParam("page") Optional<Integer> page,
                                  @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Page<Post> listPost = postService.findPaginatedByTopic(PageRequest.of(currentPage - 1, pageSize), 5);
        int totalPages = listPost.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("postPage", listPost);
        return "user/page/ExperienceCar";
    }
}
