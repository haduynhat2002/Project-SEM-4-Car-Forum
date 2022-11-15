package com.example.carforum.controller.admin;


import com.example.carforum.entity.*;
import com.example.carforum.repository.RoleRepository;
import com.example.carforum.repository.UserRepository;
import com.example.carforum.service.PostService;
import com.example.carforum.service.RoleService;
import com.example.carforum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserAdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @GetMapping("admin/users/list")
    public String listUser(Model model){
        List<Role> listRole = roleService.findAll();
        List<User> listUser = userService.findAll();
        model.addAttribute("listUser", listUser);
        model.addAttribute("listRole", listRole);
        return "admin/user/List";
    }

    @GetMapping("/admin/user/create")
    public String register() {
        return "admin/user/Create";
    }
    @PostMapping("/admin/user/create")
    public String register(@ModelAttribute User user, HttpSession session) {
        System.out.println(user.toString());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        user.setStatus(1);
        userService.save(user);
        session.setAttribute("message", "User register success....");
        return "redirect:/admin/users/list";
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
