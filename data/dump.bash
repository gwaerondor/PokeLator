#!/bin/bash


wget "http://bulbapedia.bulbagarden.net/wiki/List_of_Chinese_Pokémon_names"
mv List_of_Chinese_Pokémon_names namelist.html
TEMPDUMPFILE=$(mktemp)
tr -d '\n' < namelist.html | perl -pe 's/<tr/\n<tr/g' > ${TEMPDUMPFILE}
TEMPTABLEFILE=$(mktemp)
grep -P '^<tr style="background:#[Ff]{3}' < ${TEMPDUMPFILE} > ${TEMPTABLEFILE}
echo [ > pokemans.json
python3 parse_names.py ${TEMPTABLEFILE} >> pokemans.json
echo ] >> pokemans.json
rm ${TEMPDUMPFILE}
rm ${TEMPTABLEFILE}
rm namelist.html
