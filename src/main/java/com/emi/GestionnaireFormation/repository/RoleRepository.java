package com.emi.GestionnaireFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emi.GestionnaireFormation.model.Role;

/**
 * Repository Spring Data JPA pour accéder à la table "role".
 * <p>
 * Cette interface hérite de {@link JpaRepository}, ce qui fournit
 * toutes les opérations CRUD de base, la pagination et la gestion des tris
 * pour l'entité {@link Role}.
 * <p>
 * Elle expose également une méthode personnalisée pour rechercher un rôle par son libellé.
 *
 * @author CDA Afpa Emi
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * Recherche un rôle par son libellé.
     *
     * @param libelle le libellé du rôle (ex : "ADMIN", "USER")
     * @return le rôle correspondant, ou null si non trouvé
     */
    Role findByLibelle(String libelle);
}
