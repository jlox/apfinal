import java.util.Random;
public class geodude extends pokemon {
    Random randomNumber = new Random();
    String species = "GEODUDE";

    public geodude(int n){
	setStrength(n);
	setHealth(100);
	setSpeed(40);
	setSpecies("geodude");
	setType("rock");
    }

    public geodude(){
	setStrength(50);
	setHealth(100);
	setSpeed(40);
	setSpecies("geodude");
	setType("rock");
    }
}
