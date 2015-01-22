import java.util.Random;
public class pikachu extends pokemon{
    Random randomNumber = new Random();

    public pikachu(String n){
	setStrength(50);
	setHealth(100);
	setSpeed(40);
	setName(n);
	setSpecies("pikachu");
	setType("electric");
	
    }
    public pikachu(int n){	
	setStrength(n);
	setHealth(100);
	setSpeed(40);
	setSpecies("pikachu");
	setType("electric");
    }
    public pikachu(){
	setStrength(50);
	setHealth(100);
	setSpeed(40);
	setSpecies("pikachu");
	setType("electric");
    }
    //basics
    /*
    //tackle
    public void attack1(pokemon other){
	this.setAttackStrength(this.getStrength()/5 + randomNumber.nextInt(5));
	lowerAttackStrength((other.getStrength()/20) +randomNumber.nextInt(5));
	this.assignDamage(other);
	//	other.setDefending(true);
    }

    // volt 
    public void attack2(pokemon other){
	if (other.getType() == "water"){
	    this.setAttackStrength(this.getStrength()/7 + randomNumber.nextInt(20));
	} else {
	    this.setAttackStrength(this.getStrength()/10 + randomNumber.nextInt(20));
	}
	lowerAttackStrength((other.getStrength()/20) +randomNumber.nextInt(5));
	this.assignDamage(other);
	//	other.setDefending(true);
    }

    //thunder
    public void attack3(pokemon other){
	if (other.getType() == "water"){
	    this.setAttackStrength(this.getStrength()/3+ 5 + randomNumber.nextInt(15));
	} else {
	    this.setAttackStrength(this.getStrength()/7 + randomNumber.nextInt(10));
	}
	lowerAttackStrength((other.getStrength()/20) +randomNumber.nextInt(5));
	this.assignDamage(other);
	//	other.setDefending(true);
    }

    /*  public void receive(pokemon other)
    {
	other.lowerAttackStrength((this.getStrength()/10) +randomNumber.nextInt(5));
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
