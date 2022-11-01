package com.example.carforum.repository;

import com.example.carforum.entity.CategoryCar;
import com.example.carforum.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
