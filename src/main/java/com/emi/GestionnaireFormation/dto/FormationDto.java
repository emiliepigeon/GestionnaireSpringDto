package com.emi.GestionnaireFormation.dto;

import java.time.LocalDate;

/**
 * DTO pour exposer les informations d'une formation.
 * Sert à transporter les données entre le backend et le frontend sans exposer l'entité JPA.
 *
 * @author CDA Afpa Emi
 */
public class FormationDto {

    private String libelle;
    private String numeroOffre;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private LocalDate dateDebutPe;
    private LocalDate dateFinPe;


    /**
     * Constructeur vide obligatoire.
     */
    public FormationDto() {}

    /**
     * Retourne le libellé de la formation.
     *
     * @return le libellé de la formation
     */
    public String getLibelle() { return libelle; }

    /**
     * Définit le libellé de la formation.
     *
     * @param libelle le libellé de la formation
     */
    public void setLibelle(String libelle) { this.libelle = libelle; }

    /**
     * Retourne le numéro d'offre de la formation.
     *
     * @return le numéro d'offre de la formation
     */
    public String getNumeroOffre() { return numeroOffre; }

    /**
     * Définit le numéro d'offre de la formation.
     *
     * @param numeroOffre le numéro d'offre de la formation
     */
    public void setNumeroOffre(String numeroOffre) { this.numeroOffre = numeroOffre; }

    /**
     * Retourne la date de début de la formation.
     *
     * @return la date de début de la formation
     */
    public LocalDate getDateDebut() { return dateDebut; }

    /**
     * Définit la date de début de la formation.
     *
     * @param dateDebut la date de début de la formation
     */
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }

    /**
     * Retourne la date de fin de la formation.
     *
     * @return la date de fin de la formation
     */
    public LocalDate getDateFin() { return dateFin; }

    /**
     * Définit la date de fin de la formation.
     *
     * @param dateFin la date de fin de la formation
     */
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }

    /**
     * Retourne la date de début de la période entreprise.
     *
     * @return la date de début de la période entreprise
     */
    public LocalDate getDateDebutPe() { return dateDebutPe; }

    /**
     * Définit la date de début de la période entreprise.
     *
     * @param dateDebutPe la date de début de la période entreprise
     */
    public void setDateDebutPe(LocalDate dateDebutPe) { this.dateDebutPe = dateDebutPe; }

    /**
     * Retourne la date de fin de la période entreprise.
     *
     * @return la date de fin de la période entreprise
     */
    public LocalDate getDateFinPe() { return dateFinPe; }

    /**
     * Définit la date de fin de la période entreprise.
     *
     * @param dateFinPe la date de fin de la période entreprise
     */
    public void setDateFinPe(LocalDate dateFinPe) { this.dateFinPe = dateFinPe; }

}
