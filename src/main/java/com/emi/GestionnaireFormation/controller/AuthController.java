package com.emi.GestionnaireFormation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emi.GestionnaireFormation.model.Utilisateur;
import com.emi.GestionnaireFormation.repository.UtilisateurRepository;
import com.emi.GestionnaireFormation.service.JwtUtil;

/**
 * Contrôleur REST pour l'authentification (login).
 * Je débute : Ce contrôleur me permet de connecter un utilisateur et de recevoir un token JWT.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    /**
     * Endpoint POST pour se connecter.
     * @param request objet contenant le matricule et le mot de passe
     * @return le token JWT si la connexion est OK, sinon une erreur
     */
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        Utilisateur utilisateur = utilisateurRepository.findByMatricule(request.getMatricule());
        if (utilisateur != null && utilisateur.getPassword().equals(request.getPassword())) {
            return JwtUtil.generateToken(utilisateur.getMatricule());
        }
        throw new RuntimeException("Matricule ou mot de passe incorrect");
    }

    /**
     * Classe interne pour recevoir les infos de connexion.
     */
    public static class LoginRequest {
        private String matricule;
        private String password;

        public String getMatricule() { return matricule; }
        public void setMatricule(String matricule) { this.matricule = matricule; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}
