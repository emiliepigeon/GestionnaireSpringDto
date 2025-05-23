// src/main/java/com/emi/GestionnaireFormation/service/RoleService.java
package com.emi.GestionnaireFormation.service;

import com.emi.GestionnaireFormation.model.Role;
import com.emi.GestionnaireFormation.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }
    
    // Crée un nouveau rôle
    public Role createRole(Role role) {
        return repository.save(role);
    }
}
