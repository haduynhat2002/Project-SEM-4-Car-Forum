package com.example.carforum.controller.admin;


import com.example.carforum.entity.CarReview;
import com.example.carforum.entity.CategoryCar;
import com.example.carforum.service.CarReviewService;
import com.example.carforum.service.CategoryCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class CarReviewController {
    @Autowired
    CarReviewService carReviewService;
    @Autowired
    private CategoryCarService categoryCarService;

    @GetMapping("admin/carreview/create")
    public String showCategoryNewForm(Model model){
        List<CategoryCar> listCategoryCar = categoryCarService.findAll();
        model.addAttribute("listCategoryCar",listCategoryCar );
        model.addAttribute("carReview", new CarReview());

        return "/admin/carReview/Create";
    }
    @PostMapping("admin/carreview/save")
    public String showCategoryNewForm(CarReview carReview){
        carReviewService.save(carReview);
        return "redirect:/index";
    }
    @GetMapping("/index")
    public String showCarReviewList(Model model) {
        model.addAttribute("carReview", carReviewService.findAll());
        return "sucess";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        CarReview carReview = carReviewService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid car review Id:" + id));

        model.addAttribute("carReview", carReview);
        return "updateCarreview";
    }
    @PostMapping("/update/{id}")
    public String updateCarReview(@PathVariable("id") int id, @Valid CarReview carReview,
                                  BindingResult result, Model model) {
        if (result.hasErrors()) {
            carReview.setId(id);
            return "updateCarreview";
        }

        carReviewService.save(carReview);
        return "redirect:/admin/carreview/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteCarReview(@PathVariable("id") int id, Model model) {
        CarReview carReview = carReviewService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid car review Id:" + id));
        carReviewService.deleteById(id);
        return "redirect:/index";
    }
}
