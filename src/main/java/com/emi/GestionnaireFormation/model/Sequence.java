package com.emi.GestionnaireFormation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entité Séquence, qui représente une séquence pédagogique dans un module.
 * Cette classe est mappée sur la table "sequence" en base de données.
 *
 * @author CDA Afpa Emi
 */
@Entity
@Table(name = "sequence")
public class Sequence {

    /**
     * Identifiant unique de la séquence (clé primaire, auto-générée).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Libellé de la séquence pédagogique.
     */
    @Column(nullable = false)
    private String libelle;

    /**
     * Description de la séquence pédagogique.
     */
    @Column(nullable = false)
    private String description;

    /**
     * Ordre de la séquence dans le module.
     */
    @Column(nullable = false)
    private Integer ordre;

    /**
     * Statut de la séquence (actif ou non).
     */
    @Column(nullable = false)
    private Boolean statut;

    /**
     * Module auquel appartient cette séquence.
     */
    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;

    /**
     * Constructeur vide obligatoire pour JPA.
     */
    public Sequence() {}

    /**
     * Retourne l'identifiant de la séquence.
     *
     * @return l'id de la séquence
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit l'identifiant de la séquence.
     *
     * @param id l'id de la séquence
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retourne le libellé de la séquence.
     *
     * @return le libellé de la séquence
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Définit le libellé de la séquence.
     *
     * @param libelle le libellé de la séquence
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * Retourne la description de la séquence.
     *
     * @return la description de la séquence
     */
    public String getDescription() {
        return description;
    }

    /**
     * Définit la description de la séquence.
     *
     * @param description la description de la séquence
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retourne l'ordre de la séquence dans le module.
     *
     * @return l'ordre de la séquence
     */
    public Integer getOrdre() {
        return ordre;
    }

    /**
     * Définit l'ordre de la séquence dans le module.
     *
     * @param ordre l'ordre de la séquence
     */
    public void setOrdre(Integer ordre) {
        this.ordre = ordre;
    }

    /**
     * Retourne le statut de la séquence (actif ou non).
     *
     * @return le statut de la séquence
     */
    public Boolean getStatut() {
        return statut;
    }

    /**
     * Définit le statut de la séquence.
     *
     * @param statut le statut de la séquence
     */
    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

    /**
     * Retourne le module auquel appartient cette séquence.
     *
     * @return le module parent
     */
    public Module getModule() {
        return module;
    }

    /**
     * Définit le module auquel appartient cette séquence.
     *
     * @param module le module parent
     */
    public void setModule(Module module) {
        this.module = module;
    }
}
