
SUBDIRS=globalAsBook
#saison1 saison2

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

cleanpdf : $(SUBDIRS)
	for d in $(SUBDIRS);	\
	do	\
		$(MAKE) cleanpdf --directory=$$d;	\
	done
