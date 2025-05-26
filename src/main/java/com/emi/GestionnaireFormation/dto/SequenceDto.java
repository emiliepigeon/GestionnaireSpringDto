package com.emi.GestionnaireFormation.dto;

/**
 * DTO pour exposer les informations d'une séquence pédagogique, sans identifiant.
 * Sert à transporter les données entre le backend et le frontend sans exposer l'entité JPA.
 *
 * @author CDA Afpa Emi
 */
public class SequenceDto {

    /**
     * Libellé de la séquence pédagogique.
     */
    private String libelle;

    /**
     * Description de la séquence pédagogique.
     */
    private String description;

    /**
     * Ordre de la séquence dans le module.
     */
    private Integer ordre;

    /**
     * Constructeur vide obligatoire.
     */
    public SequenceDto() {}

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

}
