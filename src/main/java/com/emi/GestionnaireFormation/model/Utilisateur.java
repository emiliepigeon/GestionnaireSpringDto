package com.emi.GestionnaireFormation.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
     * MODIF: Relation ManyToMany pour permettre plusieurs rôles par utilisateur.
     * Je débute : avant c'était ManyToOne, maintenant ManyToMany, donc un Set<Role>.
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "utilisateur_role",
        joinColumns = @JoinColumn(name = "utilisateur_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    /**
     * Constructeur vide obligatoire pour JPA/Spring.
     */
    public Utilisateur() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getAdresseMail() { return adresseMail; }
    public void setAdresseMail(String adresseMail) { this.adresseMail = adresseMail; }

    /**
     * Retourne la liste des rôles de l'utilisateur.
     * @return les rôles
     */
    public Set<Role> getRoles() { return roles; }

    /**
     * Définit la liste des rôles de l'utilisateur.
     * @param roles les rôles à associer
     */
    public void setRoles(Set<Role> roles) { this.roles = roles; }
}
