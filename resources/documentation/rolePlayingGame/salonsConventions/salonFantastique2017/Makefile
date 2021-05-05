
## naming WITHOUT the extensions [.tex] or [.bib]
LATEXFILEDG=documentPubliciteDeltaGreen
LATEXFILECA=documentPubliciteCyberAge

## the local software...
CCPDFLA=pdflatex
CCLATEX=latex
CCBIBTE=bibtex
CCPDFTE=dvipdf
CCPSTEX=dvips

all : pdflatex


clean : $(LATEXFILEDG).log $(LATEXFILECA).log mrproper
	rm $(LATEXFILEDG).log
	rm $(LATEXFILECA).log

mrproper : $(LATEXFILEDG).aux $(LATEXFILECA).aux 
	rm $(LATEXFILEDG).aux
	rm $(LATEXFILECA).aux

pdflatex : $(LATEXFILEDG).tex $(LATEXFILECA).tex
	$(CCPDFLA) $(LATEXFILEDG).tex
	$(CCPDFLA) $(LATEXFILEDG).tex
	$(CCPDFLA) $(LATEXFILEDG).tex
	$(CCPDFLA) $(LATEXFILECA).tex
	$(CCPDFLA) $(LATEXFILECA).tex
	$(CCPDFLA) $(LATEXFILECA).tex
