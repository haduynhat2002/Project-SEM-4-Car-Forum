package com.example.carforum.repository;


import com.example.carforum.entity.CarReview;
import com.example.carforum.entity.PriceCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarReviewRepository extends JpaRepository <CarReview, Integer> {
    @Query(value = "select * from CarReview carReview where carReview.category_id = :id order by id DESC ", nativeQuery = true)
    List<CarReview> listCarReview(int id);
}
