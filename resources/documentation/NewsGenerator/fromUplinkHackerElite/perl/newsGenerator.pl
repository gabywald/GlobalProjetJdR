#!/usr/bin/perl -w

use strict;
use JSON;

## TODO get arguments from user
## TODO replacing the uppercase elements (if present) : 
##    - PERSONNAME (generate one name) ; 
##    - PERSONHANDLE (generate / find alias) ; 
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
	$completeBuildNews .= selectELTinNews($newsHash, "titles");
	## Add / select content[1-5]
	$completeBuildNews .= selectELTinNews($newsHash, "content1");
	$completeBuildNews .= selectELTinNews($newsHash, "content2");
	$completeBuildNews .= selectELTinNews($newsHash, "content3");
	$completeBuildNews .= selectELTinNews($newsHash, "content4");
	$completeBuildNews .= selectELTinNews($newsHash, "content5");
	
	return $completeBuildNews;
}

sub generateNewsToLaTeX {
	my ($DBnews) = @_;
	my @newsHashArray = @{$DBnews};
	my $newsHash = @newsHashArray[int(rand(@newsHashArray))];
	
	my $toReturn = "";
	
	$toReturn .= "\\input{../latexTemplates/template_journal_header.tex}\n\n";
	$toReturn .= "\\large{\\centering \\setmainfont{Sprawl} ".selectELTinNews($newsHash, "titles")."}\n\n";
	$toReturn .= "\\begin{multicols}{2}\n\n";
	$toReturn .= "\\small\n\n";
	$toReturn .= "{\\centering \\Huge \\setmainfont{FoglihtenDeH02} \\textbf{Q+\\_9\\_+q} }~\\\\\n\n";
	$toReturn .= "\\textbf{".selectELTinNews($newsHash, "head")."}~\\\\\n\n";
	$toReturn .= "\\emph{".selectELTinNews($newsHash, "content1")."}~\\\\\n\n";
	$toReturn .= "".selectELTinNews($newsHash, "content2")."\n\n";
	$toReturn .= "".selectELTinNews($newsHash, "content3")."\n\n";
	$toReturn .= "".selectELTinNews($newsHash, "content4")."\n\n";
	$toReturn .= "".selectELTinNews($newsHash, "content5")."\n\n";
	$toReturn .= "\\vfill~\\columnbreak\n\n";
	$toReturn .= "%% {\\small \\lipsum[1-3] }~\\\\\n\n";
	$toReturn .= "{\\centering \\Huge \\setmainfont{FoglihtenDeH02} \\textbf{\\{1=:=!\\}} }~\\\\\n\n";
	$toReturn .= "\\begin{multicols}{2}\n\n";
	$toReturn .= "\\textbf{Specific Article 1}~\\\\\n\n";
	$toReturn .= "\\emph{Some Catch about Lorem Ipsum}~\\\\\n\n";
	$toReturn .= "\\lipsum[5-7]~\\\\\n\n";
	$toReturn .= "\\end{multicols}\n\n";
	$toReturn .= "{\\centering \\rule{0.34\textwidth}{1pt} }~\\\\\n\n";
	$toReturn .= "\\end{multicols}\n\n";
	$toReturn .= "\\input{../latexTemplates/template_journal_footer.tex}\n\n";
	
	return $toReturn;
}

sub selectELTinNews {
	my ($newsHash, $keyToGet) = @_;
	return ( (exists $newsHash->{$keyToGet}) ? 
					@{$newsHash->{$keyToGet}}[int(rand(@{$newsHash->{$keyToGet}}))] : 
					"" )."\n"; ## "NO '".$keyToGet."' !"
}

## Usage example
my $DBnews = loadNewsDatabase('../databases/newsDataBase-starting.json');
print generateNews( $DBnews );

my $outputDIR = "generatedOutputs";
my $fileTEXname = "filetobuild.tex"; ## TODO generate UUID / ID with date !
open (OUTPUT, ">../".$outputDIR."/".$fileTEXname) or die "file cannot be created";
print OUTPUT generateNewsToLaTeX( $DBnews );
close OUTPUT;


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
