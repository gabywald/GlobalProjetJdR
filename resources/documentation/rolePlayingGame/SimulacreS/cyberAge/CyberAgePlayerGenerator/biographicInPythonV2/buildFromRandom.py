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

## numberOfResults = 10
## res = selectBiographicElements( numberOfResults )
## for elt in res : 
##     print( "%s " %( elt.contents[1] ) )

## Créer personnae + comparer avec script initial en Perl
personnaeToOuput = Personnae()
## Etape 1: Imaginer un concept
concept = None
while( (concept == None) or (concept == "") ):
    print("\t **** Concept ***** ")
    concept = str(input())
    concept = concept.strip()
    print("\t\t Concept: {", concept, "}")

personnaeToOuput.concept = concept
personnaeToOuput.title = concept

## Sexe / genre  
print("\t **** Sexe ***** "); ## TODO externalize sexes in a configuration file !
sexes = ( "Indéterminé-e", "Femme", "Homme" );
for count, elem in enumerate(sexes):
    print(count, elem)

choice = -1;
while( not ( (choice >= 0) and (choice <= len(sexes)) ) ):
    choice = int(input())
    print("\t\t => [", choice, "]"); 

selection = sexes[choice];
print("\t\t Selected {", selection, "}")
personnaeToOuput.sexe = selection

## Nom
name = None
while( (name == None) or (name == "") ):
    print("\t **** Nom ***** ")
    name = str(input())
    name = name.strip()
    print("\t\t Nom: {", name, "}")

personnaeToOuput.name = name

## Etape 2: Scores de caractéristiques
## ## Caractéristiques    Score     Dérivée
## ## Apparence           3D6       Prestance       = APP x5%
## ## Constitution        3D6       Endurance       = CON x5%
## ## Dextérité           3D6       Agilité         = DEX x5%
## ## Force               3D6       Puissance       = FOR x5%
## ## Taille              2D6+6     Corpulence      = TAI x5%
## ## Éducation           3D6+6     Connaissance    = EDU x5%
## ## Intelligence        2D6+6     Intuition       = INT x5%
## ## Pouvoir             3D6       Volonté         = POU x5%
## NOTE XXX 'randomizer' avec tirage de dés

import re, random

def randomizer( whatdices ):
    result = re.match("^([0-9])D([0-9]+)\+?([0-9]+)?$", whatdices)
    multi    = 0;
    kind     = 0;
    adder    = 0;
    if (result != None):
        multi    = result.group(1);
        kind     = result.group(2);
        adder    = result.group(3);
        value    = 0
        while (value <= 8):
            for i in range(int(multi)):
                value += random.randint(1, int(kind))
            if (adder != None):
                value += int(adder)
        return value
    else:
        print("\t ??{", whatdices, "} ??")
        return 0

APP = randomizer("3D6")
CON = randomizer("3D6")
DEX = randomizer("3D6")
FOR = randomizer("3D6")
TAI = randomizer("2D6+6")
EDU = randomizer("3D6+6")
INT = randomizer("2D6+6")
POU = randomizer("3D6")

