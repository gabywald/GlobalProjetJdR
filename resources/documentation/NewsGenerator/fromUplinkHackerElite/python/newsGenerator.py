#!/usr/bin/python3
# -*- coding: utf-8 -*-

__author__ = "Gabriel Chandesris"
__copyright__ = "CC Gabriel Chandesris (2020)"
__credits__ = ""
__licence__ = "GNU GENERAL PUBLIC LICENSE v3"
__version__ = "1.0.0a"
__maintainer__ = "Gabriel Chandesris"
__email__ = "gabywald[at]laposte.net"
__contact__ = "gabywald[at]laposte.net"
__status__ = "Development"

import json
import random

## Reading input file
def load_news_database(file_path):
    with open(file_path, 'r', encoding='utf-8') as file:
        return json.load(file)

def get_keyvalue_from(selected_news, key): 
    if (selected_news.__contains__( key ) ): 
        return random.choice(selected_news[ key ])
    else:
        return ""

## To generate a random News
def generate_news(db_news):
    selected_news = db_news[ random.randint(0, len(db_news) - 1 ) ]
    ## Add / select title
    title = get_keyvalue_from(selected_news, 'titles' )
    ## Add / select content[1-5]
    content1 = get_keyvalue_from(selected_news, 'content1' )
    content2 = get_keyvalue_from(selected_news, 'content2' )
    content3 = get_keyvalue_from(selected_news, 'content3' )
    content4 = get_keyvalue_from(selected_news, 'content4' )
    content5 = get_keyvalue_from(selected_news, 'content5' )
    ## Append all together
    news = f"{title}\n{content1}\n{content2}\n{content3}\n{content4}\n{content5}\n..."
    return news

## Usage example
db_news = load_news_database('../databases/newsDataBase-starting.json')
print(generate_news(db_news))
