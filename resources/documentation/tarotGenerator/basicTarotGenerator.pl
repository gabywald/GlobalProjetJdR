#!/usr/bin/perl -w

use strict;

use lib '.';
use TarotElement;

my $dataDir				= "tarotData/";
my $imgsDir				= $dataDir."img/";
my $configurationFile	= $dataDir."indexNamesAndImages.txt";

my @listOfElements		= ();
my %hashForKind			= ();
my $separator			= ";;;;;";

open (INPUT, "<".$configurationFile);
while (my $line = <INPUT>) {
	$line =~ s/[\r\n]//g;
	if ($line =~ /^([0XIV]+)\t+(.*?)\t(.*?)\t(.*?)$/) {
		## Arcanes Majeures / Atouts
		my $number	= $1;
		my $color	= $2;
		my $name	= $3;
		my $image	= $4;
		
		print "Atout : [".$number."]\t{".$color."}\t{".$name."}\t{".$image."}\n";
		
		my $newAtout = TarotElement->new();
		$newAtout->setType( 1 );
		$newAtout->setKind( $color );
		$newAtout->setName( "Arcane ".$number." -- ".$name );
		$newAtout->setImage( $image );
		push ( @listOfElements, $newAtout );
		
	}
	elsif ($line =~ /^([A-Z_]+)\t(.*?)\t(.*?)\t(.*?)$/) {
		## Éléments génériques
		my $name	= $1;
		my $first	= $2;
		my $second	= $3;
		my $third	= $4;
		
		print "KIND : [".$name."]\t{".$first."}\t{".$second."}\t{".$third."}\n";
		$hashForKind{$name} = $first.$separator.$second.$separator.$third;
	}
	elsif ($line =~ /^\t([A-Z_]+)\t(.*?)\t(.*?)\t(.*?)$/) { 
		## Arcanes mineures / Maisons
		my $kind	= $1;
		my $index	= $2;
		my $name	= $3;
		my $image	= $4;
		
		print "House : [".$name."]\t{".$kind."}\t{".$index."}\t{".$image."}\n";
		
		my $newArcana = TarotElement->new();
		$newArcana->setType( 0 );
		$newArcana->setKind( $kind );
		$newArcana->setName( $name );
		$newArcana->setImage( $image );
		push ( @listOfElements, $newArcana );
	}
}
close (INPUT);

getc();

foreach my $element (@listOfElements) 
	{ print $element->toString()."\n"; }

getc();

## foreach my $element (@listOfElements) { 
	## my @kinds = split($separator, $hashForKind{$element->getKind()});
	## print "\t{".$kinds[0]."}\t{".$kinds[1]."}\t{".$kinds[2]."}\t\n";
	## print $element->toLaTeX($kinds[0], $kinds[1], $kinds[2])."\n"; 
## }

my $titre					= "Generated tarot !";

my $betweenTwoLinesPortrait = "\n\t\t&\t&\t\\\\\t\\hline\t\t&\t&\t\\\\\n\n";
my $nextPage				= "\t\\clearpage\n\n";

my $verso		= "";
$verso			.= "\t\\doublebox{ % \\fbox{ %\\Ovalbox{%\n";
$verso			.= "\t\t\\begin{tabular}[ht]{ \@{}p{1.80cm}\@{} \@{}p{1.80cm}\@{} \@{}p{1.80cm}\@{} }\n";
$verso			.= "\t\t\t\\multicolumn{3}{ \@{}p{5.55cm}\@{} }\n";
$verso			.= "\t\t\t\t{ \\includegraphics[width=5.50cm, height=11.25cm]{../../tarotData/img/cards_background.jpg} } \\\\\n";
$verso			.= "\t\\end{tabular}\n";
$verso			.= "\t}";

