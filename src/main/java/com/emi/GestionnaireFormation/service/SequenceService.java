package com.emi.GestionnaireFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emi.GestionnaireFormation.model.Sequence;
import com.emi.GestionnaireFormation.repository.SequenceRepository;

/**
 * Service pour la logique métier liée à l'entité Séquence.
 * Fournit des méthodes pour gérer les séquences pédagogiques.
 *
 * @author CDA Afpa Emi
 */
@Service
public class SequenceService {

    private final SequenceRepository sequenceRepository;

    /**
     * Constructeur avec injection du repository SequenceRepository.
     *
     * @param sequenceRepository le repository pour l'entité Séquence
     */
    public SequenceService(SequenceRepository sequenceRepository) {
        this.sequenceRepository = sequenceRepository;
    }

    /**
     * Récupère la liste de toutes les séquences.
     *
     * @return une liste de séquences
     */
    public List<Sequence> getAllSequences() {
        return sequenceRepository.findAll();
    }

    /**
     * Récupère toutes les séquences associées à un module donné.
     *
     * @param moduleId l'identifiant du module
     * @return une liste de séquences liées à ce module
     */
    public List<Sequence> getSequencesByModuleId(Long moduleId) {
        return sequenceRepository.findByModuleId(moduleId);
    }

    /**
     * Recherche une séquence par son identifiant.
     *
     * @param id l'identifiant de la séquence
     * @return un Optional contenant la séquence si elle existe, sinon vide
     */
    public Optional<Sequence> getSequenceById(Long id) {
        return sequenceRepository.findById(id);
    }

    /**
     * Crée une nouvelle séquence pédagogique.
     *
     * @param sequence l'entité Séquence à créer
     * @return la séquence créée et sauvegardée
     */
    public Sequence createSequence(Sequence sequence) {
        return sequenceRepository.save(sequence);
    }

    /**
     * Met à jour une séquence existante.
     *
     * @param id l'identifiant de la séquence à modifier
     * @param details les nouvelles valeurs de la séquence
     * @return un Optional contenant la séquence mise à jour si elle existe, sinon vide
     */
    public Optional<Sequence> updateSequence(Long id, Sequence details) {
        return sequenceRepository.findById(id).map(sequence -> {
            sequence.setLibelle(details.getLibelle());
            sequence.setDescription(details.getDescription());
            sequence.setOrdre(details.getOrdre());
            sequence.setStatut(details.getStatut());
            sequence.setModule(details.getModule());
            return sequenceRepository.save(sequence);
        });
    }

    /**
     * Supprime une séquence par son identifiant.
     *
     * @param id l'identifiant de la séquence à supprimer
     */
    public void deleteSequence(Long id) {
        sequenceRepository.deleteById(id);
    }
}
