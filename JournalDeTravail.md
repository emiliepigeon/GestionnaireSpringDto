
# Premier API
Ceci est un journal de travail et non une documentation de l'API.

15/05/2025

Je suis débutante voici mon premier projet d'API.
Exercice demandé par mon formateur : mise en place d'une API de Gestionnaire de formation et de centre.

Pour cela un cahier des charges nous a été remis, ainsi qu'un fichier looping de la modélisation et conceptualisation de la base de données relationnelle.

-----------------------------------------------------------------------------------------
JAVA / MAVEN / SPRING BOOT
_________________________________________________________________________
# Demande 1 du formateur
Création via phpMyAdmin de la BDD (entités/tables relationnelles et contraintes).

# Demande 2 du formateur
Mettre en place un dépôt GITHUB propre et pousser régulièrement (sur le dépôt distant).

Pour cela :
- je me connecte à GitHub
- je crée un nouveau repository
- j'ouvre ma console GitBash (sur mon pc je me mais dans le répertoire où je veux travailler. Puis clic droit -> afficher plus d'otion -> ouvrir le GitBash).

- Dans mon bash :
1- git clone [url du dépôt distant]
2- cd [non du dossier] -> je me déplace dans le bon répertoire
3- git init -> j'initialise mon dépôt

- Je ferme mon GitBash et j'ouvre mon projet (dossier de travail) dans mon éditeur de texte ou IDE -> en l'occurence je vais utiliser VsCode.

Nb : j'ai en amont installé mon JDK et mis en place les variables d'environnement pour pouvoir travailler avec le langage Java.

# Demande 3 du formateur
Cette étape à déjà été faite. 

Initier le projet Spring Boot via https://start.spring.io/

Si besoin de packages supplémentaires https://mvnrepository.com/

Je vais donc juste récupérer mon projet précédent.
Pour cela je fais un copier collé de mon ancien projet dans mon nouveau projet.
Je fais cela pour que mon repository soit propre et carré (demande du formateur).

# Pour continuer
et avoir un dépôt propre.

J'ouvre un terminal GitBash dans Vs Code

Je m'assure d'être dans le bon répertoire.


#### AVANT de continuer je vais synchroniser mes dépôt

ATTENTION Ce que je vais poussé ne fonctionne pas.
C'est la base pour recommencer le travail dont je n'avais pas compris les consignes depuis 3 semaines.

git status
git add .
git commit -m "message"
git push

C'est fait!
Je vérifie sur mon GitHub.

Tout est Ok.

Mon gitignore est lui aussi bien pris en compte.

# Consignes du formateur pour la suite:
Pour le 20 mai 2025
- Il faut que pour mardi prochain en présentiel afin de pouvoir avancer soit terminé les modules API suivant : utilisateur, rôle, formation, module, et séquence  + un GitHub propre !

# Structure de base du projet
src/main/java
└── com/emi/GestionnaireFormation/
    ├── controller/
    ├── model/
    ├── repository/
    ├── service/
    └── GestionnaireFormationApplication.java

# Je créer une nouvelle branche de travail
$ git branch [non de la nouvelle branche de travail]

$ git branch
  Api_V1
* main

$ git checkout Api_V1
M       README.md
Switched to branch 'Api_V1'

# Je suis dans ma nouvelle branche de travail

Je vais pousser ma nouvelle branche:
$ git status
$ git add .
$ git commit -m "Initialisation de ma branche de travail Api_V1"
$ git branch -r
$ git push -u origin Api_V1

Je vais creer mes entités (avec leurs CRUD) et  avec mes relations avec jointures :

1 -> le model
2 -> le repository
3 -> le service
4 -> le controller

-------------------------------------------------------------------------------

Suite

Aprés la créa de chaque nouvelle entité :

- mvn clean install
- mvn spring-boot:run
___________________________________________________________________________________

