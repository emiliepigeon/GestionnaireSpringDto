package com.emi.GestionnaireFormation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import com.emi.GestionnaireFormation.dto.UtilisateurDto;
import com.emi.GestionnaireFormation.model.Role;
import com.emi.GestionnaireFormation.model.Utilisateur;
import com.emi.GestionnaireFormation.repository.RoleRepository;
import com.emi.GestionnaireFormation.repository.UtilisateurRepository;

/**
 * Contrôleur REST qui gère les routes pour les utilisateurs.
 * Permet de gérer les opérations CRUD sur les utilisateurs de la plateforme.
 *
 * @author CDA Afpa Emi
 */
@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurRepository utilisateurRepository;
    private final RoleRepository roleRepository;

    public UtilisateurController(UtilisateurRepository utilisateurRepository, RoleRepository roleRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.roleRepository = roleRepository;
    }

    /**
     * Récupère la liste de tous les utilisateurs.
     * @return une liste de UtilisateurDto
     */
    @GetMapping("/")
    public List<UtilisateurDto> findAll() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        return utilisateurs.stream().map(this::toDto).collect(Collectors.toList());
    }

    /**
     * Récupère un utilisateur par son matricule.
     * @param matricule le matricule de l'utilisateur
     * @return le UtilisateurDto correspondant, ou null si non trouvé
     */
    @GetMapping("/{matricule}")
    public UtilisateurDto findByMatricule(@PathVariable String matricule) {
        Utilisateur utilisateur = utilisateurRepository.findByMatricule(matricule);
        return utilisateur != null ? toDto(utilisateur) : null;
    }

    /**
     * Ajoute un nouvel utilisateur.
     * @param utilisateurDto le DTO de l'utilisateur à créer
     * @return le DTO de l'utilisateur créé
     */
    @PostMapping("/create")
    public UtilisateurDto createUtilisateur(@RequestBody UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = toEntity(utilisateurDto);
        Utilisateur saved = utilisateurRepository.save(utilisateur);
        return toDto(saved);
    }

    /**
     * Modifie un utilisateur existant.
     * @param matricule le matricule de l'utilisateur à modifier
     * @param utilisateurDto le DTO contenant les nouvelles valeurs
     * @return le DTO de l'utilisateur mis à jour, ou null si non trouvé
     */
    @PutMapping("/update/{matricule}")
    public UtilisateurDto updateUtilisateur(@PathVariable String matricule, @RequestBody UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = utilisateurRepository.findByMatricule(matricule);
        if (utilisateur == null) return null;
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setAdresseMail(utilisateurDto.getAdresseMail());
        utilisateur.setRoles(getRolesFromLibelles(utilisateurDto.getRoleLibelle())); // MODIF: gestion des rôles multiples
        Utilisateur updated = utilisateurRepository.save(utilisateur);
        return toDto(updated);
    }

    /**
     * Supprime un utilisateur par son matricule.
     * @param matricule le matricule de l'utilisateur à supprimer
     */
    @DeleteMapping("/delete/{matricule}")
    public void deleteUtilisateur(@PathVariable String matricule) {
        Utilisateur utilisateur = utilisateurRepository.findByMatricule(matricule);
        if (utilisateur != null) {
            utilisateurRepository.delete(utilisateur);
        }
    }

    /**
     * Convertit un Utilisateur en UtilisateurDto.
     * @param utilisateur l'entité Utilisateur
     * @return le DTO correspondant
     */
    private UtilisateurDto toDto(Utilisateur utilisateur) {
        UtilisateurDto dto = new UtilisateurDto();
        dto.setMatricule(utilisateur.getMatricule());
        dto.setNom(utilisateur.getNom());
        dto.setPrenom(utilisateur.getPrenom());
        dto.setAdresseMail(utilisateur.getAdresseMail());
        // MODIF: gestion des rôles multiples
        dto.setRoleLibelle(utilisateur.getRoles().stream()
            .map(Role::getLibelle)
            .collect(Collectors.toList()));
        return dto;
    }

    /**
     * Convertit un UtilisateurDto en Utilisateur.
     * @param dto le DTO
     * @return l'entité Utilisateur
     */
    private Utilisateur toEntity(UtilisateurDto dto) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setMatricule(dto.getMatricule());
        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setAdresseMail(dto.getAdresseMail());
        utilisateur.setRoles(getRolesFromLibelles(dto.getRoleLibelle())); // MODIF
        return utilisateur;
    }

    /**
     * Récupère les rôles à partir d'une liste de libellés.
     * @param libelles liste des libellés de rôles
     * @return Set<Role>
     */
    private java.util.Set<Role> getRolesFromLibelles(List<String> libelles) {
        return libelles == null ? new java.util.HashSet<>() :
            libelles.stream()
                .map(roleRepository::findByLibelle)
                .filter(java.util.Optional::isPresent)
                .map(java.util.Optional::get)
                .collect(Collectors.toSet());
    }
}
