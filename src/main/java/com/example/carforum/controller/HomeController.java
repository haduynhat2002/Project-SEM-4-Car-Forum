package com.example.carforum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
    @RequestMapping("/home")
    public String index() {
        return "user/index";
    }
//@RequestMapping("/admin/home")
//public String index() {
//    return "admin/index";
//}
}
