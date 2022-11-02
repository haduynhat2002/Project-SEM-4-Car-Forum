package com.example.carforum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String Home() { return "user/index"; }
    @RequestMapping("/admin/")
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

