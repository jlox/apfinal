import java.util.*;
import java.io.*;

public class driver {

    public static void main(String[] args){
	bulbasaur b1 = new bulbasaur();
	charmander c1 = new charmander();
	squirtle s1 = new squirtle();

	bulbasaur wildbulb1 = new bulbasaur();
	charmander wildchar1 = new charmander();
	pikachu wildpika1 = new pikachu();
	squirtle wildsqui1 = new squirtle();
	ArrayList<pokemon> wildpoke = new ArrayList<pokemon>();

	pokemon[] party = new pokemon[6];

	if (1 < 2){
	    party[0] = s1;
	}
	party[1] = b1;
	party[2] = c1;

	pokemon currentPoke;
	int pokenum = 0;

	
	currentPoke = party[pokenum];
	
	System.out.println(currentPoke.getSpecies());

	
	
    }
}
