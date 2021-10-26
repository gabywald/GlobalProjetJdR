
## naming WITHOUT the extensions [.tex] or [.bib]
LATEXFILEONE=anonymousTract1
LATEXFILETWO=anonymousTract2

## the local software...
CCPDFLA=pdflatex
CCLATEX=latex
CCPDFTE=dvipdf
CCPSTEX=dvips

all : pdflatex

pdf : $(LATEXFILEONE).dvi $(LATEXFILETWO).dvi
	$(CCPDFTE) $(LATEXFILEONE).dvi
	$(CCPDFTE) $(LATEXFILETWO).dvi

ps : $(LATEXFILEONE).dvi $(LATEXFILETWO).dvi
	$(CCPSTEX) $(LATEXFILEONE).dvi
	$(CCPSTEX) $(LATEXFILETWO).dvi

clean : mrproper
	rm $(LATEXFILEONE).log
	rm $(LATEXFILETWO).log

mrproper : $(LATEXFILEONE).aux $(LATEXFILETWO).aux
	rm $(LATEXFILEONE).aux
	rm $(LATEXFILETWO).aux
	

$(LATEXFILEONE).dvi : $(LATEXFILEONE).tex
	$(CCLATEX) $(LATEXFILEONE).tex
	$(CCLATEX) $(LATEXFILEONE).tex
	$(CCLATEX) $(LATEXFILEONE).tex
	
$(LATEXFILETWO).dvi : $(LATEXFILETWO).tex
	$(CCLATEX) $(LATEXFILETWO).tex
	$(CCLATEX) $(LATEXFILETWO).tex
	$(CCLATEX) $(LATEXFILETWO).tex

pdflatex : $(LATEXFILEONE).tex $(LATEXFILETWO).tex
	$(CCPDFLA) $(LATEXFILEONE).tex
	$(CCPDFLA) $(LATEXFILEONE).tex
	$(CCPDFLA) $(LATEXFILEONE).tex
	$(CCPDFLA) $(LATEXFILETWO).tex
	$(CCPDFLA) $(LATEXFILETWO).tex
	$(CCPDFLA) $(LATEXFILETWO).tex

