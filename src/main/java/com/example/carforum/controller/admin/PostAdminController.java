package com.example.carforum.controller.admin;

import com.example.carforum.entity.Post;
import com.example.carforum.entity.Topic;
import com.example.carforum.entity.User;
import com.example.carforum.repository.PostRepository;
import com.example.carforum.service.PostService;
import com.example.carforum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class PostAdminController {
    @Autowired
    private PostService postService;
    @Autowired
    private TopicService topicService;

    @Autowired
    PostRepository postRepository;

    @GetMapping("/admin/post/create")
    public String showCategoryNewForm(Model model){
        List<Topic> listTopic = topicService.findAll();
        model.addAttribute("listTopic", listTopic);
        model.addAttribute("post", new Post());
        return "admin/post/CreatePost";
    }
    @PostMapping("admin/post/save")
    public String showCategoryNewForm(Post post){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) authentication.getPrincipal();
//        user.getId();
//        post.setUser_id(user);

        post.setDateTime(LocalDateTime.now());
        postService.save(post);
        return "redirect:/admin/posts";
    }

    @GetMapping("/admin/posts")
    public String listPost(Model model){
        List<Post> listPost = postService.findAll();
        model.addAttribute("listPost", listPost);
        return "admin/post/ListPost";
    }

    @GetMapping("/category/post")
    public String postDetail(Model model){
        List<Post> listPost = postService.findAll();
        model.addAttribute("listPostDetail", listPost);
        return "user/Category";
    }

    @GetMapping("/post/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model){
        Post post = postRepository.findById(id).get();
        model.addAttribute("post", post);
        return "admin/post/CreatePost";
    }

    @GetMapping("post/delete/{id}")
    public String deletePost(@PathVariable("id") Integer id, Model model) {
        postRepository.deleteById(id);
        return "redirect:/admin/posts";
    }
}
