package com.jihun.simpleGame.auth.config;


import com.jihun.simpleGame.service.AuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class UserDetailsServiceConfig {
    @Bean
    public UserDetailsService userDetailsService(AuthService authService) {
        return authService::loadUserByUsername;
    }

}
