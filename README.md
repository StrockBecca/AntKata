# ANT COLONY

## Description
Le but de ce kata est de simuler le comportement d'une colonie de fourmis. L'interface graphique sera faite à l'aide de Swing.
Le cahier des charges est comme suit :  
- Une fourmi a les comportements suivants :  
  - elle se déplace de façon aléatoire (action scatter) dans les cases adjacentes tant qu'elle n'a pas trouvé de nourriture ou qu'elle ne sait pas où se trouve la nourriture  
  - si la fourmi sait où se trouve la nourriture, elle se dirige vers celle-ci (action fetch)  
  - une fois que la fourmi a collecté la nourriture, elle retourne à la colonie (action collect). Une fois la colonie atteinte, le compteur de nourriture de la colonie est incrémenté  
  - une fourmi peut parler (action talk) aux autres fourmis situées sur la même case qu'elle et leur faire partager l'emplacement d'un point de nourriture si celle-ci sont en recherche  
- Les fourmis commencent leurs déplacements depuis la colonie, qui ne bouge pas  
- La nourriture a une durée de vie limitée (à vous de voir comment gérer cette contrainte), une fois cette limite dépassée, la nourriture disparait de l'interface et les fourmis ne peuvent plus collecter de nourriture sur ce point  
- L'utilisateur doit pouvoir réaliser depuis l'interface les actions suivantes:  
  - il doit pouvoir ajouter des points de nourriture en cliquant sur l'interface  
  - il doit pouvoir reset la position des fourmis, effacer les nourritures présentes et remettre le compteur de nourriture à 0 en utilisant le bouton Reset de l'interface  


## Mise en place
- Forker le projet
- Importer le projet forké dans IntelliJ Idea : File > New > Project from Version Control > Git > Rentrer l'url du dépôt
- Clic droit sur le dossier AntKata > Mark Directory as Root Source
- File > Project Structure > renseigner votre jdk et votre fichier de sortie <VOTRE_WORKING_DIR/out>
- Run > Edit Configuration > ajouter une Application > Renseigner votre jdk si ce n'est pas déjà fait
- Pour ajouter JUnit, la façon la plus simple est la suivante : allez dans le fichier ant > AntTest > alt-Enter sur un @Test rouge > add JUnit to classpath
- Implémenter les classes...
- Jouer les tests
- Pousser votre pull request sur le dépôt, mettez votre nom et prénom dans le nom de la branche
