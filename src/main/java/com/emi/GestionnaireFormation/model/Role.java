package com.emi.GestionnaireFormation.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * Entité Role qui représente un rôle (ex : ADMIN, USER).
 * Cette classe est mappée sur la table "role".
 *
 * @author CDA Afpa Emi
 */
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String libelle;

    @Column(nullable = false)
    private Boolean statut;

    /**
     * MODIF: Relation ManyToMany pour permettre plusieurs utilisateurs par rôle.
     * Je débute : avant il n'y avait pas cette relation inverse, maintenant il y a un Set<Utilisateur>.
     */
    @ManyToMany(mappedBy = "roles")
    private Set<Utilisateur> utilisateurs = new HashSet<>();

    public Role() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    public Boolean getStatut() { return statut; }
    public void setStatut(Boolean statut) { this.statut = statut; }

    public Set<Utilisateur> getUtilisateurs() { return utilisateurs; }
    public void setUtilisateurs(Set<Utilisateur> utilisateurs) { this.utilisateurs = utilisateurs; }
}
