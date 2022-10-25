package com.example.carforum.controller;


import com.example.carforum.entity.*;
import com.example.carforum.service.CarReviewService;
import com.example.carforum.service.CategoryCarService;
import com.example.carforum.service.PriceCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/pricecardetai")
    public String showPriceCar(Model model){
        List<PriceCar> priceCarList = priceCarService.finAll();
        List<CarReview> carReviewList = carReviewService.findAll();
        model.addAttribute("listPriceCar", priceCarList);
        model.addAttribute("carReviewList", carReviewList);
        return "user/Price-Detail";
    }
    @GetMapping("/admin/priceCar/create")
    public String showCategoryNewForm(Model model){
        List<CategoryCar> listCategoryCar = categoryCarService.findAll();
        model.addAttribute("listCategoryCar",listCategoryCar );
        model.addAttribute("priceCar", new PriceCar());

        return "priceCarForm";
    }
    @PostMapping("/pricecar/save")
    public String showCategoryNewForm(PriceCar priceCar){
        priceCarService.save(priceCar);
        return "redirect:/sucess";
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Optional<PriceCar> priceCar = priceCarService.findById(id);
        if (!priceCar.isPresent()){
            ResponseEntity.badRequest().build();// khoong co du lieu tra ve
        }
        return ResponseEntity.ok(priceCar.get());//cos du lieu tra ve
    }

//    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
//    public ResponseEntity<PriceCar> update(@PathVariable int id, @RequestBody PriceCar updatePriceCar){
//        Optional<PriceCar> priceCar = priceCarService.findById(id);
//        if (!priceCar.isPresent()){
//            ResponseEntity.badRequest().build();
//        }
//        PriceCar exitsPriceCar = priceCar.get();
//        exitsPriceCar.setName(updatePriceCar.getName());
//        exitsPriceCar.setCategoryCar(updatePriceCar.getCategoryCar());
//        exitsPriceCar.setListed_price(updatePriceCar.getListed_price());
//        exitsPriceCar.setRolling_price(updatePriceCar.getRolling_price());
//        exitsPriceCar.setStatus(updatePriceCar.getStatus());
//        return ResponseEntity.ok(priceCarService.save(exitsPriceCar));//cos du lieu tra ve
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
//    public ResponseEntity<?> delete(@PathVariable int id) {
//        Optional<PriceCar> priceCar = priceCarService.findById(id);//tim product theo id
//        if (!priceCar.isPresent()) {
//            ResponseEntity.badRequest().build();// khoong co du lieu tra ve
//        }
//        priceCarService.deleteById(id);
//        return ResponseEntity.ok().build();//cos du lieu tra ve
//    }
}
