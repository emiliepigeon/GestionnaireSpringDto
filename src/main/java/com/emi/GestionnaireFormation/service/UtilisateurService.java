package com.emi.GestionnaireFormation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emi.GestionnaireFormation.model.Utilisateur;
import com.emi.GestionnaireFormation.repository.UtilisateurRepository;

/**
 * Service pour la gestion des utilisateurs.
 * Fournit des méthodes pour gérer les opérations courantes sur l'entité Utilisateur.
 *
 * @author CDA Afpa Emi
 */
@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    /**
     * Retourne la liste de tous les utilisateurs.
     * @return une liste d'utilisateurs
     */
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    /**
     * Recherche un utilisateur par son matricule.
     * @param matricule le matricule de l'utilisateur
     * @return l'utilisateur correspondant, ou null si non trouvé
     */
    public Utilisateur findByMatricule(String matricule) {
        return utilisateurRepository.findByMatricule(matricule);
    }

    /**
     * Ajoute ou modifie un utilisateur.
     * @param utilisateur l'entité Utilisateur à sauvegarder
     * @return l'utilisateur sauvegardé
     */
    public Utilisateur save(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    /**
     * Supprime un utilisateur par son matricule.
     * @param matricule le matricule de l'utilisateur à supprimer
     */
    public void deleteByMatricule(String matricule) {
        Utilisateur utilisateur = utilisateurRepository.findByMatricule(matricule);
        if (utilisateur != null) {
            utilisateurRepository.delete(utilisateur);
        }
    }
}
