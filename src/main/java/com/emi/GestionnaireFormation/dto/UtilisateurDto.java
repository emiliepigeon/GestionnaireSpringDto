package com.emi.GestionnaireFormation.dto;

import java.util.List;

/**
 * DTO pour exposer les informations d'un utilisateur,
 * ainsi que la liste des libellés de ses rôles.
 * Sert à transporter les données entre le backend et le frontend sans exposer l'entité JPA.
 *
 * @author CDA Afpa Emi
 */
public class UtilisateurDto {

    private String matricule;
    private String nom;
    private String prenom;
    private String adresseMail;

    /**
     * MODIF: La liste des libellés des rôles (plusieurs rôles possibles).
     * Je débute : c'était une String, maintenant c'est List<String>.
     */
    private List<String> roleLibelle;

    public UtilisateurDto() {}

    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getAdresseMail() { return adresseMail; }
    public void setAdresseMail(String adresseMail) { this.adresseMail = adresseMail; }

    /**
     * Retourne la liste des libellés de rôles.
     * @return liste des libellés
     */
    public List<String> getRoleLibelle() { return roleLibelle; }

    /**
     * Définit la liste des libellés de rôles.
     * @param roleLibelle liste des libellés
     */
    public void setRoleLibelle(List<String> roleLibelle) { this.roleLibelle = roleLibelle; }
}
