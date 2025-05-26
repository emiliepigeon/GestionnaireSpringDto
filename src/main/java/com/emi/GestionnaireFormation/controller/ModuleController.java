package com.emi.GestionnaireFormation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emi.GestionnaireFormation.dto.ModuleDto;
import com.emi.GestionnaireFormation.model.Module;
import com.emi.GestionnaireFormation.service.ModuleService;

/**
 * Contrôleur REST pour gérer les modules.
 * Utilise ModuleDto pour exposer uniquement les champs nécessaires.
 *
 * @author CDA Afpa Emi
 */
@RestController
@RequestMapping("/modules")
public class ModuleController {

    private final ModuleService moduleService;

    /**
     * Injection du service ModuleService.
     */
    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    /**
     * Récupère tous les modules et les convertit en DTO.
     *
     * @return liste de ModuleDto
     */
    @GetMapping
    public List<ModuleDto> getAllModules() {
        return moduleService.getAllModules().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Crée un nouveau module à partir d'un DTO.
     *
     * @param dto les données du module à créer
     * @return le module créé sous forme de DTO
     */
    @PostMapping
    public ModuleDto createModule(@RequestBody ModuleDto dto) {
        Module module = new Module();
        module.setNom(dto.getNom());
        module.setDescription(dto.getDescription());
        // On ne gère pas statut ni id ici

        Module saved = moduleService.createModule(module);
        return toDto(saved);
    }

    /**
     * Convertit une entité Module en DTO.
     *
     * @param module l'entité Module
     * @return le DTO correspondant
     */
    private ModuleDto toDto(Module module) {
        ModuleDto dto = new ModuleDto();
        dto.setNom(module.getNom());
        dto.setDescription(module.getDescription());
        // On n'expose pas statut
        return dto;
    }
}
