package com.emi.GestionnaireFormation.service;

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

    /**
     * Constructeur avec injection du repository RoleRepository.
     *
     * @param repository le repository pour l'entité Role
     */
    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }
    
    /**
     * Crée un nouveau rôle utilisateur.
     *
     * @param role l'entité Role à créer
     * @return le rôle créé et sauvegardé
     */
    public Role createRole(Role role) {
        return repository.save(role);
    }
}
