package com.emi.GestionnaireFormation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entité Centre qui représente un centre de formation.
 * Cette classe est mappée sur la table "centre" en base de données.
 *
 * @author CDA Afpa Emi
 */
@Entity
@Table(name = "centre")
public class Centre {

    /**
     * Identifiant unique du centre (clé primaire, auto-générée).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nom du centre.
     */
    @Column(nullable = false)
    private String nom;

    /**
     * Adresse du centre.
     */
    @Column(nullable = false)
    private String adresse;

    /**
     * Code postal du centre.
     */
    @Column(name = "code_postal", nullable = false)
    private String codePostal;

    /**
     * Ville du centre.
     */
    @Column(nullable = false)
    private String ville;

    /**
     * Statut du centre (actif ou non).
     */
    @Column(nullable = false)
    private Boolean statut;

    /**
     * Constructeur vide obligatoire pour JPA.
     */
    public Centre() {}

    /**
     * Retourne l'identifiant du centre.
     *
     * @return l'id du centre
     */
    public Long getId() {
        return id;
    }

    /**
     * Retourne le nom du centre.
     *
     * @return le nom du centre
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom du centre.
     *
     * @param nom le nom du centre
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne l'adresse du centre.
     *
     * @return l'adresse du centre
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Définit l'adresse du centre.
     *
     * @param adresse l'adresse du centre
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Retourne le code postal du centre.
     *
     * @return le code postal du centre
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * Définit le code postal du centre.
     *
     * @param codePostal le code postal du centre
     */
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    /**
     * Retourne la ville du centre.
     *
     * @return la ville du centre
     */
    public String getVille() {
        return ville;
    }

    /**
     * Définit la ville du centre.
     *
     * @param ville la ville du centre
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * Retourne le statut du centre (actif ou non).
     *
     * @return le statut du centre
     */
    public Boolean getStatut() {
        return statut;
    }

    /**
     * Définit le statut du centre.
     *
     * @param statut le statut du centre
     */
    public void setStatut(Boolean statut) {
        this.statut = statut;
    }
}
