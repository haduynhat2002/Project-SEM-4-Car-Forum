package com.example.carforum.controller;


import com.example.carforum.entity.*;
import com.example.carforum.entity.dto.AccountLoginDto;
import com.example.carforum.repository.RoleRepository;
import com.example.carforum.repository.UserRepository;
import com.example.carforum.service.PostService;
import com.example.carforum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PostService postService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @GetMapping("/register")
    public String home(Model model) {
        model.addAttribute("user", new User());
        return "user/Register";
    }

    @GetMapping("/login")
    public String login( Model model) {
        model.addAttribute("user" , new AccountLoginDto());
        return "user/Login";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user, HttpSession session , BindingResult bindingResult , Model model) {
        if (bindingResult.hasErrors()){
            return "redirect:/register";
        }else {
            System.out.println(user.toString());
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            Role role = roleRepository.findByName("ROLE_USER");
            if(role == null){
                role = checkRoleExist();
            }
            user.setRoles(Arrays.asList(role));
            user.setStatus(1);
            session.setAttribute("message", "User register success....");
            userService.save(user);
            return "redirect:/login";
        }
    }

    @GetMapping("/profile")
    public String profile(Principal p, Model m) {
        String em = p.getName();
        User user = userRepository.findByUserName(em);
        m.addAttribute("email", user.getEmail());
        m.addAttribute("fullname", user.getFullname());
        m.addAttribute("dob", user.getDob());
        m.addAttribute("phone", user.getPhone());
        m.addAttribute("avatar", user.getAvatar());
        m.addAttribute("address", user.getAddress());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object o = authentication.getPrincipal();
        List<Post> listPost = new ArrayList<>();
        if(o instanceof String && "anonymousUser".equals(String.valueOf(o))) {//chua login
        } else {
            CustomerUserDtls customerUserDtls = (CustomerUserDtls) authentication.getPrincipal();
            User u = customerUserDtls.getU();
            listPost = postService.findAllByUserId(u.getId());
        }

        m.addAttribute("listPost", listPost);
        return "user/profile";
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_USER");
        return roleRepository.save(role);
    }
}
