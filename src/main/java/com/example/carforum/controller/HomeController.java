package com.example.carforum.controller;

import com.example.carforum.entity.*;
import com.example.carforum.repository.*;
import com.example.carforum.service.*;
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
    CompanyService companyService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CarReviewRepository carReviewRepository;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserService userService;
    @Autowired
    CategoryCarService categoryCarService;
    @Autowired
    private DealerService dealerService;
    @Autowired
    PostService postService;
    @Autowired
    PriceCarRepository priceCarRepository;
    @GetMapping("/")
    public String listPost(Model model,
                           @RequestParam("page") Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size){
        List<CategoryCar> listCategoryCar = categoryCarService.findAll();
        List<User> userList = userRepository.findAll();
         List<Post> listPost1 = postRepository.listPost(1, 5);
        List<Post> listPost2 = postRepository.listPost(2, 5);
        List<Post> listPost4 = postRepository.listPost(4, 5);
        List<Post> listPost5 = postRepository.listPost(5, 5);

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(4);
        Page<Post> listPost3 = postService.findPaginatedByTopic(PageRequest.of(currentPage - 1, pageSize), 3);
        int totalPages = listPost3.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        List<Company> listCompany = companyService.findAll();
        model.addAttribute("listCompany", listCompany);
        model.addAttribute("listPost1", listPost1);
        model.addAttribute("listPost2", listPost2);
        model.addAttribute("listPost3", listPost3);
        model.addAttribute("listPost4", listPost4);
        model.addAttribute("listPost5", listPost5);
        model.addAttribute("user", userList);
        model.addAttribute("listCategoryCar",listCategoryCar );
        return "user/index";
    }
    @RequestMapping("/admin")
    public String index() {
        return "admin/index";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "user/contact";
    }

    @RequestMapping("/category")
    public String category() {
        return "user/Category";
    }

    @RequestMapping("/profile")
    public String profile() {
        return "user/Profile";
    }
    @RequestMapping("/dealer/{id}")
    public String dealer(@PathVariable("id") int id,Model model) {
        Dealer dealer = dealerService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));;
        List<Product> product = productRepository.listProduct(id);
        model.addAttribute("dealer", dealer);
        model.addAttribute("product", product);
        return "user/Dealer";
    }
    @RequestMapping("/priceDetail/{id}")
    public String PriceDetail(@PathVariable("id") int id,Model model) {
        List<PriceCar> PriceCar = priceCarRepository.listPriceCar(id);
        List<CarReview> carReviews = carReviewRepository.listCarReview(id);
        model.addAttribute("priceCar", PriceCar);
        model.addAttribute("carReviews", carReviews);

        return "user/Price-Detail";
    }
    @RequestMapping("/guide")
    public String guide() {
        return "/Guide";
    }

    @RequestMapping("/userAccount/{id}")
    public String userAccount(@PathVariable("id") int id,Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));;

        model.addAttribute("user", user);
        return "user/ProfileUser";
    }
    @RequestMapping("/company")
    public String authorized(Model model) {

        List<Company> listCompany = companyService.findAll();
        model.addAttribute("listCompany", listCompany);
        return "/Authorized";
    }
}

