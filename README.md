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

## SUITE README évolution Api_V2 (DTO et Annotations JavaDoc)
-----------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------
# 🎓 Gestionnaire de Formation
-----------------------------------------------------------------------------------------------
Bienvenue sur mon projet de gestionnaire de formation !  
J’ai créé cette application web pour apprendre à gérer des centres de formation, des formations, des modules, des séquences pédagogiques et des utilisateurs.

-----------------------------------------------------------------------------------------------
## 🚀 Objectif du projet
-----------------------------------------------------------------------------------------------
Je veux pouvoir :
- Ajouter et gérer des centres de formation
- Créer des formations et les organiser en modules et séquences
- Gérer les utilisateurs et leurs rôles (ex : admin, utilisateur)
- Découvrir comment fonctionne une application web avec Java et Spring Boot

-----------------------------------------------------------------------------------------------
## 🛠️ Ce dont j’ai besoin pour démarrer
-----------------------------------------------------------------------------------------------
Avant de commencer, je dois avoir :
- **Java 21** installé sur mon ordinateur
- **Maven** pour gérer les dépendances et compiler le projet
- Une **base de données MySQL** (ou MariaDB)
- Un éditeur de texte ou un IDE (par exemple : VSCode ou IntelliJ)

-----------------------------------------------------------------------------------------------
## 📦 Installation étape par étape
-----------------------------------------------------------------------------------------------
1. **Cloner le projet**  
   Je télécharge ou je clone ce dépôt sur mon ordinateur.
-----------------------------------------------------------------------------------------------
2. **Configurer la base de données**  
   Je crée une base de données MySQL.  
   Je renseigne mes identifiants et le nom de la base dans le fichier `src/main/resources/application.properties`.
-----------------------------------------------------------------------------------------------
3. **Installer les dépendances**  
   Dans un terminal, à la racine du projet, je tape :

   mvn clean install

Cela télécharge toutes les librairies nécessaires.
-----------------------------------------------------------------------------------------------
4. **Lancer l’application**  
Toujours dans le terminal, je lance :

mvn spring-boot:run

