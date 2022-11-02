package com.example.carforum.service;

import com.example.carforum.entity.Company;
import com.example.carforum.entity.Dealer;
import com.example.carforum.repository.CompanyRepository;
import com.example.carforum.repository.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class DealerService {
    @Autowired
    private DealerRepository dealerRepository;
    public List<Dealer> findAll() {return dealerRepository.findAll();
    }

    public Dealer save(Dealer dealer) {return dealerRepository.save(dealer);}

    public Optional<Dealer> findById(int id) {
        return dealerRepository.findById(id);
    }

    public void deleteById(int id) {
        dealerRepository.deleteById(id);
    }

}
