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

/**
 * Contrôleur REST qui gère les routes pour les rôles.
 * Permet de récupérer la liste des rôles et le rôle d'un utilisateur.
 *
 * @author CDA Afpa Emi
 */
@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleRepository roleRepository;
    private final UtilisateurRepository utilisateurRepository;

    /**
     * Constructeur pour l'injection des repositories.
     *
     * @param roleRepository repository pour l'entité Role
     * @param utilisateurRepository repository pour l'entité Utilisateur
     */
    public RoleController(RoleRepository roleRepository, UtilisateurRepository utilisateurRepository) {
        this.roleRepository = roleRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    /**
     * Récupère la liste de tous les libellés des rôles.
     *
     * @return une liste de RoleDto (libellés des rôles)
     * @see RoleDto
     */
    @GetMapping("/")
    public List<RoleDto> getAllRolesLibelle() {
        List<Role> roles = roleRepository.findAll();
        // On transforme chaque Role en RoleDto (on ne garde que le libelle)
        return roles.stream()
                .map(role -> new RoleDto(role.getLibelle()))
                .toList();
    }

    /**
     * Récupère le libellé du rôle d'un utilisateur à partir de son matricule.
     *
     * @param matricule le matricule de l'utilisateur
     * @return une liste contenant le RoleDto correspondant, ou une liste vide si non trouvé
     * @see RoleDto
     */
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
