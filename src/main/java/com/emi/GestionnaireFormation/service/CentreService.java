package com.emi.GestionnaireFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emi.GestionnaireFormation.model.Centre;
import com.emi.GestionnaireFormation.repository.CentreRepository;

/**
 * Service pour la logique métier liée à l'entité Centre.
 */
@Service
public class CentreService {

    private final CentreRepository centreRepository;

    // Injection du repository via le constructeur
    public CentreService(CentreRepository centreRepository) {
        this.centreRepository = centreRepository;
    }

    // Récupérer tous les centres
    public List<Centre> getAllCentres() {
        return centreRepository.findAll();
    }

    // Trouver un centre par son id
    public Optional<Centre> getCentreById(Long id) {
        return centreRepository.findById(id);
    }

    // Créer un nouveau centre
    public Centre createCentre(Centre centre) {
        return centreRepository.save(centre);
    }

    // Modifier un centre existant
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

    // Supprimer un centre
    public void deleteCentre(Long id) {
        centreRepository.deleteById(id);
    }
}
