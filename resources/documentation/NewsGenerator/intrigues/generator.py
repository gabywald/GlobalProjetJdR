import random

def charger_base(fichier):
    with open(fichier, 'r', encoding='utf-8') as f:
        # On sépare les entrées par "---" et on nettoie les lignes vides
        return [partie.strip() for partie in f.read().split('---\n') if partie.strip()]

def generer_nouvelle():
    # Chargement des bases
    personnages = charger_base('Personnages.txt')
    lieux = charger_base('Lieux.txt')
    objets = charger_base('Objets.txt')
    intrigues = charger_base('Intrigues.txt')
    ambiances = charger_base('Ambiance.txt')
    dialogues = charger_base('Dialogues.txt')

    # Sélection aléatoire
    personnage = random.choice(personnages)
    lieu = random.choice(lieux)
    objet = random.choice(objets)
    intrigue = random.choice(intrigues)
    ambiance = random.choice(ambiances)
    dialogue = random.choice(dialogues)

    # Extraction des informations
    nom_personnage = personnage.split('Nom: ')[1].split('\n')[0]
    nom_lieu = lieu.split('Nom: ')[1].split('\n')[0]
    nom_objet = objet.split('Nom: ')[1].split('\n')[0]
    titre_intrigue = intrigue.split('Titre: ')[1].split('\n')[0]
    description_intrigue = intrigue.split('Description: ')[1]
    replique = dialogue.split('Réplique: ')[1].split('\n')[0]

    # Génération de la nouvelle
    nouvelle = f"""
    **Titre provisoire: {titre_intrigue}**

    {ambiance}

    {personnage}

    Alors que {nom_personnage} arpentait {nom_lieu}, {nom_objet} attira son attention.
    *« {replique} »*, murmura une voix dans l’ombre.

    **Début de l’intrigue:** {description_intrigue}
    """
    return nouvelle

# Exemple d'utilisation
if __name__ == "__main__":
    print(generer_nouvelle())
