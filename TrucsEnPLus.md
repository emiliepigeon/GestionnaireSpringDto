# git

Fichier .gitignore pour cacher application.properties

Ajoute cette ligne à la racine de ton projet dans le fichier .gitignore :

________________________________________________________________________

# Ignorer le fichier de configuration Spring Boot
src/main/resources/application.properties

Si tu utilises plusieurs fichiers de configuration (par exemple pour différents profils : application-dev.properties, etc.), tu peux ajouter :

text
src/main/resources/application-*.properties

Ainsi, tous les fichiers de configuration Spring Boot seront ignorés par Git et ne seront pas poussés sur GitHub ou un autre dépôt distant.

Remarque importante :
Si tu as déjà commité ce fichier, il faudra le retirer de l’index Git avec la commande suivante avant que .gitignore ne soit pris en compte :

bash
git rm --cached src/main/resources/application.properties

Puis fais un commit pour enregistrer ce changement.

Résumé :

    Commente chaque ligne de ton fichier de configuration pour plus de clarté.

    Ajoute src/main/resources/application.properties dans .gitignore pour protéger tes identifiants et mots de passe.

____________________________________________________________________________
# Pour lancer mon serveur Spring boot
Pour régénérer votre fichier pom.xml avec les dépendances correctes et résoudre les erreurs, vous pouvez utiliser les commandes Maven suivantes dans votre terminal ou invite de commandes. Voici les étapes à suivre :

    Nettoyer le Projet :
        Utilisez la commande suivante pour nettoyer votre projet et supprimer les fichiers générés précédemment :

    mvn clean

Mettre à Jour les Dépendances :

    Pour forcer Maven à mettre à jour les dépendances, vous pouvez utiliser :

    mvn clean install -U

    L'option -U force la mise à jour des snapshots et des versions des dépendances.

Vérifier la Configuration :

    Vous pouvez vérifier la configuration de votre projet avec :

    mvn validate

Exécuter l'Application :

    Une fois que tout est configuré correctement, vous pouvez exécuter votre application Spring Boot avec :

        mvn spring-boot:run

Ces commandes devraient vous aider à régénérer votre pom.xml et à résoudre les problèmes de configuration. Assurez-vous que votre fichier pom.xml est correctement configuré comme indiqué dans ma réponse précédente avant d'exécuter ces commandes.
_______________________________________________________________________
# Dans mon navigateur pour visualiser le retour
http://localhost:8080
#
http://localhost:8080/utilisateur

# test
http://localhost:8080/utilisateur/demo

____________________________________________________________________
 Fausses données requête SQl

 Table Module
 INSERT INTO module (nom, description, statut) VALUES
('Java Fondamentaux', 'Découverte de la programmation orientée objet avec Java', true),
('Web Frontend', 'HTML, CSS, JavaScript pour le développement web', true),
('Spring Boot', 'Développement d’API REST avec Spring Boot', true),
('Base de données', 'Introduction à SQL et à la modélisation', true),
('Déploiement', 'Mise en production et CI/CD', false);


 Table Sequence
 INSERT INTO sequence (libelle, description, ordre, statut, module_id) VALUES
('Variables et types', 'Premiers pas avec les variables Java', 1, true, 1),
('Boucles et conditions', 'Comprendre les structures de contrôle', 2, true, 1),
('Classes et objets', 'POO en Java', 3, true, 1),
('HTML de base', 'Structure d’une page web', 1, true, 2),
('CSS fondamental', 'Mettre en forme ses pages', 2, true, 2),
('JavaScript initiation', 'Dynamiser le web', 3, true, 2),
('Création d’un projet Spring Boot', 'Initialisation et configuration', 1, true, 3),
('Contrôleurs REST', 'Créer des endpoints REST', 2, true, 3),
('JPA et persistance', 'Connexion à la base de données', 3, true, 3),
('Modélisation SQL', 'Concevoir un schéma relationnel', 1, true, 4),
('Requêtes de base', 'SELECT, INSERT, UPDATE, DELETE', 2, true, 4),
('Déploiement sur serveur', 'Publier une application', 1, false, 5);


