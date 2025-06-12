
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

## Suite d'avancement du projet fil rouge du formateur avec intégration de mappers
--------------------------------------------------------------------------------------------
## 02/06/25

# 🌟 Ajout des Mappers dans mon projet Java
Gestionnaire de formation

Je fais référence aux fichiers sans les afficher, et je donne des exemples d’application dans le code.

--------------------------------------------------------------------------------------------

## 1. Avant modifictions

📝 Avant, je faisais la conversion entre mes entités (comme Formation, Utilisateur…) et mes DTOs directement dans les contrôleurs ou les services. 

Cela voulait dire que j’avais souvent du code de conversion copié-collé à plusieurs endroits, ce qui rendait le projet plus long, moins lisible et plus difficile à maintenir.

--------------------------------------------------------------------------------------------

## 2. Pourquoi j’ai ajouté des mappers ?

💡 J’ai appris que la bonne pratique est de créer des **mappers** :  
- Ce sont des classes dédiées qui s’occupent uniquement de convertir une entité en DTO et inversement.
- Ça centralise la logique de conversion, évite la duplication de code et rend le projet plus propre.

--------------------------------------------------------------------------------------------

## 3. Après : Comment j’utilise les mappers

✅ Maintenant, pour chaque entité principale (Formation, Utilisateur, Centre, Module, Sequence, Role),  
j’ai créé un fichier mapper dans le dossier `mapper` de mon projet.

Chaque mapper contient deux méthodes principales :
- `toDto()` : convertit une entité en DTO.
- `toEntity()` : convertit un DTO en entité.

--------------------------------------------------------------------------------------------

## 4. 📋 Application dans mes contrôleurs

Dans mes contrôleurs, au lieu d’écrire la conversion à la main,  
j’utilise simplement le mapper correspondant. 
--------------------------------------------------------------------------------------------
Par exemple, dans le contrôleur Formation :
--------------------------------------------------------------------------------------------
```java
// Avant :
FormationDto dto = new FormationDto();
dto.setLibelle(formation.getLibelle());
// ...

// Après :
FormationDto dto = FormationMapper.toDto(formation);
```
--------------------------------------------------------------------------------------------
Pour créer une nouvelle formation à partir d’un DTO :
--------------------------------------------------------------------------------------------
```java
// Avant :
Formation formation = new Formation();
formation.setLibelle(dto.getLibelle());
// ...

// Après :
Formation formation = FormationMapper.toEntity(dto);
```
--------------------------------------------------------------------------------------------

## 5. 🗂️ Nouvelle organisation (références de fichiers)

- Tous mes mappers sont dans le dossier `mapper` (ex : `FormationMapper`, `UtilisateurMapper`, etc.).
- Les DTOs sont dans le dossier `dto`.
- Les entités sont dans le dossier `model`.
- Les contrôleurs appellent les méthodes des mappers pour convertir entités et DTOs.

--------------------------------------------------------------------------------------------

## 6. Résumé avant/après

| Avant                           | Après avec mappers                                |
|----------------------------------|---------------------------------------------------|
| Conversion partout dans le code  | Conversion centralisée dans les mappers           |
| Beaucoup de répétition           | Code plus court et plus clair                     |
| Risque d’oubli ou d’erreur       | Moins d’erreurs, plus facile à faire évoluer      |

--------------------------------------------------------------------------------------------

## 7. 🎯 Ce que ça m’apporte

- Je gagne du temps quand j’ajoute ou modifie un champ dans une entité ou un DTO.
- Mon code est plus lisible et plus professionnel.
- Je suis plus sereine pour la suite de mon apprentissage !

--------------------------------------------------------------------------------------------
## 04/06/2025 Premier pas avec SpringSecurity

-> Intégration au UtilisateurController
-> Création du package = security et du fichier 
    SecurityConfigAPI.java


Modification des routes principal dans tous les controller
"/api/non du modul"

http://localhost:8080/api/utilisateurs -> 404 NOT FOUND
http://localhost:8080/api/utilisateurs/ -> 200

http://localhost:8080/api/roles -> 404 NOT FOUND
http://localhost:8080/api/roles/ -> 200

http://localhost:8080/api/centres/ -> 200
http://localhost:8080/api/centre -> 200

http://localhost:8080/api/modules -> 200
http://localhost:8080/api/modules/ -> 404 NOT FOUND

Problème avec postman (formation/sequence) => TODO CORRIGER A.S.A.P

http://localhost:8080/api/formations -> 200
http://localhost:8080/api/formations/ -> 404 NOT FOUND


