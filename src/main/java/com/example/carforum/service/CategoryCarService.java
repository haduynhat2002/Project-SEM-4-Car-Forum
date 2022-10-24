package com.example.carforum.service;


import com.example.carforum.entity.CarReview;
import com.example.carforum.entity.CategoryCar;
import com.example.carforum.repository.CategoryCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryCarService {
    @Autowired
    private CategoryCarRepository categoryCarRepository;

    public List<CategoryCar> finAll(){return categoryCarRepository.findAll();}

    public List<CategoryCar> findAll() {
        return categoryCarRepository.findAll();
    }

    public CategoryCar save(CategoryCar categoryCar) {return categoryCarRepository.save(categoryCar);}

    public Optional<CategoryCar> findById(int id) {
        return categoryCarRepository.findById(id);
    }

    public void deleteById(int id) {
        categoryCarRepository.deleteById(id);
    }

}