print( "\t **** Attributs ***** " )
validateAttributes = None
while (validateAttributes == None):
    print( "\t\t APP: (", APP, ")")
    print( "\t\t CON: (", CON, ")")
    print( "\t\t DEX: (", DEX, ")")
    print( "\t\t FOR: (", FOR, ")")
    print( "\t\t TAI: (", TAI, ")")
    print( "\t\t EDU: (", EDU, ")")
    print( "\t\t INT: (", INT, ")")
    print( "\t\t POU: (", POU, ")")
    print( "\t Valider ? [y/N]")
    validateAttributes = str(input());
    validateAttributes = validateAttributes.strip()
    if ( (validateAttributes == "Y") or (validateAttributes == "y") ):
        validateAttributes = "y"
    else:
        validateAttributes = "N"
    print("\t\t Validation: {" + validateAttributes + "}")
    
    attributesDetection = "(APP|CON|DEX|FOR|TAI|EDU|INT|POU)";
    if ( validateAttributes != "y" ):
        validateAttributes = None
        print("\t Nouveau tirage ? [All|XXX|n]")
        newTirage = str(input());
        newTirage = newTirage.strip()
        print("\t\t newTirage: {" + newTirage + "}")
        
        resutirage = re.match(attributesDetection, newTirage)
        
        if (newTirage == "All"):
            APP = randomizer("3D6")
            CON = randomizer("3D6")
            DEX = randomizer("3D6")
            FOR = randomizer("3D6")
            TAI = randomizer("2D6+6")
            EDU = randomizer("3D6+6")
            INT = randomizer("2D6+6")
            POU = randomizer("3D6")
        elif (resutirage != None):
            resutiragegroup1 = resutirage.group(1)
            print("\t => {" + resutiragegroup1 + "}")
            if (resutiragegroup1 == "APP"):
                APP = randomizer("3D6")
            elif (resutiragegroup1 == "CON"):
                CON = randomizer("3D6")
            elif (resutiragegroup1 == "DEX"):
                DEX = randomizer("3D6")
            elif (resutiragegroup1 == "FOR"):
                FOR = randomizer("3D6")
            elif (resutiragegroup1 == "TAI"):
                TAI = randomizer("2D6+6")
            elif (resutiragegroup1 == "EDU"):
                EDU = randomizer("3D6+6")
            elif (resutiragegroup1 == "INT"):
                INT = randomizer("2D6+6")
            elif (resutiragegroup1 == "POU"):
                POU = randomizer("3D6")
        else:
            exchange = None;
            resutirage = None
            while ( resutirage == None ):
                print("\t Echange valeurs [XXX:YYY:{0-9}+|n]")
                exchange = str(input())
                exchange = exchange.str()
                print("\t\t exchange: {" + exchange + "}")
            if ( (resutirage.group(1) != "N") and (resutirage.group(1) != "n") ):
                first = resutirage.group(1)
                secon = resutirage.group(2)
                value = int(resutirage.group(3))
                print("\t\t first: [" + first + "]")
                print("\t\t secon: [" + secon + "]")
                print("\t\t value: [" + value + "]")
                if (first == "APP"): 
                    APP -= value
                elif (first == "CON"):
                    CON -= value
                elif (first == "DEX"):
                    DEX -= value
                elif (first == "FOR"):
                    FOR -= value
                elif (first == "TAI"):
                    TAI -= value
                elif (first == "EDU"):
                    EDU -= value
                elif (first == "INT"):
                    INT -= value
                elif (first == "POU"):
                    POU -= value
                
                if (secon == "APP"):
                    APP += value
                elif (secon == "CON"):
                    CON += value
                elif (secon == "DEX"):
                    DEX += value
                elif (secon == "FOR"):
                    FOR += value
                elif (secon == "TAI"):
                    TAI += value
                elif (secon == "EDU"):
                    EDU += value
                elif (secon == "INT"):
                    INT += value
                elif (secon == "POU"):
                    POU += value

personnaeToOuput.app = str(APP)
personnaeToOuput.con = str(CON)
personnaeToOuput.dex = str(DEX)
personnaeToOuput.force = str(FOR)
personnaeToOuput.tai = str(TAI)
personnaeToOuput.edu = str(EDU)
personnaeToOuput.int = str(INT)
personnaeToOuput.pou = str(POU)

## Etape 3: Autres valeurs
## ## Aplomb                = 0
## ## Santé Mentale (SAN)   = POU x5%
## ## Points de Vie         = (CON + TAI) / 2, arrondi à l'entier supérieur
## ## Seuil de Blessure     = Points de Vie / 2, arrondi à l'entier inférieur
## ## Points de Magie       = POU
## ## Impact                = voir la table ci-dessous
## ## ## ## FOR+TAI      Impact
## ## ## ## 02 à 12         -4
## ## ## ## 13 à 16         -2
## ## ## ## 17 à 24         0
## ## ## ## 25 à 32         +2
## ## ## ## 33 à 40         +4

aplomb  = 0;
SAN     = POU*5;
print("\t\t SAN: {", SAN, "}")
PV      = int( (CON + TAI) / 2 );
if ( (CON + TAI) % 2 == 1):
    PV += 1
