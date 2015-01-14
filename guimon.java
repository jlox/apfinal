import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/* 
   STEPS TO ADD NEW MAP:
   1. Create map in map.java
   2. Create function to compile map (make___)
   3. Add map-making function to gui constructor
   4. Add new map to getCurrentMap() function
   5. Add door to new map
   6. Add door to return to old map
   7. 
   
 */

public class guimon extends JFrame implements ActionListener{

    String newline = "\n"+" ";
    String endline = "~~~~~~~~~~~~~~~~~~";

    // BOOLEANS
    boolean canMove = true;

    // GUI SETUP
    JOptionPane textField = new JOptionPane();
    Container pane;
    JTextArea text = new JTextArea();
    JPanel canvas;
    JTextArea dialogue = new JTextArea();
    JScrollPane scroll = new JScrollPane(dialogue, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JButton send = new JButton();
    JButton goTalk = new JButton("OK");

    // MAP SETUP
    int ycor = 5;
    int xcor = 3;
    String swagger = "hello world this is a secret";
    map g = new map();
    char oldtile = ' ';
    char allowedBlock = ' ';
    char door = '+';
    int ybound;
    int xbound;
    int mapnum = 0;
    String currentMap;
    char[][] defaultMap;

    // CHARACTER SETUP
    int whichInput = 0;
    String newName = "";
    String starter;
    String attackMethod;
    boolean encounter = false;
    String currentString;
    String currentPoke;
    
    // String[] party = new String[6];
    pokemon[] party = new pokemon[6];
    int catchnum = 0; // always 6 or less
    int pokenum = 0; // changes based on which pokemon you want to use

    // POKEMON INITIALIZATION

    /*   
    bulbasaur bulb1 = new bulbasaur();
    bulbasaur bulb2 = new bulbasaur();
    bulbasaur bulb3 = new bulbasaur();

    charmander char1 = new charmander();
    charmander char2 = new charmander();
    charmander char3 = new charmander();

    squirtle squi1 = new squirtle();
    squirtle squi2 = new squirtle();
    squirtle squi3 = new squirtle();

    > 
    string species = "SQUIRTLE";

    if (party[numpoke].species == "SQUIRTLE"){ 
    
}
    */
    
    // RIVAL SETUP
    String rivalName = "";
    String rivalStarter;

    // INPUT SETUP
    boolean input1 = true;
    boolean input2 = false;
    boolean input3 = false;
    boolean input4 = false;
    boolean talkedToOak1 = false;
    boolean talkedToOak2 = false;
    boolean sawCharm = false;
    boolean sawBulb = false;
    boolean sawSquirt = false;

    // YOU SHALL NOT PASS
    boolean door1 = false;
    
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // MAP FUNCTIONS
    public void getBoundaries(){
	ybound = defaultMap.length;
	xbound = defaultMap[0].length;
    }
    public int getyBound(){
	return defaultMap.length;
    }
    public int getxBound(){
	return defaultMap[0].length;
    }


    public void getCurrentMap(){
	if (mapnum == 0){
	    currentMap = g.showMap(g.home);
	    defaultMap = g.home;
	} else if (mapnum == 1){
	    currentMap = g.showMap(g.first);
	    defaultMap = g.first;
	} else if (mapnum == 2){
	    currentMap = g.showMap(g.sec);
	    defaultMap = g.sec;
	} else if (mapnum == 3){
	    currentMap = g.showMap(g.lab);
	    defaultMap = g.lab;
	}
    }

    public guimon(){
	getCurrentMap();
	g.makehome();
	g.makefirst();
	g.makesec();
	g.makelab();

	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = getContentPane();
	pane.setLayout(new FlowLayout());
	text.setColumns(getxBound());
	text.setRows(getyBound());
	text.setBorder(BorderFactory.createLineBorder(Color.red,2));
	text.setEditable(false);
	Font font = new Font("Monospaced", Font.PLAIN, 20);
	text.setFont(font);
	pane.add(text);
	text.addKeyListener(new Key());
	dialogue.setRows(10);
	dialogue.setColumns(30);
	dialogue.setEditable(false);
	pane.add(scroll);
	getCurrentMap();
	swagger = currentMap;
	text.setText(swagger);
	
	// "CONTINUE CONVERSATION" BUTTON
	goTalk = new JButton("OK");
	goTalk.setVisible(false);
	goTalk.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    if (!(talkedToOak1)){
			talkedToOak1 = true;
		    }
		    if ((!(sawCharm)) &&
			((mapnum == 3) &&
			 ((ycor == 3) &&
			  (xcor == 3)))){
			sawCharm = true;
		    }
		    if ((!(sawBulb)) && 
			((mapnum == 3) &&
			 ((ycor == 2) &&
			  (xcor == 3)))){
			sawBulb = true;
		    }
		    if ((!(sawSquirt)) &&
			((mapnum == 3) &&
			 ((ycor == 4) &&
			  (xcor == 3)))){
			sawSquirt = true;
		    }

		    goTalk.setVisible(false);
		    canMove = true;
		}
	    });

	send = new JButton("NAME?");
	send.setVisible(false);
	
	// DYNAMIC DIALOGUE INPUT BOX
	send.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    if (input1){
			String input = JOptionPane.showInputDialog(guimon.this, "Please enter your name:");
			if ((input != null) && !input.isEmpty()){
			    newName = input.toUpperCase();
			    canMove = true;
			} else if (input.isEmpty()) {
			    newName = "ASH";
			    canMove = true;
			}
			input1 = false;
			send.setVisible(false);
		    }

		    if (input2){
			String input = JOptionPane.showInputDialog(guimon.this, "Please enter your rival's name:");
			if ((input != null) && !input.isEmpty()/* && whichInput == 1*/){
			    rivalName = input.toUpperCase();
			    canMove = true;
			} else if (input.isEmpty()/* && whichInput == 1*/) {
			    rivalName = "GARY";
			    canMove = true;
			}
			input2 = false;
			send.setVisible(false);
		    }
		    
		    if (input3){
			String input = JOptionPane.showInputDialog(guimon.this, "Please type in the name of the pokemon you want to select.");
			if ((input != null) && !input.isEmpty()/* && whichInput == 1*/){
			    party[catchnum] = input.toUpperCase();
			    catchnum = catchnum + 1;
			} else if (input.isEmpty() || input.toUpperCase() != "BULBASAUR" || input.toUpperCase() != "CHARMANDER" || input.toUpperCase() != "SQUIRTLE" /* && whichInput == 1*/) {
			    party[catchnum] = bulb1;
			    catchnum = catchnum + 1;
			}
			input3 = false;
			talkedToOak2 = true;
			send.setVisible(false);
			dialogue.append("You chose "+starter+"! Great decision."+newline+endline);
			goTalk.setVisible(true);
		    }
		}
	    });
	pane.add(send);
	pane.add(goTalk);
    }
	    
	    	
 
    public void actionPerformed(ActionEvent e) {}
	

    public class Key implements KeyListener {
		
	public void direction(int x, int y){
	    getBoundaries();
	    	    
	    // REGULAR MOVEMENT
	    if ((xcor - x > 0) && (xcor - x < xbound - 1) &&
		(ycor - y > 0) && (ycor - y < ybound - 1) && 
		((defaultMap[ycor-y][xcor-x] == allowedBlock) || 
		 (defaultMap[ycor-y][xcor-x] == door))) {
		defaultMap[ycor][xcor] = oldtile;
		xcor = xcor - x;
		ycor = ycor - y;
		oldtile = defaultMap[ycor][xcor];

		// DIALOGUE TRIGGERS
		if ((mapnum == 0) && 
		    (ycor == 1) && 
		    (xcor == 16) && 
		    (newName == "")) {
		    canMove = false;
		    nameSelect();
		    send.setVisible(true);
		}
		if ((mapnum == 1) &&
		    (ycor == 11) &&
		    (xcor == 13) &&
		    (rivalName == "")) {
		    canMove = false;
		    input2 = true;
		    rivalSelect();
		    send.setText("RIVAL?");
		    send.setVisible(true);
		}
		if ((mapnum == 3) &&
		    (!talkedToOak1) &&
		    (((ycor == 2) &&
		      (xcor == 8)) ||
		     ((ycor == 3) &&
		      (xcor == 9)) ||
		     ((ycor == 2) &&
		      (xcor == 10)))){
		    canMove = false;
		    talkToOak1();
		    goTalk.setVisible(true);
		}
		if ((mapnum == 3) &&
		    (!talkedToOak2) &&
		    (talkedToOak1) &&
		    (sawBulb) &&
		    (sawCharm) &&
		    (sawSquirt) &&
		    (((ycor == 2) &&
		      (xcor == 8)) ||
		     ((ycor == 3) &&
		      (xcor == 9)) ||
		     ((ycor == 2) &&
		      (xcor == 10)))){
		    send.setText("POKEMON?");
		    canMove = false;
		    input3 = true;
		    talkToOak2();
		    send.setVisible(true);
		}
		if (!sawBulb &&
		    talkedToOak1 &&
		    (mapnum == 3) &&
		    ((ycor == 2) &&
		     (xcor == 3))) {
		    canMove = false;
		    goTalk.setVisible(true);
		    dialogue.append("BULBASAUR - THE GRASS-TYPE POKEMON"+newline);
		    dialogue.append(endline+newline);	
		}
		if (!sawCharm &&
		    talkedToOak1 &&
		    (mapnum == 3) &&
		    ((ycor == 3) &&
		     (xcor == 3))) {
		    canMove = false;
		    goTalk.setVisible(true);
		    dialogue.append("CHARMANDER - THE FIRE-TYPE POKEMON"+newline);
		    dialogue.append(endline+newline);	
		}
		if (!sawSquirt &&
		    talkedToOak1 &&
		    (mapnum == 3) &&
		    ((ycor == 4) &&
		     (xcor == 3))) {
		    canMove = false;
		    goTalk.setVisible(true);
		    dialogue.append("SQUIRTLE - THE WATER-TYPE POKEMON"+newline);
		    dialogue.append(endline+newline);	
		}


		// DOOR FUNCTIONS
		if (defaultMap[ycor][xcor] == '+'){
		    if (mapnum == 0){
			if ((ycor == 1) && (xcor == 17)){
			    mapnum = 1;
			    getCurrentMap();
			    swagger = currentMap;
			    text.setText(swagger);
			    ycor = 9;
			    xcor = 13;
			    allowedBlock = ' ';
			    oldtile = ' ';
			}
		    }
		    		   
		    if (mapnum == 1){
			if ((ycor == 8) && (xcor == 13)) {
			    mapnum = 0;
			    getCurrentMap();
			    swagger = currentMap;
			    text.setText(swagger);
			    ycor = 1;
			    xcor = 16;
			    allowedBlock = ' ';
			    oldtile = ' ';
			}
			if ((ycor == 1) && (xcor == 19)) {
			    mapnum = 2;
			    getCurrentMap();
			    swagger = currentMap;
			    text.setText(swagger);
			    ycor = 10;
			    xcor = 19;
			    allowedBlock = ' ';
			    oldtile = ' ';
			}
		    }
      
		    if (mapnum == 2){
			if ((ycor == 11) && (xcor == 19)) {
			    mapnum = 1;
			    getCurrentMap();
			    swagger = currentMap;
			    text.setText(swagger);
			    ycor = 2;
			    xcor = 19;
			    allowedBlock = ' ';
			    oldtile = ' ';
			}
			if ((ycor == 6) && (xcor == 6)) {
			    mapnum = 3;
			    getCurrentMap();
			    swagger = currentMap;
			    text.setText(swagger);
			    ycor = 8;
			    xcor = 9;
			    allowedBlock = ' ';
			    oldtile = ' ';
			}
		    }
		    
		    if (mapnum == 3){
			if ((ycor == 9) & (xcor == 9)) {
			    mapnum = 2;
			    getCurrentMap();
			    swagger = currentMap;
			    text.setText(swagger);
			    ycor = 7;
			    xcor = 6;
			    allowedBlock = ' ';
			    oldtile = ' ';
			}
		    }
		}
		
		defaultMap[ycor][xcor] = '@';
		getCurrentMap();
		swagger = currentMap;
		text.setText(swagger);
	    }
	    
	}
    
    // STORYLINE + DIALOGUE FUNCTIONS

	public void nameSelect() {
	    
	    String g1 = " Welcome to the world of Pokemon!";
	    String g2 = "Before we begin our adventure, what is your name?";
	    String g3 = "If left blank, you will be defaulted to ASH.";
	    String parsing[] = {"...","...","..."};
	    String newName = new String();
	    dialogue.append(g1+newline);
	    dialogue.append(g2+newline);
	    dialogue.append("Please open the INPUT box and type your name." + newline);
	    dialogue.append("When you are done, click the red GAME SCREEN" +newline+"to resume." + newline);
	    dialogue.append(g3+newline);
	    dialogue.append(endline+newline);	    
	}

	public void rivalSelect() {
	    
	    String g1 = "Oh wait! What's your RIVAL's name?";
	    String g2 = "Please open the INPUT box and type his name.";
	    String g3 = "Afterwards, click the red GAME SCREEN to resume.";
	    String g4 = "If left blank, he will be defaulted to GARY";

	    dialogue.append(g1+newline);
	    dialogue.append(g2+newline);
	    dialogue.append(g3+newline);
	    dialogue.append(g4+newline);
	    dialogue.append(endline+newline);	    
	    
	}
	
	public void talkToOak1() {
	    
	    dialogue.append("Hello! I am Professor Oak!"+newline);
	    dialogue.append("You must be "+newName+"!"+newline);
	    dialogue.append("Please walk over to the POKEMON on the left"+newline);
	    dialogue.append("and come back to me after you've seen them all."+newline);
	    dialogue.append(endline+newline);	    
	    
	}

	public void talkToOak2() {
	    
	    dialogue.append("I'm happy you made your decision!"+newline);
	    dialogue.append("What POKEMON do you want to start with?"+newline);
	    dialogue.append("Please type in the name of the pokemon."+newline);
	    dialogue.append("If left blank, you will be given BULBASAUR."+newline);
	    dialogue.append("~~~~~~~~~~~~~~~~~~~~~~~"+newline);	    
	    
	}


	
  
	    
    

	public void keyPressed(KeyEvent e) {
	    int c = e.getKeyCode();
	    if (canMove){
		if (c == KeyEvent.VK_LEFT){
		    direction(1,0);
		}
		if (c == KeyEvent.VK_RIGHT){
		    direction(-1,0);
		}
		if (c == KeyEvent.VK_UP){
		    direction(0,1);
		}
		if (c == KeyEvent.VK_DOWN){
		    direction(0,-1);
		}
	    }
	}

	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
    }

    // BATTLE FUNCTIONS

    // Remember to implement species and make party a pokemon[] array.
    
    
    /*
    public void getCurrentPoke(){
	currentPoke = party[pokenum];
    }
    */
    
   /*
   public void yourTurn(){
	if (encounter) {
	    if (currentPoke.getHealth() <= 0){
		encounter = false;
	    } else {
		if (currentPoke.species == "BULBASAUR")
	    }
	}
    }
    */

    /*
    public void enemyTurn(){
	if (encounter) {
	    if
	    
    }
    */

    // DRIVER
    public static void main(String[] args){
	guimon f = new guimon();
	f.setTitle("JAVA-MON");
	f.setSize(400,600);
	f.setVisible(true);
	f.text.setRows(f.getyBound());
	f.text.setColumns(f.getxBound());
    
    }

}
