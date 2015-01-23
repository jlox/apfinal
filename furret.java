import java.util.Random;
public class furret extends pokemon {
    Random randomNumber = new Random();
    String species = "FURRET";

    public furret(int n){
	setStrength(n);
	setHealth(100);
	setSpeed(40);
	setSpecies("furret");
	setType("normal");
    }

    public furret(){
	setStrength(50);
	setHealth(100);
	setSpeed(40);
	setSpecies("furret");
	setType("normal");
    }
}
