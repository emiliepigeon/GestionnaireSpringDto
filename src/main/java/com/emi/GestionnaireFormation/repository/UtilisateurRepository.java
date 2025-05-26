package com.emi.GestionnaireFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emi.GestionnaireFormation.model.Utilisateur;

/**
 * Repository Spring Data JPA pour accéder à la table "utilisateur".
 * <p>
 * Cette interface hérite de {@link JpaRepository}, ce qui fournit
 * toutes les opérations CRUD de base, la pagination et la gestion des tris
 * pour l'entité {@link Utilisateur}.
 * <p>
 * Elle expose également une méthode personnalisée pour rechercher un utilisateur par son matricule.
 *
 * @author CDA Afpa Emi
 */
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    /**
     * Recherche un utilisateur par son matricule.
     *
     * @param matricule le matricule de l'utilisateur
     * @return l'utilisateur correspondant, ou null si non trouvé
     */
    Utilisateur findByMatricule(String matricule);
}
