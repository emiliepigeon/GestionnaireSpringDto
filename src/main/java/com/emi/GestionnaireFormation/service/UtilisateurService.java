package com.emi.GestionnaireFormation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emi.GestionnaireFormation.model.Utilisateur;
import com.emi.GestionnaireFormation.repository.UtilisateurRepository;

// Service pour la gestion des utilisateurs
@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    // Retourne tous les utilisateurs
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    // Retourne un utilisateur par son matricule
    public Utilisateur findByMatricule(String matricule) {
        // On retourne directement le résultat, pas de .orElse(null)
        return utilisateurRepository.findByMatricule(matricule);
    }

    // Ajoute ou modifie un utilisateur
    public Utilisateur save(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    // Supprime un utilisateur par son matricule
    public void deleteByMatricule(String matricule) {
        Utilisateur utilisateur = utilisateurRepository.findByMatricule(matricule);
        if (utilisateur != null) {
            utilisateurRepository.delete(utilisateur);
        }
    }
}
