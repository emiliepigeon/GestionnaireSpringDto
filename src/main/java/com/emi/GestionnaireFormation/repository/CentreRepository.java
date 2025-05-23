package com.emi.GestionnaireFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emi.GestionnaireFormation.model.Centre;

/**
 * Repository pour accéder à la table centre.
 */
public interface CentreRepository extends JpaRepository<Centre, Long> {
    // Je peux ajouter des méthodes personnalisées ici si besoin
}
