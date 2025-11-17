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

import os
import subprocess

import re
from datetime import date

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
    
def readFileToArray( file_path ):
  content = []
  with open(file_path, 'r', encoding='utf-8') as file:
    for line in file: 
      content.append( line )
  content = [line.rstrip('\n') for line in content]
  return content

def replacingUpperCaseElements( newsTXT ):
  if (re.search(r'PERSONNAME', newsTXT)): 
    fornames = readFileToArray( "../dataUplink/fornamesMore.txt" )
    surnames = readFileToArray( "../dataUplink/fornamesMore.txt" )
    completename = random.choice( surnames ) + " " + random.choice( fornames )
    # print(newsTXT)
    newsTXT = re.sub(r'PERSONNAME', completename, newsTXT)
    print("*****" + completename + "*****\n")
  if (re.search(r'PERSONHANDLE', newsTXT)): 
    agentaliases = readFileToArray( "../dataUplink/agentaliases.txt" )
    
    agentalias = "\'" + random.choice( agentaliases ) + "\'";
    # print(newsTXT)
    newsTXT = re.sub(r'PERSONHANDLE', agentalias, newsTXT)
    print("*****" + agentalias + "*****\n")
  if (re.search(r'COMPANYNAME', newsTXT)): 
    companynameA = readFileToArray( "../dataUplink/companya.txt" )
    companynameB = readFileToArray( "../dataUplink/companyb.txt" )
    
    companyname = random.choice( companynameA ) + " " + random.choice( companynameB )
    # print(newsTXT)
    newsTXT = re.sub(r'COMPANYNAME', companyname, newsTXT)
    print("*****" + companyname + "*****\n")
  if (re.search(r'REASON', newsTXT)): 
    newsTXT = re.sub(r'REASON', "NO REASON", newsTXT)
  if (re.search(r'TOTALFILESIZE', newsTXT)): 
    newsTXT = re.sub(r'TOTALFILESIZE', str(random.randint(0, 1000)), newsTXT)
  return newsTXT;

def generateNewsToLaTeX( newsHashArray ): 
  newsHashMAIN = db_news[ random.randint(0, len(db_news) - 1 ) ]
  newsHash0001 = db_news[ random.randint(0, len(db_news) - 1 ) ]
  newsHash0002 = db_news[ random.randint(0, len(db_news) - 1 ) ]
  newsHash0003 = db_news[ random.randint(0, len(db_news) - 1 ) ]
  newsHash0004 = db_news[ random.randint(0, len(db_news) - 1 ) ]
  newsHash0005 = db_news[ random.randint(0, len(db_news) - 1 ) ]
  
  toReturn = ""
  toReturn += "\\input{../latexTemplates/template_journal_header.tex}\n\n";
  toReturn += "\\LARGE{\\centering \\setmainfont{Sprawl} " + selectELTinNews(newsHashMAIN,'titles') + "}\n\n";
  toReturn += "\\begin{multicols}{2}\n\n";
  toReturn += "\\small\n\n";
  toReturn += " %% \\begin{center} { \\Huge \\setmainfont{FoglihtenDeH02} \\textbf{Q+\\_9\\_+q} } \\end{center} %% ~\\\\\n\n";
  toReturn += "\\textbf{" + selectELTinNews(newsHashMAIN,'head') + "}~\\\\\n";
  toReturn += "\\emph{" + selectELTinNews(newsHashMAIN,'content1') + "}~\\\\\n";
  toReturn += "" + selectELTinNews(newsHashMAIN,'content2') + "\n";
  toReturn += "" + selectELTinNews(newsHashMAIN,'content3') + "\n";
  toReturn += "" + selectELTinNews(newsHashMAIN,'content4') + "\n";
  toReturn += "" + selectELTinNews(newsHashMAIN,'content5') + " %% ~\\\\\n\n";
  toReturn += "\\vfill~\\vfill\n\n";
  toReturn += "\\textbf{" + selectELTinNews(newsHash0001,'titles') + "}~\\\\\n";
  toReturn += "\\emph{" + selectELTinNews(newsHash0001,'head') + "}~\\\\\n";
  toReturn += "" + selectELTinNews(newsHash0001,'content1') + "~\\\\\n";
  toReturn += "" + selectELTinNews(newsHash0001,'content2') + "\n";
  toReturn += "" + selectELTinNews(newsHash0001,'content3') + "\n";
  toReturn += "" + selectELTinNews(newsHash0001,'content4') + "\n";
  toReturn += "" + selectELTinNews(newsHash0001,'content5') + " %% ~\\\\\n\n";
  toReturn += "\\vfill~\\vfill\n\n";
  toReturn += "\\textbf{" + selectELTinNews(newsHash0002,'titles') + "}~\\\\\n";
  toReturn += "\\emph{" + selectELTinNews(newsHash0002,'head') + "}~\\\\\n";
  toReturn += "" + selectELTinNews(newsHash0002,'content1') + "~\\\\\n";
  toReturn += "" + selectELTinNews(newsHash0002,'content2') + "\n";
  toReturn += "" + selectELTinNews(newsHash0002,'content3') + "\n";
  toReturn += "" + selectELTinNews(newsHash0002,'content4') + "\n";
  toReturn += "" + selectELTinNews(newsHash0002,'content5') + "~\\\\\n\n";
  toReturn += "\\textbf{" + selectELTinNews(newsHash0003,'titles') + "}~\\\\\n";
  toReturn += "\\textbf{" + selectELTinNews(newsHash0004,'titles') + "}~\\\\\n";
  toReturn += "\\textbf{" + selectELTinNews(newsHash0005,'titles') + "}~\\\\\n";
  toReturn += "\\vfill~\\columnbreak\n\n";
  toReturn += "%% {\\small \\lipsum[1-3] }~\\\\\n\n";
  toReturn += "\\begin{center} { \\Huge \\setmainfont{FoglihtenDeH02} \\textbf{\\{1=:=!\\}} } \\end{center} %% ~\\\\\n\n";
  toReturn += "\\begin{center} { \\Huge \\setmainfont{FoglihtenDeH02} \\textbf{Q+\\_9\\_+q} } \\end{center} %% ~\\\\\n\n";
  toReturn += "\\begin{multicols}{2}\n\n";
  toReturn += "\\textbf{Specific Article Next}~\\\\\n\n";
  toReturn += "\\emph{Catchphrase Lorem Ipsum}~\\\\\n\n";
  toReturn += "\\lipsum[5-7]~\\\\\n\n";
  toReturn += "\\end{multicols}\n\n";
  toReturn += "{\\centering \\rule{0.34\\textwidth}{1pt} }~\\\\\n\n";
  toReturn += "Automatic Generated Page. \\textsc{Not real news !}~\\\\\n\\emph{News Generator} by \\textbf{Gaby Wald}~\\\\\n\n";
  toReturn += "\\end{multicols}\n\n";
  toReturn += "\\input{../latexTemplates/template_journal_footer.tex}\n\n";
  
  return replacingUpperCaseElements( toReturn )

