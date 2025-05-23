## Gestionnaire de Formation – Projet Spring Boot

Ce projet est une API rest réalisée en Java avec le framework Spring Boot.

Il permet de gérer des utilisateurs, des rôles, des formations, des centres, des modules et des séquences de formation.

Ce projeta été initier via Spring Boot via https://start.spring.io/


## API REST
C’est une façon pour deux applications de communiquer entre elles à travers Internet, en utilisant des règles simples.

Avec une API REST, je peux demander, ajouter, modifier ou supprimer des informations (comme des utilisateurs ou des formations) en envoyant des requêtes avec des verbes comme GET, POST, PUT ou DELETE.

C’est un moyen pratique et universel pour qu’un site web, une application mobile ou un autre programme puisse échanger des données avec mon application.

-----------------------------------------------------------------------------------------------
# 🌱 Mise en place du projet
-----------------------------------------------------------------------------------------------

1. Prérequis

    Java 17 ou plus (recommandé)

    Maven (gestionnaire de dépendances)

    Un IDE (VSCode, IntelliJ IDEA, Eclipse…)

    Une base de données MySQL ou MariaDB

-----------------------------------------------------------------------------------------------

2. Créer la base de données (exemple avec MySQL) : via PhpMyAdmin

sql
    CREATE DATABASE gestionnaire_formation CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
    .....

    Penser à Créer un compte utilisateur pour chaque BDD.

-----------------------------------------------------------------------------------------------

3. Configurer la connexion à la base de données dans le fichier 
src/main/resources/application.properties :

text :
    spring.datasource.url=jdbc:mysql://localhost:3306/gestionnaire_formation
    spring.datasource.username=ton_user
    spring.datasource.password=ton_mot_de_passe

-----------------------------------------------------------------------------------------------

4. Lancer le projet :

    Avec Maven :

        mvn spring-boot:run

    Ou directement via ton IDE (clic droit sur GestionnaireFormationApplication.java > Run)

-----------------------------------------------------------------------------------------------

5. Tester l’API avec Postman ou un navigateur.
https://www.postman.com/


-----------------------------------------------------------------------------------------------
# Mon pom.xml
Si besoin de packages supplémentaires https://mvnrepository.com/


-----------------------------------------------------------------------------------------------
## 📦 Structure du projet
-----------------------------------------------------------------------------------------------

src/main/java/com/emi/GestionnaireFormation/
├── model/        # Les entités (tables de la base)
├── repository/   # Les interfaces pour accéder à la base
├── service/      # La logique métier
├── controller/   # Les endpoints REST (API)
└── GestionnaireFormationApplication.java # Classe principale

-----------------------------------------------------------------------------------------------
## 🌍 Les verbes HTTP utilisés
-----------------------------------------------------------------------------------------------

    GET : pour lire/lister des données (ex : voir tous les utilisateurs)

    POST : pour créer une nouvelle donnée (ex : ajouter une formation)

    PUT : pour modifier une donnée existante (ex : mettre à jour un module)

    DELETE : pour supprimer une donnée (rare, car on utilise souvent PUT pour désactiver)

-----------------------------------------------------------------------------------------------
## 🛣️ Exemples d’URL (endpoints)
    Endpoint :
    Un endpoint est une « adresse » (URL) d’une API à laquelle je peux envoyer une requête HTTP (GET, POST, PUT, etc.) pour accéder à une ressource ou effectuer une action (ex : obtenir la liste des utilisateurs, créer un rôle, désactiver un module…).

    C’est le point d’entrée de l'application pour communiquer avec elle depuis un client (navigateur, Postman, autre application…).
-----------------------------------------------------------------------------------------------

| Entité        | Action                | Méthode | URL                                 | Body JSON (exemple)                      |
|---------------|-----------------------|---------|-------------------------------------|------------------------------------------|
| Role          | Lister tous           | GET     | /roles/                             | -                                        |
|               | Détail par ID         | GET     | /roles/1                            | -                                        |
|               | Créer                 | POST    | /roles/create                       | { "libelle": "Formateur", "statut": true } |
|               | Modifier              | PUT     | /roles/update/1                     | { "libelle": "Formateur principal", "statut": false } |
|               | Désactiver            | PUT     | /roles/disable/1                    | -                                        |
| Utilisateur   | Lister tous           | GET     | /utilisateurs/                      | -                                        |
|               | Détail par matricule  | GET     | /utilisateurs/STG011                | -                                        |
|               | Créer                 | POST    | /utilisateurs/create                | { "matricule": "STG020", ... }           |
|               | Modifier              | PUT     | /utilisateurs/update/STG011         | { "nom": "Durand", ... }                 |
|               | Désactiver            | PUT     | /utilisateurs/disable/STG011        | -                                        |
| Formation     | Lister tous           | GET     | /formations/                        | -                                        |
|               | Détail par ID         | GET     | /formations/1                       | -                                        |
|               | Créer                 | POST    | /formations/create                  | { "libelle": "Java", ... }               |
|               | Modifier              | PUT     | /formations/update/1                | { "libelle": "Java Avancé", ... }        |
|               | Désactiver            | PUT     | /formations/disable/1               | -                                        |
| Centre        | Lister tous           | GET     | /centres/                           | -                                        |
|               | Détail par ID         | GET     | /centres/1                          | -                                        |
|               | Créer                 | POST    | /centres/create                     | { "nom": "Centre de Paris", ... }        |
|               | Modifier              | PUT     | /centres/update/1                   | { "nom": "Centre de Lyon", ... }         |
|               | Désactiver            | PUT     | /centres/disable/1                  | -                                        |
| Module        | Lister tous           | GET     | /modules/                           | -                                        |
|               | Détail par ID         | GET     | /modules/1                          | -                                        |
|               | Créer                 | POST    | /modules/create                     | { "nom": "Module Java", ... }            |
|               | Modifier              | PUT     | /modules/update/1                   | { "nom": "Module Spring", ... }          |
|               | Désactiver            | PUT     | /modules/disable/1                  | -                                        |
| Sequence      | Lister tous           | GET     | /sequences/                         | -                                        |
|               | Détail par ID         | GET     | /sequences/1                        | -                                        |
|               | Lister par module     | GET     | /sequences/module/1                 | -                                        |
|               | Créer                 | POST    | /sequences/create                   | { "libelle": "Séquence 1", ... }         |
|               | Modifier              | PUT     | /sequences/update/1                 | { "libelle": "Séquence 1 modifiée", ... }|
|               | Désactiver            | PUT     | /sequences/disable/1                | -                                        |

-----------------------------------------------------------------------------------------------
## 💡 Notions utiles
-----------------------------------------------------------------------------------------------

    Entité (model) : classe Java qui représente une table SQL (ex : Utilisateur, Role…)

    Repository : interface pour accéder à la base de données (CRUD)

    Service : où on place la logique métier (calculs, vérifications…)

    Contrôleur : où on définit les routes HTTP (endpoints)

-----------------------------------------------------------------------------------------------
## 📚 Conseils pour progresser
-----------------------------------------------------------------------------------------------

    Je teste chaque endpoint avec Postman pour bien comprendre les échanges.

    Je lis les messages d’erreur dans la console : ils aident à corriger tes erreurs.

    Pour chaque nouvelle entité, je crée les 4 fichiers : modèle, repository, service, contrôleur.

-----------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------