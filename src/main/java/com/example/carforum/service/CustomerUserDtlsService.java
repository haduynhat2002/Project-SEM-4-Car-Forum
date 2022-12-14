package com.example.carforum.service;


import com.example.carforum.entity.CustomerUserDtls;
import com.example.carforum.entity.User;
import com.example.carforum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDtlsService implements UserDetailsService {
    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findByUserName(username);

        if (user != null) {
            return new CustomerUserDtls(user);
        }

        throw new UsernameNotFoundException("user not available");
    }
}

