Assia TRARI et Lina RADI

TP7

#   Gestionnaire de travaux

Ce dépôt correspond au TP de PDS
« [mshell](http://www.fil.univ-lille1.fr/~hym/e/pds/tp/tdjobs.html) ».

##Problèmes

Normalement nos commandes do_ fonctionnent sauf do_kill et do_pipe car si on fait par exemple kill %2, ça ferme le mshell.
Pour do_pipe, nous avons esseyer de l'implementer mais la compilation génère beaucoup de warning donc on a preferait le mettre en commentaire.

Nous n'avons pas su faire des commande sur un autres shell qui agissent sur le mshell
##stopper un jobs
doit suspendre xeyes

- MSHELL xeyes
- MSHELL ctrl-Z

##faire un exit avec sans jobs
doit fermer le mshell, on retourne alors dans le shell normale
- MSHELL
- MSHELL ctrl-Z

##faire un exit avec jobs non stoppé

doit fermer le mshell, mais xclock et xeyes fonctionne encore en arriere plan

- MSHELL xclock &
- MSHELL xeyes &
- exit

##faire un exit alors qu'il y a un job stoppé

ne doit pas fermer le mshell, et affiche un message qui dit qu'il y a des jobs stoppés

- MSHELL xclock &
- MSHELL xeyes
- MSHELL ctrl-Z
- exit

##afficher la liste des jobs

doit afficher deux jobs

- MSHELL xclock &
- MSHELL xeyes
- MSHELL jobs

##mettre un jobs en premier plan
on doit perdre la main dans le mshell 

- MSHELL xclock &
- MSHELL fg %1


