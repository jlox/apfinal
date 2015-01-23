apfinal
=======

  ___________________________________________
~/*** AP CS Term 1 Final Project Description ***\~
 _____________________________________________

 At first, Jeanne and I decided to create an ASCII-based pokemon
 clone within the terminal, but later decided to


  ___________________________________________
~/*** AP CS Term 1 Final Project Checklist ***\~
 _____________________________________________

Required:
- 2d array
- pokemon
- variables for direction
- create maps
- create trainers
- create like 10~ pokemon
- array for pokemon party


Stuff to add to basechar:
- pokedex
- pokemon party
- bag/inventory
- save

Stuff to add to pokemon:
- level up
- pokemon moves
- name
- HP
- Experience
- Boolean for level/move requirement *
- arrayList for moves; once you hit certain level, adds move name to arraylist
  and you can use it

Division of work:

 /Jeanne:
> basechar for actual character
> Driver.java
> figure out colors

 /Derrick:
> base pokemon class
> extensions of pokemon class (individual pokemon)
> inventory

/Together:
> figure out ascii field thing
> how to have screen update?

1/7/2015
=======
- Added new pokemons, created maps (arrays and 2d arrays that hold them), figured out how to "connect" maps so that you can move from one to another
- Gui works more; added text component
- Created functions that add arrays to make maps

1/9/2015
=======
- Edited pokemon files, added more attacks
- Worked on map, added lab interior
- Worked on guimon.java, added dynamic input dialogue box

1/10/2015
======
- Dialogue box changes, added "OK" button to continue dialogue
- Input box now can change based on situation (ex. name of char, name of rival, pokemon you want to choose, etc.)

1/11/2015
=======
- Started working on battle sequences
- Making battle sequence into two parts, yourTurn and enemyTurn

1/15/2015
=======
- Jeanne - worked on battle function (yourTurn) in guimon.java, added dialogue.
- Derrick - set up booleans, etc. needed in battle functions
- Created wildpokemon ArrayList

1/22/2015
=======
- Derrick - fixed up Battle functionality, added heal method
- Jeanne - added pokemon files, added more maps, worked on adapting enemy strength to own
     NEED TO FIX:
  	  - need to make wild pokemon weaker (from constructor)
	  - need to fix checkDeath()
	  - user should teleport back to a Pokemon center after death
	  - squirtle cannot attack bulbasaur or vice versa
