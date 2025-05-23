package com.emi.GestionnaireFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emi.GestionnaireFormation.model.Utilisateur;

// Repository pour gérer les utilisateurs
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByMatricule(String matricule);
}
