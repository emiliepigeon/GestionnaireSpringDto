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

import com.emi.GestionnaireFormation.model.Formation;
import com.emi.GestionnaireFormation.service.FormationService;

/**
 * Contrôleur REST pour l'entité Formation.
 * Toutes les méthodes renvoient du JSON.
 */
@RestController
@RequestMapping("/formations") // Toutes les routes commencent par /formations
public class FormationController {

    private final FormationService formationService;

    // Injection du service via le constructeur
    public FormationController(FormationService formationService) {
        this.formationService = formationService;
    }

    // GET /formations ou /formations/
    @GetMapping({"", "/"})
    public List<Formation> getAllFormations() {
        return formationService.getAllFormations();
    }

    // GET /formations/{id}
    @GetMapping("/{id}")
    public Optional<Formation> getFormationById(@PathVariable Long id) {
        return formationService.getFormationById(id);
    }

    // POST /formations/create
    @PostMapping("/create")
    public Formation createFormation(@RequestBody Formation formation) {
        return formationService.createFormation(formation);
    }

    // PUT /formations/update/{id}
    @PutMapping("/update/{id}")
    public Optional<Formation> updateFormation(@PathVariable Long id, @RequestBody Formation details) {
        return formationService.updateFormation(id, details);
    }

    // DELETE /formations/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void deleteFormation(@PathVariable Long id) {
        formationService.deleteFormation(id);
    }
}
