package com.gestao_estoque.gestao_estoque.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.gestao_estoque.gestao_estoque.util.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

     @Autowired
    private JwtRequestFilter jwtRequestFilter;   

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers("/", "/home").permitAll()
                    .requestMatchers("/auth/login", "/auth/logout").permitAll()
                    .requestMatchers("/static/**").permitAll()
                    .requestMatchers("/public/**").permitAll()
                    .requestMatchers("/resources/**").permitAll()
                    .requestMatchers("/dashboard").authenticated()
                    .anyRequest().authenticated()
            )
            .formLogin(form -> form
                    .loginPage("/auth/login") // Alterado para incluir o prefixo
                    .defaultSuccessUrl("/dashboard", true)
                    .permitAll()
            )
            .logout(logout -> logout
                    .logoutUrl("/auth/logout") // Alterado para incluir o prefixo
                    .logoutSuccessUrl("/home?logout")
                    .permitAll()
            )
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class); // Registra o filtro JWT

    return http.build();
}

   
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = 
            http.getSharedObject(AuthenticationManagerBuilder.class);
        return authenticationManagerBuilder.build();
    }
}