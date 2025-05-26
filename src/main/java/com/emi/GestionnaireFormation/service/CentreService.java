package com.emi.GestionnaireFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emi.GestionnaireFormation.model.Centre;
import com.emi.GestionnaireFormation.repository.CentreRepository;

/**
 * Service pour la logique métier liée à l'entité Centre.
 * Fournit des méthodes pour gérer les centres de formation.
 *
 * @author CDA Afpa Emi
 */
@Service
public class CentreService {

    private final CentreRepository centreRepository;

    /**
     * Constructeur avec injection du repository CentreRepository.
     *
     * @param centreRepository le repository pour l'entité Centre
     */
    public CentreService(CentreRepository centreRepository) {
        this.centreRepository = centreRepository;
    }

    /**
     * Récupère la liste de tous les centres.
     *
     * @return une liste de centres
     */
    public List<Centre> getAllCentres() {
        return centreRepository.findAll();
    }

    /**
     * Recherche un centre par son identifiant.
     *
     * @param id l'identifiant du centre
     * @return un Optional contenant le centre s'il existe, sinon vide
     */
    public Optional<Centre> getCentreById(Long id) {
        return centreRepository.findById(id);
    }

    /**
     * Crée un nouveau centre de formation.
     *
     * @param centre l'entité Centre à créer
     * @return le centre créé et sauvegardé
     */
    public Centre createCentre(Centre centre) {
        return centreRepository.save(centre);
    }

    /**
     * Met à jour un centre existant.
     *
     * @param id l'identifiant du centre à modifier
     * @param details les nouvelles valeurs du centre
     * @return un Optional contenant le centre mis à jour s'il existe, sinon vide
     */
    public Optional<Centre> updateCentre(Long id, Centre details) {
        return centreRepository.findById(id).map(centre -> {
            centre.setNom(details.getNom());
            centre.setAdresse(details.getAdresse());
            centre.setCodePostal(details.getCodePostal());
            centre.setVille(details.getVille());
            centre.setStatut(details.getStatut());
            return centreRepository.save(centre);
        });
    }

    /**
     * Supprime un centre par son identifiant.
     *
     * @param id l'identifiant du centre à supprimer
     */
    public void deleteCentre(Long id) {
        centreRepository.deleteById(id);
    }
}
