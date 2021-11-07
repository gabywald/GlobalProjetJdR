#!/usr/bin/python3

__author__ = "Gabriel Chandesris"
__copyright__ = "CC Gabriel Chandesris (2021)"
__credits__ = ""
__licence__ = "GNU GENERAL PUBLIC LICENSE v3"
__version__ = "1.0.0"
__maintainer__ = "Gabriel Chandesris"
__email__ = "gabywald[at]laposte.net"
__contact__ = "gabywald[at]laposte.net"
__status__ = "Development"


from Personnae import Personnae

## import BiographicDataLoadAndSelect
from BiographicDataLoadAndSelect import BiographicDataLoad
from BiographicDataLoadAndSelect import selectRandomBiographic
from BiographicDataLoadAndSelect import selectBiographicElements

biotables = BiographicDataLoad.loadBiographicsTables()
jobs = BiographicDataLoad.loadJobsToSkills()
skills = BiographicDataLoad.loadSkills()

numberOfResults = 10

res = selectBiographicElements( numberOfResults )

for elt in res : 
    print( "%s " %( elt.contents[1] ) )

## Créer personnae + comparer avec script initial en Perl
## Etape 1: Imaginer un concept
## Etape 2: Scores de caractéristiques
## ## Caractéristiques	Score 	Dérivée
## ## Apparence			3D6 	Prestance		= APP x5%
## ## Constitution		3D6 	Endurance		= CON x5%
## ## Dextérité			3D6 	Agilité			= DEX x5%
## ## Force				3D6 	Puissance		= FOR x5%
## ## Taille			2D6+6 	Corpulence		= TAI x5%
## ## Éducation			3D6+6 	Connaissance	= EDU x5%
## ## Intelligence		2D6+6 	Intuition		= INT x5%
## ## Pouvoir			3D6 	Volonté			= POU x5%
## NOTE XXX 'randomizer' avec tirage de dés
## Etape 3: Autres valeurs
## ## Aplomb				= 0
## ## Santé Mentale (SAN)	= POU x5%
## ## Points de Vie		= (CON + TAI) / 2, arrondi à l'entier supérieur
## ## Seuil de Blessure	= Points de Vie / 2, arrondi à l'entier inférieur
## ## Points de Magie		= POU
## ## Impact				= voir la table ci-dessous
## ## ## ## FOR+TAI  	Impact
## ## ## ## 02 à 12  	  -4
## ## ## ## 13 à 16  	  -2
## ## ## ## 17 à 24  	  0
## ## ## ## 25 à 32  	  +2
## ## ## ## 33 à 40  	  +4
## ## ## Competences Métier : EDU*20 (%)
## countJobTalent	= 0;
## countJobMaxims	= $EDU*20;
## ## ## Compétences intérêt perso : INT*10 (%)
## countPersoTalent	= 0;
## countPersoMaxims	= $INT*10;
## Préparation Étape 4 : générer biographie
## ## ## quelques variables pour retenir des éléments supplémentaires liés à la biographie...
## ... preparing and function for biographic details
## Etape 4: Choisir une occupation : choix métier + répartir EDU*20 (et au moins une à 60%)
## Etape 5: Les Compétences d'intérêts personnels (INT*10% ailleurs) => indiquer valeur
## Etape 6: Finitions
## ## ## ...

