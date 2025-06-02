package com.emi.GestionnaireFormation.mapper;

import com.emi.GestionnaireFormation.dto.ModuleDto;
import com.emi.GestionnaireFormation.model.Module;

/**
 * Mapper utilitaire pour convertir entre Module et ModuleDto.
 */
public class ModuleMapper {

    /**
     * Convertit une entité Module en DTO ModuleDto.
     * @param module l'entité Module
     * @return le DTO correspondant, ou null si module est null
     */
    public static ModuleDto toDto(Module module) {
        if (module == null) return null;
        ModuleDto dto = new ModuleDto();
        dto.setNom(module.getNom());
        dto.setDescription(module.getDescription());
        return dto;
    }

    /**
     * Convertit un DTO ModuleDto en entité Module.
     * @param dto le DTO à convertir
     * @return l'entité Module, ou null si dto est null
     */
    public static Module toEntity(ModuleDto dto) {
        if (dto == null) return null;
        Module module = new Module();
        module.setNom(dto.getNom());
        module.setDescription(dto.getDescription());
        return module;
    }
}
