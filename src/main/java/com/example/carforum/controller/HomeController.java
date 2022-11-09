package com.example.carforum.controller;

import com.example.carforum.entity.CategoryCar;
import com.example.carforum.entity.Dealer;
import com.example.carforum.entity.Post;
import com.example.carforum.entity.User;
import com.example.carforum.repository.PostRepository;
import com.example.carforum.repository.UserRepository;
import com.example.carforum.service.CategoryCarService;
import com.example.carforum.service.DealerService;
import com.example.carforum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class HomeController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CategoryCarService categoryCarService;
    @Autowired
    private DealerService dealerService;
    @Autowired
    PostService postService;
    @GetMapping("/")
    public String listPost(Model model,
                           @RequestParam("page") Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size){
        List<CategoryCar> listCategoryCar = categoryCarService.findAll();

        List<User> userList = userRepository.findAll();

         List<Post> listPost1 = postRepository.listPost(1, 5);
        List<Post> listPost2 = postRepository.listPost(2, 5);
        //List<Post> listPost3 = postRepository.listPost(3);


        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Page<Post> listPost3 = postService.findPaginatedByTopic(PageRequest.of(currentPage - 1, pageSize), 3);
        int totalPages = listPost3.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("listPost1", listPost1);
        model.addAttribute("listPost2", listPost2);
        model.addAttribute("listPost3", listPost3);
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
    @RequestMapping("/dealer/{id}")
    public String dealer(@PathVariable("id") int id,Model model) {
        Dealer dealer = dealerService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));;

        model.addAttribute("dealer", dealer);
        return "user/Dealer";
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