-----------------------------------------------------------------------------------------------

ICONS pour cutomiser mes README

En Markdown pour un README (notamment sur GitHub), je peux insérer des icônes (pictos) de plusieurs façons :

---

## 🌟 Les pictos que je peux utiliser dans un README

### 1. **Émojis standards Unicode**
C’est la méthode la plus simple et universelle.  
Je peux copier-coller n’importe quel émoji dans mon texte, il s’affichera partout (titres, listes, paragraphes).

**Exemples d’émojis utiles pour un README :**

- 🚀 (lancement, démarrage)
- 📦 (installation, package)
- 🛠️ (outils, configuration)
- 📝 (documentation)
- 📚 (ressources, lecture)
- 🔗 (liens)
- 🖥️ (ordinateur, code)
- 🧰 (boîte à outils)
- 💡 (astuce, idée)
- ⚠️ (attention)
- ✅ (ok, validé)
- ❌ (erreur)
- 🔒 (sécurité)
- 👤 (utilisateur)
- 🗂️ (organisation, fichiers)
- 📁 (dossier)
- 📄 (fichier)
- 🎯 (objectif)
- ✨ (nouveauté, fonctionnalité)
- 📊 (statistiques)
- 🕒 (temps)
- 🔥 (important, performant)
- 🧪 (test)
- 🐞 (bug)
- 🧑‍💻 (développeur)
- 🏁 (fin, objectif atteint)
- 🌐 (web)
- 📅 (date)
- 🎉 (succès, fête)
- 🤖 (automatisation)
- 🏗️ (construction, en cours)
- 🏆 (succès)
- 🔍 (recherche)
- 📌 (important)
- 🏠 (accueil)
- 🏢 (organisation)
- 📬 (contact)
- 🏷️ (étiquette, tag)
- 🛡️ (sécurité)
- 🏷️ (étiquette)
- 🧭 (navigation)

---

### 2. **Icônes avec images**
Je peux insérer des images (petites icônes .png ou .svg) dans mon README, mais il faut qu’elles soient hébergées quelque part (dans le projet ou en ligne) :

```markdown
![logo](https://exemple.com/mon-icone.png)
```
Mais ce n’est pas aussi universel ni rapide que les émojis.

---

### 3. **Icônes FontAwesome ou autres**
Sur GitHub, je ne peux pas utiliser directement FontAwesome ou d’autres bibliothèques d’icônes dans un README standard, sauf sur certains générateurs de documentation ou plateformes spécifiques[2].  
Donc, je privilégie les émojis pour la compatibilité maximale.

---

