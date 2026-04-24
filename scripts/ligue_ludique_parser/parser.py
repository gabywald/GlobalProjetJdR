# parser.py
import requests
from bs4 import BeautifulSoup
import re
import sqlite3
from datetime import datetime, timedelta
from icalendar import Calendar, Event
import json
import os

# Configuration
FORUM_URL = "https://ligue-ludique.fr/forum/index.php"
CATEGORIES = {
    "boutiques": ["Le Repaire du Dragon", "OberJeux", "La Cabane", "OpenBar", "Majestik Games",
                   "La Plume du Phénix", "Robin des Jeux", "Loufoque, 5ème arr, Rue Dante",
                   "Loufoque, 9ème arr, Rue Thimonnier", "Au Dé 12", "Le 3Bis"],
    "lieux": ["Discord", "Événements Hors Ligue"],
    "virtualité": ["Discord"]
}

def fetch_forum_page(url):
    headers = {'User-Agent': 'Mozilla/5.0'}
    response = requests.get(url, headers=headers)
    response.raise_for_status()
    return response.text

def parse_forum(html):
    soup = BeautifulSoup(html, 'html.parser')
    events = []

    # Parse chaque catégorie
    for category, forums in CATEGORIES.items():
        for forum in forums:
            forum_link = soup.find('a', string=re.compile(forum))
            if forum_link:
                forum_url = f"https://ligue-ludique.fr/forum/{forum_link['href']}"
                forum_html = fetch_forum_page(forum_url)
                events.extend(parse_forum_page(forum_html, forum))

    return events

def parse_forum_page(html, forum_name):
    soup = BeautifulSoup(html, 'html.parser')
    events = []
    rows = soup.find_all('div', class_='forabg')

    for row in rows:
        topic = row.find('a', class_='topictitle')
        if topic:
            title = topic.text.strip()
            link = f"https://ligue-ludique.fr/forum/{topic['href']}"
            last_post = row.find('p', class_='lastpost')
            if last_post:
                last_post_date = last_post.find('time')['datetime']
                # Extraire la date/heure/lieu/adresse depuis le contenu de la ligne
                content = row.find('div', class_='content').text.strip()
                event_details = extract_event_details(content, forum_name)
                if event_details:
                    event_details['title'] = title
                    event_details['forum'] = forum_name
                    event_details['last_post_date'] = last_post_date
                    events.append(event_details)

    return events

def extract_event_details(content, forum_name):
    # Regex pour extraire date, heure, lieu, adresse
    patterns = {
        'date': r'(?:le|Les|de|du|Les )([\w\s]+?)(?:\s|de|à)',
        'heure': r'(\d{1,2}h\d{2})\s*-\s*(\d{1,2}h\d{2})',
        'adresse': r'([\d\s]+(?:[\w\s]+),\s*\d{5}\s*\w+)',
        'prix': r'(\d+€)'
    }

    details = {}
    for field, pattern in patterns.items():
        match = re.search(pattern, content, re.IGNORECASE)
        if match:
            if field == 'date':
                details['date'] = match.group(1)
            elif field == 'heure':
                details['start_time'] = match.group(1)
                details['end_time'] = match.group(2)
            elif field == 'adresse':
                details['address'] = match.group(1)
            elif field == 'prix':
                details['price'] = match.group(1)

    # Si l'adresse n'est pas trouvée, utiliser l'adresse du forum
    if 'address' not in details and forum_name in ["Le Repaire du Dragon", "OberJeux", "La Cabane", "OpenBar", "Majestik Games",
                   "La Plume du Phénix", "Robin des Jeux", "Loufoque, 5ème arr, Rue Dante",
                   "Loufoque, 9ème arr, Rue Thimonnier", "Au Dé 12", "Le 3Bis"]:
        addresses = {
            "Le Repaire du Dragon": "43bis Av. Simon Bolivar, 75019 Paris",
            "OberJeux": "47 rue de la Folie Méricourt, Paris",
            "La Cabane": "76 Rue Notre Dame de Nazareth, 75003 Paris",
            "OpenBar": "194 Rue d'Alésia 75014 Paris",
            "Majestik Games": "148 Avenue du Maine, 75014 Paris",
            "La Plume du Phénix": "100 Rue de Montreuil, 75011 Paris",
            "Robin des Jeux": "37 Boulevard de Charonne, 75011 Paris",
            "Loufoque, 5ème arr, Rue Dante": "5 Rue Dante, 75005 Paris",
            "Loufoque, 9ème arr, Rue Thimonnier": "10 Rue Thimonnier, 75009 Paris",
            "Au Dé 12": "126 Av. de la République 75011 Paris",
            "Le 3Bis": "41 Rue des Pirogues de Bercy, 75012 Paris"
        }
        details['address'] = addresses.get(forum_name, "")

    return details if details else None

def save_to_db(events):
    conn = sqlite3.connect('events.db')
    c = conn.cursor()
    c.execute('''CREATE TABLE IF NOT EXISTS events
                 (id INTEGER PRIMARY KEY AUTOINCREMENT,
                  title TEXT,
                  forum TEXT,
                  date TEXT,
                  start_time TEXT,
                  end_time TEXT,
                  address TEXT,
                  price TEXT,
                  last_post_date TEXT,
                  link TEXT)''')
    c.executemany('INSERT INTO events VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)',
                  [(e['title'], e['forum'], e.get('date'), e.get('start_time'), e.get('end_time'),
                    e.get('address'), e.get('price'), e.get('last_post_date'), e.get('link', ""))
                   for e in events])
    conn.commit()
    conn.close()

def generate_weekly_events():
    conn = sqlite3.connect('events.db')
    c = conn.cursor()
    c.execute("SELECT * FROM events WHERE date >= date('now') ORDER BY date, start_time")
    events = c.fetchall()
    conn.close()

    weekly_events = []
    for event in events:
        weekly_events.append(
            f"{event[1]} - {event[3]} {event[4]}-{event[5]} @ {event[6]} (Prix: {event[7]})\n"
            f"Dernier post: {event[8]} | Lien: {event[9]}"
        )

    with open('weekly_events.txt', 'w') as f:
        f.write("Événements de la semaine:\n\n")
        f.write("\n".join(weekly_events))

    return weekly_events

def export_to_icalendar():
    conn = sqlite3.connect('events.db')
    c = conn.cursor()
    c.execute("SELECT * FROM events WHERE date >= date('now') ORDER BY date, start_time")
    events = c.fetchall()
    conn.close()

    cal = Calendar()
    for event in events:
        ical_event = Event()
        ical_event.add('summary', event[1])
        ical_event.add('dtstart', datetime.strptime(f"{event[3]} {event[4]}", "%A %d %B %Y %Hh%M"))
        ical_event.add('dtend', datetime.strptime(f"{event[3]} {event[5]}", "%A %d %B %Y %Hh%M"))
        ical_event.add('location', event[6])
        ical_event.add('description', f"Forum: {event[2]} | Prix: {event[7]} | Lien: {event[9]}")
        cal.add_component(ical_event)

    with open('calendar.ics', 'wb') as f:
        f.write(cal.to_ical())

if __name__ == "__main__":
    html = fetch_forum_page(FORUM_URL)
    events = parse_forum(html)
    save_to_db(events)
    generate_weekly_events()
    export_to_icalendar()
