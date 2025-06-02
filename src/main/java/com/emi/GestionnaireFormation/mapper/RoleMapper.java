package com.emi.GestionnaireFormation.mapper;

import com.emi.GestionnaireFormation.dto.RoleDto;
import com.emi.GestionnaireFormation.model.Role;

/**
 * Mapper utilitaire pour convertir entre Role et RoleDto.
 */
public class RoleMapper {

    /**
     * Convertit une entité Role en DTO RoleDto.
     * @param role l'entité Role
     * @return le DTO correspondant, ou null si role est null
     */
    public static RoleDto toDto(Role role) {
        if (role == null) return null;
        return new RoleDto(role.getLibelle());
    }

    /**
     * Convertit un DTO RoleDto en entité Role.
     * @param dto le DTO à convertir
     * @return l'entité Role, ou null si dto est null
     */
    public static Role toEntity(RoleDto dto) {
        if (dto == null) return null;
        Role role = new Role();
        role.setLibelle(dto.getLibelle());
        return role;
    }
}
