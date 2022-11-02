package com.example.carforum.controller;

import com.example.carforum.entity.CategoryCar;
import com.example.carforum.entity.Post;
import com.example.carforum.entity.User;
import com.example.carforum.repository.CategoryCarRepository;
import com.example.carforum.repository.PostRepository;
import com.example.carforum.repository.UserRepository;
import com.example.carforum.service.CategoryCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CategoryCarService categoryCarService;
    @GetMapping("/")
    public String listPost(Model model){
        List<CategoryCar> listCategoryCar = categoryCarService.findAll();

        List<User> userList = userRepository.findAll();
        List<Post> listPost1 = postRepository.listPost(1);
        List<Post> listPost2 = postRepository.listPost(2);
        List<Post> listPost6 = postRepository.listPost(6);
        model.addAttribute("listPost1", listPost1);
        model.addAttribute("listPost2", listPost2);
        model.addAttribute("listPost6", listPost6);
        model.addAttribute("user", userList);
        model.addAttribute("listCategoryCar",listCategoryCar );
        return "user/index";
    }
    @RequestMapping("/admin")
    public String index() {
        return "admin/index";
    }
//        @RequestMapping("/admin/home2")
//    public String index2() {
//        return "admin/index2";
//    }
//    @RequestMapping("/admin/home3")
//    public String index3() {
//        return "admin/index3";
//    }
    @RequestMapping("/contact")
    public String contact() {
        return "user/contact";
    }
//    @RequestMapping("/login")
//    public String login() {
//        return "user/Login";
//    }
    @RequestMapping("/category")
    public String category() {
        return "user/Category";
    }
//    @RequestMapping("/register")
//    public String register() {
//        return "user/Register";
//    }
    @RequestMapping("/profile")
    public String profile() {
        return "user/Profile";
    }
    @RequestMapping("/priceCar")
    public String CarReview() {
        return "user/Car-review";
    }
    @RequestMapping("/priceDetail")
    public String PriceDetail() {
        return "user/Price-Detail";
    }
    @RequestMapping("/guide")
    public String guide() {
        return "/Guide";
    }
    @RequestMapping("/authorized")
    public String authorized() {
        return "/Authorized";
    }
}

