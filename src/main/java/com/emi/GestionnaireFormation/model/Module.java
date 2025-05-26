package com.emi.GestionnaireFormation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entité Module qui représente un module de formation.
 * Cette classe est mappée sur la table "module" en base de données.
 *
 * @author CDA Afpa Emi
 */
@Entity
@Table(name = "module")
public class Module {

    /**
     * Identifiant unique du module (clé primaire, auto-générée).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nom du module.
     */
    @Column(nullable = false)
    private String nom;

    /**
     * Description du module.
     */
    @Column(nullable = false)
    private String description;

    /**
     * Statut du module (actif ou non).
     */
    @Column(nullable = false)
    private Boolean statut;

    /**
     * Constructeur vide obligatoire pour JPA.
     */
    public Module() {}

    /**
     * Retourne l'identifiant du module.
     *
     * @return l'id du module
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit l'identifiant du module.
     *
     * @param id l'id du module
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retourne le nom du module.
     *
     * @return le nom du module
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom du module.
     *
     * @param nom le nom du module
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la description du module.
     *
     * @return la description du module
     */
    public String getDescription() {
        return description;
    }

    /**
     * Définit la description du module.
     *
     * @param description la description du module
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retourne le statut du module (actif ou non).
     *
     * @return le statut du module
     */
    public Boolean getStatut() {
        return statut;
    }

    /**
     * Définit le statut du module.
     *
     * @param statut le statut du module
     */
    public void setStatut(Boolean statut) {
        this.statut = statut;
    }
}
