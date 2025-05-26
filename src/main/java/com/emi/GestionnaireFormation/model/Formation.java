package com.emi.GestionnaireFormation.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entité Formation qui représente une formation en base de données.
 * Cette classe est mappée sur la table "formation".
 *
 * @author CDA Afpa Emi
 */
@Entity
@Table(name = "formation")
public class Formation {

    /**
     * Identifiant unique de la formation (clé primaire, auto-générée).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Libellé de la formation.
     */
    @Column(nullable = false)
    private String libelle;

    /**
     * Numéro d'offre de la formation.
     */
    @Column(name = "numero_offre", nullable = false)
    private String numeroOffre;

    /**
     * Date de début de la formation.
     */
    @Column(name = "date_debut", nullable = false)
    private LocalDate dateDebut;

    /**
     * Date de fin de la formation.
     */
    @Column(name = "date_fin", nullable = false)
    private LocalDate dateFin;

    /**
     * Date de début de la période entreprise.
     */
    @Column(name = "date_debut_pe", nullable = false)
    private LocalDate dateDebutPe;

    /**
     * Date de fin de la période entreprise.
     */
    @Column(name = "date_fin_pe", nullable = false)
    private LocalDate dateFinPe;

    /**
     * Statut de la formation (actif ou non).
     */
    @Column(nullable = false)
    private Boolean statut;

    /**
     * Constructeur vide obligatoire pour JPA.
     */
    public Formation() {}

    /**
     * Retourne l'identifiant de la formation.
     *
     * @return l'identifiant de la formation
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit l'identifiant de la formation.
     *
     * @param id l'identifiant de la formation
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retourne le libellé de la formation.
     *
     * @return le libellé de la formation
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Définit le libellé de la formation.
     *
     * @param libelle le libellé de la formation
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * Retourne le numéro d'offre de la formation.
     *
     * @return le numéro d'offre de la formation
     */
    public String getNumeroOffre() {
        return numeroOffre;
    }

    /**
     * Définit le numéro d'offre de la formation.
     *
     * @param numeroOffre le numéro d'offre de la formation
     */
    public void setNumeroOffre(String numeroOffre) {
        this.numeroOffre = numeroOffre;
    }

    /**
     * Retourne la date de début de la formation.
     *
     * @return la date de début de la formation
     */
    public LocalDate getDateDebut() {
        return dateDebut;
    }

    /**
     * Définit la date de début de la formation.
     *
     * @param dateDebut la date de début de la formation
     */
    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * Retourne la date de fin de la formation.
     *
     * @return la date de fin de la formation
     */
    public LocalDate getDateFin() {
        return dateFin;
    }

    /**
     * Définit la date de fin de la formation.
     *
     * @param dateFin la date de fin de la formation
     */
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * Retourne la date de début de la période entreprise.
     *
     * @return la date de début de la période entreprise
     */
    public LocalDate getDateDebutPe() {
        return dateDebutPe;
    }

    /**
     * Définit la date de début de la période entreprise.
     *
     * @param dateDebutPe la date de début de la période entreprise
     */
    public void setDateDebutPe(LocalDate dateDebutPe) {
        this.dateDebutPe = dateDebutPe;
    }

    /**
     * Retourne la date de fin de la période entreprise.
     *
     * @return la date de fin de la période entreprise
     */
    public LocalDate getDateFinPe() {
        return dateFinPe;
    }

    /**
     * Définit la date de fin de la période entreprise.
     *
     * @param dateFinPe la date de fin de la période entreprise
     */
    public void setDateFinPe(LocalDate dateFinPe) {
        this.dateFinPe = dateFinPe;
    }

    /**
     * Retourne le statut de la formation (actif ou non).
     *
     * @return le statut de la formation
     */
    public Boolean getStatut() {
        return statut;
    }

    /**
     * Définit le statut de la formation.
     *
     * @param statut le statut de la formation
     */
    public void setStatut(Boolean statut) {
        this.statut = statut;
    }
}
