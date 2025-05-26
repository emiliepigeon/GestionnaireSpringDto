package com.emi.GestionnaireFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emi.GestionnaireFormation.model.Centre;

/**
 * Repository Spring Data JPA pour accéder à la table "centre".
 * <p>
 * Cette interface hérite de {@link JpaRepository}, ce qui fournit
 * toutes les opérations CRUD de base, la pagination et la gestion des tris
 * pour l'entité {@link Centre}. Il n'est pas nécessaire d'ajouter une
 * annotation (@Repository) sur cette interface, Spring s'en charge automatiquement.
 * <p>
 * Des méthodes personnalisées peuvent être ajoutées si besoin.
 *
 * @author CDA Afpa Emi
 */
public interface CentreRepository extends JpaRepository<Centre, Long> {
    // Ajouter ici des méthodes personnalisées si besoin
}
