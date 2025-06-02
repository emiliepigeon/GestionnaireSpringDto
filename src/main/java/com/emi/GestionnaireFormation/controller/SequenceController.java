package com.emi.GestionnaireFormation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emi.GestionnaireFormation.dto.SequenceDto;
import com.emi.GestionnaireFormation.mapper.SequenceMapper;
import com.emi.GestionnaireFormation.model.Sequence;
import com.emi.GestionnaireFormation.service.SequenceService;

/**
 * Contrôleur REST pour gérer les séquences pédagogiques.
 * Utilise SequenceDto pour exposer uniquement les champs nécessaires.
 * Utilise SequenceMapper pour convertir entité <-> DTO.
 *
 * @author CDA Afpa Emi
 */
@RestController
@RequestMapping("/sequences")
public class SequenceController {

    private final SequenceService sequenceService;

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
                .map(SequenceMapper::toDto) // Utilisation du mapper
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
        Sequence sequence = SequenceMapper.toEntity(dto); // Utilisation du mapper
        Sequence saved = sequenceService.createSequence(sequence);
        return SequenceMapper.toDto(saved); // Utilisation du mapper
    }
}
