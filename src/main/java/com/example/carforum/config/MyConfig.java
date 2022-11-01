package com.example.carforum.config;

import com.example.carforum.service.CustomerUserDtlsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService getUserDetailsService(){
        return new CustomerUserDtlsService();
    }
    @Bean
    public BCryptPasswordEncoder getPassword(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider daoProvider(){
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
        dao.setUserDetailsService(getUserDetailsService());
        dao.setPasswordEncoder(getPassword());
        return dao;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.authenticationProvider(daoProvider());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests()
                .antMatchers("/admin/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/post/new").hasRole("USER")
                .and()
                        .formLogin().
                        loginPage("/login").
                        loginProcessingUrl("/postlogin").
                        defaultSuccessUrl("/")
                .and().csrf().disable();
    }
}
