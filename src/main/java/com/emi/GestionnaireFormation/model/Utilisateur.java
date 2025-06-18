package com.emi.GestionnaireFormation.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 7)
    private String matricule;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(name = "adresse_mail", nullable = false)
    private String adresseMail;

    @Column(name = "adresse_postal", nullable = false)
    private String adressePostal;

    @Column(name = "code_postal", nullable = false, length = 5)
    private String codePostal;

    @Column(nullable = false)
    private String ville;

    @Column(name = "mot_de_passe", nullable = false)
    private String motDePasse;

    @Column(nullable = false)
    private Boolean statut;

    // Relations ManyToMany avec Role (table utilisateur_role)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "utilisateur_role",
        joinColumns = @JoinColumn(name = "utilisateur_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public Utilisateur() {}

    // --- Getters et Setters ---

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

    public String getAdressePostal() { return adressePostal; }
    public void setAdressePostal(String adressePostal) { this.adressePostal = adressePostal; }

    public String getCodePostal() { return codePostal; }
    public void setCodePostal(String codePostal) { this.codePostal = codePostal; }

    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }

    /**
     * Getter pour le mot de passe.
     * @return le mot de passe de l'utilisateur
     */
    public String getMotDePasse() { return motDePasse; }

    /**
     * Setter pour le mot de passe.
     * @param motDePasse le mot de passe à enregistrer
     */
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    public Boolean getStatut() { return statut; }
    public void setStatut(Boolean statut) { this.statut = statut; }

    public Set<Role> getRoles() { return roles; }
    public void setRoles(Set<Role> roles) { this.roles = roles; }
}
