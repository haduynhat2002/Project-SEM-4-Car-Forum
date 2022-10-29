package com.example.carforum.controller;


import com.example.carforum.entity.Role;
import com.example.carforum.entity.UserDtls;
import com.example.carforum.repository.RoleRepository;
import com.example.carforum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @GetMapping("/register")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "user/Login";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserDtls user, HttpSession session) {
        System.out.println(user.toString());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findByName("ROLE_USER");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        user.setStatus(1);
        userService.save(user);
        session.setAttribute("message", "User register success....");
        return "redirect:/login";
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_USER");
        return roleRepository.save(role);
    }
}
