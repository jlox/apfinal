import java.util.Random;
public class pidgey extends pokemon {
    Random randomNumber = new Random();
    String species = "PIDGEY";

    public pidgey(int n){
	setStrength(n);
	setHealth(100);
	setSpeed(40);
	setSpecies("pidgey");
	setType("normal");
    }

    public pidgey(){
	setStrength(50);
	setHealth(100);
	setSpeed(40);
	setSpecies("pidgey");
	setType("normal");
    }
}
