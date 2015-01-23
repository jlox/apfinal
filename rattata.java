import java.util.Random;
public class rattata extends pokemon {
    Random randomNumber = new Random();
    String species = "RATTATA";

    public rattata(int n){
	setStrength(n);
	setHealth(100);
	setSpeed(40);
	setSpecies("rattata");
	setType("normal");
    }

    public rattata(){
	setStrength(50);
	setHealth(100);
	setSpeed(40);
	setSpecies("rattata");
	setType("normal");
    }
}