## 💡 Astuce
Pour trouver un émoji, j’utilise [emojipedia.org](https://emojipedia.org/) ou le clavier émoji de mon système (Win + . sous Windows, Cmd + Ctrl + Espace sous Mac).

---

**En résumé** :  
Je peux insérer tous les émojis que je veux dans mon README, dans les titres, listes, ou paragraphes, pour rendre la lecture plus agréable et visuelle[3][5][6][7].  
C’est simple, rapide, et compatible partout sur GitHub !

Smileys & émotions

😀 😃 😄 😁 😆 😅 😂 🤣 😊 😇 🙂 🙃 😉 😌 😍 🥰 😘 😗 😙 😚 😋 😛 😜 🤪 😝 🤑 🤗 🤭 🤫 🤔 🤐 🤨 😐 😑 😶 🙄 😏 😣 😥 😮 🤐 😯 😪 😫 😴 😌 😛 😜 😝 🤤 😒 😓 😔 😕 🙃 🥳 😎 🤓 🧐 😕 😟 😢 😭 😤 😠 😡 🤬 🤯 😳 🥺 😦 😧 😨 😰 😥 😢 😭 😱 😖 😣 😞 😓 😩 😫 🥱 😤 😡 😠 🤬 😈 👿 💀 ☠️ 👻 👽 🤖 🎃 😺 😸 😹 😻 😼 😽 🙀 😿 😾
Gestes & mains

👋 🤚 ✋ 🖐 🖖 👌 🤌 🤏 ✌️ 🤞 🤟 🤘 🤙 👈 👉 👆 🖕 👇 👍 👎 ✊ 👊 🤛 🤜 👏 🙌 👐 🤲 🤝 🙏
Personnes & corps

👶 🧒 👦 👧 🧑 👨 👩 🧔 👴 👵 🙍 🙎 🙅 🙆 💁 🙋 🙇 🤦 🤷 🧏 🙉 🙈 🙊
Animaux & nature

🐶 🐱 🐭 🐹 🐰 🦊 🐻 🐼 🐨 🐯 🦁 🐮 🐷 🐸 🐵 🦄 🐔 🦉 🦇 🐝 🐛 🦋 🐌 🐞 🐜 🦟 🦗 🐢 🐍 🦎 🐙 🦑 🦐 🦀 🐡 🐠 🐟 🐬 🐳 🐋 🦈 🐊 🦧 🐘 🦏 🦛 🐪 🐫 🦙 🦒 🦘 🦥 🦦 🦨 🦡 🐓 🦃 🦚 🦜 🦢 🦩 🕊️ 🐇 🦝 🦨 🦡 🦦 🦥
Nourriture & boissons

🍏 🍎 🍐 🍊 🍋 🍌 🍉 🍇 🍓 🫐 🍈 🍒 🍑 🥭 🍍 🥥 🥝 🍅 🥑 🍆 🥔 🥕 🌽 🌶️ 🥒 🥬 🥦 🧄 🧅 🍄 🥜 🌰 🍞 🥐 🥖 🥨 🥯 🥞 🧇 🧀 🍖 🍗 🥩 🥓 🍔 🍟 🍕 🌭 🥪 🌮 🌯 🥗 🥘 🥫 🍝 🍜 🍲 🍛 🍣 🍱 🍤 🍙 🍚 🍘 🍥 🥠 🥡 🍦 🍧 🍨 🍩 🍪 🎂 🍰 🧁 🍫 🍬 🍭 🍮 🍯 🍼 ☕ 🍵 🍶 🍺 🍻 🥂 🍷 🥃 🍸 🍹 🧉 🧃 🧊
Objets & symboles

⌚ 📱 📲 💻 🖥️ 🖨️ 🖱️ 🖲️ 🕹️ 🗜️ 💽 💾 💿 📀 🎥 🎬 📷 📸 📹 📺 📻 🎙️ 🎚️ 🎛️ ⏰ ⏱️ ⏲️ ⏳ ⌛ 🔋 🔌 💡 🔦 🕯️ 🪔 🧯 🛢️ 💸 💵 💴 💶 💷 💰 💳 🧾 💎 ⚖️ 🔧 🔨 ⚒️ 🛠️ ⛏️ 🔩 ⚙️ 🗜️ ⚗️ 🔬 🔭 📡 💉 💊 🚪 🛏️ 🛋️ 🚽 🚿 🛁 🪑 🧴 🧷 🧹 🧺 🧻 🧼 🧽 🪥 🧯
Transports & lieux

🚗 🚕 🚙 🚌 🚎 🏎️ 🚓 🚑 🚒 🚐 🛻 🚚 🚛 🚜 🦽 🦼 🛴 🚲 🛵 🏍️ 🚨 🚔 🚍 🚘 🚖 🚡 🚠 🚟 🚃 🚋 🚞 🚝 🚄 🚅 🚈 🚂 🚆 🚇 🚊 🚉 ✈️ 🛫 🛬 🛩️ 🛥️ 🚤 ⛵ 🛶 🚢 🚀 🛸 🛎️ 🏰 🏯 🏠 🏡 🏢 🏬 🏭 🏣 🏤 🏥 🏦 🏨 🏩 🏪 🏫 🏩 🕍 ⛪ 🕌 🛕 🕋 ⛩️ 🛤️ 🛣️ 🏞️ 🏜️ 🏝️ 🏖️ 🏕️ ⛺

Pour une liste complète et mise à jour, je peux consulter :

    Unicode Full Emoji List v16.0

    Emojipedia
