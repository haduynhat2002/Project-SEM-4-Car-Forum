package com.example.carforum.service;

import com.example.carforum.entity.Company;
import com.example.carforum.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> finAll(){return companyRepository.findAll();}

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company save(Company company) {return companyRepository.save(company);}

    public Optional<Company> findById(int id) {
        return companyRepository.findById(id);
    }

    public void deleteById(int id) {
        companyRepository.deleteById(id);
    }
}
