package com.emi.GestionnaireFormation.dto;

/**
 * DTO pour exposer les informations d'un module de formation, sans identifiant.
 * Sert à transporter les données entre le backend et le frontend sans exposer l'entité JPA.
 *
 * @author CDA Afpa Emi
 */
public class ModuleDto {

    /**
     * Le nom du module.
     */
    private String nom;

    /**
     * La description du module.
     */
    private String description;


    /**
     * Constructeur vide obligatoire.
     */
    public ModuleDto() {}

    /**
     * Retourne le nom du module.
     *
     * @return le nom du module
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom du module.
     *
     * @param nom le nom du module
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la description du module.
     *
     * @return la description du module
     */
    public String getDescription() {
        return description;
    }

    /**
     * Définit la description du module.
     *
     * @param description la description du module
     */
    public void setDescription(String description) {
        this.description = description;
    }


    
}
