package com.example.carforum.repository;

import com.example.carforum.entity.Topics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topics, Integer> {
}
