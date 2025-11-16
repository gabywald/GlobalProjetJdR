#!/usr/bin/perl -w

use strict;
use JSON;

use POSIX qw(strftime);

## TODO get arguments from user
## DONE replacing the uppercase elements (if present) : 
##    - PERSONNAME (generate one name) ; 
##    - PERSONHANDLE (generate / find alias) ; (NOTE / TODO bug when used (show LaTeX output in console ?)
##    - COMPANYNAME (generate one name) ; 
##    - REASON (conviction / "hacks into the ..." / "refuses to ...") ; 
##    - TOTALFILESIZE (for Gigaquads) ; 

## Reading input file
sub loadNewsDatabase {
    my ($filePath) = @_;

    ## Open JSON file
    open(my $file, '<:encoding(UTF-8)', $filePath) or die "Impossible to open the file '$filePath': $!";

    ## Read File Content
    local $/ = undef;
    my $textJSON = <$file>;
    close($file);

    ## Decode JSON and return the Data Structure
    return decode_json($textJSON);
}

## To generate a random News
sub generateNews {
	my ($DBnews) = @_;
	my @newsHashArray = @{$DBnews};
	my $newsHash = @newsHashArray[int(rand(@newsHashArray))];
	
	my $completeBuildNews = "";
	
	## Add / select title
	$completeBuildNews .= selectELTinNews($newsHash, "titles")."\n";
	## Add / select content[1-5]
	$completeBuildNews .= selectELTinNews($newsHash, "content1")."\n";
	$completeBuildNews .= selectELTinNews($newsHash, "content2")."\n";
	$completeBuildNews .= selectELTinNews($newsHash, "content3")."\n";
	$completeBuildNews .= selectELTinNews($newsHash, "content4")."\n";
	$completeBuildNews .= selectELTinNews($newsHash, "content5")."\n";
	
	return replacingUpperCaseElements( $completeBuildNews );
}

sub readFileToArray {
	my $filePath = shift;
	open (INPUTT, "<".$filePath) or die "cannot access '".$filePath."' ? "; ## die $!;
	# chomp(my @array2return = <INPUTT>);
	my @array2return = ();
	while (my $line = <INPUTT>) {
		$line =~ s/[\r\n]//g;
		push (@array2return, $line);
	}
	close INPUTT;
	
	## foreach my $line (@array2return) { print $line." -- \n"; }
	## print "\n";
		
	return \@array2return;
}

