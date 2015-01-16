import java.util.Random;
public class charmander extends pokemon {
    Random randomNumber = new Random();
    String type = "FIRE";
    String species = "CHARMANDER";

    public charmander(String n){
	setStrength(50);
	setHealth(100);
	setSpeed(40);
	setName(n);
    }

    public charmander(){
	setStrength(50);
	setHealth(100);
	setSpeed(40);
    }

    //basics
    public void scratch(pokemon other) {	
	this.setAttackStrength(this.getStrength()/10 + randomNumber.nextInt(20)); 
	other.setDefending(true);
    }

    public void megakick(pokemon other){
	this.setAttackStrength(this.getStrength()/8 + randomNumber.nextInt(20));
	other.setDefending(true);
    }

    public void focuspunch(pokemon other){
	this.setAttackStrength(this.getStrength()/7 + randomNumber.nextInt(20));
	other.setDefending(true);
    }

    //not actual use; used when attacked, see if misses
    public void dodge(pokemon other)
    {
	other.lowerAttackStrength(this.getStrength()/9 + randomNumber.nextInt(20));
	/*	
		if (other.getAttackStrength() < 15){
		}
	*/
	other.assignDamage(this);
	
    }

    /*
    public void run (pokemon other)
    {
	boolean escape = randomNumber.nextInt(150) < this.getStrength();
	if (escape) 
	    {
		System.out.println(this.getName() + " knocked over " + other.getName() + " and fled successfully");
	    }
	else
	    {
		System.out.println("RUN failed...");
	    }
	other.setAttackStrength(0);
    }
    */
}
