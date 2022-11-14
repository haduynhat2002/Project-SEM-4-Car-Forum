package com.example.carforum.service;

import com.example.carforum.entity.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    Comment addComment(String content, int postId);
}
