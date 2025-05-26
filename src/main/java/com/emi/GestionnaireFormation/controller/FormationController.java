package com.emi.GestionnaireFormation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emi.GestionnaireFormation.dto.FormationDto;
import com.emi.GestionnaireFormation.model.Formation;
import com.emi.GestionnaireFormation.service.FormationService;

/**
 * Contrôleur REST pour gérer les formations.
 * Utilise FormationDto pour exposer uniquement les champs nécessaires.
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
                .map(this::toDto)
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
        Formation formation = new Formation();
        formation.setLibelle(dto.getLibelle());
        formation.setNumeroOffre(dto.getNumeroOffre());
        formation.setDateDebut(dto.getDateDebut());
        formation.setDateFin(dto.getDateFin());
        formation.setDateDebutPe(dto.getDateDebutPe());
        formation.setDateFinPe(dto.getDateFinPe());
        // On ne gère pas id ni statut ici

        Formation saved = formationService.createFormation(formation);
        return toDto(saved);
    }

    /**
     * Convertit une entité Formation en DTO.
     *
     * @param formation l'entité Formation
     * @return le DTO correspondant
     */
    private FormationDto toDto(Formation formation) {
        FormationDto dto = new FormationDto();
        dto.setLibelle(formation.getLibelle());
        dto.setNumeroOffre(formation.getNumeroOffre());
        dto.setDateDebut(formation.getDateDebut());
        dto.setDateFin(formation.getDateFin());
        dto.setDateDebutPe(formation.getDateDebutPe());
        dto.setDateFinPe(formation.getDateFinPe());
        // On n'expose pas id ni statut
        return dto;
    }
}
