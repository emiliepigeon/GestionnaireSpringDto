package com.emi.GestionnaireFormation.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigAPI {
    // Gestions des requêtes Http
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            return http
                .authorizeHttpRequests(authorizeRequests->
                authorizeRequests.anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults())
                .build();
        }

    // Gestion du hashage du password
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new  BCryptPasswordEncoder();
    }

    // Gestion user test
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails utilisateur = User.withUsername("Mal")
                .password(passwordEncoder().encode("Alatete"))
                .build();
            return new InMemoryUserDetailsManager(utilisateur);
    }

}