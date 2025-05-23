package com.emi.GestionnaireFormation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Cette classe représente un rôle (ex : ADMIN, USER)
@Entity
@Table(name = "role")
public class Role {
    @Id // identifiant unique
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // le libellé ne peut pas être null
    private String libelle;

    @Column(nullable = false) // le statut ne peut pas être null (actif/inactif)
    private Boolean statut;

    // Constructeur vide obligatoire pour JPA
    public Role() {}

    // Getter pour l'id (lecture)
    public Long getId() { return id; }

    // Getter et setter pour libelle (lecture/écriture)
    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    // Getter et setter pour statut (lecture/écriture)
    public Boolean getStatut() { return statut; }
    public void setStatut(Boolean statut) { this.statut = statut; }
}