http://localhost:8080/api/sequences -> 200
http://localhost:8080/api/sequences/ -> 404 NOT FOUND


Besoin d'investiguer pour comprendre le pourquoi ?????

## 05/06/25 Suite

Réponse trouvée pour les / et sans = 200 ou 404

    @GetMapping({"", "/"})


SecurityConfigAPI.java

Explications complémentaires : classe SecurityConfigAPI 

    L’annotation @Configuration indique à Spring que cette classe contient des beans de configuration pour la sécurité.

    Le bean SecurityFilterChain est le cœur de la configuration de sécurité : il définit comment les requêtes HTTP sont sécurisées (ici, toutes nécessitent une authentification via HTTP Basic).

    Le bean PasswordEncoder permet de hasher les mots de passe avec BCrypt, ce qui est recommandé pour la sécurité.

    Le bean UserDetailsService crée un utilisateur en mémoire, pratique pour les phases de test ou de prototypage.

-------------------------------------------------------------------------------------------------

## 12/06/25 Suite -> intégration de JWT pour l'authentification

<!-- 📝 Journal de travail – Sécurité & Tests API
🔒 1. Mise en place de la sécurité JWT

    Nous avons corrigé la configuration de Spring Security pour protéger les endpoints avec un token JWT.

    Correction du filtre JWT pour donner un rôle (ROLE_USER) à chaque utilisateur authentifié.

🛠️ 2. Correction des erreurs 401 et 403

    🚫 Avant : Tous les endpoints étaient en 401 (non authentifié), puis en 403 (non autorisé).

    ✅ Après correction : Les utilisateurs avec un JWT valide peuvent accéder aux endpoints protégés.

🗃️ 3. Vérification du code

    Nous avons relu et corrigé :

        Le filtre JwtAuthenticationFilter.java

        La configuration SecurityConfigJwt.java

        Le contrôleur d’authentification AuthController.java

    Suppression des configs de sécurité inutiles.

🧪 4. Tests avec Postman

    📤 Login :

        POST /auth/login avec un matricule et mot de passe existants.

        Récupération du token JWT.

    📥 Utilisation du token :

        Ajout du header Authorization: Bearer <token> dans toutes les requêtes protégées.

        Test des endpoints (GET, POST, PUT, DELETE) sur /api/utilisateurs/.

🗨️ 5. Conseils et bonnes pratiques

    Toujours commencer par le login pour obtenir un token.

    Vérifier l’URL exacte et le mapping dans les contrôleurs.

    Lire les messages d’erreur dans la console pour comprendre les problèmes. -->

<!-- 🎯 Bilan

    🔄 Maintenant, l’authentification et l’autorisation fonctionnent !

    🌟 Je peux tester toute mon API en sécurité avec Postman. -->

📝 Journal de travail – Sécurité & Tests API
🔒 1. Mise en place de la sécurité JWT

    Correction de la configuration Spring Security pour protéger les endpoints avec un token JWT.

    Ajout d’un rôle (ROLE_USER) à chaque utilisateur authentifié dans le filtre JWT.

🛠️ 2. Correction des erreurs 401 et 403

    🚫 Avant : Tous les endpoints étaient en 401 (non authentifié), puis en 403 (non autorisé).

    ✅ Après correction : Les utilisateurs avec un JWT valide devraient pouvoir accéder aux endpoints protégés.

    ⚠️ Problème restant : Je suis toujours en 403 sur tous mes endpoints, même après toutes les corrections.

🗃️ 3. Vérification du code

    Relecture et correction de :

        JwtAuthenticationFilter.java

        SecurityConfigJwt.java

        AuthController.java

    Suppression des configurations de sécurité inutiles.

🧪 4. Tests avec Postman

    📤 Login : POST /auth/login avec un matricule et mot de passe existants → récupération du token JWT.

    📥 Utilisation du token : Ajout du header Authorization: Bearer <token> pour toutes les requêtes protégées.

    ❌ Résultat : Toujours 403 Forbidden sur tous les endpoints testés.

🗨️ 5. Conseils et constats

    Vérification de l’URL et du mapping dans les contrôleurs.

    Lecture des messages d’erreur dans la console.

    Le problème ne vient pas du pom.xml ni des DTO/mappers, mais sans doute d’un détail dans la configuration ou le mapping.

🎯 Bilan

    🔄 Beaucoup de corrections appliquées, mais le 403 Forbidden persiste sur tous les endpoints malgré un JWT valide.

    🆘 Prochaine étape : Continuer à chercher la cause du blocage (vérifier le mapping réel, la config de sécurité, la console Spring, etc.).