L’application démarre sur [http://localhost:8080]

-----------------------------------------------------------------------------------------------
## ✨ Ce que je peux faire avec ce projet
-----------------------------------------------------------------------------------------------
- Ajouter, modifier ou supprimer des centres de formation
- Créer des formations, des modules et des séquences pédagogiques
- Gérer les utilisateurs et leur attribuer des rôles
- Utiliser l’API REST pour connecter un front-end ou faire des tests

-----------------------------------------------------------------------------------------------
## 🧰 Ce que j’utilise
-----------------------------------------------------------------------------------------------
- **Java 21** : le langage principal
- **Spring Boot 3** : pour créer l’application web
- **Spring Data JPA** : pour gérer la base de données facilement
- **MySQL** : pour stocker les données
- **Maven** : pour gérer les dépendances et compiler

-----------------------------------------------------------------------------------------------
## 🚀Arborescence complète classique d’un projet Spring Boot Maven
-----------------------------------------------------------------------------------------------
GestionnaireFormation/                # C'est le dossier principal de mon projet

├── pom.xml                           # Ici, je déclare toutes les dépendances et la configuration Maven du projet
├── src/                              # Tout mon code source se trouve ici

│   ├── main/                         # Ce dossier contient le code principal de l’application
│   │   ├── java/                     # Je mets ici tous mes fichiers Java
│   │   │   └── com/
│   │   │       └── emi/
│   │   │           └── GestionnaireFormation/
│   │   │               ├── GestionnaireFormationApplication.java  # C'est la classe qui lance mon application Spring Boot
│   │   │               ├── model/                               # Ici, je crée mes classes qui représentent les tables de la base de données (entités)
│   │   │               │   ├── Centre.java
│   │   │               │   ├── Formation.java
│   │   │               │   ├── Module.java
│   │   │               │   ├── Sequence.java
│   │   │               │   ├── Role.java
│   │   │               │   └── Utilisateur.java
│   │   │               ├── repository/                          # Ici, je mets mes interfaces pour accéder aux données (repositories Spring Data)
│   │   │               │   ├── CentreRepository.java
│   │   │               │   ├── FormationRepository.java
│   │   │               │   ├── ModuleRepository.java
│   │   │               │   ├── SequenceRepository.java
│   │   │               │   ├── RoleRepository.java
│   │   │               │   └── UtilisateurRepository.java
│   │   │               ├── service/                             # Ici, je mets la logique métier (services)
│   │   │               │   ├── CentreService.java
│   │   │               │   ├── FormationService.java
│   │   │               │   ├── ModuleService.java
│   │   │               │   ├── SequenceService.java
│   │   │               │   ├── RoleService.java
│   │   │               │   └── UtilisateurService.java
│   │   │               └── controller/                          # Ici, je peux mettre mes contrôleurs (pour gérer les requêtes HTTP)
│   │   │                   └── (exemple : FormationController.java, etc.)
│   │   └── resources/                 # Ici, je mets les fichiers de configuration et ressources
│   │       ├── application.properties # Je configure ici la connexion à la base de données et d'autres paramètres
│   │       └── (autres fichiers : templates Thymeleaf, statiques, etc. si besoin)
│   └── test/                          # Ici, je mets mes tests unitaires et d’intégration
│       └── java/
│           └── com/
│               └── emi/
│                   └── GestionnaireFormation/
│                       └── (tests des différentes classes du projet)
└── README.md                          # Je mets ici la documentation simple pour expliquer comment utiliser mon projet

-----------------------------------------------------------------------------------------------
## 🚦 L’ordre des appels et le lien entre les fichiers
-----------------------------------------------------------------------------------------------
1. Je démarre l’application

    GestionnaireFormationApplication.java
    C’est la classe principale. Quand je lance l’application (mvn spring-boot:run), c’est ce fichier qui démarre tout.
    Il initialise Spring Boot et configure tout le projet.
-----------------------------------------------------------------------------------------------
2. Je reçois une requête (par exemple, pour afficher toutes les formations)

    controller/
    Si j’ai un contrôleur (ex : FormationController.java), c’est lui qui reçoit la requête HTTP (comme GET /formations).
    Il fait le lien entre l’utilisateur (ou le front-end) et le reste du code.
-----------------------------------------------------------------------------------------------
3. Je traite la logique métier

    service/
    Le contrôleur appelle un service (ex : FormationService.java).
    Le service contient la logique métier : il décide quoi faire, comment traiter les données, etc.
-----------------------------------------------------------------------------------------------
4. J’accède aux données

    repository/
    Le service appelle un repository (ex : FormationRepository.java).
    Le repository s’occupe de parler à la base de données : il va chercher, enregistrer, modifier ou supprimer des données.
-----------------------------------------------------------------------------------------------
5. Je manipule des objets

    model/
    Les repositories, services et contrôleurs manipulent des objets Java (ex : Formation.java, Centre.java).
    Ces objets représentent les tables de la base de données.
-----------------------------------------------------------------------------------------------
6. Je configure l’application

    application.properties
    Ce fichier me permet de configurer la connexion à la base de données, le port du serveur, etc.
    Spring Boot lit ce fichier au démarrage.

-----------------------------------------------------------------------------------------------
## 🔗 Exemple d’un appel complet (afficher toutes les formations)
-----------------------------------------------------------------------------------------------
    L’utilisateur envoie une requête HTTP GET /formations.

    Le contrôleur (FormationController.java) reçoit la requête.

    Il demande au service (FormationService.java) de lui donner la liste des formations.

    Le service demande au repository (FormationRepository.java) de récupérer toutes les formations dans la base de données.

    Le repository retourne une liste d’objets Formation (Formation.java).

    Le service renvoie la liste au contrôleur, qui la renvoie à l’utilisateur (en JSON par exemple).

-----------------------------------------------------------------------------------------------
## 🧭 Résumé du chemin d’une requête
-----------------------------------------------------------------------------------------------
Utilisateur → Controller → Service → Repository → Base de données
                ↑            ↑            ↑
             (model)      (model)      (model)

    model/ : utilisé partout pour manipuler les données sous forme d’objets Java.
-----------------------------------------------------------------------------------------------
En résumé :
Chaque fichier a son rôle, et ils travaillent ensemble comme une chaîne :
le contrôleur reçoit la demande, le service gère la logique, le repository parle à la base, et les modèles représentent les données.

-----------------------------------------------------------------------------------------------
## 💡 Pour aller plus loin
-----------------------------------------------------------------------------------------------
Ce projet est parfait pour m’entraîner à développer avec Spring Boot.  
Je peux ajouter une interface graphique, de nouvelles fonctionnalités, ou l’adapter à mes besoins.  
N’hésite pas à l’utiliser comme base pour tes propres projets ou pour t’exercer !

-----------------------------------------------------------------------------------------------
**Auteur :** CDA Afpa Emi
-----------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------

Voir JournalDeTravail pour la suite des transformations du projet.
-----------------------------------------------------------------------------------------------
## 02/06/25 -> intégration de mappers
-----------------------------------------------------------------------------------------------
## ✨Ajout des Mappers :
-----------------------------------------------------------------------------------------------
1. Avant

Avant, dans mon projet :

    Je faisais la conversion entre les entités (par exemple Formation, Utilisateur…) et les DTOs (FormationDto, UtilisateurDto…) directement dans les contrôleurs ou les services.

    J’avais souvent du code du genre :

java
    FormationDto dto = new FormationDto();
    dto.setLibelle(formation.getLibelle());
// etc.

Cette conversion était répétée à plusieurs endroits, ce qui rendait le code long, moins lisible et difficile à maintenir.

-----------------------------------------------------------------------------------------------
2. Pourquoi changer ?

    Je veux que mon code soit plus propre, plus facile à lire et à maintenir.

    Je veux éviter de répéter la même logique de conversion partout.

    J’ai appris que la bonne pratique, c’est d’utiliser des mappers : des classes dédiées qui font la conversion entre entités et DTOs.

-----------------------------------------------------------------------------------------------
3. ✨Après (avec les mappers)

Maintenant, j’ai ajouté des mappers pour chaque entité principale.
Un mapper est une classe qui contient des méthodes pour convertir une entité en DTO et inversement.

Par exemple, pour Formation :

    J’ai créé une classe FormationMapper avec deux méthodes :

        toDto(Formation formation)

        toEntity(FormationDto dto)

Dans mes contrôleurs, au lieu de faire la conversion à la main, j’utilise simplement le mapper :

java
    FormationDto dto = FormationMapper.toDto(formation);
    Formation formation = FormationMapper.toEntity(dto);

-----------------------------------------------------------------------------------------------
## ✨Nouvelle architecture du projet (commentée)

Voici à quoi ressemble maintenant l’organisation de mes fichiers :
src/main/java/com/emi/GestionnaireFormation/
│
├── controller/
│   ├── FormationController.java      // Utilise FormationMapper
│   ├── UtilisateurController.java    // Utilise UtilisateurMapper
│   ├── CentreController.java         // Utilise CentreMapper
│   ├── ModuleController.java         // Utilise ModuleMapper
│   └── SequenceController.java       // Utilise SequenceMapper
│
├── dto/
│   ├── FormationDto.java
│   ├── UtilisateurDto.java
│   ├── CentreDto.java
│   ├── ModuleDto.java
│   └── SequenceDto.java
│
├── mapper/
│   ├── FormationMapper.java      // Conversion Formation <-> FormationDto
│   ├── UtilisateurMapper.java    // Conversion Utilisateur <-> UtilisateurDto
│   ├── CentreMapper.java         // Conversion Centre <-> CentreDto
│   ├── ModuleMapper.java         // Conversion Module <-> ModuleDto
│   └── SequenceMapper.java       // Conversion Sequence <-> SequenceDto
│
├── model/
│   ├── Formation.java
│   ├── Utilisateur.java
│   ├── Centre.java
│   ├── Module.java
│   └── Sequence.java
│
├── repository/
│   ├── FormationRepository.java
│   ├── UtilisateurRepository.java
│   ├── CentreRepository.java
│   ├── ModuleRepository.java
│   └── SequenceRepository.java
│
└── service/
    ├── FormationService.java
    ├── UtilisateurService.java
    ├── CentreService.java
    ├── ModuleService.java
    └── SequenceService.java

-----------------------------------------------------------------------------------------------
## 👍Ce que ça change

    Le code de mes contrôleurs et services est beaucoup plus court et plus clair.

    Toute la logique de conversion est centralisée dans un seul endroit.

    Si je dois changer la structure d’un DTO ou d’une entité, je n’ai qu’un seul fichier à modifier (le mapper).

    C’est plus facile à relire et à faire évoluer


-----------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------

## 🔄 Les mappers : un pont entre mes fichiers

Les mappers jouent maintenant un rôle central dans mon projet. Ils font le lien entre les entités (dans le dossier `model`) et les DTOs (dans le dossier `dto`). Grâce à eux, chaque fois que j’ai besoin d’envoyer des données à l’extérieur de mon application (par exemple, vers le frontend ou une API), je peux facilement convertir une entité en DTO. Inversement, quand je reçois des données du frontend, je peux convertir un DTO en entité avant de l’enregistrer en base de données.  
-----------------------------------------------------------------------------------------------
Cela crée une nouvelle relation :  
-----------------------------------------------------------------------------------------------
- Les **contrôleurs** n’ont plus à connaître les détails des entités ou des DTOs : ils appellent simplement les méthodes des mappers pour faire la conversion.
-----------------------------------------------------------------------------------------------
- Les **services** peuvent aussi utiliser les mappers pour préparer les données à envoyer ou à recevoir.
-----------------------------------------------------------------------------------------------
- Les **mappers** deviennent ainsi le point de passage obligé pour toute transformation entre le monde de la base de données (`model`) et le monde de l’échange de données (`dto`).


-----------------------------------------------------------------------------------------------
En résumé, chaque couche de mon application a maintenant un rôle plus clair et mieux séparé :  
- Les **entités** représentent la structure en base de données (model).
- Les **DTOs** servent à transporter les données vers l’extérieur ou l’intérieur.
- Les **mappers** assurent la conversion entre les deux.
- Les **contrôleurs** et **services** orchestrent ces échanges, mais sans avoir à se préoccuper des détails de conversion.
-----------------------------------------------------------------------------------------------

- Les **repositories** restent responsables de toute la communication avec la base de données.
Ils permettent de récupérer, sauvegarder, modifier ou supprimer les entités, ce qui alimente ensuite les conversions via les mappers et les échanges avec les contrôleurs et services.

-----------------------------------------------------------------------------------------------

Cette organisation rend mon projet plus modulaire, plus facile à maintenir et à faire évoluer !

-----------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------
## Start with Spring Security 04/06/25
🔒 Ajout de Spring Security 

👋 Je viens d’ajouter Spring Security à mon projet !

    🔐 Maintenant, l’accès à l’application est sécurisé.

    🛡️ Un mot de passe est demandé pour accéder aux pages.

    👤 Un utilisateur de test est déjà configuré (voir le code).

    🔄 Les mots de passe sont protégés grâce au hashage.

    Grâce à Spring Security, mon application est plus sûre et prête pour gérer des utilisateurs ! 🚀
