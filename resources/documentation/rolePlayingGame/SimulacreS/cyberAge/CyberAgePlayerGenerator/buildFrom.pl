#!/usr/bin/perl -w

use strict;

use lib '.';
use Personnae;

if (@ARGV < 1) {
	print "NOT enough arguments";
	exit(1);
} ## END "if (@ARGV < 1)"

my $fileToLoad			= $ARGV[0];

my @personnaes			= ();

my $currentPersonnae	= undef;

my $flagPersonnae		= 0;
my $flagCyberEqui		= 0;
my $flagCailloux		= 0;
my $flagProgramme		= 0;
my $flagTalents			= 0;
my $flagBiography		= 0;
my $flagLightBiog		= 0;
open (INPUT, "<".$fileToLoad);
while (my $line = <INPUT>) {
	$line =~ s/[\n\r]//;
	if ($line =~ /BEGIN personnae/) { 
		$flagPersonnae = 1;
		$currentPersonnae = Personnae->new();
	} ## END "if ($line =~ /BEGIN personnae/)"
	if ($line =~ /END personnae/) { 
		$flagPersonnae = 0;
		if (defined $currentPersonnae) {
			push(@personnaes, $currentPersonnae);
			print $currentPersonnae->toString();
			$currentPersonnae = undef;
		} ## END "if (defined $currentPersonnae)"
	} ## END "if ($line =~ /END personnae/)"
	if ($flagPersonnae == 1) {
		if ($line =~ /^NAME (.*?)$/) 
			{ $currentPersonnae->setName($1); }
		if ($line =~ /^IMAGE (.*?)$/) 
			{ $currentPersonnae->setImage($1); }
		if ($line =~ /^TITLE (.*?)$/) 
			{ $currentPersonnae->setTitle($1); }
		if ($line =~ /^PV (.*?)$/) 
			{ $currentPersonnae->setPV($1); }
		if ($line =~ /^IMPACT (.*?)$/) 
			{ $currentPersonnae->setImpact($1); }
		if ($line =~ /^SAN (.*?)$/) 
			{ $currentPersonnae->setSAN($1); }
		if ($line =~ /^AGE (.*?)$/) 
			{ $currentPersonnae->setAge($1); }
		if ($line =~ /^SEXE (.*?)$/) 
			{ $currentPersonnae->setSexe($1); }
		if ($line =~ /^PARRAIN (.*?)$/) 
			{ $currentPersonnae->setParrain($1); }
		if ($line =~ /^ARGENT (.*?)$/) 
			{ $currentPersonnae->setArgent($1); }
		if ($line =~ /^DIVERS (.*?)$/) 
			{ $currentPersonnae->setDivers($1); }
		if ($line =~ /^METIER (.*?)$/) 
			{ $currentPersonnae->setMetier($1); }
			
		if ($line =~ /^APP (.*?)$/) 
			{ $currentPersonnae->setAPP($1); }
		if ($line =~ /^CON (.*?)$/) 
			{ $currentPersonnae->setCON($1); }
		if ($line =~ /^DEX (.*?)$/) 
			{ $currentPersonnae->setDEX($1); }
		if ($line =~ /^FOR (.*?)$/) 
			{ $currentPersonnae->setFOR($1); }
		if ($line =~ /^TAI (.*?)$/) 
			{ $currentPersonnae->setTAI($1); }
		if ($line =~ /^EDU (.*?)$/) 
			{ $currentPersonnae->setEDU($1); }
		if ($line =~ /^INT (.*?)$/) 
			{ $currentPersonnae->setINT($1); }
		if ($line =~ /^POU (.*?)$/) 
			{ $currentPersonnae->setPOU($1); }
			
		if ($line =~ /END cyberequipement/)
			{ $flagCyberEqui = 0; }
		if ($flagCyberEqui == 1) 
			{ $currentPersonnae->addCyberEquipments($line); }
		if ($line =~ /BEGIN cyberequipement/)
			{ $flagCyberEqui = 1; }

		if ($line =~ /END programmes/)
			{ $flagProgramme = 0; }
		if ($flagProgramme == 1) 
			{ $currentPersonnae->addProgrammes($line); }
		if ($line =~ /BEGIN programmes/)
			{ $flagProgramme = 1; }

		if ($line =~ /END cailloux/)
			{ $flagCailloux = 0; }
		if ($flagCailloux == 1) 
			{ $currentPersonnae->addCailloux($line); }
		if ($line =~ /BEGIN cailloux/)
			{ $flagCailloux = 1; }

		if ($line =~ /END talents/)
			{ $flagTalents = 0; }
		if ($flagTalents == 1) 
			{ $currentPersonnae->addTalents($line); }
		if ($line =~ /BEGIN talents/)
			{ $flagTalents = 1; }
			
		if ($line =~ /END lightbio/)
			{ $flagLightBiog = 0; }
		if ($flagLightBiog == 1) 
			{ $currentPersonnae->addLightBiography($line); }
		if ($line =~ /BEGIN lightbio/)
			{ $flagLightBiog = 1; }
		
		if ($line =~ /END biography/)
			{ $flagBiography = 0; }
		if ($flagBiography == 1) 
			{ $currentPersonnae->addBiography($line); }
		if ($line =~ /BEGIN biography/)
			{ $flagBiography = 1; }
		
	} ## END "if ($flagPersonnae == 1)"
}
close INPUT;

