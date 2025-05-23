package com.emi.GestionnaireFormation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entité Séquence, qui représente une séquence pédagogique dans un module.
 */
@Entity
@Table(name = "sequence")
public class Sequence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Libellé de la séquence
    @Column(nullable = false)
    private String libelle;

    // Description de la séquence
    @Column(nullable = false)
    private String description;

    // Ordre de la séquence dans le module
    @Column(nullable = false)
    private Integer ordre;

    // Statut actif ou non
    @Column(nullable = false)
    private Boolean statut;

    // Relation ManyToOne avec Module (chaque séquence appartient à un module)
    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;

    // Constructeur vide obligatoire pour JPA
    public Sequence() {}

    // Getters et setters
    public Long getId() { return id; }
    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getOrdre() { return ordre; }
    public void setOrdre(Integer ordre) { this.ordre = ordre; }
    public Boolean getStatut() { return statut; }
    public void setStatut(Boolean statut) { this.statut = statut; }
    public Module getModule() { return module; }
    public void setModule(Module module) { this.module = module; }
}
