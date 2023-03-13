# Jeu de pendu Client-Serveur

Le projet -jeu de pendu- consiste à développer le fameux jeu du pendu classique qui consiste à initier une partie pour tenter de trouver un mot caché généré d’une façon aléatoire au bout d’un certain nombre de tentatives (dix tentatives maximum), en comptant le score obtenu pour chaque partie. Le score reflète la rapidité du joueur à retrouver le mot caché. Après avoir consommé toutes les tentatives sans que le joueur puisse retrouver le mot caché, ce joueur est considéré comme perdant (partie perdue)

## :pushpin: Développement: 
Le développement du jeu doit prendre en considération l’ensemble des consignes :
•	On réalisera une application distribuée (Client/Serveur), et donc on doit prévoir le développement de deux programmes : un 1èr programme coté Serveur et un 2ème programme coté Client.  

•	On utilisera les techniques de programmation multithreading afin de permettre au serveur d’accepter de servir plusieurs clients simultanément : plusieurs clients peuvent initier des parties de jeu sur le même serveur en même temps.

•	Le serveur évitera toute sorte du blocage qui pourra être dû à l’utilisation de fonctions bloquantes comme l’attente de connexion ou la réception de messages.

•	Le serveur est toujours prêt et en écoute de nouvelles connexions pour servir un nombre de client pourront atteindre 10 clients.

•	Le client est celui qui décide d’initier une nouvelle partie.

•	Le serveur dispose d’un dictionnaire de mot à proposer auprès de ces clients, le dictionnaire de mot peut être sous forme d’un fichier ou même juste sous forme d’un tableau de mots.

•	Le serveur sélectionne d’une façon aléatoire le mot à proposer pour chacune des parties.

•	La proposition d’un mot (par le serveur) à dévoiler se fait tout en donnant le nombre total de caractères cachés représentés par des traits tout en dévoilant initialement le premier et le dernier caractère


## :pushpin: Utilisateur: 
L’utilisateur du coté client doit saisir un seul caractère pour chaque tentative et il devra recevoir immédiatement la confirmation en relation avec son choix :
o	Si le caractère choisi appartient effectivement au mot à deviner, le serveur affiche le caractère qui vient d’être choisi dans sa position exacte par rapport aux caractères constitutifs du mot caché.
o	Une tentative réussie n’est pas considérée comme étant consommée et l’utilisateur garde le nombre de tentatives restantes qui possède avant de jouer une tentative réussie.
o	 Si le caractère choisi n’appartient pas au mot caché, alors la tentative est considérée comme étant consommée.
o	Si l’utilisateur choisit un caractère qui a été déjà choisi avant, alors le serveur lui rappelle qu’il a déjà choisi le caractère et ne prends pas en considération de cette tentative, ainsi on donnera une sorte de tolérance à l’erreur au profit de l’utilisateur sans lui diminuer le nombre de tentatives restantes.
o	Un caractère choisit et qui se trouve dans plusieurs endroits (positions par rapport aux caractères constitutifs du mot caché) dans un mot, devra être dévoilé dans toutes ces positions lors d’une tentative réussie.
•	Le jeu se termine après avoir dévoilé la totalité des caractères constitutifs du mot caché avec succès (le joueur est gagnant) tout en donnant pour chaque joueur son score (le nombre de tentatives consommées). Le jeu se termine aussi après  avoir consommé toutes les tentatives sans avoir réussi à dévoiler le mot caché (le joueur est pendu/perdu).
•	Il est recommandé de jouer à ce jeu sur papier avec vos proches avant même de commencer à développer le jeu afin de mieux assimiler tous les processus qui devront être programmés.
•	Enfin, Amusez-vous bien aussi bien en jouant qu’en développant ce jeu, faites en sorte que le développement soit aussi bien amusant pour en faire la meilleure motivation pour développer un travail de qualité. Bonne courage !!!

## :pushpin: Exemple : 
Le mot MAROC sera présenté de la façon suivante : M - - - C
