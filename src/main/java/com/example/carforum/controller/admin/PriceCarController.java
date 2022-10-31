package com.example.carforum.controller.admin;


import com.example.carforum.entity.*;
import com.example.carforum.service.CarReviewService;
import com.example.carforum.service.CategoryCarService;
import com.example.carforum.service.PriceCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class PriceCarController {
    @Autowired
    PriceCarService priceCarService;
    @Autowired
    CarReviewService carReviewService;

    @Autowired
    private CategoryCarService categoryCarService;

    @GetMapping("/admin/priceCar/list")
    public String showPriceCar(Model model){
        List<PriceCar> priceCarList = priceCarService.finAll();
        List<CarReview> carReviewList = carReviewService.findAll();
        model.addAttribute("listPriceCar", priceCarList);
        model.addAttribute("carReviewList", carReviewList);
        return "admin/priceCar/List";
    }
    @GetMapping("/admin/priceCar/create")
    public String showCategoryNewForm(Model model){
        List<CategoryCar> listCategoryCar = categoryCarService.findAll();
        model.addAttribute("listCategoryCar",listCategoryCar );
        model.addAttribute("priceCar", new PriceCar());

        return "admin/priceCar/Create";
    }
    @PostMapping("/pricecar/save")
    public String showCategoryNewForm(PriceCar priceCar) {
        priceCarService.save(priceCar);

        return "redirect:/admin/priceCar/list";
    }
    @GetMapping("/indexpricecar")
    public String ShowPriceCarList(Model model){
        model.addAttribute("priceCar",priceCarService.finAll());
        return "sucessPrice";
    }
    @GetMapping("/editprice/{id}")
    public String showUpdatePriceCar(@PathVariable("id") int id , Model model){
        PriceCar priceCar = priceCarService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid price car Id:" + id));
        model.addAttribute("priceCar", priceCar);
        return "updatePriceCar";
    }
    @PostMapping("/updateprice/{id}")
    public String updatePriceCar(@PathVariable("id") int id, @Valid PriceCar priceCar,
                                  BindingResult result, Model model) {
        if (result.hasErrors()) {
            priceCar.setId(id);
            return "updatePriceCar";
        }

        priceCarService.save(priceCar);
        return "redirect:/indexpricecar";
    }

    @GetMapping("/deleteprice/{id}")
    public String deletePriceCar(@PathVariable("id") int id, Model model) {
        PriceCar priceCar = priceCarService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid price car Id:" + id));
        priceCarService.deleteById(id);
        return "redirect:/indexpricecar";
    }
    }
