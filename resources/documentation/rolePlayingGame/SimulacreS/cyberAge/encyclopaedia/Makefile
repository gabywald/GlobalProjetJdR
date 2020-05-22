
## naming WITHOUT the extensions [.tex] or [.bib]
LATEXFILE=document

## the local software...
CCPDFLA=pdflatex
CCINDEX=makeindex
CCLATEX=latex
CCBIBTE=bibtex
CCPDFTE=dvipdf
CCPSTEX=dvips

all : pdflatex

pdf : $(LATEXFILE).dvi
	$(CCPDFTE) $(LATEXFILE).dvi

ps : $(LATEXFILE).dvi
	$(CCPSTEX) $(LATEXFILE).dvi

clean : mrproper
	# rm $(LATEXFILE).dvi
	# rm $(LATEXFILE).pdf

mrproper : $(LATEXFILE).aux $(LATEXFILE).log $(LATEXFILE).toc $(LATEXFILE).idx $(LATEXFILE).ilg $(LATEXFILE).ind $(LATEXFILE).bbl $(LATEXFILE).blg
	rm $(LATEXFILE).aux
	rm $(LATEXFILE).log
	rm $(LATEXFILE).toc
	rm $(LATEXFILE).idx
	rm $(LATEXFILE).ilg
	rm $(LATEXFILE).ind
	rm $(LATEXFILE).bbl
	rm $(LATEXFILE).blg
	rm $(LATEXFILE).out

$(LATEXFILE).dvi : $(LATEXFILE).tex
	$(CCLATEX) $(LATEXFILE).tex
	$(CCLATEX) $(LATEXFILE).tex
	$(CCLATEX) $(LATEXFILE).tex

pdflatex : $(LATEXFILE).tex
	$(CCPDFLA) $(LATEXFILE).tex
	$(CCINDEX) -s $(LATEXFILE).ist $(LATEXFILE).idx
	$(CCBIBTE) $(LATEXFILE)
	$(CCPDFLA) $(LATEXFILE).tex
	$(CCPDFLA) $(LATEXFILE).tex
