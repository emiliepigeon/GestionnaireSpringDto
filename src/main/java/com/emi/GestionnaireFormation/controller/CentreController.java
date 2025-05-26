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

import com.emi.GestionnaireFormation.model.Centre;
import com.emi.GestionnaireFormation.service.CentreService;

/**
 * Contrôleur REST pour l'entité Centre.
 * Permet de gérer les opérations CRUD sur les centres de formation.
 * 
 * @author CDA Afpa Emi
 */
@RestController
@RequestMapping("/centres") // Toutes les routes commencent par /centres
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
     * Récupère la liste de tous les centres de formation.
     * 
     * @return une liste de centres
     */
    @GetMapping({"", "/"})
    public List<Centre> getAllCentres() {
        return centreService.getAllCentres();
    }

    /**
     * Récupère un centre de formation par son identifiant.
     * 
     * @param id l'identifiant du centre
     * @return un Optional contenant le centre s'il existe, sinon Optional.empty()
     */
    @GetMapping("/{id}")
    public Optional<Centre> getCentreById(@PathVariable Long id) {
        return centreService.getCentreById(id);
    }

    /**
     * Crée un nouveau centre de formation.
     * 
     * @param centre l'objet centre à créer
     * @return le centre créé
     */
    @PostMapping("/create")
    public Centre createCentre(@RequestBody Centre centre) {
        return centreService.createCentre(centre);
    }

    /**
     * Modifie un centre de formation existant.
     * 
     * @param id l'identifiant du centre à modifier
     * @param details les nouvelles valeurs du centre
     * @return un Optional contenant le centre mis à jour s'il existe, sinon Optional.empty()
     */
    @PutMapping("/update/{id}")
    public Optional<Centre> updateCentre(@PathVariable Long id, @RequestBody Centre details) {
        return centreService.updateCentre(id, details);
    }

    /**
     * Supprime un centre de formation par son identifiant.
     * 
     * @param id l'identifiant du centre à supprimer
     */
    @DeleteMapping("/delete/{id}")
    public void deleteCentre(@PathVariable Long id) {
        centreService.deleteCentre(id);
    }
}
