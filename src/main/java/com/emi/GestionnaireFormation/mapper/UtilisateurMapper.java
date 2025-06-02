package com.emi.GestionnaireFormation.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.emi.GestionnaireFormation.dto.UtilisateurDto;
import com.emi.GestionnaireFormation.model.Role;
import com.emi.GestionnaireFormation.model.Utilisateur;

/**
 * Mapper utilitaire pour convertir entre Utilisateur et UtilisateurDto.
 * Je débute : On centralise la logique de conversion pour éviter la duplication.
 */
public class UtilisateurMapper {

    public static UtilisateurDto toDto(Utilisateur utilisateur) {
        if (utilisateur == null) return null;
        UtilisateurDto dto = new UtilisateurDto();
        dto.setMatricule(utilisateur.getMatricule());
        dto.setNom(utilisateur.getNom());
        dto.setPrenom(utilisateur.getPrenom());
        dto.setAdresseMail(utilisateur.getAdresseMail());
        dto.setRoleLibelle(utilisateur.getRoles() == null ? List.of() :
                utilisateur.getRoles().stream()
                        .map(Role::getLibelle)
                        .collect(Collectors.toList()));
        return dto;
    }

    public static Utilisateur toEntity(UtilisateurDto dto, Set<Role> roles) {
        if (dto == null) return null;
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setMatricule(dto.getMatricule());
        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setAdresseMail(dto.getAdresseMail());
        utilisateur.setRoles(roles);
        return utilisateur;
    }
}