src/
└── main/
    └── java/
        └── com/
            └── emi/
                └── GestionnaireFormation/
                    ├── model/
                    │   ├── Utilisateur.java
                    │   ├── Role.java
                    │   └── Formation.java
                    ├── repository/
                    │   ├── UtilisateurRepository.java
                    │   ├── RoleRepository.java
                    │   └── FormationRepository.java
                    ├── service/
                    │   ├── UtilisateurService.java
                    │   ├── RoleService.java
                    │   └── FormationService.java
                    ├── controller/
                    │   ├── UtilisateurController.java
                    │   ├── RoleController.java
                    │   └── FormationController.java
                    └── GestionnaireFormationApplication.java

Conseils pour éviter les conflits

    Toujours un seul public class par fichier (le nom du fichier == nom de la classe).

    Pas deux classes avec le même nom dans le même package.

    Utilise les packages pour séparer les rôles (voir ci-dessus).

    Ne jamais mélanger plusieurs classes dans un même fichier (sauf classes internes privées, mais ce n’est pas utile ici).


Résumé

    Un fichier = une classe publique

    Nom du fichier = nom de la classe

    Sépare bien tes packages (model, repository, service, controller)

    Pas de doublon de nom de classe dans le même package

________________________________________________________________________________

------------------------------------
src/
└── main/
    ├── java/
    │   └── com/
    │       └── emi/
    │           └── GestionnaireFormation/
    │               ├── model/
    │               │   ├── Utilisateur.java
    │               │   ├── Role.java
    │               │   ├── Formation.java
    │               │   ├── Centre.java
    │               │   └── Module.java
    │               ├── repository/
    │               │   ├── UtilisateurRepository.java
    │               │   ├── RoleRepository.java
    │               │   ├── FormationRepository.java
    │               │   ├── CentreRepository.java
    │               │   └── ModuleRepository.java
    │               ├── service/
    │               │   ├── UtilisateurService.java
    │               │   ├── RoleService.java
    │               │   ├── FormationService.java
    │               │   ├── CentreService.java
    │               │   └── ModuleService.java
    │               ├── controller/
    │               │   ├── UtilisateurController.java
    │               │   ├── RoleController.java
    │               │   ├── FormationController.java
    │               │   ├── CentreController.java
    │               │   └── ModuleController.java
    │               └── GestionnaireFormationApplication.java
    └── resources/
        ├── application.properties
        └── ... (autres fichiers de config, templates, etc.)


------------------------------------------------------------------------------------------


### tableau récapitule tous les endpoints REST 
### Pour chaque entité [Controller-Service-Repository] ###

| Entité      | Action         | Méthode | URL                                      | Body JSON (exemple)                                                                                  |
|-------------|---------------|---------|------------------------------------------|------------------------------------------------------------------------------------------------------|
| **Role**    | Lister tous    | GET     | /roles/                                  | -                                                                                                    |
|             | Détail par ID  | GET     | /roles/1                                 | -                                                                                                    |
|             | Créer          | POST    | /roles/create                            | { "libelle": "Formateur", "statut": true }                                                          |
|             | Modifier       | PUT     | /roles/update/1                          | { "libelle": "Formateur principal", "statut": true }                                                |
|             | Supprimer      | DELETE  | /roles/delete/1                          | -                                                                                                    |
|             | Désactiver     | PUT     | /roles/disable/1                         | -                                                                                                    |
| **Utilisateur** | Lister tous    | GET     | /utilisateurs/                            | -                                                                                                    |
|             | Détail par matricule | GET     | /utilisateurs/STG011                      | -                                                                                                    |
|             | Créer          | POST    | /utilisateurs/create                      | { "matricule": "STG020", "nom": "Durand", ... , "role": { "id": 2 } }                                |
|             | Modifier       | PUT     | /utilisateurs/update/STG011               | { "nom": "Durand", ... , "role": { "id": 2 } }                                                       |
|             | Supprimer      | DELETE  | /utilisateurs/delete/STG011               | -                                                                                                    |
|             | Désactiver     | PUT     | /utilisateurs/disable/STG011              | -                                                                                                    |
| **Formation** | Lister tous    | GET     | /formations/                              | -                                                                                                    |
|             | Détail par ID  | GET     | /formations/1                             | -                                                                                                    |
|             | Créer          | POST    | /formations/create                        | { "libelle": "Java", "numeroOffre": "ABC123", ... , "statut": true }                                 |
|             | Modifier       | PUT     | /formations/update/1                      | { "libelle": "Java Avancé", ... }                                                                    |
|             | Supprimer      | DELETE  | /formations/delete/1                      | -                                                                                                    |
| **Centre**  | Lister tous    | GET     | /centres/                                 | -                                                                                                    |
|             | Détail par ID  | GET     | /centres/1                                | -                                                                                                    |
|             | Créer          | POST    | /centres/create                           | { "nom": "Centre de Paris", "adresse": "10 rue ...", "codePostal": "75000", "ville": "Paris", "statut": true } |
|             | Modifier       | PUT     | /centres/update/1                         | { "nom": "Centre de Lyon", ... }                                                                     |
|             | Supprimer      | DELETE  | /centres/delete/1                         | -                                                                                                    |
| **Module**  | Lister tous    | GET     | /modules/                                 | -                                                                                                    |
|             | Détail par ID  | GET     | /modules/1                                | -                                                                                                    |
|             | Créer          | POST    | /modules/create                           | { "nom": "Module Java", "description": "POO", "statut": true }                                       |
|             | Modifier       | PUT     | /modules/update/1                         | { "nom": "Module Spring", ... }                                                                      |
|             | Supprimer      | DELETE  | /modules/delete/1                         | -                                                                                                    |
| **Sequence**| Lister tous    | GET     | /sequences/                               | -                                                                                                    |
|             | Détail par ID  | GET     | /sequences/1                              | -                                                                                                    |
|             | Lister par module | GET  | /sequences/module/1                       | -                                                                                                    |
|             | Créer          | POST    | /sequences/create                         | { "libelle": "Séquence 1", "description": "Intro", "ordre": 1, "statut": true, "module": { "id": 1 } } |
|             | Modifier       | PUT     | /sequences/update/1                       | { "libelle": "Séquence 1 modifiée", ... }                                                           |
|             | Supprimer      | DELETE  | /sequences/delete/1                       | -                                                                                         

