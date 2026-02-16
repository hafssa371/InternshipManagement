package com.example.intership.security;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session ->
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )
        .authorizeHttpRequests(auth -> auth

            // 🔓 AUTH
            .requestMatchers("/api/auth/**").permitAll()

            // 🔓 Swagger
            .requestMatchers("/swagger-ui/**").permitAll()
            .requestMatchers("/v3/api-docs/**").permitAll()

            // 🔐 ROLES
            .requestMatchers("/api/admin/**").hasRole("ADMIN")
            .requestMatchers("/api/recruteur/**").hasRole("RECRUTEUR")
            .requestMatchers("/api/candidat/**").hasRole("CANDIDAT")
            .requestMatchers("/api/users/**").hasRole("ADMIN")
            .requestMatchers("/api/candidatures/postulCandidature")
                .hasRole("CANDIDAT")

            .requestMatchers("/api/candidatures/download/**")
                .hasAnyRole("ADMIN","RECRUTEUR")

            .anyRequest().authenticated()
        );

    return http.build();
}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
