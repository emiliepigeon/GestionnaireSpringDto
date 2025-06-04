package com.emi.GestionnaireFormation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emi.GestionnaireFormation.dto.ModuleDto;
import com.emi.GestionnaireFormation.mapper.ModuleMapper;
import com.emi.GestionnaireFormation.model.Module;
import com.emi.GestionnaireFormation.service.ModuleService;

/**
 * Contrôleur REST pour gérer les modules.
 * Utilise ModuleDto pour exposer uniquement les champs nécessaires.
 * Utilise ModuleMapper pour convertir entité <-> DTO.
 *
 * @author CDA Afpa Emi
 */
@RestController
@RequestMapping("/api/modules")
public class ModuleController {

    private final ModuleService moduleService;

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
                .map(ModuleMapper::toDto) // Utilisation du mapper
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
        Module module = ModuleMapper.toEntity(dto); // Utilisation du mapper
        Module saved = moduleService.createModule(module);
        return ModuleMapper.toDto(saved); // Utilisation du mapper
    }
}
