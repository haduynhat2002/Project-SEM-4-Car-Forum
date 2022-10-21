package com.example.carforum.repository;

 import com.example.carforum.entity.PriceCar;
import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;


@Repository
public interface PriceCarRepository extends JpaRepository<PriceCar, Integer> {
}
