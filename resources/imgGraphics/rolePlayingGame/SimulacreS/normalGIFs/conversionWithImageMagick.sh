
## images "*2.gif" comes from [ http://mtgshin.free.fr/Simulacres/ ]

for  f in *2.gif; do convert -alpha off $f ${f%2.gif}1.gif;done;
for  f in *1.gif; do convert $f ${f%1.gif}.png;done;
for f in *.png;do convert -resize 40x40 $f $f; done;
mv *.png ../normal40x40/