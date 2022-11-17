package com.example.carforum.controller;

import com.example.carforum.entity.Comment;
import com.example.carforum.entity.Post;
import com.example.carforum.service.CommentService;
import com.example.carforum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ApiCommentController {
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @PostMapping(path = "/home/comment/save/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Comment> addComment(@RequestBody Map<String, String> params, @PathVariable("id") int id){
        try {
            String content = params.get("content");
            int postId = Integer.parseInt(params.get("postId"));

            Comment comment = this.commentService.addComment(content, postId);
            return new ResponseEntity<>(comment, HttpStatus.CREATED);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
