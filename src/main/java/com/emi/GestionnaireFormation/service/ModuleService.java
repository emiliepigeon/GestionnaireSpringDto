package com.emi.GestionnaireFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emi.GestionnaireFormation.model.Module;
import com.emi.GestionnaireFormation.repository.ModuleRepository;

/**
 * Service pour la logique métier liée à l'entité Module.
 */
@Service
public class ModuleService {

    private final ModuleRepository moduleRepository;

    // Injection du repository via le constructeur
    public ModuleService(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    // Récupérer tous les modules
    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    // Trouver un module par son id
    public Optional<Module> getModuleById(Long id) {
        return moduleRepository.findById(id);
    }

    // Créer un nouveau module
    public Module createModule(Module module) {
        return moduleRepository.save(module);
    }

    // Modifier un module existant
    public Optional<Module> updateModule(Long id, Module details) {
        return moduleRepository.findById(id).map(module -> {
            module.setNom(details.getNom());
            module.setDescription(details.getDescription());
            module.setStatut(details.getStatut());
            return moduleRepository.save(module);
        });
    }

    // Supprimer un module
    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }
}
