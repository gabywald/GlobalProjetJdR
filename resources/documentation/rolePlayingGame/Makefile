
SUBDIRS=background Basic/models divnet GURPS/models retrofutur SimulacreS/models SimulacreS/cyberAge/dataLaTeX SimulacreS/cyberAge/encyclopaedia

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


