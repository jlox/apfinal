import java.util.Random;
public class charmander extends pokemon {
    Random randomNumber = new Random();
    public charmander(String n) {
	setStrength(50));
	setHealth(100);
	setSpeed(40);
	setName(n);
    }

// basic attacks
    public void slash(pokemon other)
    {
	this.setAttackStrength(this.getStrength()/10 + randomNumber.nextInt(20)); 
	System.out.println(this.getName() + " SLASHES " +other);
	other.setDefending(true);
    }
    /* 
     Bash sets the attack strength, which is one tenth of the strength + a random integer from 0 to 20.
     After it sets the attack strength, it sets the opponent's defending variable to true. This will trigger the opponent to defend.
     When the opponent attacks, a similar thing happens. The defending variable is set to true, thus triggering the option of using your shield. 
     Maybe we should add more defense methods? The defense method then reduces the attack strength by a certain amount. I put it as strength/9 + random int from 0 to 20.
     Finally, the damage is given 
    */

    public void dodge(pokemon other)
    {
	System.out.println(this.getName() + " DODGES " + other.getName() + "'s attack");
	other.lowerAttackStrength(this.getStrength()/9 + randomNumber.nextInt(20));
	if (other.getAttackStrength() < 15)
	    {
		System.out.println(this.getName() + " DODGED THE ATTACK!");
	    }
	
	other.assignDamage(this);
	
    }
    public void run (basechar other)
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
}
