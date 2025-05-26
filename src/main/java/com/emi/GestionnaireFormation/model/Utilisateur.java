package com.emi.GestionnaireFormation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entité Utilisateur qui représente un utilisateur dans la base de données.
 * Cette classe est mappée sur la table "utilisateur".
 *
 * @author CDA Afpa Emi
 */
@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    /**
     * Identifiant unique de l'utilisateur (clé primaire, auto-générée).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Matricule unique de l'utilisateur.
     */
    private String matricule;

    /**
     * Nom de famille de l'utilisateur.
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
     * Rôle de l'utilisateur (relation ManyToOne).
     */
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    /**
     * Constructeur vide obligatoire pour JPA/Spring.
     */
    public Utilisateur() {}

    /**
     * Retourne l'identifiant de l'utilisateur.
     *
     * @return l'id de l'utilisateur
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit l'identifiant de l'utilisateur.
     *
     * @param id l'id de l'utilisateur
     */
    public void setId(Long id) {
        this.id = id;
    }

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
     * Retourne le nom de famille de l'utilisateur.
     *
     * @return le nom de l'utilisateur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de famille de l'utilisateur.
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
     * Retourne le rôle de l'utilisateur.
     *
     * @return le rôle de l'utilisateur
     */
    public Role getRole() {
        return role;
    }

    /**
     * Définit le rôle de l'utilisateur.
     *
     * @param role le rôle de l'utilisateur
     */
    public void setRole(Role role) {
        this.role = role;
    }
}
