package com.emi.GestionnaireFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emi.GestionnaireFormation.model.Module;

/**
 * Repository pour accéder à la table module.
 */
public interface ModuleRepository extends JpaRepository<Module, Long> {
    // Je peux ajouter des méthodes personnalisées ici si besoin
}
