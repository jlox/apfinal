import java.util.Random;
public class pikachu extends pokemon{
    Random randomNumber = new Random();
    String type = "ELECTRIC";
    String species = "PIKACHU";

    public pikachu(String n){
	setStrength(50);
	setHealth(100);
	setSpeed(40);
	setName(n);
    }

    //basics
    public void headbutt(pokemon other){
	this.setAttackStrength(this.getStrength()/10 + randomNumber.nextInt(20));
	System.out.println(this.getName() + " HEADBUTTS " +other);
	other.setDefending(true);
    }

    public void voltswitch(pokemon other){
	this.setAttackStrength(this.getStrength()/9 + randomNumber.nextInt(20));
	System.out.println(this.getName() + " USES VOLT SWITCH ON " +other);
	other.setDefending(true);
    }

    public void thunder(pokemon other){
	this.setAttackStrength(this.getStrength()/7 + randomNumber.nextInt(20));
	System.out.println(this.getName() + " USES THUNDER ON " +other);
	other.setDefending(true);
    }

    public void dodge(pokemon other){
	other.lowerAttackStrength(this.getStrength()/9 + randomNumber.nextInt(20));
	if (other.getAttackStrength() < 15){
	    System.out.println(this.getName() + " DODGED the attack!");
	}
	other.assignDamage(this);
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
