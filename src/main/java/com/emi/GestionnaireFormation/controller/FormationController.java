package com.emi.GestionnaireFormation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emi.GestionnaireFormation.dto.FormationDto;
import com.emi.GestionnaireFormation.mapper.FormationMapper;
import com.emi.GestionnaireFormation.model.Formation;
import com.emi.GestionnaireFormation.service.FormationService;

/**
 * Contrôleur REST pour gérer les formations.
 * Utilise FormationDto pour exposer uniquement les champs nécessaires.
 * Utilise FormationMapper pour convertir entre entité et DTO.
 *
 * @author CDA Afpa Emi
 */
@RestController
@RequestMapping("/formations")
public class FormationController {

    private final FormationService formationService;

    /**
     * Injection du service FormationService.
     */
    public FormationController(FormationService formationService) {
        this.formationService = formationService;
    }

    /**
     * Récupère toutes les formations et les convertit en DTO.
     *
     * @return liste de FormationDto
     */
    @GetMapping
    public List<FormationDto> getAllFormations() {
        return formationService.getAllFormations().stream()
                .map(FormationMapper::toDto) // Utilisation du mapper
                .collect(Collectors.toList());
    }

    /**
     * Crée une nouvelle formation à partir d'un DTO.
     *
     * @param dto les données de la formation à créer
     * @return la formation créée sous forme de DTO
     */
    @PostMapping
    public FormationDto createFormation(@RequestBody FormationDto dto) {
        Formation formation = FormationMapper.toEntity(dto); // Utilisation du mapper
        Formation saved = formationService.createFormation(formation);
        return FormationMapper.toDto(saved); // Utilisation du mapper
    }
}
