# GlobalProjetJdR

Outil(s) pour du JdR / Jeu de Rôle

Gabriel "GabyWald" Chandesris
Licence GNU GPL (v3?)

## Ressources initiales

Code Java pour une application avec des générateurs et ressources documentaires (GURPS, SimulacreS, encyclopédie CyberAge...), documents LaTeX, un générateur de cartes de tarot... 

Pas mal de choses qui datent du début des années 2010, du Java Swing, des images, des ressources, des fichiers de configuration, des générateurs, du texte brut / TeX / LaTeX / ... Pas mal d'idées réutilisables !

Une partie des ressources vient de Casus Belli première itération (années 1990's), sinon facilement trouvables par ailleurs (retrait possible sur simple demande). 

Dans les ressources : 
  * La campagne du "Réseau Divin" : resources > documentation > rolePlayingGame > divnet ; (resources/documentation/rolePlayingGame/divnet)
  * L'encyclopédie CyberAge : resources > documentation > rolePlayingGame > SimulacreS > cyberage > encyclopaedia ; (resources/documentation/rolePlayingGame/SimulacreS/cyberAge)
  * Quelques articles Casus Belli : resources > documentation > rolePlayingGame > background > casusbelli ; (resources/documentation/rolePlayingGame/background/casusbelli)
  * Documentation : 
    * Tarot : pour générer des cartes de tarot (utile pour certains jeux : tirages aléatoires, inspiration de scénarios, génération de personnages...) ; 
    * IChing : idem (utilisé pour "clan of two") ; 
    * Resources pour fiches de personnages GURPS, Basic RPG, SimulacreS... ; 
    * Resources de background (?) et idées de scénarios ; 
    * Conversions entre systèmes de jeu ; 
    * "News Generator", pour générer des unes de journaux, façon CyperPunk fax) ; 
  * ... 

## Autres inspirations et projets sur ces bases

Idée(s) de logiciel(s) utilitaire(s) pour du JdR / Jeu de Rôle : 
  * GTC : Gestionnaire de Table de Convention
    * Gestion des tables de jeux (MJ / Meneur de Jeu) + (Jeu et description) + (nombre de joueurs) ; 
    * Gestion des inscriptions (système de messagerie / middleware ou inscription manuelle ?) : utilisation "Apache Kafka" ?! ; 
    * ... 
  * Génération de personnages (à préciser)
  * Génération cartographique (génération procédurale)
  * Génération de scénarios "sur-le-pouce"
  
## Code existant (Java, JavaSwing, Ant ; 2010-2012 puis reprise vers 2020 et 2026)

"Simulacrum : Role-Playing-Game Personnae Build Assist"
  * Outil de Jeu de Rôle (JdR sur table), en anglais : TTRPG ("TableTop RolePlayingGame")
  * Idée de base était de gérer une / des fiche(s) de personnage (visuellement et stockage et génration PDF) ; 
  * Onglets : 
    * Welcome ; 
    * General Informations (pour personnage) ; 
    * Biography (générateur de biographie, reprise de celle de "CyberAge 28 minutes dans le futur", autres possibles) ; 
    * Scenario (génération à partir de tables pré-définies) ; 
    * RétroFutur (collection d'images, bannières, logos..) ; 
    * Engines Failures (Pannes et erreurs "Barbarisme Scientifique") ; 
    * GURPS (fiche de perso interactive système GURPS) ; 
    * BasiCs (fiche de perso interactive système BasiCs) ; 
    * SimulacreS (fiche de perso interactive système SimulacreS) ; 
    * Skills (sélection selon liste prédéfinie, selon système de JdR) ; 
    * Weapons (Listes d'armes selon système de JdR et proximité d'usage) ; 
    * Equipment (Protection, Magique, Hardware, Software... et selon système de JdR) ; 
    * Special Powers (Pouvoirs Psy, Pouvoirs de la Force...) ; 
    * CyberAge (Generic / BasiCs, conversion depuis SimulacreS) ; 
    
Compilation testée sur Ubuntu 24.04 avec Java 1.8.0_422 avec Ant [Apache Ant(TM) version 1.10.14 compiled on September 25 2023)]

## Idée "DM Digital ToolBox" / "Boite à Outils Numérique du MJ"

  * Outil préparation de partie / en cours de partie
    * => IHM avec Onglets (Tabs) et appels de fonctions ; (graphique ou ligne de commande) ; 
    * Inspiration "à la volée" (évènement, PNJ, lieu, ...) ; 
    * Tâches / Quêtes en cours ; 
    * Ajout de données (étapes, scénarios, campagnes, PJ, PNJ, documents de jeu...) ; 
    * Gestion PBtA (?) ou similaire (actions pré-définies ou catégories) ; 
    * Diagramme du scénario / Diagramme campagne en cours ; 

Voir notamment [Boîte à outils numériques du MJ](https://github.com/gabywald/BoiteAOutilsNumeriqueDuMJ)
