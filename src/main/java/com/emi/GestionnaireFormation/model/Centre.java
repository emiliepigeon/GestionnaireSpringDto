package com.emi.GestionnaireFormation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entité Centre qui représente un centre de formation.
 */
@Entity
@Table(name = "centre")
public class Centre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nom du centre
    @Column(nullable = false)
    private String nom;

    // Adresse du centre
    @Column(nullable = false)
    private String adresse;

    // Code postal du centre
    @Column(name = "code_postal", nullable = false)
    private String codePostal;

    // Ville du centre
    @Column(nullable = false)
    private String ville;

    // Statut actif ou non
    @Column(nullable = false)
    private Boolean statut;

    // Constructeur vide obligatoire pour JPA
    public Centre() {}

    // Getters et setters
    public Long getId() { return id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public String getCodePostal() { return codePostal; }
    public void setCodePostal(String codePostal) { this.codePostal = codePostal; }
    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }
    public Boolean getStatut() { return statut; }
    public void setStatut(Boolean statut) { this.statut = statut; }
}
