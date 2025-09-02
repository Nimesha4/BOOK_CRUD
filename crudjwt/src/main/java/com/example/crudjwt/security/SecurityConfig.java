package com.example.crudjwt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll()
                // Allow GET for all products and single product for USER and ADMIN
                .requestMatchers(org.springframework.http.HttpMethod.GET, "/products", "/products/{id}").hasAnyRole("USER", "ADMIN")
                // Allow POST, PUT, DELETE for ADMIN only
                .requestMatchers(org.springframework.http.HttpMethod.POST, "/products").hasRole("ADMIN")
                .requestMatchers(org.springframework.http.HttpMethod.PUT, "/products/{id}").hasRole("ADMIN")
                .requestMatchers(org.springframework.http.HttpMethod.DELETE, "/products/{id}").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
