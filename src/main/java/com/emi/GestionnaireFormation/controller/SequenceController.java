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

import com.emi.GestionnaireFormation.model.Sequence;
import com.emi.GestionnaireFormation.service.SequenceService;

/**
 * Contrôleur REST pour l'entité Séquence.
 */
@RestController
@RequestMapping("/sequences") // Toutes les routes commencent par /sequences
public class SequenceController {

    private final SequenceService sequenceService;

    public SequenceController(SequenceService sequenceService) {
        this.sequenceService = sequenceService;
    }

    // GET /sequences ou /sequences/
    @GetMapping({"", "/"})
    public List<Sequence> getAllSequences() {
        return sequenceService.getAllSequences();
    }

    // GET /sequences/module/{moduleId}
    @GetMapping("/module/{moduleId}")
    public List<Sequence> getSequencesByModule(@PathVariable Long moduleId) {
        return sequenceService.getSequencesByModuleId(moduleId);
    }

    // GET /sequences/{id}
    @GetMapping("/{id}")
    public Optional<Sequence> getSequenceById(@PathVariable Long id) {
        return sequenceService.getSequenceById(id);
    }

    // POST /sequences/create
    @PostMapping("/create")
    public Sequence createSequence(@RequestBody Sequence sequence) {
        return sequenceService.createSequence(sequence);
    }

    // PUT /sequences/update/{id}
    @PutMapping("/update/{id}")
    public Optional<Sequence> updateSequence(@PathVariable Long id, @RequestBody Sequence details) {
        return sequenceService.updateSequence(id, details);
    }

    // DELETE /sequences/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void deleteSequence(@PathVariable Long id) {
        sequenceService.deleteSequence(id);
    }
}
