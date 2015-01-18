import java.util.Random;
public class squirtle extends pokemon {
    Random randomNumber = new Random();
    String species = "SQUIRTLE";

    public squirtle(String n){
	setStrength(50);
	setHealth(100);
	setSpeed(40);
	setName(n);
	setType("water");
	setSpecies("squirtle");
    }

    public squirtle(){
	setStrength(50);
	setHealth(100);
	setSpeed(40);
	setType("water");
	setSpecies("squirtle");
    }

    //basics
    public void tackle(pokemon other){
	this.setAttackStrength(this.getStrength()/5 + randomNumber.nextInt(5)); 
	lowerAttackStrength((other.getStrength()/20) +randomNumber.nextInt(5));
	this.assignDamage(other);
    }

    public void watergun(pokemon other){
	if (other.getType() == "fire"){
	    this.setAttackStrength(this.getStrength()/7 + randomNumber.nextInt(20));
	} else {
	    this.setAttackStrength(this.getStrength()/10 + randomNumber.nextInt(20));
	}


	lowerAttackStrength((other.getStrength()/20) +randomNumber.nextInt(5));
	this.assignDamage(other);
    }

    public void waterspout(pokemon other){
	if (other.getType() == "fire"){
	    this.setAttackStrength(this.getStrength()/3+ 5 + randomNumber.nextInt(15));
	} else {
	    this.setAttackStrength(this.getStrength()/7 + randomNumber.nextInt(10));
	}

	lowerAttackStrength((other.getStrength()/20) +randomNumber.nextInt(5));
	this.assignDamage(other);
    }


    /*
    public void run (pokemon other){
	boolean escape = randomNumber.nextInt(150) < this.getStrength();
	if (escape) {
	    System.out.println(this.getName() + " knocked over " + other.getName() + " and fled successfully");
	} else {
	    System.out.println("RUN failed...");
	}
	other.setAttackStrength(0);
    }
    */
}
