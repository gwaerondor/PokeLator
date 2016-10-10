#!/bin/bash

download_language_data() {
    wget "http://bulbapedia.bulbagarden.net/wiki/List_of_Chinese_Pokémon_names"
    mv List_of_Chinese_Pokémon_names namelist.html
}

dump_data_to_csv() {
    TEMPDUMPFILE=$(mktemp)
    TEMPTABLEFILE=$(mktemp)
    tr -d '\n' < namelist.html | perl -pe 's/<tr/\n<tr/g' > ${TEMPDUMPFILE}
    grep -P '^<tr style="background:#[Ff]{3}' < ${TEMPDUMPFILE} > ${TEMPTABLEFILE}
    python3 parse_names.py ${TEMPTABLEFILE} > pokemans.csv
    python3 parse_images.py ${TEMPTABLEFILE} > icons.csv
    rm ${TEMPDUMPFILE}
    rm ${TEMPTABLEFILE}
#    rm namelist.html
}

download_all_icons() {
    sed -e 's/?/q/g' < icons.csv | sed -e 's/"\(.\{3\}\)","\(.*\)"/wget \2 -O icons\/\1.png/e'
}

create_language_data() {
#    download_language_data
    dump_data_to_csv
#    download_all_icons
}

create_language_data
