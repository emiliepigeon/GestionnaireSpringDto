package com.emi.GestionnaireFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emi.GestionnaireFormation.model.Module;

/**
 * Repository Spring Data JPA pour accéder à la table "module".
 * <p>
 * Cette interface hérite de {@link JpaRepository}, ce qui fournit
 * toutes les opérations CRUD de base, la pagination et la gestion des tris
 * pour l'entité {@link Module}. Il n'est pas nécessaire d'ajouter une
 * annotation (@Repository) sur cette interface, Spring s'en charge automatiquement[1][2][3][4][8].
 * <p>
 * Des méthodes personnalisées peuvent être ajoutées si besoin.
 *
 * @author CDA Afpa Emi
 */
public interface ModuleRepository extends JpaRepository<Module, Long> {
    // Ajouter ici des méthodes personnalisées si besoin
}
