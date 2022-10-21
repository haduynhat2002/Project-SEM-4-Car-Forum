package com.example.carforum.controller;


import com.example.carforum.entity.CarReview;
import com.example.carforum.service.CarReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carrview")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class CarReviewController {
    @Autowired
    CarReviewService carReviewService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CarReview>> getList() {
        return ResponseEntity.ok(carReviewService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Optional<CarReview> carReview = carReviewService.findById(id);
        if (!carReview.isPresent()){
            ResponseEntity.badRequest().build();// khoong co du lieu tra ve
        }
        return ResponseEntity.ok(carReview.get());//cos du lieu tra ve
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CarReview> create(@RequestBody CarReview carReview) {
        return ResponseEntity.ok(carReviewService.save(carReview));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<CarReview> update(@PathVariable int id, @RequestBody CarReview updateCarReview){
        Optional<CarReview> carReview = carReviewService.findById(id);
        if (!carReview.isPresent()){
            ResponseEntity.badRequest().build();// khoong co du lieu tra ve
        }
        CarReview exitsCarReview = carReview.get();
        exitsCarReview.setTitle(updateCarReview.getTitle());
        exitsCarReview.setContent(updateCarReview.getContent());
        exitsCarReview.setType(updateCarReview.getType());
        exitsCarReview.setImage(updateCarReview.getImage());
        exitsCarReview.setCategoryCar(updateCarReview.getCategoryCar());
        exitsCarReview.setCategory_id(updateCarReview.getCategory_id());
        exitsCarReview.setViewcount(updateCarReview.getViewcount());
        exitsCarReview.setStatus(updateCarReview.getStatus());
        return ResponseEntity.ok(carReviewService.save(exitsCarReview));//cos du lieu tra ve
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<CarReview> carReview = carReviewService.findById(id);
        if (!carReview.isPresent()) {
            ResponseEntity.badRequest().build();// khoong co du lieu tra ve
        }
        carReviewService.deleteById(id);
        return ResponseEntity.ok().build();//cos du lieu tra ve
    }
}