-----------------------------------------------------------------------------------------


------------------------------------------------------------------------------------------
22 / 23 mai 2025

### Évolution V2 de l'API
### Intégration du DTO => création du package DTO [UtilisateurDto et RoleDto] ###



------------------------------------------------------------------------------------------
26 mai 2025

### Évolution V2 de l'API suitedu Dto
### Intégration du DTO => création du package DTO [FormationDto / CentreDto / ModuleDto et SequenceDto] ###

### Ajout des annotations spécifique pour générer la JavaDoc

 mvn clean spring-boot:run

## 🟢 À retenir

    Aucun appel à un champ ou méthode inexistant dans le DTO.

    Chaque méthode et classe est commentée pour t’aider à comprendre le rôle de chaque partie.

    Tu peux compléter l’exemple pour les autres entités (Centre, Utilisateur, etc.) en suivant ce modèle.

--------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------
## Demande de correction de mon formateur du 28/05/2025
--------------------------------------------------------------------------------------------
## 🛠️ 02/06/2025

Voici un texte explicatif simple, étape par étape, des modifications apportées à ton projet aujourd’hui, en réponse aux demandes de ton formateur.  
Je t’explique chaque correction "avant/après" et pourquoi elle a été faite, avec un ton zen, simple et adapté à une débutante.

--------------------------------------------------------------------------------------------

## 1. **CentreDto : ne pas afficher le statut**

**Avant :**  
Le DTO CentreDto contenait un champ `statut` (actif/inactif).

**✅Après :**  
J’ai supprimé le champ `statut` du CentreDto.  
**Pourquoi ?**  
Le DTO sert à transmettre seulement les infos nécessaires au frontend. Le statut n’est pas utile côté client, donc on ne l’expose pas.

--------------------------------------------------------------------------------------------

## 2. **CentreDto, ModuleDto, SequenceDto : constructeurs pleins avec setters**

**Avant :**  
Il n’y avait que des constructeurs vides dans ces DTO.

**✅Après :**  
J’ai ajouté un constructeur "plein" dans chaque DTO, qui prend tous les champs en paramètres et les initialise avec les setters.  
**Pourquoi ?**  
C’est pratique pour créer rapidement un objet DTO avec toutes ses infos, surtout lors de la conversion entité ↔ DTO.

