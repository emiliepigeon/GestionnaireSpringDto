package com.emi.GestionnaireFormation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emi.GestionnaireFormation.dto.RoleDto;
import com.emi.GestionnaireFormation.model.Role;
import com.emi.GestionnaireFormation.model.Utilisateur;
import com.emi.GestionnaireFormation.repository.RoleRepository;
import com.emi.GestionnaireFormation.repository.UtilisateurRepository;

// Contrôleur qui gère les routes pour les rôles
@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleRepository roleRepository;
    private final UtilisateurRepository utilisateurRepository;

    public RoleController(RoleRepository roleRepository, UtilisateurRepository utilisateurRepository) {
        this.roleRepository = roleRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    // GET /roles/ : renvoie la liste de tous les libellés des rôles
    @GetMapping("/")
    public List<RoleDto> getAllRolesLibelle() {
        List<Role> roles = roleRepository.findAll();
        // On transforme chaque Role en RoleDto (on ne garde que le libelle)
        return roles.stream()
                .map(role -> new RoleDto(role.getLibelle()))
                .toList();
    }

    // GET /roles/utilisateur/{matricule} : renvoie le libelle du rôle d'un utilisateur précis
    @GetMapping("/utilisateur/{matricule}")
    public List<RoleDto> getRoleLibelleByUtilisateur(@PathVariable String matricule) {
        Utilisateur utilisateur = utilisateurRepository.findByMatricule(matricule);
        if (utilisateur != null && utilisateur.getRole() != null) {
            // On retourne le libelle du rôle de l'utilisateur dans une liste
            return List.of(new RoleDto(utilisateur.getRole().getLibelle()));
        } else {
            // Si l'utilisateur ou son rôle n'existe pas, on retourne une liste vide
            return List.of();
        }
    }
}
