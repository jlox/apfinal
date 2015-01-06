import java.util.*;
public class Driver {
    public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);	
	String newName;
	String character;
	String attackMethod;
	boolean encounter;
	// INTRODUCTION
	
	System.out.println();
	
	character = charSelect().toLowerCase();
	newName = nameSelect().toUpperCase();
	// COMBAT
	if (character.equals("warrior")) {
	    ash p1 = new ash(newName);
	    String parsing[] = { "Your adventure begins now!...", "...","... ", "...", "..." };
	    String parsing2[] = { "...", "...", "...", "...", "....!!" };
	    String parsing3[] = { "...", "...", "...", "..." };
	    try {
		for (int i=0;i<parsing.length;i++){
		    Thread.sleep(200);
		    System.out.println(parsing[i]);
		}
		Thread.sleep(1000);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }

	    charmander enemy = new charmander("CHARMANDER");
	    System.out.println();
	    System.out.println("You are a "+character.toLowerCase()+" named "+newName.toUpperCase()+".");
	    System.out.println("You walk slowly through the abandoned castle, your mace dragging along the floor.");
	    try { Thread.sleep(1000); } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    try {
		for (int i=0;i<parsing.length;i++){
		    Thread.sleep(200);
		    System.out.println(parsing2[i]);
		}
		Thread.sleep(1000);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    String attackMethods[] = {"->BASH"};
	    String defenseMethods[] = {"->BLOCK", "->RUN"};
	    System.out.println("You encountered an "+enemy.getName().toUpperCase()+"!");
	    encounter = true;
	    System.out.println();
	    System.out.println("What do you want to do?");
	    System.out.println();
	    System.out.println(enemy.getName() + " HEALTH: "+enemy.getHealth());
	    System.out.println(p1.getName()+"'s HEALTH: "+p1.getHealth());
	    while (encounter == true) {
		System.out.println();
		System.out.println("You can:");

		try {
		    for (int i=0;i<attackMethods.length;i++){
			Thread.sleep(200);
			System.out.println(attackMethods[i]);
		    }
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		attackMethod = scanner.nextLine();
		System.out.println();
		System.out.println();
		System.out.println();
		if (attackMethod.toUpperCase().equals("BASH")) {
		    p1.bash(enemy);
		    if (enemy.getDefending()) {
			enemy.dodge(p1);
		    }
		}
		try {
		    for (int i=0;i<parsing3.length;i++){
			Thread.sleep(200);
			System.out.println(parsing3[i]);
		    }
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		System.out.println();
		System.out.println("THIEF HEALTH: "+enemy.getHealth());
		System.out.println(p1.getName()+"'s HEALTH: "+p1.getHealth());
		/*	if (enemy.getHealth() <= 0 || p1.getHealth() <= 0) {
			encounter = false;
			}
			}*/
		System.out.println();
		System.out.println();
		Random r1 = new Random();
		if (r1.nextInt(1) == 1)
		    {
			enemy.slash(p1);
		    }
		else
		    {
			enemy.stab(p1);
		    }
		System.out.println("Uh oh...");
		System.out.println("What do you do?");
		try {
		    for (int i=0;i<defenseMethods.length;i++){
			Thread.sleep(500);
			System.out.println(defenseMethods[i]);
		    }
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		String defenseMethod = scanner.nextLine();
		System.out.println();
		System.out.println();
		System.out.println();
		if (attackMethod.toUpperCase().equals("BLOCK")) {
		    p1.block(enemy);
		}
		try {
		    for (int i=0;i<parsing3.length;i++){
			Thread.sleep(200);
			System.out.println(parsing3[i]);
		    }
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		if (attackMethod.toUpperCase().equals("RUN")) {
		    p1.run(enemy);
		    System.out.println("Congratulations! You're a coward!");
		    break; 
		}
		
	    }
	}
    }

    public static String charSelect() {
	Scanner scanner = new Scanner(System.in);
	String character = new String();
	System.out.println();
	System.out.println("Welcome to Stuyablo!");
	System.out.println();
	System.out.println("What class do you want to be?");
	System.out.println("If left blank, you will be defaulted to WARRIOR.");
	System.out.println("-> Warrior");
	System.out.println("-> Mage");
	System.out.println("-> Rogue");
	character = scanner.nextLine();
	if (character.equals("")) {
	    character = "WARRIOR";
		}
	return character;
    }
    public static String nameSelect() {
	Scanner scanner = new Scanner(System.in);
	String newName = new String();
	System.out.println("Hi, I'm Professor Oak, and welcome to the world of Pokemon!");
	System.out.println();
	System.out.println("What is your name?");
	System.out.println("If left blank, you will be defaulted to MIKE.");
	newName = scanner.nextLine();
	if (newName.equals("")) {
	    newName = "MIKE";
	}
        return newName;
    }
}
