package Computer;

use strict;

sub new {
	my $class	= shift;
	$class		= ref($class) || $class;

	my $self	= {};

	$self->{NAME}			= undef;
	$self->{COMPANYNAME}	= undef;
	$self->{FILETYPE	}	= undef;
	$self->{RECENTHACKS}	= 0;
	$self->{ADDINS}			= ();

	bless($self, $class);
	return $self;
}

sub setNAME {
	my $self		= shift;
	$self->{NAME}	= shift;
}

sub getNAME {
	my $self		= shift;
	return $self->{NAME};
}

sub setCOMPANYNAME {
	my $self		= shift;
	$self->{COMPANYNAME}	= shift;
}

sub getCOMPANYNAME {
	my $self		= shift;
	return $self->{COMPANYNAME};
}

sub setFILETYPE {
	my $self		= shift;
	$self->{FILETYPE}	= shift;
}

sub getFILETYPE {
	my $self		= shift;
	return $self->{FILETYPE};
}

sub addRECENTHACKS {
	my $self		= shift;
	$self->{RECENTHACKS}	+= 1;
}

sub countZeroRECENTHACKS {
	my $self		= shift;
	$self->{RECENTHACKS}	= 0;
}

sub getRECENTHACKS {
	my $self		= shift;
	return $self->{RECENTHACKS};
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
	
	$toReturn .= $self->getNAME();
	$toReturn .= $self->getCOMPANYNAME();
	$toReturn .= $self->getRECENTHACKS();
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

1;
