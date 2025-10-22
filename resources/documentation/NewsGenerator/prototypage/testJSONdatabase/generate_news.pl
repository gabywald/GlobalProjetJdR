#!/usr/bin/perl
use strict;
use warnings;
use JSON;

## Ce script génère une nouvelle aléatoire à partir d'une base de données JSON de phrases types.

## Fonction pour charger la base de données JSON
sub load_news_database {
    my ($file_path) = @_;

    ## Ouvrir le fichier JSON
    open(my $file, '<:encoding(UTF-8)', $file_path) or die "Impossible d'ouvrir le fichier '$file_path': $!";

    ## Lire le contenu du fichier
    local $/ = undef;
    my $json_text = <$file>;
    close($file);

    ## Décoder le JSON et retourner la structure de données
    return decode_json($json_text);
}

## Fonction pour générer une nouvelle aléatoire
sub generate_news {
    my ($news_db) = @_;

    ## Sélectionner aléatoirement un titre, une introduction, un développement et une conclusion
    my $titre = $news_db->{'titres'}[int(rand(@{$news_db->{'titres'}}))];
    my $introduction = $news_db->{'introductions'}[int(rand(@{$news_db->{'introductions'}}))];
    my $developpement = $news_db->{'developpements'}[int(rand(@{$news_db->{'developpements'}}))];
    my $conclusion = $news_db->{'conclusions'}[int(rand(@{$news_db->{'conclusions'}}))];

    ## Assembler les éléments pour former la nouvelle
    my $nouvelle = "$titre\n\n$introduction $developpement $conclusion";
    return $nouvelle;
}

## Exemple d'utilisation
my $news_db = load_news_database('news_database.json');
print generate_news($news_db);

