package com.emi.GestionnaireFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emi.GestionnaireFormation.model.Formation;
import com.emi.GestionnaireFormation.repository.FormationRepository;

/**
 * Service pour la logique métier liée à l'entité Formation.
 * Fournit des méthodes pour gérer les formations.
 *
 * @author CDA Afpa Emi
 */
@Service
public class FormationService {

    private final FormationRepository formationRepository;

    /**
     * Constructeur avec injection du repository FormationRepository.
     *
     * @param formationRepository le repository pour l'entité Formation
     */
    public FormationService(FormationRepository formationRepository) {
        this.formationRepository = formationRepository;
    }

    /**
     * Récupère la liste de toutes les formations.
     *
     * @return une liste de formations
     */
    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    /**
     * Recherche une formation par son identifiant.
     *
     * @param id l'identifiant de la formation
     * @return un Optional contenant la formation si elle existe, sinon vide
     */
    public Optional<Formation> getFormationById(Long id) {
        return formationRepository.findById(id);
    }

    /**
     * Crée une nouvelle formation.
     *
     * @param formation l'entité Formation à créer
     * @return la formation créée et sauvegardée
     */
    public Formation createFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    /**
     * Met à jour une formation existante.
     *
     * @param id l'identifiant de la formation à modifier
     * @param details les nouvelles valeurs de la formation
     * @return un Optional contenant la formation mise à jour si elle existe, sinon vide
     */
    public Optional<Formation> updateFormation(Long id, Formation details) {
        return formationRepository.findById(id).map(formation -> {
            formation.setLibelle(details.getLibelle());
            formation.setNumeroOffre(details.getNumeroOffre());
            formation.setDateDebut(details.getDateDebut());
            formation.setDateFin(details.getDateFin());
            formation.setDateDebutPe(details.getDateDebutPe());
            formation.setDateFinPe(details.getDateFinPe());
            formation.setStatut(details.getStatut());
            return formationRepository.save(formation);
        });
    }

    /**
     * Supprime une formation par son identifiant.
     *
     * @param id l'identifiant de la formation à supprimer
     */
    public void deleteFormation(Long id) {
        formationRepository.deleteById(id);
    }
}
