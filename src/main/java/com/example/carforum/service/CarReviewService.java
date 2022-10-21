package com.example.carforum.service;

import com.example.carforum.entity.CarReview;
import com.example.carforum.repository.CarReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarReviewService {
    @Autowired
    private CarReviewRepository carReviewRepository;

    public List<CarReview> findAll() {
        return carReviewRepository.findAll();
    }

    public CarReview save(CarReview carReview) {return carReviewRepository.save(carReview);}

    public Optional<CarReview> findById(int id) {return carReviewRepository.findById(id);}

    public void deleteById(int id) {
        carReviewRepository.deleteById(id);
    }
}
