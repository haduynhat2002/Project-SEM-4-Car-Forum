package com.example.carforum.controller.admin;

import com.example.carforum.entity.CustomerUserDtls;
import com.example.carforum.entity.Post;
import com.example.carforum.entity.Topic;

import com.example.carforum.entity.User;
import com.example.carforum.entity.dto.PostDTO;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PostAdminController {
    @Autowired
    private PostService postService;
    @Autowired
    private TopicService topicService;

    @Autowired
    PostRepository postRepository;

    public static String UPLOAD_DIRECTORY = "D:/Project-SEM-4-Car-Forum/src/main/resources/static/uploads";//System.getProperty("post.image") + "/uploads";

    @GetMapping("/admin/post/create")
    public String showCategoryNewForm(Model model){
        List<Topic> listTopic = topicService.findAll();
        model.addAttribute("listTopic", listTopic);
        model.addAttribute("post", new PostDTO());
        return "admin/post/CreatePost";
    }
    @PostMapping("admin/post/save")
    public String showCategoryNewForm(PostDTO postDTO ,  @RequestParam("image") MultipartFile file,
                                      Model model)throws IOException {

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        CustomerUserDtls customerUserDtls = (CustomerUserDtls) authentication.getPrincipal();
        User user = null;//customerUserDtls.getU();

//        post.setUser_id(user);
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        model.addAttribute("msg", "Uploaded images: " + fileNames.toString());

        Post post = new Post();
        post.setContent(postDTO.getContent());
        post.setTopic(postDTO.getTopic());
        post.setTitle(postDTO.getTitle());
        post.setImage( "/uploads/" +  file.getOriginalFilename());
        post.setUser_id(user);

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
