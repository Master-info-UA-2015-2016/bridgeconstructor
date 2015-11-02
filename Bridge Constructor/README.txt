#####################################################################
#	BRIDGE-CONSTRUCTOR	- README							  		#
#		par	DAVID Florian									  		#
#		et		FOURMOND Jérôme								  		#
#####################################################################


Programme d'Intelligence Artificielle pour choisir
	le type, les matériaux, et le prix pour la construction d'un
	pont en fonction de l'Environnement


#####################	L'Installation	############################

Sous Windows :
	- Executer le script bridge-constructor.bat
	- Executer le fichier bridge-constructor.jar

Sous Linux :
	- Donner les droits au script bridge-constructor.sh
	- Executer le script bridge-constructor.sh
	-> Ultérieurement il n'est pas nécessaire de reproduire la
dernière étape mais seulement d'exectuer bridge-constructor.jar


#####################	La Présentation	  ###########################

Interface Ask :
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
chaînage qu'il souhaite ainsi que le but souhaité.

 
#####################	L'Implémentation	#########################

	Les traces de l'application sont affichées (complètes ou 
concises) dans la console.