## Alors vu mon problème de 403 pour mes endpoints on va tout remettre à plat

Voici mon analyse du projet en l'état actuel:
---

## Respect des bonnes pratiques

**Points positifs :**
- **Architecture claire en couches** : J’utilise bien la séparation entre mes entités (`model`), mes DTO, mes repositories, mes services, mes mappers et mes controllers. C’est la base d’une bonne architecture en Spring Boot.
- **Sécurité** : J’ai intégré Spring Security avec un filtre JWT pour sécuriser mes endpoints, ce qui est une bonne pratique moderne.
- **Utilisation des DTO** : Je n’expose pas directement mes entités JPA, mais j’utilise des DTO pour échanger avec le frontend, ce qui protège mes données et évite les fuites d’informations sensibles.
- **Configuration propre** : Ma configuration de base de données est claire et adaptée à un environnement de développement avec MariaDB/MySQL.
- **Gestion des dépendances** : Mon `pom.xml` est bien organisé, avec les dépendances nécessaires pour Spring Boot, JPA, Security, JWT, etc.
- **Utilisation de Postman** : Je teste mes endpoints avec Postman, ce qui est une bonne pratique pour vérifier le fonctionnement de mon API.

**Points à améliorer :**
- **Clé secrète JWT** : Pour la production, je devrai utiliser une clé secrète plus complexe et ne pas la laisser en dur dans mon code.
- **Gestion des mots de passe** : Mes mots de passe sont stockés en clair. Il est recommandé de les chiffrer (par exemple avec BCrypt) avant de les sauvegarder en base.
- **Validation des données** : Je pourrais ajouter de la validation sur mes DTO (avec des annotations comme `@NotNull`, `@Email`, etc.) pour sécuriser les entrées utilisateur.
- **Gestion des erreurs** : Pour l’instant, les erreurs sont retournées sous forme d’exception brute. Il est conseillé de gérer les erreurs avec des réponses plus claires pour le frontend (ex : codes HTTP, messages personnalisés).

---

## Architecture de mon projet

Mon projet suit une architecture **3-tiers** classique, très utilisée en Spring Boot :

| Couche                   | Rôle principal                                                                 |
|--------------------------|-------------------------------------------------------------------------------|
| **Présentation**         | Mes `controllers` (ex : `UtilisateurController`) reçoivent les requêtes HTTP. |
| **Logique métier**       | Mes `services` (ex : `UtilisateurService`) contiennent la logique métier.     |
| **Accès aux données**    | Mes `repositories` (ex : `UtilisateurRepository`) accèdent à la base de données.|

Autres éléments :
- **DTO et Mappers** : Mes DTO servent à transporter les données, mes Mappers à convertir entre entités et DTO.
- **Sécurité** : Ma sécurité est gérée par un filtre JWT et une configuration Spring Security.
- **Configuration** : Les propriétés de la base de données et de Spring Boot sont dans `application.properties`.

### Schéma simplifié de mon architecture

```
[Frontend/Postman]
        |
     (HTTP)
        |
[Controller]  [DTO]  [Mapper]  [Service]  [Repository]  [Base de données]
        |
   [Sécurité JWT]
```

Je peux faire évoluer cette architecture plus tard (modularisation, microservices, etc.), mais pour un projet CRUD REST, c’est déjà très bien.

---

## Conclusion

Mon projet respecte les bonnes pratiques de base pour une application Spring Boot moderne et structurée. 

J’ai une séparation claire des responsabilités, j’utilise des outils adaptés et j’ai déjà intégré la sécurité. 

Pour aller plus loin, je pense à la gestion des mots de passe, à la validation des entrées et à une meilleure gestion des erreurs, mais je suis sur la bonne voie !


## Shéma hiérarchie du projet (actuelle)

