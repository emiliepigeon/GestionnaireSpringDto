package com.emi.GestionnaireFormation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emi.GestionnaireFormation.dto.CentreDto;
import com.emi.GestionnaireFormation.model.Centre;
import com.emi.GestionnaireFormation.service.CentreService;

/**
 * Contrôleur REST pour l'entité Centre.
 * Permet de gérer les opérations CRUD sur les centres de formation.
 * 
 * @author CDA Afpa Emi
 */
@RestController
@RequestMapping("/centres")
public class CentreController {

    private final CentreService centreService;

    /**
     * Constructeur pour l'injection du service CentreService.
     * 
     * @param centreService service métier pour l'entité Centre
     */
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
            .map(this::toDto)
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
        Centre centre = toEntity(dto);
        Centre saved = centreService.createCentre(centre);
        return toDto(saved);
    }

    // Méthodes de conversion
    private CentreDto toDto(Centre centre) {
        return new CentreDto(
            centre.getNom(),
            centre.getAdresse(),
            centre.getCodePostal(),
            centre.getVille()
        );
    }

    private Centre toEntity(CentreDto dto) {
        Centre centre = new Centre();
        centre.setNom(dto.getNom());
        centre.setAdresse(dto.getAdresse());
        centre.setCodePostal(dto.getCodePostal());
        centre.setVille(dto.getVille());
        // Vous pouvez définir un statut par défaut ici si besoin
        return centre;
    }
}
