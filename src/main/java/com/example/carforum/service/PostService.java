package com.example.carforum.service;

import com.example.carforum.entity.Post;
import com.example.carforum.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public Post save(Post post) {
        return postRepository.save(post);
    }
    public List<Post> findAll() {
        return postRepository.findAll();
    }
    public Optional<Post> finById(int id) {
        return postRepository.findById(id);
    }

    public List<Post> findAllByUserId(int userId) {
        return postRepository.findAllByUserId(userId);
    }

    public Page<Post> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Post> list;

        List<Post> posts = findAll();

        if (posts.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, posts.size());
            list = posts.subList(startItem, toIndex);
        }

        Page<Post> bookPage
                = new PageImpl<Post>(list,
                PageRequest.of(currentPage, pageSize), posts.size());

        return bookPage;
    }
    public Page<Post> findPaginatedByTopic(Pageable pageable, int id) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Post> list;

        List<Post> posts = postRepository.listPost(id);

        if (posts.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, posts.size());
            list = posts.subList(startItem, toIndex);
        }

        Page<Post> bookPage
                = new PageImpl<Post>(list,
                PageRequest.of(currentPage, pageSize), posts.size());

        return bookPage;
    }

    public Page<Post> findPaginateLasteddByTopic(int id) {
        int pageSize = 5;
        int currentPage = 1;
        int startItem = currentPage * pageSize;
        List<Post> list;

        List<Post> posts = postRepository.listPostOrderBy(id);

        if (posts.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, posts.size());
            list = posts.subList(startItem, toIndex);
        }

        Page<Post> bookPage
                = new PageImpl<Post>(list,
                PageRequest.of(currentPage, pageSize), posts.size());

        return bookPage;
    }

}
