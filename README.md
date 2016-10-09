#The Pokélator
Pokémon Sun and Moon will finally include the options to play the game in Chinese!
For those of us who grew up with the English Pokémon names, there will be an initial hurdle to overcome to learn the more-than-seven-hundred names in a new language.

This tool, when finished, will help with that.
It has a simple interface with a search box, and a box with search results in each language.

Anything can be entered into the search box. If there is a hit in the Pokédex number, English name, name in simplified Chinese or in traditional Chinese, the hits will be listed showing each of those fields. Partial hits will also be shown.

The cantonese names used in Hong Kong are also included, even though they will unfortunately not be in the officially translated versions of the games.

# Running the tool
The tool is written in Java. No standalone executable exists yet, as the tool is not finished.
Java will be the only requirement.

# Current status
## Done
* Searching
* Importing the name database into the program
* GUI listening to typing events so it can update hits in real time
* Dumping the name database from Bulbapedia.

## Kind of done
* GUI (Cannot be resized at the moment, I turned it off because I couldn't get the components to scale properly)

## Not done
* Nicer representation of languages, maybe with flag icons.

## Maybe in the future
* Clickable results that will bring up additional information about the selected pokémon (pokédex entries in the different languages, pinyin, jyutping)
* Adding a searchable database of move names that works much the same as the monster name database.
* Separate the search logic from the GUI thread
* Android app