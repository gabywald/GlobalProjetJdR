
## naming WITHOUT the extensions [.tex] or [.bib]
LATEXFILE=document

## the local software...
CCPDFLA=pdflatex
CCLATEX=latex
CCPDFTE=dvipdf
CCPSTEX=dvips

all : pdflatex

pdf : $(LATEXFILE).dvi
	$(CCPDFTE) $(LATEXFILE).dvi

ps : $(LATEXFILE).dvi
	$(CCPSTEX) $(LATEXFILE).dvi

clean : $(LATEXFILE).log mrproper
	rm $(LATEXFILE).log

mrproper : $(LATEXFILE).aux $(LATEXFILE).toc
	rm $(LATEXFILE).aux
	## rm $(LATEXFILE).bbl
	## rm $(LATEXFILE).blg
	rm $(LATEXFILE).toc

$(LATEXFILE).dvi : $(LATEXFILE).tex
	$(CCLATEX) $(LATEXFILE).tex
	$(CCLATEX) $(LATEXFILE).tex
	$(CCLATEX) $(LATEXFILE).tex

pdflatex : $(LATEXFILE).tex
	$(CCPDFLA) $(LATEXFILE).tex
	$(CCPDFLA) $(LATEXFILE).tex
	$(CCPDFLA) $(LATEXFILE).tex
