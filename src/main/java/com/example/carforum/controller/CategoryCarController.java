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


//    @RequestMapping(method = RequestMethod.GET, path = "{id}")
//    public ResponseEntity<?> findById(@PathVariable int id) {
//        Optional<CategoryCar> categoryCar = categoryCarService.findById(id);
//        if (!categoryCar.isPresent()){
//            ResponseEntity.badRequest().build();// khoong co du lieu tra ve
//        }
//        return ResponseEntity.ok(categoryCar.get());//cos du lieu tra ve
//    }
//    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
//    public ResponseEntity<CategoryCar> update(@PathVariable int id, @RequestBody CategoryCar updateCategoryCar){
//        Optional<CategoryCar> categoryCar = categoryCarService.findById(id);
//        if (!categoryCar.isPresent()){
//            ResponseEntity.badRequest().build();// khoong co du lieu tra ve
//        }
//        CategoryCar exitsCategoryCar = categoryCar.get();
//        exitsCategoryCar.setName(updateCategoryCar.getName());
////        exitsCategoryCar.setUser_id(updateCategoryCar.getUser_id());
//        exitsCategoryCar.setStatus(updateCategoryCar.getStatus());
//        return ResponseEntity.ok(categoryCarService.save(exitsCategoryCar));//cos du lieu tra ve
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
//    public ResponseEntity<?> delete(@PathVariable int id) {
//        Optional<CategoryCar> categoryCar = categoryCarService.findById(id);//tim product theo id
//        if (!categoryCar.isPresent()) {
//            ResponseEntity.badRequest().build();// khoong co du lieu tra ve
//        }
//        categoryCarService.deleteById(id);
//        return ResponseEntity.ok().build();//cos du lieu tra ve
//    }
}
