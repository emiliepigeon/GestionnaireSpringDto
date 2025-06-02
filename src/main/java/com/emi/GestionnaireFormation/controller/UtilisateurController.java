package com.emi.GestionnaireFormation.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Objects;

import org.springframework.web.bind.annotation.*;

import com.emi.GestionnaireFormation.dto.UtilisateurDto;
import com.emi.GestionnaireFormation.model.Role;
import com.emi.GestionnaireFormation.model.Utilisateur;
import com.emi.GestionnaireFormation.repository.RoleRepository;
import com.emi.GestionnaireFormation.repository.UtilisateurRepository;
import com.emi.GestionnaireFormation.mapper.UtilisateurMapper;

/**
 * Contrôleur REST pour les utilisateurs.
 * Utilise UtilisateurDto pour exposer uniquement les champs nécessaires.
 * Utilise UtilisateurMapper pour convertir entité <-> DTO.
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
     *
     * @return une liste de UtilisateurDto
     */
    @GetMapping("/")
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream()
            .map(UtilisateurMapper::toDto) // Utilisation du mapper
            .collect(Collectors.toList());
    }

    /**
     * Récupère un utilisateur par son matricule.
     *
     * @param matricule le matricule de l'utilisateur
     * @return le UtilisateurDto correspondant, ou null si non trouvé
     */
    @GetMapping("/{matricule}")
    public UtilisateurDto findByMatricule(@PathVariable String matricule) {
        Utilisateur utilisateur = utilisateurRepository.findByMatricule(matricule);
        return utilisateur != null ? UtilisateurMapper.toDto(utilisateur) : null;
    }

    /**
     * Ajoute un nouvel utilisateur.
     *
     * @param utilisateurDto le DTO de l'utilisateur à créer
     * @return le DTO de l'utilisateur créé
     */
    @PostMapping("/create")
    public UtilisateurDto createUtilisateur(@RequestBody UtilisateurDto utilisateurDto) {
        Set<Role> roles = utilisateurDto.getRoleLibelle().stream()
            .map(libelle -> roleRepository.findByLibelle(libelle).orElse(null))
            .filter(Objects::nonNull)
            .collect(Collectors.toSet());
        Utilisateur utilisateur = UtilisateurMapper.toEntity(utilisateurDto, roles); // Utilisation du mapper
        Utilisateur saved = utilisateurRepository.save(utilisateur);
        return UtilisateurMapper.toDto(saved); // Utilisation du mapper
    }

    /**
     * Modifie un utilisateur existant.
     *
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
        Set<Role> roles = utilisateurDto.getRoleLibelle().stream()
            .map(libelle -> roleRepository.findByLibelle(libelle).orElse(null))
            .filter(Objects::nonNull)
            .collect(Collectors.toSet());
        utilisateur.setRoles(roles);
        Utilisateur updated = utilisateurRepository.save(utilisateur);
        return UtilisateurMapper.toDto(updated); // Utilisation du mapper
    }

    /**
     * Supprime un utilisateur par son matricule.
     *
     * @param matricule le matricule de l'utilisateur à supprimer
     */
    @DeleteMapping("/delete/{matricule}")
    public void deleteUtilisateur(@PathVariable String matricule) {
        Utilisateur utilisateur = utilisateurRepository.findByMatricule(matricule);
        if (utilisateur != null) {
            utilisateurRepository.delete(utilisateur);
        }
    }
}
