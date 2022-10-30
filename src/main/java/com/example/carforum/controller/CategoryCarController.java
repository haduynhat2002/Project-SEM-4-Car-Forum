package com.example.carforum.controller;


import com.example.carforum.entity.CategoryCar;
import com.example.carforum.service.CategoryCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryCarController {
    @Autowired
    private CategoryCarService categoryCarService;

}
