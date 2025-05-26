package com.emi.GestionnaireFormation.dto;

/**
 * DTO pour transporter uniquement le libellé (nom) du rôle.
 * Sert à exposer le nom du rôle sans exposer l'entité JPA complète.
 *
 * @author CDA Afpa Emi
 */
public class RoleDto {

    /**
     * Libellé du rôle (ex : "ADMIN", "USER").
     */
    private String libelle;

    /**
     * Constructeur avec le libellé.
     *
     * @param libelle le libellé du rôle
     */
    public RoleDto(String libelle) {
        this.libelle = libelle;
    }

    /**
     * Retourne le libellé du rôle.
     *
     * @return le libellé du rôle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Définit le libellé du rôle.
     *
     * @param libelle le libellé du rôle
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
