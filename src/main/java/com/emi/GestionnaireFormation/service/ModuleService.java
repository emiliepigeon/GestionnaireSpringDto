package com.emi.GestionnaireFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emi.GestionnaireFormation.model.Module;
import com.emi.GestionnaireFormation.repository.ModuleRepository;

/**
 * Service pour la logique métier liée à l'entité Module.
 * Fournit des méthodes pour gérer les modules de formation.
 *
 * @author CDA Afpa Emi
 */
@Service
public class ModuleService {

    private final ModuleRepository moduleRepository;

    /**
     * Constructeur avec injection du repository ModuleRepository.
     *
     * @param moduleRepository le repository pour l'entité Module
     */
    public ModuleService(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    /**
     * Récupère la liste de tous les modules.
     *
     * @return une liste de modules
     */
    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    /**
     * Recherche un module par son identifiant.
     *
     * @param id l'identifiant du module
     * @return un Optional contenant le module s'il existe, sinon vide
     */
    public Optional<Module> getModuleById(Long id) {
        return moduleRepository.findById(id);
    }

    /**
     * Crée un nouveau module de formation.
     *
     * @param module l'entité Module à créer
     * @return le module créé et sauvegardé
     */
    public Module createModule(Module module) {
        return moduleRepository.save(module);
    }

    /**
     * Met à jour un module existant.
     *
     * @param id l'identifiant du module à modifier
     * @param details les nouvelles valeurs du module
     * @return un Optional contenant le module mis à jour s'il existe, sinon vide
     */
    public Optional<Module> updateModule(Long id, Module details) {
        return moduleRepository.findById(id).map(module -> {
            module.setNom(details.getNom());
            module.setDescription(details.getDescription());
            module.setStatut(details.getStatut());
            return moduleRepository.save(module);
        });
    }

    /**
     * Supprime un module par son identifiant.
     *
     * @param id l'identifiant du module à supprimer
     */
    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }
}
