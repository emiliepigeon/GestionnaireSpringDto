package com.emi.GestionnaireFormation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emi.GestionnaireFormation.model.Sequence;

/**
 * Repository pour accéder à la table sequence.
 */
public interface SequenceRepository extends JpaRepository<Sequence, Long> {
    // Exemple de méthode personnalisée : trouver toutes les séquences d'un module
    List<Sequence> findByModuleId(Long moduleId);
}
