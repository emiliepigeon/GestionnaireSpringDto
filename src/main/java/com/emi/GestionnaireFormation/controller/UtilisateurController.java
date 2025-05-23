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

// Contrôleur qui gère les routes pour les utilisateurs
@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurController(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    // Récupérer tous les utilisateurs (GET)
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

    // Récupérer un utilisateur par son matricule (GET)
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

    // Ajouter un utilisateur (POST)
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

    // Modifier un utilisateur (PUT)
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

    // Supprimer un utilisateur (DELETE)
    @DeleteMapping("/delete/{matricule}")
    public void deleteUtilisateur(@PathVariable String matricule) {
        Utilisateur utilisateur = utilisateurRepository.findByMatricule(matricule);
        if (utilisateur != null) {
            utilisateurRepository.delete(utilisateur);
        }
    }
}
