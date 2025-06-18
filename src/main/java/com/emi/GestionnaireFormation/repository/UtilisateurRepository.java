package com.emi.GestionnaireFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emi.GestionnaireFormation.model.Utilisateur;

/**
 * Repository Spring Data JPA pour accéder à la table "utilisateur".
 */
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByMatricule(String matricule);
}