def selectELTinNews( selectArray, key ): 
  if key in selectArray: 
    return selectArray[key][ random.randint(0, len(selectArray[key]) - 1 ) ]
  else: 
    return "" ## "NO DATA !"

def generateDateYYYMMDDHHMMSS(): 
  # see https://www.tutorialspoint.com/python/python_date_time.htm
  d = date.fromordinal(738630) # 738630th day after 1. 1. 0001
  return d.strftime("%Y%m%d%H%M%S")

## Usage example
db_news = load_news_database('../databases/newsDataBase-starting.json')
print(generate_news(db_news))

outputDIR = "generatedOutputs"
## TODO generate UUID / ID with date !
## TODO use later : my $fileTEXname = "filetobuild".generateDateYYYMMDDHHMMSS()
fileTEXname = "filetobuild";
## Generate the TeX file
print( "Creating TeX file..." )
with open( "../" + outputDIR + "/" + fileTEXname + ".tex", 'w') as fileTEXnameOUTPUT:
  fileTEXnameOUTPUT.write( generateNewsToLaTeX( db_news ) )

## DONE Makefile && make !
with open( "../latexTemplates/template_Makefile", 'r') as MakefileINPUTT:
  with open( "../" + outputDIR + "/Makefile", 'w') as MakefileOUTPUT:
    MakefileOUTPUT.write( "LATEXFILE=" + fileTEXname )
    for line in MakefileINPUTT:
      MakefileOUTPUT.write( line )

def launcheMakePDFfromLaTeX( directory_1, directory_2 ) : 
    print( "Changing dir to {" + directory_1 + "}..." )
    os.chdir( directory_1 )
    print( "Compiling TeX file to PDF..." )
    retcode = subprocess.call( "make", stdin=None, stdout=subprocess.DEVNULL, stderr=None, shell=True )
    print( retcode )
    print( "Cleaning..." )
    retcode2 = subprocess.call( "make clean", stdin=None, stdout=subprocess.DEVNULL, stderr=None, shell=True)
    print( retcode2 )
    print( "Changing dir to {" + directory_2 + "}..." )
    os.chdir( directory_2 )

launcheMakePDFfromLaTeX( "../generatedOutputs/", "../python/" )
