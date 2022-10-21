package com.example.carforum.repository;

import com.example.carforum.entity.CategoryCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryCarRepository extends JpaRepository<CategoryCar, Integer> {
}
