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

/**
 * Classe de configuration de la sécurité pour l'API.
 * 
 * Cette classe définit la configuration de sécurité de Spring Security,
 * incluant la gestion des utilisateurs en mémoire, le hashage des mots de passe
 * et la configuration des filtres de sécurité HTTP.
 */
@Configuration
public class SecurityConfigAPI {

    /**
     * Configure la chaîne de filtres de sécurité pour les requêtes HTTP.
     * 
     * Toutes les requêtes nécessitent une authentification.
     * Utilise l'authentification HTTP Basic par défaut.
     *
     * @param http l'objet HttpSecurity à configurer
     * @return la SecurityFilterChain configurée
     * @throws Exception en cas d'erreur de configuration
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Toutes les requêtes doivent être authentifiées (aucune URL publique)
        // Tous les endpoints sont "fermés"
        return http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests.anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults())
            .build();
    }
    // Autres exemple mélange de endpoints ouverts et de endpoints sont "fermés"
    // @Bean // Définition du bean SecurityFilterChain qui configure la sécurité HTTP.
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     return http
    //             .authorizeHttpRequests( // Configuration des autorisations des requêtes HTTP
    //                     authorizeRequests -> authorizeRequests.requestMatchers(
    //                             "/api/centres/",
    //                             "/api/formations/",
    //                             "/api/modules/",
    //                             "/api/roles/",
    //                             "/api/sequences/",
    //                             "/api/utilisateurs/").permitAll()
    //                             .requestMatchers("/api/utilisateurs/matricule/").authenticated()
    //                             .anyRequest().authenticated())
    //             .build();
    // }

    /**
     * Fournit un encodeur de mots de passe utilisant BCrypt.
     * 
     * Permet de stocker les mots de passe de façon sécurisée (hashage).
     *
     * @return un PasswordEncoder basé sur BCrypt
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Déclare un utilisateur de test en mémoire.
     * 
     * Utile pour les tests ou les petits projets sans base de données utilisateur.
     * L'utilisateur créé ici a pour nom "Mal" et mot de passe "Alatete" (hashé).
     *
     * @return un UserDetailsService avec un utilisateur en mémoire
     */
    @Bean
    public UserDetailsService userDetailsService() {
        // Création d'un utilisateur de test avec nom et mot de passe
        UserDetails utilisateur = User.withUsername("Mal")
                .password(passwordEncoder().encode("Alatete"))
                .build();
        return new InMemoryUserDetailsManager(utilisateur);
    }
}
