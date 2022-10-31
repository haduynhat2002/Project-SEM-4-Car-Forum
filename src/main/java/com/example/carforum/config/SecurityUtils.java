package com.example.carforum.config;

import com.example.carforum.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {
    public static User getPrincipal() {
        return (User) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
    }
}
