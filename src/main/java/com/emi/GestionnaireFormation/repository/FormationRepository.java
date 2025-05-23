package com.emi.GestionnaireFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emi.GestionnaireFormation.model.Formation;

// Interface pour accéder à la table formation
public interface FormationRepository extends JpaRepository<Formation, Long> {
    // Je peux ajouter des méthodes personnalisées ici si besoin
}
