package com.emi.GestionnaireFormation.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "formation")
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Le libellé de la formation (ex: "CDA")
    @Column(nullable = false)
    private String libelle;

    // Le numéro d'offre de la formation
    @Column(name = "numero_offre", nullable = false)
    private String numeroOffre;

    // Dates de la formation
    @Column(name = "date_debut", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "date_fin", nullable = false)
    private LocalDate dateFin;

    @Column(name = "date_debut_pe", nullable = false)
    private LocalDate dateDebutPe;

    @Column(name = "date_fin_pe", nullable = false)
    private LocalDate dateFinPe;

    // Statut (actif ou non)
    @Column(nullable = false)
    private Boolean statut;

    // Constructeur vide obligatoire pour JPA
    public Formation() {}

    // Getters et setters
    public Long getId() { return id; }
    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }
    public String getNumeroOffre() { return numeroOffre; }
    public void setNumeroOffre(String numeroOffre) { this.numeroOffre = numeroOffre; }
    public LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }
    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }
    public LocalDate getDateDebutPe() { return dateDebutPe; }
    public void setDateDebutPe(LocalDate dateDebutPe) { this.dateDebutPe = dateDebutPe; }
    public LocalDate getDateFinPe() { return dateFinPe; }
    public void setDateFinPe(LocalDate dateFinPe) { this.dateFinPe = dateFinPe; }
    public Boolean getStatut() { return statut; }
    public void setStatut(Boolean statut) { this.statut = statut; }
}