--------------------------------------------------------------------------------------------

## 3. **UtilisateurDto : roleLibelle devient une liste**

**Avant :**  
Dans UtilisateurDto, il y avait un champ `roleLibelle` de type `String`, donc un seul rôle possible par utilisateur.

**✅Après :**  
J’ai remplacé ce champ par une `List roleLibelle`, pour permettre plusieurs rôles par utilisateur.  
**Pourquoi ?**  
Un utilisateur peut avoir plusieurs rôles (exemple : "ADMIN" et "USER" en même temps).  
C’est plus flexible et conforme à la réalité.

--------------------------------------------------------------------------------------------

## 4. **Relation utilisateur/role : ManyToMany**

**Avant :**  
Dans les modèles, la relation était `ManyToOne` :  
- Un utilisateur avait un seul rôle.

**✅Après :**  
J’ai modifié la relation en `ManyToMany` :  
- Un utilisateur peut avoir plusieurs rôles, et un rôle peut être partagé par plusieurs utilisateurs.  
- Cela se traduit par un `Set` dans Utilisateur et un `Set` dans Role.  
**Pourquoi ?**  
C’est la vraie logique métier : un utilisateur peut avoir plusieurs rôles.

--------------------------------------------------------------------------------------------

## 5. **CentreService : update avec un simple .save()**

**Avant :**  
La méthode `updateCentre` allait chercher le centre à modifier, changeait chaque champ, puis sauvegardait.

**✅Après :**  
La méthode `updateCentre` fait simplement `save(centre)` avec l’objet à mettre à jour.  
**Pourquoi ?**  
C’est plus simple et Spring Data JPA gère la mise à jour automatiquement si l’id existe.

--------------------------------------------------------------------------------------------

## 6. **RoleService : méthodes héritées ou à écrire ?**

**Avant :**  
Je ne savais pas si je devais écrire toutes les méthodes du service, ou utiliser celles héritées de JpaRepository.

**✅Après :**  
J’ai gardé ou ajouté seulement les méthodes vraiment utiles dans le service (comme `findAll`, `findById`, `findByLibelle`, `deleteById`).  
**Pourquoi ?**  
Spring Data JPA fournit déjà beaucoup de méthodes de base (CRUD) dans JpaRepository, donc je n’ai pas besoin de tout réécrire.  
j'ajoute seulement ce qui est spécifique au métier.

--------------------------------------------------------------------------------------------

## 7. **Bonus : Optional dans les repositories**

**Avant :**  
j'utilisais parfois des méthodes qui retournaient directement un objet ou `null`.

**✅Après :**  
J’ai adapté les méthodes de recherche personnalisées (comme `findByLibelle`) pour qu’elles retournent un `Optional`.  
**Pourquoi ?**  
C’est plus sûr : ça force à gérer le cas où l’objet n’existe pas, et ça évite les erreurs de type `NullPointerException`.

--------------------------------------------------------------------------------------------

## **Résumé avant/après**

| Correction demandée                               | Avant                              | Après (modification)                              |
|---------------------------------------------------|------------------------------------|---------------------------------------------------|
| CentreDto : pas de statut                         | Champ statut présent               | Champ statut supprimé                             |
| DTOs : constructeurs pleins                       | Seulement constructeurs vides      | Ajout de constructeurs pleins avec setters        |
| UtilisateurDto : rôle unique                      | roleLibelle : String (un seul rôle)| roleLibelle : List (plusieurs rôles)      |
| Modèle utilisateur/role : relation                | ManyToOne (un seul rôle)           | ManyToMany (plusieurs rôles)                      |
| CentreService : update                            | Modification champ par champ       | Un simple .save()                                 |
| RoleService : méthodes                            | Incertitude                        | Utilisation des méthodes héritées + personnalisées|
| Repository : gestion du "pas trouvé"              | Retourne null                      | Retourne Optional                                 |

--------------------------------------------------------------------------------------------

## ✅🌱**Conclusion**

Toutes ces modifications rendent le projet plus clair, plus flexible et plus conforme aux bonnes pratiques Java/Spring.  
Elles facilitent aussi la maintenance et l’évolution de cette application.  

--------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------


