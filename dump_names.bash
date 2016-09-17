#!/bin/bash

w3m -dump -cols 10000 http://bulbapedia.bulbagarden.net/wiki/List_of_Chinese_Pokémon_names > /tmp/pokemans_dump.txt
cd /mnt/e/PokeLator/
echo "Number English Trad Simp HK" > pokemans.txt
cat /tmp/pokemans_dump.txt | grep -E '^[0-9]{3}\s' | awk '{ print $1 " " $3 " " $4 " " $5 " " $6 }' >> pokemans.txt
cd -
