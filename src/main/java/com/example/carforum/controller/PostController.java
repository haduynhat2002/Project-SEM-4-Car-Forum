package com.example.carforum.controller;


import com.example.carforum.entity.Post;
import com.example.carforum.service.PostService;
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
@RequestMapping("api/v1/post")
public class PostController {
    @Autowired
    PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findAll(){
        return ResponseEntity.ok(postService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Post> save(@RequestBody Post post){
        return ResponseEntity.ok(postService.save(post));
    }
}
