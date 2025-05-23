package com.emi.GestionnaireFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emi.GestionnaireFormation.model.Sequence;
import com.emi.GestionnaireFormation.repository.SequenceRepository;

/**
 * Service pour la logique métier liée à l'entité Séquence.
 */
@Service
public class SequenceService {

    private final SequenceRepository sequenceRepository;

    public SequenceService(SequenceRepository sequenceRepository) {
        this.sequenceRepository = sequenceRepository;
    }

    // Récupérer toutes les séquences
    public List<Sequence> getAllSequences() {
        return sequenceRepository.findAll();
    }

    // Récupérer toutes les séquences d'un module
    public List<Sequence> getSequencesByModuleId(Long moduleId) {
        return sequenceRepository.findByModuleId(moduleId);
    }

    // Trouver une séquence par son id
    public Optional<Sequence> getSequenceById(Long id) {
        return sequenceRepository.findById(id);
    }

    // Créer une nouvelle séquence
    public Sequence createSequence(Sequence sequence) {
        return sequenceRepository.save(sequence);
    }

    // Modifier une séquence existante
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

    // Supprimer une séquence
    public void deleteSequence(Long id) {
        sequenceRepository.deleteById(id);
    }
}
