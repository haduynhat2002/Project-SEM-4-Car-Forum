package com.example.carforum.service;


import com.example.carforum.entity.CategoryCar;
import com.example.carforum.entity.PriceCar;
import com.example.carforum.repository.CategoryCarRepository;
import com.example.carforum.repository.PriceCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceCarService {
    @Autowired
    private PriceCarRepository priceCarRepository;

    public List<PriceCar> finAll(){return priceCarRepository.findAll();}

    public PriceCar save(PriceCar priceCar) {return priceCarRepository.save(priceCar);}

    public Optional<PriceCar> findById(int id) {
        return priceCarRepository.findById(id);
    }

    public void deleteById(int id) {
        priceCarRepository.deleteById(id);
    }
}
