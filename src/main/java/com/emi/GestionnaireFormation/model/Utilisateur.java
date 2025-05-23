package com.emi.GestionnaireFormation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Cette classe représente un utilisateur dans la base de données
@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique

    private String matricule;    // Matricule unique
    private String nom;          // Nom de famille
    private String prenom;       // Prénom
    private String adresseMail;  // Email

    // Chaque utilisateur a UN SEUL rôle
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    // Constructeur vide obligatoire pour JPA/Spring
    public Utilisateur() {}

    // Getters et setters pour chaque champ
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

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}
