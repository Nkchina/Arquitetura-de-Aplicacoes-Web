package com.example.Authentication.and.Authorization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .requestMatchers(HttpMethod.POST, "/login/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/username/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/comum/**").permitAll()
                        .requestMatchers("/moderador/**").hasRole("MODERADOR")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()
                ).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails moderador = User.builder()
                .username("João")
                .password(passwordEncoder().encode("1234"))
                .roles("MODERADOR")
                .build();
        UserDetails comum = User.builder()
                .username("José")
                .password(passwordEncoder().encode("8080"))
                .roles("COMUM")
                .build();
        UserDetails admin = User.builder()
                .username("Nicolas")
                .password(passwordEncoder().encode("2820"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(moderador,admin,comum);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
