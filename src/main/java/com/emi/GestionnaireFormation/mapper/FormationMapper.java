package com.emi.GestionnaireFormation.mapper;

import com.emi.GestionnaireFormation.dto.FormationDto;
import com.emi.GestionnaireFormation.model.Formation;

/**
 * Mapper pour convertir entre Formation et FormationDto.
 * Je débute : c'est une classe utilitaire statique, pas besoin de l'instancier.
 */
public class FormationMapper {

    /**
     * Convertit une entité Formation en DTO FormationDto.
     * @param formation l'entité Formation
     * @return le DTO correspondant
     */
    public static FormationDto toDto(Formation formation) {
        if (formation == null) return null;
        FormationDto dto = new FormationDto();
        dto.setLibelle(formation.getLibelle());
        dto.setNumeroOffre(formation.getNumeroOffre());
        dto.setDateDebut(formation.getDateDebut());
        dto.setDateFin(formation.getDateFin());
        dto.setDateDebutPe(formation.getDateDebutPe());
        dto.setDateFinPe(formation.getDateFinPe());
        return dto;
    }

    /**
     * Convertit un DTO FormationDto en entité Formation.
     * @param dto le DTO
     * @return l'entité Formation
     */
    public static Formation toEntity(FormationDto dto) {
        if (dto == null) return null;
        Formation formation = new Formation();
        formation.setLibelle(dto.getLibelle());
        formation.setNumeroOffre(dto.getNumeroOffre());
        formation.setDateDebut(dto.getDateDebut());
        formation.setDateFin(dto.getDateFin());
        formation.setDateDebutPe(dto.getDateDebutPe());
        formation.setDateFinPe(dto.getDateFinPe());
        return formation;
    }
}
