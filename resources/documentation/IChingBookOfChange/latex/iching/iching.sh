#! /bin/sh
random=`date +%m%d%H%M%S`
sed s/1234/$random/ iching.tex > Iching.tex
latex Iching
