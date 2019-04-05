# Pokemon-Light

Bonjour lecteur et bienvenue dans le répertoire GitHub de mon projet de programmation mobile sur **Android Studio** !

Dans ce répertoire tu trouveras tout mon travail effectué sur cet outil pour concevoir une application mobile sous Android qui liste différents Pokémon (151 sur la liste). L'application comporte trois activités principales :

- La page de lancement
- La liste des Pokémon
- La page de description pour chaque Pokémon

Voici des photos des trois activités respectives :

![img](https://image.noelshack.com/fichiers/2019/14/5/1554500769-laucnher.jpg)  ![img](https://image.noelshack.com/fichiers/2019/14/5/1554500769-list.jpg)  ![img](https://image.noelshack.com/fichiers/2019/14/5/1554500769-descriptionitem.jpg)

## Détails sur les différentes activités


- La page de lancement :

La page de lancement est une activité qui se lance au démarrage de l'application. Elle comporte une image et deux lignes de textes. Il faut cliquer sur l'image pour lancer la liset de Pokémon.

- La liste des Pokémon :

La liste de Pokémon est un RecyclerView issu d'une API prétéélchargée via **Internet** et qui a la capacité d'**être stockée en cache** par la suite.

- La page de description pour chaque Pokémon :

La page de description compote une photo (normalement du Pokémon), son nom et une notification avec son nom également qui apparait dès qu'on affiche cette page et qui disaparait après quelques secondes. Pour revenir sur la liste il suffit d'utiliser le bouton retour d'Android.

## Récapitalif des activités

SmartyPants converts ASCII punctuation characters into "smart" typographic punctuation HTML entities. For example:

|Activité          |Classe Java        |
|------------------|-------------------|
|Page de lancement |LaunchActivity     |
|Liste de Pokémon  |MainActivity       |
|Description       |DescripActivity    |



## L'architecture

![img](https://image.noelshack.com/fichiers/2019/14/5/1554500769-rep.jpg)

