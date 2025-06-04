package com.emi.GestionnaireFormation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emi.GestionnaireFormation.dto.CentreDto;
import com.emi.GestionnaireFormation.mapper.CentreMapper;
import com.emi.GestionnaireFormation.model.Centre;
import com.emi.GestionnaireFormation.service.CentreService;

/**
 * Contrôleur REST pour l'entité Centre.
 * Permet de gérer les opérations CRUD sur les centres de formation.
 * Utilise CentreMapper pour convertir entité <-> DTO.
 *
 * @author CDA Afpa Emi
 */
@RestController
@RequestMapping("/api/centres")
public class CentreController {

    private final CentreService centreService;

    public CentreController(CentreService centreService) {
        this.centreService = centreService;
    }

    /**
     * Récupère la liste de tous les centres de formation sous forme de DTO.
     *
     * @return une liste de CentreDto
     */
    @GetMapping({"", "/"})
    public List<CentreDto> getAllCentres() {
        return centreService.getAllCentres().stream()
            .map(CentreMapper::toDto) // Utilisation du mapper
            .collect(Collectors.toList());
    }

    /**
     * Crée un nouveau centre de formation à partir d'un DTO.
     *
     * @param dto l'objet CentreDto à créer
     * @return le centre créé sous forme de DTO
     */
    @PostMapping("/create")
    public CentreDto createCentre(@RequestBody CentreDto dto) {
        Centre centre = CentreMapper.toEntity(dto); // Utilisation du mapper
        Centre saved = centreService.createCentre(centre);
        return CentreMapper.toDto(saved); // Utilisation du mapper
    }
}
