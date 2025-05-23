package com.emi.GestionnaireFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emi.GestionnaireFormation.model.Formation;
import com.emi.GestionnaireFormation.repository.FormationRepository;

@Service
public class FormationService {

    private final FormationRepository formationRepository;

    public FormationService(FormationRepository formationRepository) {
        this.formationRepository = formationRepository;
    }

    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    public Optional<Formation> getFormationById(Long id) {
        return formationRepository.findById(id);
    }

    public Formation createFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    public Optional<Formation> updateFormation(Long id, Formation details) {
        return formationRepository.findById(id).map(formation -> {
            formation.setLibelle(details.getLibelle());
            formation.setNumeroOffre(details.getNumeroOffre());
            formation.setDateDebut(details.getDateDebut());
            formation.setDateFin(details.getDateFin());
            formation.setDateDebutPe(details.getDateDebutPe());
            formation.setDateFinPe(details.getDateFinPe());
            formation.setStatut(details.getStatut());
            return formationRepository.save(formation);
        });
    }

    public void deleteFormation(Long id) {
        formationRepository.deleteById(id);
    }
}
