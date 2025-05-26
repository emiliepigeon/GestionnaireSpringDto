package com.emi.GestionnaireFormation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principale pour démarrer l'application Spring Boot GestionnaireFormation.
 * <p>
 * Cette classe contient le point d'entrée {@code main} qui lance l'application
 * avec la configuration Spring Boot.
 *
 * @author CDA Afpa Emi
 */
@SpringBootApplication
public class GestionnaireFormationApplication {

    /**
     * Point d'entrée principal de l'application.
     *
     * @param args arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        SpringApplication.run(GestionnaireFormationApplication.class, args);
    }
}
