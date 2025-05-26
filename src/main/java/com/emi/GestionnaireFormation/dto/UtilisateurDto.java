package com.emi.GestionnaireFormation.dto;

/**
 * DTO pour exposer les informations d'un utilisateur,
 * ainsi que le libellé de son rôle.
 * Sert à transporter les données entre le backend et le frontend sans exposer l'entité JPA.
 *
 * @author CDA Afpa Emi
 */
public class UtilisateurDto {

    /**
     * Matricule de l'utilisateur.
     */
    private String matricule;

    /**
     * Nom de l'utilisateur.
     */
    private String nom;

    /**
     * Prénom de l'utilisateur.
     */
    private String prenom;

    /**
     * Adresse mail de l'utilisateur.
     */
    private String adresseMail;

    /**
     * Libellé du rôle de l'utilisateur (ex : "ADMIN").
     */
    private String roleLibelle;

    /**
     * Constructeur vide obligatoire.
     */
    public UtilisateurDto() {}

    /**
     * Retourne le matricule de l'utilisateur.
     *
     * @return le matricule de l'utilisateur
     */
    public String getMatricule() {
        return matricule;
    }

    /**
     * Définit le matricule de l'utilisateur.
     *
     * @param matricule le matricule de l'utilisateur
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    /**
     * Retourne le nom de l'utilisateur.
     *
     * @return le nom de l'utilisateur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de l'utilisateur.
     *
     * @param nom le nom de l'utilisateur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le prénom de l'utilisateur.
     *
     * @return le prénom de l'utilisateur
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Définit le prénom de l'utilisateur.
     *
     * @param prenom le prénom de l'utilisateur
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Retourne l'adresse mail de l'utilisateur.
     *
     * @return l'adresse mail de l'utilisateur
     */
    public String getAdresseMail() {
        return adresseMail;
    }

    /**
     * Définit l'adresse mail de l'utilisateur.
     *
     * @param adresseMail l'adresse mail de l'utilisateur
     */
    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    /**
     * Retourne le libellé du rôle de l'utilisateur.
     *
     * @return le libellé du rôle
     */
    public String getRoleLibelle() {
        return roleLibelle;
    }

    /**
     * Définit le libellé du rôle de l'utilisateur.
     *
     * @param roleLibelle le libellé du rôle
     */
    public void setRoleLibelle(String roleLibelle) {
        this.roleLibelle = roleLibelle;
    }
}
