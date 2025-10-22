
import json
import random

def load_news_database(file_path):
    with open(file_path, 'r', encoding='utf-8') as file:
        return json.load(file)

def generate_news(news_db):
    titre = random.choice(news_db['titres'])
    introduction = random.choice(news_db['introductions'])
    developpement = random.choice(news_db['developpements'])
    conclusion = random.choice(news_db['conclusions'])
    
    nouvelle = f"{titre}\n\n{introduction} {developpement} {conclusion}"
    return nouvelle

# Exemple d'utilisation
news_db = load_news_database('news_database.json')
print(generate_news(news_db))
