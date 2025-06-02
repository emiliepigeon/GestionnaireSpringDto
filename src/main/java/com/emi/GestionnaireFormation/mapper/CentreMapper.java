package com.emi.GestionnaireFormation.mapper;

import com.emi.GestionnaireFormation.dto.CentreDto;
import com.emi.GestionnaireFormation.model.Centre;

/**
 * Mapper utilitaire pour convertir entre Centre et CentreDto.
 */
public class CentreMapper {

    /**
     * Convertit une entité Centre en DTO CentreDto.
     * @param centre l'entité Centre
     * @return le DTO correspondant, ou null si centre est null
     */
    public static CentreDto toDto(Centre centre) {
        if (centre == null) return null;
        return new CentreDto(centre.getNom(), centre.getAdresse(), centre.getCodePostal(), centre.getVille());
    }

    /**
     * Convertit un DTO CentreDto en entité Centre.
     * @param dto le DTO à convertir
     * @return l'entité Centre, ou null si dto est null
     */
    public static Centre toEntity(CentreDto dto) {
        if (dto == null) return null;
        Centre centre = new Centre();
        centre.setNom(dto.getNom());
        centre.setAdresse(dto.getAdresse());
        centre.setCodePostal(dto.getCodePostal());
        centre.setVille(dto.getVille());
        return centre;
    }
}
