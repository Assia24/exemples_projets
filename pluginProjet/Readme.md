# Projet Plugin

**Lina RADI, Assia TRARI**

### Le projet

L'objectif de ce projet est de manipuler le design pattern Observer en mettant en place progressivement une application qui s’adapte dynamiquement en fonction de “plugins” installés dans un répertoire.

### Etat
Nous avons fait l'exercice 4, et commencer l'exercice 5. Pour l'exercice 4, les fichiers .class doivent être dans un dossier **doss** à la racine du projet. Notre interface graphique detecte les nouveaux plugins ajoutés ou supprimés dans un dossier **dossPlugin** à la racine du projet, mais nous n'avons pas implémenté l'application d'effet lorsqu'on selectionne un plugin.

### howto

**Récuperation du dépot**
*à la racine du projet*

	`$git pull`

**génération du projet**

	`$mvn package`

**execution exercice 4**

	`java -classpath target/classes:dossPlugin fil.coo.SimulationPlugin &`

**execution exercice 5**
	`java -classpath target/classes:dossPlugin fil.coo.MainWithInterfaceGraphique &`
