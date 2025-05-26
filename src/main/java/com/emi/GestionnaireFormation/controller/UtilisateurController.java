package com.emi.GestionnaireFormation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emi.GestionnaireFormation.dto.UtilisateurDto;
import com.emi.GestionnaireFormation.model.Utilisateur;
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

    /**
     * Constructeur pour l'injection du repository UtilisateurRepository.
     *
     * @param utilisateurRepository repository pour l'entité Utilisateur
     */
    public UtilisateurController(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    /**
     * Récupère la liste de tous les utilisateurs.
     *
     * @return une liste de UtilisateurDto
     */
    @GetMapping("/")
    public List<UtilisateurDto> findAll() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        // On transforme chaque Utilisateur en UtilisateurDto
        return utilisateurs.stream().map(utilisateur -> {
            UtilisateurDto dto = new UtilisateurDto();
            dto.setMatricule(utilisateur.getMatricule());
            dto.setNom(utilisateur.getNom());
            dto.setPrenom(utilisateur.getPrenom());
            dto.setAdresseMail(utilisateur.getAdresseMail());
            // On récupère le libelle du rôle s'il existe
            if (utilisateur.getRole() != null) {
                dto.setRoleLibelle(utilisateur.getRole().getLibelle());
            }
            return dto;
        }).collect(Collectors.toList());
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
        if (utilisateur == null) return null;
        UtilisateurDto dto = new UtilisateurDto();
        dto.setMatricule(utilisateur.getMatricule());
        dto.setNom(utilisateur.getNom());
        dto.setPrenom(utilisateur.getPrenom());
        dto.setAdresseMail(utilisateur.getAdresseMail());
        if (utilisateur.getRole() != null) {
            dto.setRoleLibelle(utilisateur.getRole().getLibelle());
        }
        return dto;
    }

    /**
     * Ajoute un nouvel utilisateur.
     *
     * @param utilisateurDto le DTO de l'utilisateur à créer
     * @return le DTO de l'utilisateur créé
     */
    @PostMapping("/create")
    public UtilisateurDto createUtilisateur(@RequestBody UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setMatricule(utilisateurDto.getMatricule());
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setAdresseMail(utilisateurDto.getAdresseMail());
        // Pour le rôle, il faut aller chercher l'objet Role en base selon le libelle (à faire dans le service)
        // utilisateur.setRole(...);

        Utilisateur saved = utilisateurRepository.save(utilisateur);

        UtilisateurDto dto = new UtilisateurDto();
        dto.setMatricule(saved.getMatricule());
        dto.setNom(saved.getNom());
        dto.setPrenom(saved.getPrenom());
        dto.setAdresseMail(saved.getAdresseMail());
        if (saved.getRole() != null) {
            dto.setRoleLibelle(saved.getRole().getLibelle());
        }
        return dto;
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
        // Pour le rôle, à compléter si besoin

        Utilisateur updated = utilisateurRepository.save(utilisateur);

        UtilisateurDto dto = new UtilisateurDto();
        dto.setMatricule(updated.getMatricule());
        dto.setNom(updated.getNom());
        dto.setPrenom(updated.getPrenom());
        dto.setAdresseMail(updated.getAdresseMail());
        if (updated.getRole() != null) {
            dto.setRoleLibelle(updated.getRole().getLibelle());
        }
        return dto;
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
