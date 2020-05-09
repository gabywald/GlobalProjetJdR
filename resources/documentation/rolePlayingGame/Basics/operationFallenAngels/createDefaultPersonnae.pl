#!/usr/bin/perl -w

use strict;

my $outputFile="defaultPersonnae.txt";

open (OUTPUT, ">".$outputFile);
print OUPUT "";
close OUPUT;

my $command = 0;

do {
	print "\tSelect what to do : \n";
	print "\t--------------------\n";
	print "\t0 : exit ...........\n";
	print "\t1 : create new perso\n";
	print "\t--------------------\n";

	$command = <STDIN>;
	chomp($command);
	if ($command eq "") 
		{ $command = 0; }
	print "\t => [".$command."]\n";
	if ($command == 1) {
		print "\tName ? ";
		my $name = <STDIN>;
		chomp($name);
		my ($APP, $CON, $DEX, $FOR, $TAI, $EDU, $INT, $POU);
		my $confirm = 1;
		do {
			$APP = &launchD6(3);
			$CON = &launchD6(3);
			$DEX = &launchD6(3);
			$FOR = &launchD6(3);
			$TAI = &launchD6(2, 6);
			$EDU = &launchD6(3, 6);
			$INT = &launchD6(2, 6);
			$POU = &launchD6(3);
			
			$APP = (($APP < 6)?6:$APP);
			$CON = (($CON < 6)?6:$CON);
			$DEX = (($DEX < 6)?6:$DEX);
			$FOR = (($FOR < 6)?6:$FOR);
			$TAI = (($TAI < 6)?6:$TAI);
			$EDU = (($EDU < 6)?6:$EDU);
			$INT = (($INT < 6)?6:$INT);
			$POU = (($POU < 6)?6:$POU);
			
			print "\t APP => [".$APP."]\n";
			print "\t CON => [".$CON."]\n";
			print "\t DEX => [".$DEX."]\n";
			print "\t FOR => [".$FOR."]\n";
			print "\t TAI => [".$TAI."]\n";
			print "\t EDU => [".$EDU."]\n";
			print "\t INT => [".$INT."]\n";
			print "\t POU => [".$POU."]\n";

			print "\t OK [y/n] ?????";
			$confirm = <STDIN>;
			chomp($confirm);
			print "\t\t[".$confirm."]\n";
			if ( (defined $confirm) && ( ($confirm eq "") || ($confirm eq "y") ) )
				{ $confirm = 0; }
			else { $confirm = 1; }
		} while ($confirm == 1);
		my ($prestance, $endurance, $agilite, $puissance, $corpulence, $connaissance, $intuition, $volonte);
		$prestance		= $APP * 5; $prestance		= (($prestance < 10)?"0":"").$prestance;
		$endurance		= $CON * 5; $endurance		= (($endurance < 10)?"0":"").$endurance;
		$agilite		= $DEX * 5; $agilite		= (($agilite < 10)?"0":"").$agilite;
		$puissance		= $FOR * 5; $puissance		= (($puissance < 10)?"0":"").$puissance;
		$corpulence		= $TAI * 5; $corpulence		= (($corpulence < 10)?"0":"").$corpulence;
		$connaissance		= $EDU * 5; $connaissance	= (($connaissance < 10)?"0":"").$connaissance;
		$intuition		= $INT * 5; $intuition		= (($intuition < 10)?"0":"").$intuition;
		$volonte		= $POU * 5; $volonte		= (($volonte < 10)?"0":"").$volonte;
		
		my $aplomb			= 0;
		my $santeMentale	= $POU * 5;
		my $pointsDeVie		= int( ($CON + $TAI) / 2 ) + 1;
		my $seuilBlessure	= int( $pointsDeVie / 2);
		my $pointsDeMagie	= $POU;
		my $impact		= ($FOR + $TAI);
		if ( ($impact >=  2) && ($impact <= 12) ) { $impact = "-4"; }
		if ( ($impact >= 13) && ($impact <= 16) ) { $impact = "-2"; }
		if ( ($impact >= 17) && ($impact <= 24) ) { $impact = " 0"; }
		if ( ($impact >= 25) && ($impact <= 32) ) { $impact = "+2"; }
		if ( ($impact >= 33) && ($impact <= 40) ) { $impact = "+4"; }

		my @content = ();
		push (@content, "\t\\[Portrait\\]~\\\\\n");
		push (@content, "\t\\textbf{\\Large ".$name."...}~\\\\\n\n");
		push (@content, "\t\\begin{tabular}[c]{ p{1.75cm} p{0.75cm} p{1.75cm} p{0.75cm} }\n");
		push (@content, "\t\t\\FRdefCharacterSkillsAPP	& \\dotfill ".$APP." & \\FRdefCharacterSkillsPES & \\dotfill ".$prestance." \\%	\\\\\n");
		push (@content, "\t\t\\FRdefCharacterSkillsCON	& \\dotfill".$CON." & \\FRdefCharacterSkillsSTA & \\dotfill ".$endurance." \\%	\\\\\n");
		push (@content, "\t\t\\FRdefCharacterSkillsDEX	& \\dotfill ".$DEX." & \\FRdefCharacterSkillsAGI & \\dotfill ".$agilite." \\%	\\\\\n");
		push (@content, "\t\t\\FRdefCharacterSkillsPOW	& \\dotfill ".$FOR." & \\FRdefCharacterSkillsPUI & \\dotfill ".$puissance." \\%	\\\\\n");
		push (@content, "\t\t\\FRdefCharacterSkillsTAI	& \\dotfill ".$TAI." & \\FRdefCharacterSkillsCOR & \\dotfill ".$corpulence." \\%	\\\\\n");
		push (@content, "\t\t\\FRdefCharacterSkillsEDU	& \\dotfill ".$EDU." & \\FRdefCharacterSkillsKNO & \\dotfill ".$connaissance." \\%	\\\\\n");
		push (@content, "\t\t\\FRdefCharacterSkillsINT	& \\dotfill ".$INT." & \\FRdefCharacterSkillsIUI & \\dotfill ".$intuition." \\%	\\\\\n");
		push (@content, "\t\t\\FRdefCharacterSkillsPOU	& \\dotfill ".$POU." & \\FRdefCharacterSkillsVOL & \\dotfill ".$volonte." \\%	\\\\\n");
		push (@content, "\t\\end{tabular}~\\\\\n\n");
		
		push (@content, "\t Aplomb : ".$aplomb."~\\\\\n");
		push (@content, "\t SAN : ".$santeMentale."~\\\\\n");
		push (@content, "\t Points de Vie : ".$pointsDeVie."~\\\\\n");
		push (@content, "\t Seuil Blessure : ".$seuilBlessure."~\\\\\n");
		push (@content, "\t Points de Magie : ".$pointsDeMagie."~\\\\\n");
		push (@content, "\t Impact : ".$impact."~\\\\\n\n\n");
		
		push (@content, "\t\\textbf{Comp{\\'e}tences}~\\\\\n");
		push (@content, "\t\tr{\\'e}partir ".($EDU * 20)." dans les competences metiers (une {\\`a} 60\\% et +)~\\\\\n\n\n");
		push (@content, "\t\tr{\\'e}partir ".($INT * 10)." dans les competences int{\\'e}r{\\^e}t personnel~\\\\\n\n\n");
		push (@content, "\t\\textbf{Langues}~\\\\\n\n\n");
		push (@content, "\t\\textbf{Description}~\\\\\n\n\n");
		push (@content, "\t\\vfill\n");
		push (@content, "\t\\columnbreak\n\n\n");
		
		open(OUTPUT, ">>".$outputFile);
		foreach my $line (@content)
			{ print OUTPUT $line; }
		close(OUTPUT);

	} ## END "if ($command == 1)"
} while($command != 0);


sub launchD6 {
	my $numberOfTimes	= shift;
	my $whatToAdd		= shift;
	if ( ( ! defined $numberOfTimes) || ($numberOfTimes <= 0) )
		{ $numberOfTimes = 1; }
	if ( ! defined $whatToAdd) 
		{ $whatToAdd = 0; }
	my $toReturn = 0;
	for (my $i = 0 ; $i < $numberOfTimes ; $i++)
		{ $toReturn += int(rand(6)); }
	$toReturn += $whatToAdd;
	return $toReturn;
}