my $headerLaTeX = "";
$headerLaTeX .= "\\documentclass[11pt,oneside,a4paper]{article} %% oneside and NOT twoside here !!\n";
$headerLaTeX .= "% http://www-h.eng.cam.ac.uk/help/tpl/textprocessing/latex_maths+pix/node6.html symboles de math\n";
$headerLaTeX .= "% http://fr.wikibooks.org/wiki/Programmation_LaTeX Programmation latex (wikibook)\n";
$headerLaTeX .= "%=========================== En-Tete =================================\n";
$headerLaTeX .= "%--- Insertion de paquetages (optionnel) ---\n";
$headerLaTeX .= "\\usepackage[french]{babel}\n";
$headerLaTeX .= "\\usepackage{a4}	             % pour la taille   \n";
$headerLaTeX .= "\\usepackage[T1]{fontenc}     % pour les font postscript\n";
$headerLaTeX .= "\\usepackage{epsfig}          % pour gerer les images\n";
$headerLaTeX .= "%\\usepackage{psfig}\n";
$headerLaTeX .= "\\usepackage{amsmath, amsthm} % tres bon mode mathematique\n";
$headerLaTeX .= "\\usepackage{amsfonts,amssymb}% permet la definition des ensembles\n";
$headerLaTeX .= "\\usepackage{float}           % pour le placement des figures\n";
$headerLaTeX .= "\\usepackage{verbatim}\n";
$headerLaTeX .= "\\usepackage{longtable} % pour les tableaux de plusieurs pages\n";
$headerLaTeX .= "\\usepackage[table]{xcolor} % couleur de fond des cellules de tableaux\n";
$headerLaTeX .= "\\usepackage{lastpage}\n";
$headerLaTeX .= "\\usepackage{multirow}\n";
$headerLaTeX .= "\\usepackage{multicol} % pour {\\'e}crire dans certaines zones en colonnes : \\begin{multicols}{nb colonnes}...\end{multicols} \n\n";
$headerLaTeX .= "% \\usepackage[top=1.5cm, bottom=1.5cm, left=1.5cm, right=1.5cm]{geometry}\n";
$headerLaTeX .= "% gauche, haut, droite, bas, entete, ente2txt, pied, txt2pied\n";
$headerLaTeX .= "\\usepackage{vmargin}\n";
$headerLaTeX .= "\\setmarginsrb{0.50cm}{1.00cm}{1.50cm}{1.00cm}{15pt}{3pt}{60pt}{25pt}\n\n";
$headerLaTeX .= "\\usepackage{lscape} % changement orientation page\n";
$headerLaTeX .= "%\\usepackage{frbib} % enlever pour obtenir references en anglais\n";
$headerLaTeX .= "% --- style de page (pour les en-tete) ---\n";
$headerLaTeX .= "\\pagestyle{headings}\n\n";

my ($sec,$min,$hour,$mday,$mon,$year,$wday,$yday,$isdst) = localtime(time);
my @abbr = qw( Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec );
my @long = qw( January February March April Juny July August September October November December );
$headerLaTeX .= "\\def\\MainTitle{".$titre." --- \\today --- "
				.$abbr[$mon]." ".$mday.", ".(1900+$year)." ".$hour.":".$min.":".$sec."}\n\n";

