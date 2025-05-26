package com.emi.GestionnaireFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emi.GestionnaireFormation.model.Formation;

/**
 * Repository Spring Data JPA pour accéder à la table "formation".
 * <p>
 * Cette interface hérite de {@link JpaRepository}, ce qui fournit
 * toutes les opérations CRUD de base, la pagination et la gestion des tris
 * pour l'entité {@link Formation}. Il n'est pas nécessaire d'ajouter une
 * annotation (@Repository) sur cette interface, Spring s'en charge automatiquement[1][3][4].
 * <p>
 * Des méthodes personnalisées peuvent être ajoutées si besoin.
 *
 * @author CDA Afpa Emi
 */
public interface FormationRepository extends JpaRepository<Formation, Long> {
    // Ajouter ici des méthodes personnalisées si besoin
}
