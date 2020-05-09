

SUBDIRS=Alternate Campagne DeBase VersionX

all : $(SUBDIRS)
	for d in $(SUBDIRS);	\
	do	\
		$(MAKE) --directory=$$d;	\
	done
	
clean : $(SUBDIRS)
	for d in $(SUBDIRS);	\
	do	\
		$(MAKE) clean --directory=$$d;	\
	done