$headerLaTeX .= "\\usepackage{fancybox}\n\n";
$headerLaTeX .= "% % % en-tete et pieds de page configurables : fancyhdr.sty\n";
$headerLaTeX .= "% http://www.trustonme.net/didactels/250.html\n\n";
$headerLaTeX .= "% http://ww3.ac-poitiers.fr/math/tex/pratique/entete/entete.htm\n";
$headerLaTeX .= "% http://www.ctan.org/tex-archive/macros/latex/contrib/fancyhdr/fancyhdr.pdf\n";
$headerLaTeX .= "\\usepackage{fancyhdr}\n";
$headerLaTeX .= "\\pagestyle{fancy}\n";
$headerLaTeX .= "% \\newcommand{\\chaptermark}[1]{\\markboth{#1}{}}\n";
$headerLaTeX .= "% \\newcommand{\\sectionmark}[1]{\\markright{\\thesection\\ #1}}\n";
$headerLaTeX .= "\\fancyhf{}\n";
$headerLaTeX .= "\\fancyhead[LE,RO]{\\thepage /\\pageref{LastPage} \\hfill\n";
$headerLaTeX .= "	\\MainTitle \n";
$headerLaTeX .= "\\hfill \\includegraphics[width=0.5cm]{../../tarotData/img/logo_glider.png} }\n";
$headerLaTeX .= "\\fancyfoot[LE,RO]{\\includegraphics[width=0.5cm]{../../tarotData/img/logo_glider.png} \\hfill\n";
$headerLaTeX .= "	\\MainTitle \n";
$headerLaTeX .= "\\hfill \\thepage /\\pageref{LastPage}}\n";
$headerLaTeX .= "\\renewcommand{\\headrulewidth}{0.25pt}\n";
$headerLaTeX .= "\\renewcommand{\\footrulewidth}{0.50pt}\n";
$headerLaTeX .= "\\addtolength{\\headheight}{0.5pt}\n";
$headerLaTeX .= "\\fancypagestyle{plain}{\n";
$headerLaTeX .= "	\\fancyhead{}\n";
$headerLaTeX .= "	\\renewcommand{\\headrulewidth}{0pt}\n";
$headerLaTeX .= "}\n\n";
$headerLaTeX .= "%--- Definitions de nouvelles commandes ---\n";
$headerLaTeX .= "\\newcommand{\\N}{\\mathbb{N}} % les entiers naturels\n\n";
$headerLaTeX .= "%--- Definitions de nouvelles couleurs ---\n";
$headerLaTeX .= "\\definecolor{verylightgrey}{rgb}{0.8,0.8,0.8}\n";
$headerLaTeX .= "\\definecolor{verylightgray}{gray}{0.80}\n";
$headerLaTeX .= "\\definecolor{lightgrey}{rgb}{0.6,0.6,0.6}\n";
$headerLaTeX .= "\\definecolor{lightgray}{gray}{0.6}\n\n";
$headerLaTeX .= "%============================= Corps =================================\n";
$headerLaTeX .= "\\begin{document}\n\n";
$headerLaTeX .= "\\setlength\\parindent{0pt} % \\noindent for all document\n\n";
$headerLaTeX .= "% \\begin{longtable}[ht]{ p{4.75cm} p{0.75cm} p{4.75cm} p{0.75cm} p{4.75cm} }\n";
$headerLaTeX .= "\\begin{longtable}[ht]{ l l l }\n";

my $footerLaTeX = "";
$footerLaTeX .= "\\end{longtable}\n";
$footerLaTeX .= "\\end{document}\n";

## portrait OUTPUT !
open (OUTPUT, ">"."output.tex" );
print OUTPUT $headerLaTeX;
my $i = 1;
foreach my $element (@listOfElements) { 
	my @kinds = split($separator, $hashForKind{$element->getKind()});
	print OUTPUT $element->toLaTeX($kinds[0], $kinds[1], $kinds[2]); ## ."\n"; 
	if ( ($i % 6) == 0)		{ 
		print OUTPUT "\t\\\\\n".$betweenTwoLinesPortrait;
		print OUTPUT $nextPage;
		print OUTPUT $verso."\t&\n".$verso."\t&\n".$verso."\t\\\\\n".$betweenTwoLinesPortrait;
		print OUTPUT $verso."\t&\n".$verso."\t&\n".$verso."\t\\\\\n".$betweenTwoLinesPortrait;
		if ($i != @listOfElements) { print OUTPUT $nextPage; }
	}
	elsif ( ($i % 3) == 0)	{ print OUTPUT "\t\\\\\n".$betweenTwoLinesPortrait; }
	else					{ print OUTPUT "\t&\n"; }
	
	$i++;
}
print OUTPUT $footerLaTeX;
close (OUTPUT);

system("./convertLaTeXChars.pl output.tex");
system("cp -v output.tex tarotTests/generated/output.tex");
system("cp -v output.tex tarotTests/generated/document.tex");
system("rm -v output.tex");
chdir("tarotTests/generated/");
system("make && make clean");