GestionnaireFormation/
│
├── pom.xml
│     → Mon fichier de configuration Maven : il décrit les dépendances, la version de Java, les plugins, etc.
│
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── emi/
│                   └── GestionnaireFormation/
│                       │
│                       ├── GestionnaireFormationApplication.java
│                       │     → Le point d’entrée de mon application Spring Boot. C’est ici que je démarre mon appli.
│                       │
│                       ├── controller/
│                       │     ├── UtilisateurController.java
│                       │     │     → Je gère les endpoints REST pour les utilisateurs (CRUD, rôles...).
│                       │     ├── RoleController.java
│                       │     │     → Je gère les endpoints REST pour les rôles.
│                       │     ├── FormationController.java
│                       │     │     → Je gère les endpoints REST pour les formations.
│                       │     ├── CentreController.java
│                       │     │     → Je gère les endpoints REST pour les centres de formation.
│                       │     ├── ModuleController.java
│                       │     │     → Je gère les endpoints REST pour les modules de formation.
│                       │     ├── SequenceController.java
│                       │     │     → Je gère les endpoints REST pour les séquences pédagogiques.
│                       │     └── AuthController.java
│                       │           → Je gère l’authentification (login) et la génération du token JWT.
│                       │
│                       ├── dto/
│                       │     ├── UtilisateurDto.java
│                       │     │     → Je transporte les infos d’un utilisateur sans exposer l’entité JPA.
│                       │     ├── RoleDto.java
│                       │     │     → Je transporte le libellé d’un rôle.
│                       │     ├── FormationDto.java
│                       │     │     → Je transporte les infos d’une formation.
│                       │     ├── CentreDto.java
│                       │     │     → Je transporte les infos d’un centre de formation.
│                       │     ├── ModuleDto.java
│                       │     │     → Je transporte les infos d’un module de formation.
│                       │     └── SequenceDto.java
│                       │           → Je transporte les infos d’une séquence pédagogique.
│                       │
│                       ├── mapper/
│                       │     ├── UtilisateurMapper.java
│                       │     │     → Je convertis entre Utilisateur et UtilisateurDto.
│                       │     ├── RoleMapper.java
│                       │     │     → Je convertis entre Role et RoleDto.
│                       │     ├── FormationMapper.java
│                       │     │     → Je convertis entre Formation et FormationDto.
│                       │     ├── CentreMapper.java
│                       │     │     → Je convertis entre Centre et CentreDto.
│                       │     ├── ModuleMapper.java
│                       │     │     → Je convertis entre Module et ModuleDto.
│                       │     └── SequenceMapper.java
│                       │           → Je convertis entre Sequence et SequenceDto.
│                       │
│                       ├── model/
│                       │     ├── Utilisateur.java
│                       │     │     → Mon entité JPA pour les utilisateurs.
│                       │     ├── Role.java
│                       │     │     → Mon entité JPA pour les rôles.
│                       │     ├── Formation.java
│                       │     │     → Mon entité JPA pour les formations.
│                       │     ├── Centre.java
│                       │     │     → Mon entité JPA pour les centres de formation.
│                       │     ├── Module.java
│                       │     │     → Mon entité JPA pour les modules de formation.
│                       │     └── Sequence.java
│                       │           → Mon entité JPA pour les séquences pédagogiques.
│                       │
│                       ├── repository/
│                       │     ├── UtilisateurRepository.java
│                       │     │     → Je gère l’accès à la base de données pour les utilisateurs.
│                       │     ├── RoleRepository.java
│                       │     │     → Je gère l’accès à la base de données pour les rôles.
│                       │     ├── FormationRepository.java
│                       │     │     → Je gère l’accès à la base de données pour les formations.
│                       │     ├── CentreRepository.java
│                       │     │     → Je gère l’accès à la base de données pour les centres.
│                       │     ├── ModuleRepository.java
│                       │     │     → Je gère l’accès à la base de données pour les modules.
│                       │     └── SequenceRepository.java
│                       │           → Je gère l’accès à la base de données pour les séquences.
│                       │
│                       ├── service/
│                       │     ├── UtilisateurService.java
│                       │     │     → Je contiens la logique métier pour les utilisateurs.
│                       │     ├── RoleService.java
│                       │     │     → Je contiens la logique métier pour les rôles.
│                       │     ├── FormationService.java
│                       │     │     → Je contiens la logique métier pour les formations.
│                       │     ├── CentreService.java
│                       │     │     → Je contiens la logique métier pour les centres.
│                       │     ├── ModuleService.java
│                       │     │     → Je contiens la logique métier pour les modules.
│                       │     ├── SequenceService.java
│                       │     │     → Je contiens la logique métier pour les séquences.
│                       │     └── JwtUtil.java
│                       │           → Je gère la création et la validation des tokens JWT.
│                       │
│                       └── security/
│                             ├── SecurityConfigJwt.java
│                             │     → Je configure la sécurité de mon application (routes protégées, filtre JWT...).
│                             └── JwtAuthenticationFilter.java
│                                   → Je vérifie les tokens JWT sur chaque requête et j’authentifie l’utilisateur.
│
└── src/
    └── main/
        └── resources/
            ├── application.properties
            │     → Je contiens la configuration de mon application (base de données, port, etc.).
            └── ... (autres fichiers de configuration éventuels)
