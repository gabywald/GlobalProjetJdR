# NewsGenerator

L'objectif de ce projet / sous-projet est de générer des nouvelles ("News") pouvant facilement être réutilisées pour générer des "Unes" de journaux ou magazines avec un minimum de ressources : 
 - base de données textuelle : 
	- format JSON : structuration d'éléments pré-construits ; 
	- données initales issues du jeu vidéo "Uplink Hacker Elite" ; 
	- ...
 - ... 

## Outils et Technique

 - Perl v5.38.2
 - Python 3.12.3
 - Ubuntu 24.04
 - LaTeX / pdflatex 3.141592653-2.6-1.40.25
 - Pas d'Intelligence Artificielle (ou le moins possible)

## Structuration du JSON

La base de donnée source est actuellement définie comme une succession d'objets JSON possédant les attributs suivants (tous optionnels) : 
 - titles (array) ; 
 - head (array) ; 
 - content[1-5] (arrayS) ; 
 - conclusion (array) ; 
 - launcher (object) : 
 	- computername (string) ; 
 	- computertype (string) ; 
 	- filetype (string) ; 
 	- numrecentshacks (integer) ; 
 	- uplinkrating (integer) ; 

Exemple générique : 

```json
	{		
		"titles": [ "possible title 1", "possible title 2", "possible title 3" ], 
		"head": [ "HEAD of the article" ], 
		"content1": [ "long content part 1 of the generated article... " ], 
		"content2": [ "long content part 2 of the generated article... " ], 
		"content3": [ "long content part 3 of the generated article... " ], 
		"content4": [ "long content part 4 of the generated article... " ], 
		"content5": [ "long content part 5 of the generated article... " ], 
		"conclusion": [ "END of the article" ],  
		"launcher": { 
			"computername": "International Social Security Database", 
			"computertype": "Public Bank Server",
			"filetype": "SCIENTIFIC",
			"uplinkrating": 1, 
			"numrecentshacks": 1
		}
	}
```

## Répertoires

 - _prototypage_ correspond à des éléments dorigine d'exploration ; 
 - _fromUplinkHackerElite_ pour le projet initial de démarrage ; 
