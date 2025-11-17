
## naming WITHOUT the extensions [.tex] or [.bib]
LATEXFILE=GrandLivreJdRparGW
BIBTEFILE=GrandLivreJdRparGW
# BIBTEFILE1=agenceTownsendJdR
# BIBTEFILE2=arcanesJdR
# BIBTEFILE3=giscardpunkBetonJdR

## the local software...
CCLUAXE=xelatex
CCLUALA=lualatex
CCPDFLA=pdflatex
CCLATEX=latex
CCBIBTE=bibtex
CCPDFTE=dvipdf
CCPSTEX=dvips

all : pdflatex

pdf : $(LATEXFILE).dvi
	$(CCPDFTE) $(LATEXFILE).dvi

ps : $(LATEXFILE).dvi
	$(CCPSTEX) $(LATEXFILE).dvi

clean : $(LATEXFILE).log mrproper
	rm $(LATEXFILE).log
	# rm $(LATEXFILE).lot
	# rm $(LATEXFILE).lof
	# rm $(LATEXFILE).dvi
	# rm $(LATEXFILE).pdf

mrproper : $(LATEXFILE).aux $(LATEXFILE).bbl $(LATEXFILE).blg $(LATEXFILE).toc
	rm $(LATEXFILE).aux
	rm $(LATEXFILE).bbl
	rm $(LATEXFILE).blg
	rm $(LATEXFILE).toc

$(LATEXFILE).dvi : $(LATEXFILE).tex $(BIBTEFILE).bib # $(BIBTEFILE1).bib $(BIBTEFILE2).bib $(BIBTEFILE3).bib
	$(CCLATEX) $(LATEXFILE).tex
	$(CCBIBTE) $(BIBTEFILE)
	$(CCLATEX) $(LATEXFILE).tex
	$(CCLATEX) $(LATEXFILE).tex
	$(CCLATEX) $(LATEXFILE).tex

pdflatex : $(LATEXFILE).tex $(BIBTEFILE).bib # $(BIBTEFILE1).bib $(BIBTEFILE2).bib $(BIBTEFILE3).bib
	$(CCPDFLA) $(LATEXFILE).tex
	$(CCBIBTE) $(BIBTEFILE)
	$(CCPDFLA) $(LATEXFILE).tex
	$(CCPDFLA) $(LATEXFILE).tex
	$(CCPDFLA) $(LATEXFILE).tex
