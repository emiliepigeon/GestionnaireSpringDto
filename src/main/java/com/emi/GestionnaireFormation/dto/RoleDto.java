package com.emi.GestionnaireFormation.dto;

// Ce DTO sert à transporter uniquement le libellé (nom) du rôle
public class RoleDto {
    private String libelle; // ex : "ADMIN", "USER"

    // Constructeur avec le libelle
    public RoleDto(String libelle) {
        this.libelle = libelle;
    }

    // Getter pour lire le libelle
    public String getLibelle() {
        return libelle;
    }

    // Setter pour modifier le libelle
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
