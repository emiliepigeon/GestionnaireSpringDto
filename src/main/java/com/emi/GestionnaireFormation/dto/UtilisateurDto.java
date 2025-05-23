package com.emi.GestionnaireFormation.dto;

// DTO pour exposer les infos d'un utilisateur + le libellé de son rôle
public class UtilisateurDto {
    private String matricule;
    private String nom;
    private String prenom;
    private String adresseMail;
    private String roleLibelle; // Le nom du rôle (ex : "ADMIN")

    // Constructeur vide
    public UtilisateurDto() {}

    // Getters et setters
    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getAdresseMail() { return adresseMail; }
    public void setAdresseMail(String adresseMail) { this.adresseMail = adresseMail; }

    public String getRoleLibelle() { return roleLibelle; }
    public void setRoleLibelle(String roleLibelle) { this.roleLibelle = roleLibelle; }
}
