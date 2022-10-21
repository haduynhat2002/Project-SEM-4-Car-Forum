package com.example.carforum.repository;


import com.example.carforum.entity.CarReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarReviewRepository extends JpaRepository<CarReview, Integer> {
}
