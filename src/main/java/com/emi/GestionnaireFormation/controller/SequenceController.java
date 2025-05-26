package com.emi.GestionnaireFormation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emi.GestionnaireFormation.dto.SequenceDto;
import com.emi.GestionnaireFormation.model.Sequence;
import com.emi.GestionnaireFormation.service.SequenceService;

/**
 * Contrôleur REST pour gérer les séquences pédagogiques.
 * Utilise SequenceDto pour exposer uniquement les champs nécessaires.
 *
 * @author CDA Afpa Emi
 */
@RestController
@RequestMapping("/sequences")
public class SequenceController {

    private final SequenceService sequenceService;

    /**
     * Injection du service SequenceService.
     */
    public SequenceController(SequenceService sequenceService) {
        this.sequenceService = sequenceService;
    }

    /**
     * Récupère toutes les séquences et les convertit en DTO.
     *
     * @return liste de SequenceDto
     */
    @GetMapping
    public List<SequenceDto> getAllSequences() {
        return sequenceService.getAllSequences().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Crée une nouvelle séquence à partir d'un DTO.
     *
     * @param dto les données de la séquence à créer
     * @return la séquence créée sous forme de DTO
     */
    @PostMapping
    public SequenceDto createSequence(@RequestBody SequenceDto dto) {
        Sequence sequence = new Sequence();
        sequence.setLibelle(dto.getLibelle());
        sequence.setDescription(dto.getDescription());
        sequence.setOrdre(dto.getOrdre());
        // On ne gère pas statut ni moduleId ici

        Sequence saved = sequenceService.createSequence(sequence);
        return toDto(saved);
    }

    /**
     * Convertit une entité Sequence en DTO.
     *
     * @param sequence l'entité Sequence
     * @return le DTO correspondant
     */
    private SequenceDto toDto(Sequence sequence) {
        SequenceDto dto = new SequenceDto();
        dto.setLibelle(sequence.getLibelle());
        dto.setDescription(sequence.getDescription());
        dto.setOrdre(sequence.getOrdre());
        // On n'expose pas statut ni moduleId
        return dto;
    }
}
