# tests/test_parser.py
import pytest
from parser import extract_event_details

def test_extract_event_details():
    content = "43bis Av. Simon Bolivar, 75019 Paris - Test. Horaire : Les Lundi de 19h30 à 23h. 3€ par participant sauf le MJ."
    forum_name = "Le Repaire du Dragon"
    details = extract_event_details(content, forum_name)
    assert details['date'] == "Lundi"
    assert details['start_time'] == "19h30"
    assert details['end_time'] == "23h"
    assert details['address'] == "43bis Av. Simon Bolivar, 75019 Paris"
    assert details['price'] == "3€"

def test_extract_event_details_missing_fields():
    content = "Horaire : Les Lundi de 19h30 à 23h."
    forum_name = "Inconnu"
    details = extract_event_details(content, forum_name)
    assert details is None

def test_generate_weekly_events():
    # À tester après avoir peuplé la base de données
    pass
