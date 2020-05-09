package TarotElement;

use strict;

sub new {
	my $class = shift;
	$class = ref($class) || $class;
	
	my $self			= {};
	
	$self->{TYPE}		= 0;		## 1 for major arcana and 0 for minor arcana
	$self->{KIND}		= undef;	## Group of element ( general / NONE / Air ; Fire ; Earth ; Water )
	$self->{NAME}		= undef;
	$self->{IMGE}		= undef;

	bless ($self, $class);
	return $self;
}

sub toString {
	my $self		= shift;
	my $toReturn	= "";
	
	$toReturn		.= (($self->{TYPE} == 1)?"Major":"Minor")." Arcana -- ";
	$toReturn		.= $self->{KIND}." -- ".$self->{NAME}." -- ".$self->{IMGE};
	
	return $toReturn;
}

sub toLaTeX {
	my $self		= shift;
	my $kind1		= shift;
	my $kind2		= shift;
	my $kind3		= shift;
	my $toReturn	= "";
	
	## print "\t{".$kind1."}\t{".$kind2."}\t{".$kind3."}\t\n";
	
	my $name		= $self->{NAME};
	## (($self->{TYPE} == 1)?"Major":"Minor")." Arcana -- ";
	## $toReturn		.= $self->{KIND}." -- ".$self->{NAME}." -- ".$self->{IMGE};
	
	$toReturn		.= "\t\\doublebox{ % \\fbox{ %\\Ovalbox{%\n";
	$toReturn		.= "\t\t\\begin{tabular}[ht]{ \@{}p{1.80cm}\@{} \@{}p{1.80cm}\@{} \@{}p{1.80cm}\@{} }\n";
	$toReturn		.= "\t\t\t\\includegraphics[width=1.75cm, height=1.00cm]{"
							."../../tarotData/img/".$kind1."}\n";
	$toReturn		.= "\t\t\t\t& \\includegraphics[width=1.75cm, height=1.00cm]{../../tarotData/img/"
						.(($self->{TYPE} == 1)?"color_interrexclam.jpg":$kind2)."}\n";
	$toReturn		.= "\t\t\t\t& \\includegraphics[width=1.75cm, height=1.00cm]{"
						."../../tarotData/img/".$kind3."} \\\\\n";
	$toReturn		.= "\t\t\t\\multicolumn{3}{ \@{}c\@{} }{ \\textbf{"
						.(($self->{TYPE} == 1)?"\\small ":"\\footnotesize ").$name."} } \\\\\n";
	$toReturn		.= "\t\t\t\\multicolumn{3}{ \@{}p{5.55cm}\@{} }\n";
	$toReturn		.= "\t\t\t\t{ \\includegraphics[width=5.50cm, height=8.00cm]{../../tarotData/img/".$self->{IMGE}."} } \\\\\n";
	$toReturn		.= "\t\t\t\\multicolumn{3}{ \@{}c\@{} }{ \\textbf{"
						.(($self->{TYPE} == 1)?"\\small ":"\\footnotesize ").$name."} } \\\\\n";
	$toReturn		.= "\t\t\t\\includegraphics[width=1.75cm, height=1.00cm]{"
							."../../tarotData/img/".$kind1."}\n";
	$toReturn		.= "\t\t\t\t& \\includegraphics[width=1.75cm, height=1.00cm]{../../tarotData/img/"
						.(($self->{TYPE} == 1)?"color_interrexclam.jpg":$kind2)."}\n";
	$toReturn		.= "\t\t\t\t& \\includegraphics[width=1.75cm, height=1.00cm]{"
						."../../tarotData/img/".$kind3."} \\\\\n";
	$toReturn		.= "\t\t\\end{tabular}\n";
	$toReturn		.= "\t}";
	
	return $toReturn;
}

sub getType {
	my $self		= shift;
	return $self->{TYPE};
}

sub setType {
	my $self		= shift;
	$self->{TYPE}	= shift;
}

sub getKind {
	my $self		= shift;
	return $self->{KIND};
}

sub setKind {
	my $self		= shift;
	$self->{KIND}	= shift;
}

sub getName {
	my $self		= shift;
	return $self->{NAME};
}

sub setName {
	my $self		= shift;
	$self->{NAME}	= shift;
}

sub getImage {
	my $self		= shift;
	return $self->{IMGE};
}

sub setImage {
	my $self		= shift;
	$self->{IMGE}	= shift;
}

1;
