package com.emi.GestionnaireFormation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emi.GestionnaireFormation.model.Sequence;

/**
 * Repository Spring Data JPA pour accéder à la table "sequence".
 * <p>
 * Cette interface hérite de {@link JpaRepository}, ce qui fournit
 * toutes les opérations CRUD de base, la pagination et la gestion des tris
 * pour l'entité {@link Sequence}.
 * <p>
 * Elle expose également une méthode personnalisée pour rechercher toutes les séquences
 * associées à un module donné.
 *
 * @author CDA Afpa Emi
 */
public interface SequenceRepository extends JpaRepository<Sequence, Long> {

    /**
     * Recherche toutes les séquences associées à un module donné.
     *
     * @param moduleId l'identifiant du module
     * @return une liste de séquences liées à ce module
     */
    List<Sequence> findByModuleId(Long moduleId);
}
