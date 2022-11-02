package com.example.carforum.repository;

import com.example.carforum.entity.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealerRepository extends JpaRepository<Dealer, Integer> {
}
