package com.example.carforum.controller.admin;


import com.example.carforum.entity.CategoryCar;
import com.example.carforum.service.CategoryCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryCarAdminController {
    @Autowired
    private CategoryCarService categoryCarService;
    @GetMapping("/admin/categoryCar")
    public String listCategory(Model model){
        List<CategoryCar> listCategoryCar = categoryCarService.findAll();
        model.addAttribute("listCategoryCar",listCategoryCar );
        return "admin/categoryCar/list";
    }
    @GetMapping("admin/categoryCar/create")
    public String showCategoryCar(Model model){
        model.addAttribute("categoryCar", new CategoryCar());
        return "admin/categoryCar/create";
    }
    @PostMapping("admin/categorycar/save")
    public String showCategoryNewForm(CategoryCar categoryCar){
//        categoryCar.setStatus('1');
        categoryCarService.save(categoryCar);
        return "redirect:/admin/categoryCar";
    }

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
