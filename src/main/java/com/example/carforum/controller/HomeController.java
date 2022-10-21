package com.example.carforum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    //    @RequestMapping("/home")
//    public String index() {
//        return "user/index";
//    }
    @RequestMapping("/admin/home")
    public String index() {
        return "admin/index";
    }
        @RequestMapping("/admin/home2")
    public String index2() {
        return "admin/index2";
    }
    @RequestMapping("/admin/home3")
    public String index3() {
        return "admin/index3";
    }
    @RequestMapping("/admin/general")
    public String charts() {
        return "admin/pages/UI/general";
    }
}

