package com.emi.GestionnaireFormation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emi.GestionnaireFormation.dto.RoleDto;
import com.emi.GestionnaireFormation.model.Role;
import com.emi.GestionnaireFormation.model.Utilisateur;
import com.emi.GestionnaireFormation.repository.RoleRepository;
import com.emi.GestionnaireFormation.repository.UtilisateurRepository;

/**
 * Contrôleur REST qui gère les routes pour les rôles.
 * Permet de récupérer la liste des rôles et les rôles d'un utilisateur.
 *
 * @author CDA Afpa Emi
 */
@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleRepository roleRepository;
    private final UtilisateurRepository utilisateurRepository;

    public RoleController(RoleRepository roleRepository, UtilisateurRepository utilisateurRepository) {
        this.roleRepository = roleRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    /**
     * Récupère la liste de tous les libellés des rôles.
     * @return une liste de RoleDto (libellés des rôles)
     */
    @GetMapping("/")
    public List<RoleDto> getAllRolesLibelle() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream()
                .map(role -> new RoleDto(role.getLibelle()))
                .collect(Collectors.toList());
    }

    /**
     * Récupère les libellés des rôles d'un utilisateur à partir de son matricule.
     * @param matricule le matricule de l'utilisateur
     * @return une liste de RoleDto correspondant, ou une liste vide si non trouvé
     */
    @GetMapping("/utilisateur/{matricule}")
    public List<RoleDto> getRoleLibelleByUtilisateur(@PathVariable String matricule) {
        Utilisateur utilisateur = utilisateurRepository.findByMatricule(matricule);
        if (utilisateur != null && utilisateur.getRoles() != null) {
            // MODIF: gestion des rôles multiples
            return utilisateur.getRoles().stream()
                    .map(role -> new RoleDto(role.getLibelle()))
                    .collect(Collectors.toList());
        } else {
            return List.of();
        }
    }
}
