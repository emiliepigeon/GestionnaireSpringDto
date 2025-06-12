package com.emi.GestionnaireFormation.service;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Classe utilitaire pour gérer les tokens JWT.
 * Je débute : Cette classe me permet de créer et de valider un token JWT.
 */
public class JwtUtil {
    // Clé secrète pour signer le token (à changer pour la production)
    private static final String SECRET_KEY = "ma_cle_secrete";

    /**
     * Génère un token JWT pour un utilisateur.
     * @param matricule le matricule de l'utilisateur
     * @return le token JWT sous forme de String
     */
    public static String generateToken(String matricule) {
        return Jwts.builder()
                .setSubject(matricule)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    /**
     * Parse et valide un token JWT.
     * @param token le token JWT
     * @return les Claims (infos du token)
     * @throws io.jsonwebtoken.JwtException si le token est invalide
     */
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
