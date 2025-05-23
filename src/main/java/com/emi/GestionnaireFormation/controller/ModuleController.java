package com.emi.GestionnaireFormation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emi.GestionnaireFormation.model.Module;
import com.emi.GestionnaireFormation.service.ModuleService;

/**
 * Contrôleur REST pour l'entité Module.
 */
@RestController
@RequestMapping("/modules") // Toutes les routes commencent par /modules
public class ModuleController {

    private final ModuleService moduleService;

    // Injection du service via le constructeur
    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    // GET /modules ou /modules/
    @GetMapping({"", "/"})
    public List<Module> getAllModules() {
        return moduleService.getAllModules();
    }

    // GET /modules/{id}
    @GetMapping("/{id}")
    public Optional<Module> getModuleById(@PathVariable Long id) {
        return moduleService.getModuleById(id);
    }

    // POST /modules/create
    @PostMapping("/create")
    public Module createModule(@RequestBody Module module) {
        return moduleService.createModule(module);
    }

    // PUT /modules/update/{id}
    @PutMapping("/update/{id}")
    public Optional<Module> updateModule(@PathVariable Long id, @RequestBody Module details) {
        return moduleService.updateModule(id, details);
    }

    // DELETE /modules/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void deleteModule(@PathVariable Long id) {
        moduleService.deleteModule(id);
    }
}
