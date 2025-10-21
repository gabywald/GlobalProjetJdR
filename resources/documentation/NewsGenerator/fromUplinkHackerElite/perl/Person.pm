package Computer;

use strict;

sub new {
	my $class	= shift;
	$class		= ref($class) || $class;

	my $self	= {};

	$self->{NAME}			= undef;
	$self->{HANDLE}			= undef;

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

sub setHANDLE {
	my $self		= shift;
	$self->{HANDLE}	= shift;
}

sub getHANDLE {
	my $self		= shift;
	return $self->{HANDLE};
}

sub toString {
	my $self = shift;
	my $toReturn = "";
	
	$toReturn .= $self->getNAME();
	$toReturn .= $self->getHANDLE();
	
	return $toReturn;
}

1;
