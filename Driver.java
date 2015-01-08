import java.util.*;
public class Driver {
    public static void main(String[] args){
	guimon f = new guimon();
	f.setTitle("POKEMON: JAVA EDITION");
	f.setSize(400,600);
	f.setVisible(true);
	f.text.setRows(f.getyBound());
	f.text.setColumns(f.getxBound());
	/*
   	Scanner scanner = new Scanner(System.in);
	String newName;
	String starter;
	String attackMethod;
	boolean encounter;
	String p1name, p2name, p3name, p4name, p5name, p6name;
	
	//INTRODUCTION
	System.out.println();
	
	starter = pokeSelect(f).toLowerCase();
	newName = nameSelect().toUpperCase();

	//charmander poke1 = new charmander("Jeanne");

	System.out.println("You are a "+starter.toLowerCase()+" named "+newName.toUpperCase()+".");
    }

	public static String pokeSelect(guimon other) {
	    Scanner scanner = new Scanner(System.in);
	    String starter = new String();
	    other.dialogue.setText("You have the choice of one of 3 different starter"+" \n"+"Pokemon!"+ "\n \n");

	    other.dialogue.setCaretPosition(other.dialogue.getDocument().getLength());
	    try {
		for (int i=0;i<5;i++){
		    Thread.sleep(200);
		}
		Thread.sleep(1000);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    other.dialogue.append("Which Pokemon do you want to select?" + "\n");
	    other.dialogue.setCaretPosition(other.dialogue.getDocument().getLength());
	    other.dialogue.append("If left blank, you will be defaulted to CHARMANDER." + "\n");
	    other.dialogue.setCaretPosition(other.dialogue.getDocument().getLength());
	    
	    other.dialogue.append("-> BULBASAUR - GRASS type" + "\n");
	    other.dialogue.setCaretPosition(other.dialogue.getDocument().getLength());
	    other.dialogue.append("-> CHARMANDER - FIRE type" + "\n");
	    other.dialogue.setCaretPosition(other.dialogue.getDocument().getLength());
	    other.dialogue.append("-> SQUIRTLE - WATER type" + "\n");
	    other.dialogue.setCaretPosition(other.dialogue.getDocument().getLength());
	    starter = scanner.nextLine();
	    if (starter.equals("")) {
		starter = "bulbasaur";
	    }
	    if (!(starter.toLowerCase().equals("bulbasaur")) || !(starter.toLowerCase().equals("squirtle")) || !(starter.toLowerCase().equals("charmander"))) {
		starter = "bulbasaur";
	    }
	    
	return starter;
	
	}
    
	
	public static String nameSelect() {
	    String parsing[] = {"...","...","..."};
	    Scanner scanner = new Scanner(System.in);
	    String newName = new String();
	    System.out.println("Hi, I'm Professor Oak, and welcome to the world of Pokemon!");
	    try {
		for (int i=0;i<parsing.length;i++){
		    Thread.sleep(200);
		    System.out.println(parsing[i]);
		}
		Thread.sleep(1000);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    System.out.println();
	    System.out.println("What is your name?");
	    System.out.println("If left blank, you will be defaulted to ASH.");
	    newName = scanner.nextLine();
	    if (newName.equals("")) {
		newName = "ASH";
	    }
	    return newName;
	}
	*/
    }
}

