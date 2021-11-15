package BiographicElement;

use strict;

sub new {
	my $class	= shift;
	$class		= ref($class) || $class;

	my $self	= {};

	$self->{CONTENT}	= undef;
	$self->{ADDINS}		= ();

	bless($self, $class);
	return $self;
}

sub addCONTENT {
	my $self			= shift;
	my $toAdd			= shift;
	if ($self->{CONTENT} =~ /^Table (.*?)$/) 
		{ $self->{CONTENT} = "[".$1."] ".$toAdd; } 
	else { $self->{CONTENT} .= " --- ".$toAdd; }
}

sub setCONTENT {
	my $self			= shift;
	$self->{CONTENT}	= shift;
}

sub getCONTENT {
	my $self		= shift;
	return $self->{CONTENT};
}

sub addADDINS {
	my $self			= shift;
	while(@_) { push (@{$self->{ADDINS}},shift); }
}

sub getADDINS {
	my $self = shift;
	return ($self->{ADDINS})?@{$self->{ADDINS}}:();
}

sub toString {
	my $self = shift;
	my $toReturn = "";
	
	$toReturn .= $self->getCONTENT(); ## +"\n";
	my @addins = $self->getADDINS();
	my $i = 0;
	for my $element (@addins) {
		if ($i == 0) { $toReturn .= "\t{"; }
		else { $toReturn.= ";"; }
		$toReturn .= "'".$element."'";
		$i++;
		if ($i == @addins) { $toReturn.= "}"; }
	} ## END "for my $element (@addins)"
	
	$toReturn .= ""; ## "\n";
	
	return $toReturn;
}

sub getARandomElementBIOGRAPHIC {
	my $biographics = shift;
	my %biographics = %{$biographics};
	my $orientation	= $biographics{"d'Orientation"};
	my $be			= undef;
	do {
		my @content	= $orientation->getCONTENTS();
		my @addins	= $orientation->getADDINS();
		my @links	= $orientation->getLINKSTO();
		my $rand	= int(rand(@content));
		my $content	= $content[$rand];
		my $addin	= $addins[$rand];
		my $link	= $links[$rand];
		
		## print "\t'".$content."'\t'".$link."'\t'".$addin."'\n";
		
		if ( ! defined $be) { $be = new BiographicElement(); }
		$be->setCONTENT( $content );
		if ($addin ne "") { $be->addADDINS( split(';', $addin) ); }
		
		if ($link ne "") {
			if ($link eq "Cicatrices") {
				$orientation	= $biographics{ "Cicatrices-localisation" };
				@content		= $orientation->getCONTENTS();
				$rand			= int(rand(@content));
				$content		= "Cicatrice : ".$content[$rand];
				
				$orientation	= $biographics{ "Cicatrices-gravité" };
				@content		= $orientation->getCONTENTS();
				$rand			= int(rand(@content));
				$content		.= $content[$rand];
				
				$be->addCONTENT( $content );
				$orientation = undef;
			} else { $orientation = $biographics{ $link }; }
		} ## END "if ($link ne "")"
		else { $orientation = undef; }
	} while (defined $orientation);
	return $be;
}

sub getARandomElementEQUIPMENT {
	my $equipments = shift;
	my %equipments = %{$equipments};
	my $orientation	= $equipments{"Equipement"};
	my $be			= undef;
	do {
		my @content	= $orientation->getCONTENTS();
		my @addins	= $orientation->getADDINS();
		my @links	= $orientation->getLINKSTO();
		my $rand	= int(rand(@content));
		my $content	= $content[$rand];
		my $addin	= $addins[$rand];
		my $link	= $links[$rand];
		
		## print "\t'".$content."'\t'".$link."'\t'".$addin."'\n";
		
		if ( ! defined $be) { 
			$be = new BiographicElement();
			$be->setCONTENT( $content );
			if ($addin ne "") { $be->addADDINS( split(';', $addin) ); }
		} else {
			$be->addCONTENT( $content );
			if ($addin ne "") { $be->addADDINS( split(';', $addin) ); }
		}
		
		if ($link ne "") 
			{ $orientation = $equipments{ $link }; }
		else { $orientation = undef; }
	} while (defined $orientation);
	return $be;
}

sub addToGreatTalent {
	my $talents = shift;
	my %talents = %{$talents};
	my $greatTales = shift;
	my %greatTales = %{$greatTales};
	my $selection	= shift;
	my $initValue	= shift;
	my $addValues	= shift;
	my $jobOrPerso	= shift;
	
	if ( (defined $talents{$selection}) 
			&& ( ! defined $greatTales{$selection}) ) {
		my @values		= @{$talents{$selection}};
		my $initValDef	= $values[0];
		$greatTales{$selection} = $initValDef;
		print "\t\t Selected {".$selection."} setted at ".$initValDef."% (initial / base)\n";
	} ## END "if (defined $talents{$talent})"
	
	if (defined $greatTales{$selection}) {
		print "\t\t Selected {".$selection."} +".$addValues."%\n";
		$greatTales{$selection} += $addValues;
	} else { 
		print "\t\t Selected {".$selection."} setted at ".$initValue."%\n";
		$greatTales{$selection} = $initValue;
	}
	
	## if ( (defined $jobOrPerso) && ($jobOrPerso == 1) )
	## 	{ $countJobTalent += $addValues; }
	## else
	## 	{ $countPersoTalent += $addValues; }
	
}

1;
