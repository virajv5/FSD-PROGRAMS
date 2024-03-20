package com.fsdproject.springbootconcept.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@EnableMethodSecurity
@Configuration

public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(){
    UserDetails normaluser = User
            .withUsername("admin")
            .password(passwordEncoder().encode("admin"))
            .roles("NORMAL")
            .build();

    UserDetails adminuser = User
            .withUsername("admin1")
            .password(passwordEncoder().encode("admin"))
            .roles("NORMAL")
            .build();


        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(normaluser, adminuser);
        return inMemoryUserDetailsManager;
    }
}
