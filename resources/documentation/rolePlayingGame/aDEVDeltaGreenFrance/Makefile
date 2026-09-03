
## naming WITHOUT the extensions [.tex] or [.bib]
LATEXFILE=DeltaGreenFrance
# BIBTEFILE=DeltaGreenFrance

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
	rm $(LATEXFILE).out
	# rm $(LATEXFILE).lot
	# rm $(LATEXFILE).lof
	# rm $(LATEXFILE).dvi
	# rm $(LATEXFILE).pdf

mrproper : $(LATEXFILE).toc $(LATEXFILE).aux # $(LATEXFILE).bbl $(LATEXFILE).blg 
	rm $(LATEXFILE).aux
	# rm $(LATEXFILE).bbl
	# rm $(LATEXFILE).blg
	rm $(LATEXFILE).toc

$(LATEXFILE).dvi : $(LATEXFILE).tex # $(BIBTEFILE1).bib 
	# $(CCLATEX) $(LATEXFILE).tex
	# $(CCBIBTE) $(BIBTEFILE)
	$(CCLATEX) $(LATEXFILE).tex
	$(CCLATEX) $(LATEXFILE).tex
	$(CCLATEX) $(LATEXFILE).tex

pdflatex : $(LATEXFILE).tex # $(BIBTEFILE1).bib 
	# $(CCPDFLA) $(LATEXFILE).tex
	# $(CCBIBTE) $(BIBTEFILE)
	$(CCPDFLA) $(LATEXFILE).tex
	$(CCPDFLA) $(LATEXFILE).tex
	$(CCPDFLA) $(LATEXFILE).tex
