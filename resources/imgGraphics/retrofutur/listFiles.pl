#!/usr/bin/perl -w

use strict;

my $basicDir = "resources/imgGraphics/retrofutur/";

my $outputFile = "listOfFiles.txt";

my @content = glob("*");

my $i = 0;

open (OUTPUT, ">".$outputFile);
while (@content > 0) {
	@content = reverse sort(@content);
	my $fileOrDir	= pop(@content);
	my $currentRep	= $basicDir;
	if (-d $fileOrDir) {
		chdir($fileOrDir);
		$currentRep = $fileOrDir."/";
		my @addToContent = glob("*");
		foreach my $toAdd (reverse sort @addToContent) 
			{ push (@content, $currentRep.$toAdd); }
		chdir("..");
		$currentRep = $basicDir;
	} elsif ($fileOrDir =~ /^(.*?)\.(gif|jpg|jpeg|png)$/) {
		my $toPut = (( ($i%5) == 0)?"/** ".(($i < 100)?"0":"").(($i < 10)?"0":"").$i." */":"");
		my $viewLine = "\t\t\"".$basicDir.$fileOrDir."\", \t\t".$toPut."\n";
		print $viewLine;
		print OUTPUT $viewLine;
		$i++;
	}
}
close (OUTPUT);