sub replacingUpperCaseElements {
	my $newsTXT = shift;
	if ($newsTXT =~ /PERSONNAME/) {
		my @fornames = @{readFileToArray( "../dataUplink/fornamesMore.txt" )};
		my @surnames = @{readFileToArray( "../dataUplink/fornamesMore.txt" )};
		
		my $completename = @surnames[int(rand(@surnames))]." ".@fornames[int(rand(@fornames))];
		print $newsTXT;
		$newsTXT =~ s/PERSONNAME/$completename/g;
		print "*****".$completename."*****\n";
	}
	if ($newsTXT =~ /PERSONHANDLE/) {
		my @agentaliases = @{readFileToArray( "../dataUplink/agentaliases.txt" )};
		
		my $agentalias = "\'".@agentaliases[int(rand(@agentaliases))]."\'";
		$newsTXT =~ s/PERSONHANDLE/$agentalias/g;
		print "*****".$agentalias."*****\n";
	}
	if ($newsTXT =~ /COMPANYNAME/) {
		my @companynameA = @{readFileToArray( "../dataUplink/companya.txt" )};
		my @companynameB = @{readFileToArray( "../dataUplink/companyb.txt" )};
		
		my $companyname = @companynameA[int(rand(@companynameA))]." ".@companynameB[int(rand(@companynameB))];
		$newsTXT =~ s/COMPANYNAME/$companyname/g;
		print "*****".$companyname."*****\n";
	}
	if ($newsTXT =~ /REASON/)			{ $newsTXT =~ s/REASON/\'NO REASON\'/g; }
	if ($newsTXT =~ /TOTALFILESIZE/)	{ 
		my $value = int(rand(1000));
		$newsTXT =~ s/TOTALFILESIZE/$value/g;
	}
	return $newsTXT;
}

sub generateNewsToLaTeX {
	my ($DBnews) = @_;
	my @newsHashArray = @{$DBnews};
	my $newsHashMAIN = @newsHashArray[int(rand(@newsHashArray))];
	my $newsHash0001 = @newsHashArray[int(rand(@newsHashArray))];
	my $newsHash0002 = @newsHashArray[int(rand(@newsHashArray))];
	my $newsHash0003 = @newsHashArray[int(rand(@newsHashArray))];
	my $newsHash0004 = @newsHashArray[int(rand(@newsHashArray))];
	my $newsHash0005 = @newsHashArray[int(rand(@newsHashArray))];
	
	my $toReturn = "";
	
	$toReturn .= "\\input{../latexTemplates/template_journal_header.tex}\n\n";
	$toReturn .= "\\LARGE{\\centering \\setmainfont{Sprawl} ".selectELTinNews($newsHashMAIN, "titles")."}\n\n";
	$toReturn .= "\\begin{multicols}{2}\n\n";
	$toReturn .= "\\small\n\n";
	$toReturn .= " %% \\begin{center} { \\Huge \\setmainfont{FoglihtenDeH02} \\textbf{Q+\\_9\\_+q} } \\end{center} %% ~\\\\\n\n";
	$toReturn .= "\\textbf{".selectELTinNews($newsHashMAIN, "head")."}~\\\\\n";
	$toReturn .= "\\emph{".selectELTinNews($newsHashMAIN, "content1")."}~\\\\\n";
	$toReturn .= "".selectELTinNews($newsHashMAIN, "content2")."\n";
	$toReturn .= "".selectELTinNews($newsHashMAIN, "content3")."\n";
	$toReturn .= "".selectELTinNews($newsHashMAIN, "content4")."\n";
	$toReturn .= "".selectELTinNews($newsHashMAIN, "content5")."~\\\\\n\n";
	$toReturn .= "\\vfill~\\vfill\n\n";
	$toReturn .= "\\textbf{".selectELTinNews($newsHash0001, "titles")."}~\\\\\n";
	$toReturn .= "\\emph{".selectELTinNews($newsHash0001, "head")."}~\\\\\n";
	$toReturn .= "".selectELTinNews($newsHash0001, "content1")."~\\\\\n";
	$toReturn .= "".selectELTinNews($newsHash0001, "content2")."\n";
	$toReturn .= "".selectELTinNews($newsHash0001, "content3")."\n";
	$toReturn .= "".selectELTinNews($newsHash0001, "content4")."\n";
	$toReturn .= "".selectELTinNews($newsHash0001, "content5")."~\\\\\n\n";
	$toReturn .= "\\vfill~\\vfill\n\n";
	$toReturn .= "\\textbf{".selectELTinNews($newsHash0002, "titles")."}~\\\\\n";
	$toReturn .= "\\emph{".selectELTinNews($newsHash0002, "head")."}~\\\\\n";
	$toReturn .= "".selectELTinNews($newsHash0002, "content1")."~\\\\\n";
	$toReturn .= "".selectELTinNews($newsHash0002, "content2")."\n";
	$toReturn .= "".selectELTinNews($newsHash0002, "content3")."\n";
	$toReturn .= "".selectELTinNews($newsHash0002, "content4")."\n";
	$toReturn .= "".selectELTinNews($newsHash0002, "content5")."~\\\\\n\n";
	$toReturn .= "\\textbf{".selectELTinNews($newsHash0003, "titles")."}~\\\\\n";
	$toReturn .= "\\textbf{".selectELTinNews($newsHash0004, "titles")."}~\\\\\n";
	$toReturn .= "\\textbf{".selectELTinNews($newsHash0005, "titles")."}~\\\\\n";
	$toReturn .= "\\vfill~\\columnbreak\n\n";
	$toReturn .= "%% {\\small \\lipsum[1-3] }~\\\\\n\n";
	$toReturn .= "\\begin{center} { \\Huge \\setmainfont{FoglihtenDeH02} \\textbf{\\{1=:=!\\}} } \\end{center} %% ~\\\\\n\n";
	$toReturn .= "\\begin{center} { \\Huge \\setmainfont{FoglihtenDeH02} \\textbf{Q+\\_9\\_+q} } \\end{center} %% ~\\\\\n\n";
	$toReturn .= "\\begin{multicols}{2}\n\n";
	$toReturn .= "\\textbf{Specific Article Next}~\\\\\n\n";
	$toReturn .= "\\emph{Catchphrase Lorem Ipsum}~\\\\\n\n";
	$toReturn .= "\\lipsum[5-7]~\\\\\n\n";
	$toReturn .= "\\end{multicols}\n\n";
	$toReturn .= "{\\centering \\rule{0.34\\textwidth}{1pt} }~\\\\\n\n";
	$toReturn .= "Automatic Generated Page. \\textsc{Not real news !}~\\\\\n\\emph{News Generator} by \\textbf{Gaby Wald}~\\\\\n\n";
	$toReturn .= "\\end{multicols}\n\n";
	$toReturn .= "\\input{../latexTemplates/template_journal_footer.tex}\n\n";
	
	return replacingUpperCaseElements( $toReturn );
}

sub selectELTinNews {
	my ($newsHash, $keyToGet) = @_;
	return ( (exists $newsHash->{$keyToGet}) ? 
					@{$newsHash->{$keyToGet}}[int(rand(@{$newsHash->{$keyToGet}}))] : 
					"" ); ## "NO '".$keyToGet."' !"
}

sub generateDateYYYMMDDHHMMSS() {
	# see https://www.tutorialspoint.com/perl/perl_date_time.htm
	# my @months = qw( Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec );
	# my @days = qw(Sun Mon Tue Wed Thu Fri Sat Sun);
	# my ($sec,$min,$hour,$mday,$month,$year,$wday,$yday,$isdst) = localtime();
	# print "$mday $months[$month] $days[$wday]\n";
	# return $year.$month.$mday.$hour.$min.$sec;
	# my $datestring = strftime "%a %b %e %H:%M:%S %Y", localtime;
	return strftime "%Y%m%d%H%M%S", localtime;
}

## Usage example
my $DBnews = loadNewsDatabase('../databases/newsDataBase-starting.json');
print generateNews( $DBnews );

my $outputDIR = "generatedOutputs";
## DONE generate UUID / ID with date !
## DONE use later : my $fileTEXname = "filetobuild".generateDateYYYMMDDHHMMSS();
my $fileTEXname = "filetobuild";
open (OUTPUT, ">../".$outputDIR."/".$fileTEXname.".tex") or die "file cannot be created";
print OUTPUT generateNewsToLaTeX( $DBnews );
close OUTPUT;

## DONE Makefile && make !
open (INPUTT, "<../latexTemplates/template_Makefile") or die $!;
open (OUTPUT, ">../".$outputDIR."/Makefile") or die $!; # "file cannot be created";
print OUTPUT "LATEXFILE=".$fileTEXname;
while(<INPUTT>) { print OUTPUT $_; }
close OUTPUT;
close INPUTT;

chdir("../generatedOutputs/");
my $output = `make && make clean`;
chdir("../perl/");

## Some tests to show data !
## for my $news (@{$DBnews}) {
## 	print "\t".$news."\n";
## 	print "\t".$news->{"titles"}[0]."\n";
## 	# if ( ! exists $news->{"bolo"}) { print "\t 'bolo' IS NULL !\n"; }
## 	# if ( ! exists $news->{"head"}) { print "\t 'head' IS NULL !\n"; }
## 	if ( ! exists $news->{"content1"}) { print "\t 'content1' IS NULL !\n"; }
## 	if ( ! exists $news->{"content2"}) { print "\t 'content2' IS NULL !\n"; }
## 	if ( ! exists $news->{"content3"}) { print "\t 'content3' IS NULL !\n"; }
## 	if ( ! exists $news->{"content4"}) { print "\t 'content4' IS NULL !\n"; }
## 	if ( ! exists $news->{"content5"}) { print "\t 'content5' IS NULL !\n"; }
## 	# if ( ! exists $news->{"conclusion"}) { print "\t 'conclusion' IS NULL !\n"; }
## 	if ( ! exists $news->{"launcher"}) { print "\t 'launcher' IS NULL !\n"; }
## 	else {
## 		if ( exists $news->{"launcher"}->{"computername"}) 
## 			{ print "\t launcher/'computername [".$news->{"launcher"}->{"computername"}."] \n"; } 
## 		if ( exists $news->{"launcher"}->{"computertype"}) 
## 			{ print "\t launcher/'computertype' [".$news->{"launcher"}->{"computertype"}."] \n"; } 
## 		if ( exists $news->{"launcher"}->{"filetype"}) 
## 			{ print "\t launcher/'filetype' [".$news->{"launcher"}->{"filetype"}."] \n"; } 
## 		if ( exists $news->{"launcher"}->{"numrecentshacks"}) 
## 			{ print "\t launcher/'numrecentshacks' [".$news->{"launcher"}->{"numrecentshacks"}."] \n"; } 
## 		if ( exists $news->{"launcher"}->{"uplinkrating"}) 
## 			{ print "\t launcher/'uplinkrating' [".$news->{"launcher"}->{"uplinkrating"}."] \n"; } 
## 	}
## }

## sub ltrim { my $s = shift; $s =~ s/^\s+//;       return $s };
## sub rtrim { my $s = shift; $s =~ s/\s+$//;       return $s };
## sub  trim { my $s = shift; $s =~ s/^\s+|\s+$//g; return $s };
## use String::Util qw(trim);
## use Text::Trim qw(trim);
