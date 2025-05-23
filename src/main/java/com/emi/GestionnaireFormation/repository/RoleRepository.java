package com.emi.GestionnaireFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emi.GestionnaireFormation.model.Role;

// Repository pour gérer les rôles
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByLibelle(String libelle);
}
