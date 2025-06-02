package com.emi.GestionnaireFormation.mapper;

import com.emi.GestionnaireFormation.dto.SequenceDto;
import com.emi.GestionnaireFormation.model.Sequence;

/**
 * Mapper utilitaire pour convertir entre Sequence et SequenceDto.
 */
public class SequenceMapper {

    /**
     * Convertit une entité Sequence en DTO SequenceDto.
     * @param sequence l'entité Sequence
     * @return le DTO correspondant, ou null si sequence est null
     */
    public static SequenceDto toDto(Sequence sequence) {
        if (sequence == null) return null;
        SequenceDto dto = new SequenceDto();
        dto.setLibelle(sequence.getLibelle());
        dto.setDescription(sequence.getDescription());
        dto.setOrdre(sequence.getOrdre());
        return dto;
    }

    /**
     * Convertit un DTO SequenceDto en entité Sequence.
     * @param dto le DTO à convertir
     * @return l'entité Sequence, ou null si dto est null
     */
    public static Sequence toEntity(SequenceDto dto) {
        if (dto == null) return null;
        Sequence sequence = new Sequence();
        sequence.setLibelle(dto.getLibelle());
        sequence.setDescription(dto.getDescription());
        sequence.setOrdre(dto.getOrdre());
        return sequence;
    }
}