my $dirOfPersonnaeSample	= "CyberAgePlayerSample/";
my $baseNameOutputFiles		= "defaultBasePersonnae";

my @filesToCompileAsTEX = ();
foreach my $perso (@personnaes) {
	my $currentName = $perso->getName();
	print "\t {" .$currentName."}\n";
	
	my $fileTEXname = $baseNameOutputFiles.$currentName.".tex";
	$fileTEXname =~ s/[ \{\\\}\'\`\^\¨\~]//g;
	push (@filesToCompileAsTEX, $fileTEXname);
	print "\t\t {" .$fileTEXname."}\n";
	
	open (OUTPUT, ">".$dirOfPersonnaeSample.$fileTEXname);
	print OUTPUT $perso->toLaTeX();
	close OUTPUT;
} ## END "foreach my $perso (@personnaes)"

open (OUTPUT, ">".$dirOfPersonnaeSample."Makefile");
## print OUTPUT "LATEXFILE=personnae\n\n";
foreach (my $i = 0 ; $i < @filesToCompileAsTEX ; $i++) {
	my $fileTEX		= $filesToCompileAsTEX[$i];
	$fileTEX		=~ s/^(.*?).tex$/$1/g;
	my $numToShow	= (($i < 10)?"0":"").$i;
	print OUTPUT "LATEXFILE".$numToShow."=".$fileTEX."\n";
} ## END "foreach (my $i = 0 ; $i < @filesToCompileAsTEX ; $i++)"
print OUTPUT "\n";
print OUTPUT "CCPDFLA=pdflatex\n";
print OUTPUT "CCLATEX=latex\n";
print OUTPUT "CCBIBTE=bibtex\n\n";
print OUTPUT "all : pdflatex\n\n";
print OUTPUT "clean : mrproper\n";
print OUTPUT "\t# rm *.dvi\n";
print OUTPUT "\t# rm *.pdf\n\n";
## print OUTPUT "mrproper : \$(LATEXFILE).aux \$(LATEXFILE).log\n";
## print OUTPUT "\trm \$(LATEXFILE).aux\n";
## print OUTPUT "\trm \$(LATEXFILE).log\n\n";
print OUTPUT "mrproper : \n";
print OUTPUT "\trm *.aux\n";
print OUTPUT "\trm *.log\n\n";
## print OUTPUT "pdflatex : \$(LATEXFILE).tex\n";
## print OUTPUT "\t\$(CCPDFLA) \$(LATEXFILE).tex\n";
## print OUTPUT "\t\$(CCPDFLA) \$(LATEXFILE).tex\n";
## print OUTPUT "\t\$(CCPDFLA) \$(LATEXFILE).tex\n\n";
print OUTPUT "pdflatex : ";
foreach (my $i = 0 ; $i < @filesToCompileAsTEX ; $i++) {
	my $numToShow = (($i < 10)?"0":"").$i;
	print OUTPUT " \$(LATEXFILE".$numToShow.").tex";
} ## END "foreach (my $i = 0 ; $i < @filesToCompileAsTEX ; $i++)"
print OUTPUT "\n";
foreach (my $i = 0 ; $i < @filesToCompileAsTEX ; $i++) {
	my $numToShow = (($i < 10)?"0":"").$i;
	for (my $j = 0 ; $j < 3 ; $j++) 
		{ print OUTPUT "\t\$(CCPDFLA) \$(LATEXFILE".$numToShow.")\n"; }
} ## END "foreach (my $i = 0 ; $i < @filesToCompileAsTEX ; $i++)"
close OUTPUT;

chdir($dirOfPersonnaeSample);

system( "make" );
system( "make clean" );

my ($sec,$min,$hour,$mday,$mon,$year,$wday,$yday,$isdst) = localtime(time);
my $fullYear	= 1900+$year;
my $month		= $mon+1;
my $dirname		= ##$fullYear.(($month < 10)?"0":"").$month.(($mday < 10)?"0":"").$mday
					##.(($hour < 10)?"0":"").$hour.(($min < 10)?"0":"").$min.(($sec < 10)?"0":"").$sec
					##."-".
					"persoGeneratedOnBaseRandom";
mkdir($dirname);

system( "mv ".$baseNameOutputFiles."*.pdf ".$dirname."/" );
system( "rm ".$baseNameOutputFiles."*.tex" );
system( "rm Makefile" );

chdir("..");

