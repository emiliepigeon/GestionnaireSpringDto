package com.emi.GestionnaireFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emi.GestionnaireFormation.model.Role;
import com.emi.GestionnaireFormation.repository.RoleRepository;

/**
 * Service pour la logique métier liée à l'entité Role.
 * Fournit des méthodes pour gérer les rôles utilisateurs.
 *
 * @author CDA Afpa Emi
 */
@Service
public class RoleService {

    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    /**
     * Crée un nouveau rôle utilisateur.
     * @param role l'entité Role à créer
     * @return le rôle créé et sauvegardé
     */
    public Role createRole(Role role) {
        return repository.save(role);
    }

    /**
     * Récupère tous les rôles.
     * @return liste des rôles
     */
    public List<Role> findAll() {
        return repository.findAll();
    }

    /**
     * Recherche un rôle par son id.
     * @param id identifiant du rôle
     * @return rôle optionnel
     */
    public Optional<Role> findById(Long id) {
        return repository.findById(id);
    }

    /**
     * Recherche un rôle par son libellé.
     * @param libelle libellé du rôle
     * @return rôle optionnel
     */
    public Optional<Role> findByLibelle(String libelle) {
        return repository.findByLibelle(libelle);
    }

    /**
     * Supprime un rôle par son id.
     * @param id identifiant du rôle
     */
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
