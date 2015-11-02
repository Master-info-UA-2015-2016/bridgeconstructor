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
	L'application contient un moteur (le système expert) de chainage avant, arrière et mixte. Le package Java "bridge-constructor" est chargé de créer les faits et les règles pour les ajouter dans le système expert et crée également l'interface de l'application, afin qu'ils soient adaptés au cas présent.

	Les traces de l'application sont affichées (complètes ou 
concises) dans la console.

	Lors de l'ajout d'un fait, si ce dernier a pour valeur faux et 
est déjà présent, il n'est pas ajouté à la base.

	Dans le cas d'une valeur, la maximale est toujours conservée.

################	Autre	##################################

	Les Méta-Règles n'ont pas été implémentées, notre algorithme
étant généraliste.

	Nous n'avons pas ajouté d'explication sur chaque règle car nous nous n'avons pas trouvé de documentation précise sur les conditions et valeurs pour la construction de ponts. Nous avons donc crées des règles à partir de nos connaissances, de recherche sur internet et de principes logiques avec des valeurs approximatives.

	Les paquets de règles n'ont pas été mis en place
	
	Pour la gestion de la cohérence, nous avons décidé d'agir de manière restrictive, si une règle interdit un fait (NON mot), elle est prioritaire, si elle autorise un mot, elle est peut être annulée par une règle l'interdisant.
Pour les valeurs, nos variables étant des minimums (hauteur, largeur et longueur minimum), seule la plus grande valeur est conservée. Cela correspond au sujet des ponts, mais il faudrait adapter l'algorithme si un autre cas utilise des valeurs maximales (il faudrait ajouter un attribut dans les règles du fichier xml de règles).
