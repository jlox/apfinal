import java.util.Random;
public class bulbasaur extends pokemon {
    Random randomNumber = new Random();
    String type = "GRASS";
    String species = "BULBASAUR";

    public bulbasaur(String n){
	setStrength(80);
	setHealth(100);
	setSpeed(40);
	setName(n);
	setSpecies("bulbasaur");
	setType("grass");
    }
    
    public bulbasaur(){
	setStrength(80);
	setHealth(100);
	setSpeed(40);
	setSpecies("bulbasaur");
	setType("grass");
    }
    

    //basics
    public void tackle(pokemon other){
	this.setAttackStrength(this.getStrength()/5+randomNumber.nextInt(5));
	lowerAttackStrength(other.getStrength()/20 + randomNumber.nextInt(5));

	//	other.setDefending(true);
	this.assignDamage(other);
    }

    public void vinewhip(pokemon other){
	if (other.getType() == "water"){
	    this.setAttackStrength(this.getStrength()/7 + randomNumber.nextInt(20));
	} else {
	    this.setAttackStrength(this.getStrength()/10 + randomNumber.nextInt(20));
	}

	lowerAttackStrength((other.getStrength()/20) +randomNumber.nextInt(5));

	this.assignDamage(other);
	//other.setDefending(true);
    }

    public void leafstorm(pokemon other){
	if (other.getType() == "water"){
	    this.setAttackStrength(this.getStrength()/4 + 5 + randomNumber.nextInt(15));
	} else {
	    this.setAttackStrength(this.getStrength()/7 + 5 + randomNumber.nextInt(10));
	}
	lowerAttackStrength((other.getStrength()/20) +randomNumber.nextInt(5));

	this.assignDamage(other);
	//other.setDefending(true);
    }

    //not actual use; used when attacked, see if misses
    /*    public void receive(pokemon other){
	other.lowerAttackStrength(this.getStrength()/10 + randomNumber.nextInt(5));


	other.assignDamage(this);
    }
    */

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
