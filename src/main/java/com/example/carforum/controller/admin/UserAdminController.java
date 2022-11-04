package com.example.carforum.controller.admin;


import com.example.carforum.entity.*;
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
    private PostService postService;

    @GetMapping("admin/users/list")
    public String listCategory(Model model){
        List<User> listTopic = userService.findAll();
        model.addAttribute("listUser", listTopic);
        return "admin/user/List";
    }
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @GetMapping("/admin/user/create")
    public String home() {
        return "admin/user/Create";
    }



    @PostMapping("/admin/user/create")
    public String register(@ModelAttribute User user, HttpSession session) {
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

//    @GetMapping("/profile")
//    public String profile(Principal p, Model m) {
//        String em = p.getName();
//        User user = userRepository.findByEmail(em);
//        m.addAttribute("email", user.getEmail());
//        m.addAttribute("fullname", user.getFullname());
//        m.addAttribute("dob", user.getDob());
//        m.addAttribute("phone", user.getPhone());
//        m.addAttribute("avatar", user.getAvatar());
//        m.addAttribute("address", user.getAddress());
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Object o = authentication.getPrincipal();
//        List<Post> listPost = new ArrayList<>();
//        if(o instanceof String && "anonymousUser".equals(String.valueOf(o))) {//chua login
//        } else {
//            CustomerUserDtls customerUserDtls = (CustomerUserDtls) authentication.getPrincipal();
//            User u = customerUserDtls.getU();
//            listPost = postService.findAllByUserId(u.getId());
//        }
//
//        m.addAttribute("listPost", listPost);
//        return "user/profile";
//    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_USER");
        return roleRepository.save(role);
    }
}