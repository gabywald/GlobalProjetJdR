import random
import glob
from pathlib import Path

class CyberpunkTitreGenerator:
    def __init__(self, dossier_titres="titres/"):
        self.dossier_titres = dossier_titres
        self.titres_par_fichier = self._charger_titres()

    def _charger_titres(self):
        titres = {}
        for fichier in glob.glob(f"{self.dossier_titres}*.txt"):
            with open(fichier, "r", encoding="utf-8") as f:
                titres[fichier] = [ligne.strip() for ligne in f if ligne.strip()]
        return titres

    def generer_titre(self, mots_cles=None):
        if not self.titres_par_fichier:
            raise ValueError("Aucun fichier de titres trouvé.")

        fichier = random.choice(list(self.titres_par_fichier.keys()))
        titres = self.titres_par_fichier[fichier]
        titre = random.choice(titres)

        if mots_cles:
            titre = self._integrer_mots_cles(titre, mots_cles)

        return {
            "titre": titre,
            "source": Path(fichier).name
        }

    def _integrer_mots_cles(self, titre, mots_cles):
        mots = titre.split()
        for i, mot in enumerate(mots):
            if random.random() < 0.3 and mots_cles:
                mots[i] = random.choice(mots_cles)
        return " ".join(mots)

# Exemple d'utilisation
if __name__ == "__main__":
    generator = CyberpunkTitreGenerator()
    mots_cles = ["IA", "révolte", "néon", "glitch", "corporation"]
    nouveau_titre = generator.generer_titre(mots_cles)
    print(f"Titre généré: {nouveau_titre['titre']}")
    print(f"Source: {nouveau_titre['source']}")
