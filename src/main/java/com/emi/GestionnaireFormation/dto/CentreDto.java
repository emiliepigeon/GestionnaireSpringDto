package com.emi.GestionnaireFormation.dto;

/**
 * DTO pour exposer les informations d'un centre de formation.
 * Sert à transporter les données entre le backend et le frontend sans exposer l'entité JPA.
 *
 * @author CDA Afpa Emi
 */
public class CentreDto {

    /**
     * Le nom du centre.
     */
    private String nom;

    /**
     * L'adresse du centre.
     */
    private String adresse;

    /**
     * Le code postal du centre.
     */
    private String codePostal;

    /**
     * La ville du centre.
     */
    private String ville;

    /**
     * Constructeur vide obligatoire.
     */
    public CentreDto() {}

    /**
     * Constructeur plein utilisant les setters.
     *
     * @param nom le nom du centre
     * @param adresse l'adresse du centre
     * @param codePostal le code postal du centre
     * @param ville la ville du centre
     */
    public CentreDto(String nom, String adresse, String codePostal, String ville) {
        setNom(nom);
        setAdresse(adresse);
        setCodePostal(codePostal);
        setVille(ville);
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
}
