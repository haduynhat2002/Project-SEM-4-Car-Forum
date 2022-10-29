package com.example.carforum.controller.admin;


import com.example.carforum.entity.CarReview;
import com.example.carforum.entity.CategoryCar;
import com.example.carforum.service.CarReviewService;
import com.example.carforum.service.CategoryCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CarReviewController {
    @Autowired
    CarReviewService carReviewService;
    @Autowired
    private CategoryCarService categoryCarService;
//    @RequestMapping(method = RequestMethod.GET, path = "{id}")
//    public ResponseEntity<?> findById(@PathVariable int id) {
//        Optional<CarReview> carReview = carReviewService.findById(id);
//        if (!carReview.isPresent()){
//            ResponseEntity.badRequest().build();// khoong co du lieu tra ve
//        }
//        return ResponseEntity.ok(carReview.get());//cos du lieu tra ve
//    }

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
        return "redirect:/admin/carreview/create";
    }

//    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
//    public ResponseEntity<CarReview> update(@PathVariable int id, @RequestBody CarReview updateCarReview){
//        Optional<CarReview> carReview = carReviewService.findById(id);
//        if (!carReview.isPresent()){
//            ResponseEntity.badRequest().build();// khoong co du lieu tra ve
//        }
//        CarReview exitsCarReview = carReview.get();
//        exitsCarReview.setTitle(updateCarReview.getTitle());
//        exitsCarReview.setContent(updateCarReview.getContent());
//        exitsCarReview.setType(updateCarReview.getType());
//        exitsCarReview.setImage(updateCarReview.getImage());
//        exitsCarReview.setCategoryCar(updateCarReview.getCategoryCar());
//        exitsCarReview.setViewcount(updateCarReview.getViewcount());
//        exitsCarReview.setStatus(updateCarReview.getStatus());
//        return ResponseEntity.ok(carReviewService.save(exitsCarReview));//cos du lieu tra ve
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
//    public ResponseEntity<?> delete(@PathVariable int id) {
//        Optional<CarReview> carReview = carReviewService.findById(id);
//        if (!carReview.isPresent()) {
//            ResponseEntity.badRequest().build();// khoong co du lieu tra ve
//        }
//        carReviewService.deleteById(id);
//        return ResponseEntity.ok().build();//cos du lieu tra ve
//    }
}
