# Projet 1 : Donjon

**Lina RADI, Assia TRARI**

### Le projet

L'objectif de ce projet et d'implémenter un le jeu du donjon. Ce jeu est en interaction avec l'utilisateur.Il y a un seul joueur. Le donjon est représenté par une carte comportant plusieurs pieces relié entre elles. le but du jeu et de trouver le chemin qui mêne à la sortie du Donjon. Dans les pièces, le joueurs peut trouver des objets ou des monstres.
Arrivé dans une pièce, le joueurs à le choix parmis plusieurs actions :
- Aller dans une prochaine pièce (en fonction des différentes direction disponible dans la pièce courante et s'il n'y a pas de monstres ou plus de monstre vivant dans la pièce courante)
- Utiliser un objet de la pièce (s'il y en a)
- Regarder la pièce (et avoir donc une exception)
- Attaquer un monstre (si il y en a)

*Note* : un schema de ma carte utilisée pour cette version et dans le dépot.

### howto

**Récuperation du dépot**
*à la racine du projet*

	`$git pull`

**génération de la documentation**

	`$mvn javadoc:javadoc`

*Note* : la documentation sera consultable dans le dossier doc

**génération du projet**

	'$mvn package'

**execution (jar executable)**

	`$java -jar target/Donjon-1.0-SNAPSHOT.jar`

**éléments de code**

Nous avons essayé d'ouvrir le projet à l'extention le plus possible. Ainsi, nous avons utiliser une interface gameMap pour typer les cartes du jeu puis nous avons créer une BasicGameMap pour notre jeu. Notre programme ne dépends que de BasicGameMap, il sera donc facile d'utiliser d'autres nouvelles cartes.
Pareil pour les objets et les actions. Chaque cartes peut fournir sa propre liste d'actions et d'items.

Nous avons utiliser la methode générique chose de ListChoser pour tout les choix de l'utilisateurs.