print("\t\t PV-: {", PV, "}")
seuilBL   = int( PV / 2 )
print("\t\t sBL: {", seuilBL, "}")
impact    = (FOR + TAI);

if ( (impact >=  2) and (impact <= 12) ):
    impact = "-4"
elif ( (impact >= 13) and (impact <= 16) ):
    impact = "-2"
elif ( (impact >= 17) and (impact <= 24) ):
    impact = "0"
elif ( (impact >= 25) and (impact <= 32) ):
    impact = "+2"
elif ( (impact >= 33) and (impact <= 40) ):
    impact = "+4"
print("\t\t imp: {", impact, "}")

personnaeToOuput.san = str(SAN)
personnaeToOuput.pv = str(PV)
personnaeToOuput.impact = impact
## TODO ++ aplomb 
## TODO ++ seuil de blessure ?

## ## ## Competences Métier : EDU*20 (%)
countJobTalent    = 0;
countJobMaxims    = EDU*20;
## ## ## Compétences intérêt perso : INT*10 (%)
countPersoTalent    = 0;
countPersoMaxims    = INT*10;

## Préparation Étape 4 : générer biographie
## ## ## quelques variables pour retenir des éléments supplémentaires liés à la biographie...
## ... preparing and function for biographic details
## Etape 4: Choisir une occupation : choix métier + répartir EDU*20 (et au moins une à 60%)

print("\t **** Age de base ***** ")
validateAge = None;
while ( validateAge == None ):
    tirageAge = random.randint(1, 6)
    if (tirageAge == 1):
        age           = 12 + random.randint(1, 16-12+1);
        argent        = random.randint(1, 6)*2000;
        count4biog    = 3;
    elif ( (tirageAge == 2) or (tirageAge == 3) ):
        age           = 17 + random.randint(1, 30-17+1);
        argent        = random.randint(1, 6)*1000 + 10000;
        count4biog    = 6; 
    elif ( (tirageAge == 4) or (tirageAge == 5) ):
        age           = 30 + random.randint(1, 50-30+1);
        argent        = random.randint(1, 6)*2000 + 30000;
        count4biog    = 6;
    elif (tirageAge == 6):
        age           = 50 + random.randint(1, 20);
        argent        = random.randint(1, 6)*2000 + 5000;
        count4biog    = 8;
    
    print("\t\t Age: ", age, " ans. ")
    print("\t\t Fortune: ", argent, " euros. ")
    
    if (age < (EDU+6)):
        print("\t WARN \"Age < (EDU+6)\" ! => [", age, "] < [", (EDU+6), "] WARN !")
    
    print("\t Valider ? [y/N]")
    validateAge = str(input()).strip()
    if ( (validateAge == "Y") or (validateAge == "y") ):
        validateAge = "Y"
    else:
        validateAge = None

personnaeToOuput.age = str(age)
personnaeToOuput.argent = str(argent) ## NOTE : can be modified later !!

## Etape 5: Les Compétences d'intérêts personnels (INT*10% ailleurs) => indiquer valeur
remain4job = "For Job, max was [" + str(countJobMaxims) + "] (EDU*20), used [" + str(countJobTalent) + "], remain [" + str(countJobMaxims - countJobTalent) + "]";
remain4per = "For Perso, max was [" + str(countPersoMaxims) + "] (INT*10), used [" + str(countPersoTalent) + "], remain [" + str(countPersoMaxims - countPersoTalent) + "]";

personnaeToOuput.addLightBiography( remain4job )
personnaeToOuput.addLightBiography( remain4per )

print( remain4job )
print( remain4per )

## Etape 6: Finitions
import os
if not os.path.exists("generated"):
    os.makedirs("generated")

outputFile = concept + "-" + name;
outputFile = re.sub(" ", "", outputFile)
outputFile = "generated/personnae" + outputFile + ".txt";
with open(outputFile, "w", encoding = "utf-8") as file:
    file.write( personnaeToOuput.toStringPersonnae() )

os.system( "./convertLaTeXChars.pl " + outputFile);

## ## ## ...

