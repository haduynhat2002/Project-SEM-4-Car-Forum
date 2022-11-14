package com.example.carforum.serviceimpl;


import com.example.carforum.entity.Comment;
import com.example.carforum.entity.Post;
import com.example.carforum.entity.User;
import com.example.carforum.repository.CommentRepository;
import com.example.carforum.repository.PostRepository;
import com.example.carforum.repository.UserRepository;
import com.example.carforum.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Comment addComment(String content, int postId) {
        Post post = this.postRepository.getReferenceById(postId);
        Optional<User> _user = this.userRepository.findUserById(1);
        User user = null;
        Comment comment = new Comment();

        if(_user.isPresent()) {
            user = _user.get();

            comment.setContent(content);
            comment.setPost(post);
            comment.setUser(user);
            comment.setCreateDate(new Date());

            return this.commentRepository.save(comment);
        }
        return comment;
    }
}
