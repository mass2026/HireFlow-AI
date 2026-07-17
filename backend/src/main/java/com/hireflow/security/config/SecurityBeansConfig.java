package com.hireflow.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Purpose:
 * Defines security-related Spring beans used across the application.
 *
 * Responsibilities:
 * - Provide PasswordEncoder bean.
 *
 * Future Beans:
 * - AuthenticationManager
 * - UserDetailsService
 */
@Configuration
public class SecurityBeansConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}