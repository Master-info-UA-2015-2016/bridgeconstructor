##############################################################
#	BRIDGE-CONSTRUCTOR	- README			  		#
#		par	DAVID Florian				  		#
#		et		FOURMOND Jérôme		  		#
##############################################################


Programme d'Intelligence Artificielle pour choisir
	le type, les matériaux, et le prix pour la construction d'un
	pont en fonction de l'Environnement

Testé sous Windows (à partir de Windows 7 à 10)

Testé sous Linux (sur la 14.04)

Sous le JDK 8 d'Oracle

####################	L'Installation	########################
Java 1.8 doit être installé sur le systême.

Sous Windows :
	- Executer le script launch.bat
	- Ou ouvrez l'archive bridge-constructor.jar avec Java
	(double clic si l'ouverture par défaut est configuree)

Sous Linux :
	- Donner les droits au script bridge-constructor.sh
	- Executer le script bridge-constructor.sh
	-> Ultérieurement il n'est pas nécessaire de reproduire la
dernière étape mais seulement d'exectuer bridge-constructor.jar


###################	La Présentation	  ######################
	L'application est entierement utilisable avec l'interface
 graphique, mais si on souhaite avoir des traces, abrégées
 ou non, il faut la lancer avec le script fourni ou depuis un terminal.

Fenètre Ask :
	Dans cette interface, l'utilisateur sélectionne et saisie les
données de l'Environnement correspondant.
	Il a également accès aux menus :
		- Fichier
			-> Quitter (pour quitter l'application)
		- Afficher
			-> Base de Règles (pour afficher la base de règles)
			-> Traces Abrégées (pour un affichage concis en console)
		- Arrière et Mixte
			-> pour ouvrir l'interface Chaînage Arrière

Chaînage Arrière :
	Dans cette interface, l'utilisateur sélectionne le type de
chaînage arrière (simple ou mixte) qu'il souhaite ainsi que le but souhaité.

 
################		L'Implémentation	###################

	Les traces de l'application sont affichées (complètes ou 
concises) dans la console.

	Lors de l'ajout d'un fait, si ce dernier a pour valeur faux et 
est déjà présent, il n'est pas ajouté à la base.

	Dans le cas d'une valeur, la maximale est toujours conservée.

################	Autre	##################################

	Les Méta-Règles n'ont pas été implémentées, notre algorithme
étant généraliste.

	Aucun paquet de règle n'a été mis en place.