import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;


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

    Random randomNumber = new Random();
    String newline = "\n"+" ";
    String endline = "~~~~~~~~~~~~~~~~~~";

    ash a = new ash();

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

    JLabel yourPokePic = new JLabel();
    JLabel enemyPokePic = new JLabel();
    JLabel titleblock = new JLabel();
    ImageIcon titleicon = new ImageIcon("javamon.PNG");
    
    JTextArea myHP = new JTextArea();
    JTextArea enemyHP = new JTextArea();
    JButton ability1 = new JButton();
    JButton ability2 = new JButton();
    JButton ability3 = new JButton();

    // IMAGE SETUP
    ImageIcon charFront = new ImageIcon("charmanderfront.png");
    ImageIcon charBack = new ImageIcon("charmanderback.png");

    ImageIcon squiFront = new ImageIcon("squirtlefront.png");
    ImageIcon squiBack = new ImageIcon("squirtleback.png");

    ImageIcon bulbFront = new ImageIcon("bulbasaurfront.png");
    ImageIcon bulbBack = new ImageIcon("bulbasaurback.png");
    
    ImageIcon pikaFront = new ImageIcon("pikachufront.png");
    ImageIcon pikaBack = new ImageIcon("pikachuback.png");

    // MAP SETUP
    int ycor = 5;
    int xcor = 3;
    String swagger = "hello world this is a secret";
    map g = new map();
    char oldtile = ' ';
    char allowedBlock = ' ';
    char door = '+';
    char grass = '!';
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
    String currentString;
    pokemon currentPoke;
    
    // String[] party = new String[6];
    pokemon[] party = new pokemon[6];
    int catchnum = 0; // always 6 or less
    int pokenum = 0; // changes based on which pokemon you want to use

    // POKEMON INITIALIZATION

    
    bulbasaur bulb1 = new bulbasaur();
    bulbasaur bulb2 = new bulbasaur();
    bulbasaur bulb3 = new bulbasaur();
    
    charmander char1 = new charmander();
    charmander char2 = new charmander();
    charmander char3 = new charmander();
    
    squirtle squi1 = new squirtle();
    squirtle squi2 = new squirtle();
    squirtle squi3 = new squirtle();

    pikachu pika1 = new pikachu();
    pikachu pika2= new pikachu();
    pikachu pika3= new pikachu();
    
    
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

    // BATTLE SETUP
    boolean move1 = false;
    boolean move2 = false;
    boolean move3 = false;

    boolean encounter = false;
    
    boolean ashturn = true;
    boolean garyturn = false;

    pokemon currentEnemy;

    String moveName1 = "";
    String moveName2 = "";
    String moveName3 = "";

    public void getMoveNames(){
	moveName1 = "TACKLE";
	if (party[pokenum].getSpecies() == "bulbasaur"){
	    moveName2 = "VINEWHIP";
	    moveName3 = "LEAFSTORM";
	}
	if (party[pokenum].getSpecies() == "charmander"){
	    moveName3 = "EMBER";
	    moveName3 = "FLAMETHROWER";
	}
	if (party[pokenum].getSpecies() == "squirtle"){
	    moveName2 = "WATERSPOUT";
	    moveName3 = "WATERGUN";
	}
	if (party[pokenum].getSpecies() == "pikachu"){
	    moveName2 = "VOLTSWITCH";
	    moveName3 = "THUNDER";
	}
    }
    

    // WILD POKEMON SETUP
    bulbasaur wildbulb1 = new bulbasaur();
    charmander wildchar1 = new charmander();
    pikachu wildpika1 = new pikachu();
    squirtle wildsqui1 = new squirtle();
    ArrayList<pokemon> wildpoke = new ArrayList<pokemon>();

    public void makeWildPoke(){
	wildpoke.add(wildbulb1);
	wildpoke.add(wildchar1);
	wildpoke.add(wildpika1);
	wildpoke.add(wildsqui1);
    }

    
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
	} else if (mapnum == 4){
	    currentMap = g.showMap(g.thi);
	    defaultMap = g.thi;
	}
    }

    public guimon(){
	// currentPoke = bulb1;
	makeWildPoke();
	getCurrentMap();
	g.makehome();
	g.makefirst();
	g.makesec();
	g.makelab();
	g.makethi();

	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = getContentPane();
	pane.setLayout(new FlowLayout());
	text.setColumns(getxBound());
	text.setRows(getyBound());
	text.setBorder(BorderFactory.createLineBorder(Color.red,2));
	text.setEditable(false);
	myHP.setEditable(false);
	enemyHP.setEditable(false);
	Font font = new Font("Monospaced", Font.PLAIN, 20);
	text.setFont(font);
	
	pane.add(titleblock);
	pane.add(myHP);
	myHP.setRows(1);
	myHP.setColumns(3);
	enemyHP.setRows(1);
	enemyHP.setColumns(3);
	pane.add(yourPokePic);
	pane.add(enemyPokePic);
	pane.add(enemyHP);
	titleblock.setIcon(titleicon);
	yourPokePic.setVisible(false);
	enemyPokePic.setVisible(false);
	titleblock.setVisible(true);
	myHP.setVisible(false);
	enemyHP.setVisible(false);

	pane.add(text);
	text.addKeyListener(new Key());
	dialogue.setRows(10);
	dialogue.setColumns(30);
	dialogue.setEditable(false);
	pane.add(scroll);
	getCurrentMap();
	swagger = currentMap;
	text.setText(swagger);
	pane.add(ability1);
	pane.add(ability2);
	pane.add(ability3);
	ability1.setVisible(false);
	ability2.setVisible(false);
	ability3.setVisible(false);

	
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
			} else if (input.isEmpty() || input == null) {
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
			} else if (input.isEmpty() || (input == null)/* && whichInput == 1*/) {
			    rivalName = "GARY";
			    canMove = true;
			}
			input2 = false;
			send.setVisible(false);
		    }
		    
		    if (input3){
			String input = JOptionPane.showInputDialog(guimon.this, "Please type in the name of the pokemon you want to select.");
			dialogue.append(input+newline);
			if ((input != null) && !input.isEmpty()/* && whichInput == 1*/){
			    if (input.toUpperCase() == "BULBASAUR"){
				party[catchnum] = bulb1;
			    }
			    if (input.toUpperCase() == "SQUIRTLE"){
				party[catchnum] = squi1;
			    }
			    if (input.toUpperCase() == "CHARMANDER"){
				 party[catchnum] = char1;
			    }
			    catchnum = catchnum + 1;
			} else if (input.isEmpty() || input.toUpperCase() != "BULBASAUR" || input.toUpperCase() != "CHARMANDER" || input.toUpperCase() != "SQUIRTLE" /* && whichInput == 1*/) {
			    party[catchnum] = bulb1;
			    catchnum = catchnum + 1;
			}/* else if (input == null){
			    party[catchnum] = bulb1;
			    catchnum = catchnum + 1;
			    }*/
			input3 = false;
			talkedToOak2 = true;
			send.setVisible(false);
			dialogue.append("Great decision."+newline+endline+newline);
			goTalk.setVisible(true);
			door1 = true;
		    }
		    // FOR BATTLING

		    if (encounter && ashturn){
			if (currentPoke.getSpecies() == "bulbasaur"){
			    String[] options = new String[] {"TACKLE", "VINEWHIP", "NIPPLE PUNCH"};
			    int response = JOptionPane.showOptionDialog(null, "Choose an attack!", "BATTLE!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			    if (response == 0){
				move1 = true;
			    } else if (response == 1){
				move2 = true;
			    } else if (response == 2){
				move3 = true;
			    }
			    yourTurn();
			}
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
	    int wildchance = randomNumber.nextInt(20);
	    	    
	    // REGULAR MOVEMENT
	    if ((xcor - x > 0) && (xcor - x < xbound - 1) &&
		(ycor - y > 0) && (ycor - y < ybound - 1) && 
		((defaultMap[ycor-y][xcor-x] == allowedBlock) || 
		 (defaultMap[ycor-y][xcor-x] == door) ||
		 (defaultMap[ycor-y][xcor-x] == grass))) {
		defaultMap[ycor][xcor] = oldtile;
		xcor = xcor - x;
		ycor = ycor - y;
		oldtile = defaultMap[ycor][xcor];

		// WILD GRASS 
		if ((mapnum == 4)){
		    if (defaultMap[ycor][xcor] == '!'){
			dialogue.append("The grass brushes against you as you walk."+ newline + endline + newline);
			if (wildchance < 5){
			    yourPokePic.setVisible(true);
			    enemyPokePic.setVisible(true);
			    send.setVisible(true);
			    text.setVisible(false);
			    encounter = true;
			    canMove = false;
			    send.setText("CHOOSE AN ATTACK!");
			    // CurrentPoke();
			    // getCurrentEnemy();
			    // getMoveNames(currentPoke);
			    // getMoveNames();
			    currentEnemy = wildpoke.get(randomNumber.nextInt(wildpoke.size()));
			    
			    System.out.println(party[pokenum].getSpecies()); // THIS IS THE PROBLEM
			    
			    System.out.println(currentEnemy.getSpecies());
			    
			    dialogue.append("Your "+currentPoke.getSpecies()+" has encountered a wild "+currentEnemy.getSpecies()+"!"+newline+endline+newline);


			    myHP.setVisible(true);
			    enemyHP.setVisible(true);
			    myHP.setText(""+currentPoke.getHealth());
			    enemyHP.setText(""+currentEnemy.getHealth());

			    if (currentPoke.getSpecies() == "bulbasaur"){
				enemyPokePic.setIcon(bulbBack);
			    } else if (currentPoke.getSpecies() == "charmander"){
				enemyPokePic.setIcon(charBack);
			    } else if (currentPoke.getSpecies() == "squirtle"){
				enemyPokePic.setIcon(squiBack);
			    } else if (currentPoke.getSpecies() == "pikachu"){
				enemyPokePic.setIcon(pikaBack);
			    }
			    if (currentEnemy.getSpecies() == "bulbasaur"){
				enemyPokePic.setIcon(bulbFront);
			    } else if (currentEnemy.getSpecies() == "charmander"){
				enemyPokePic.setIcon(charFront);
			    } else if (currentEnemy.getSpecies() == "squirtle"){
				enemyPokePic.setIcon(squiFront);
			    } else if (currentEnemy.getSpecies() == "pikachu"){
				enemyPokePic.setIcon(pikaFront);
			    }
			}
		    } else {
			    yourPokePic.setVisible(false);
			    enemyPokePic.setVisible(false);

			    myHP.setVisible(false);
			    enemyHP.setVisible(false);
			    
			    send.setVisible(false);
			    encounter = false;
			    for (int i=0;i<4;i++){
				wildpoke.get(i).setHealth(100);
			    }
		    }
		}
	    
		    

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
			if ((ycor == 1) && (xcor == 13) && door1 ){
			    mapnum = 4;
			    getCurrentMap();
			    swagger = currentMap;
			    text.setText(swagger);
			    ycor = 10;
			    xcor = 12;
			    allowedBlock = ' ';
			    oldtile = ' ';
			}
			if ((ycor == 1) && (xcor == 13) && !door1 ){
			    dialogue.append("This way is blocked by a large pokemon."+newline+endline+newline);
			}
		    }
		    
		    if (mapnum == 3){
			if ((ycor == 9) && (xcor == 9)) {
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
		    
		    if (mapnum == 4){
			if ((ycor == 11) && (xcor == 12)){
			    mapnum = 2;
			    getCurrentMap();
			    swagger = currentMap;
			    text.setText(swagger);
			    ycor = 2;
			    xcor = 13;
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
    
    
    public void getCurrentPoke(){
	currentPoke = party[pokenum];
    }

    public void getCurrentEnemy(){
	currentEnemy = wildpoke.get(randomNumber.nextInt(wildpoke.size()));
    }
   

    // We have to find a different way to store the current pokemon.


    
    public void yourTurn(){ // edit the "enemy" and boolean things
	if (encounter) {
	    text.setVisible(false);
	    if (currentPoke.getHealth() <= 0){
		encounter = false;
		text.setVisible(true);
		send.setVisible(false);
		ashturn = true;
		canMove = true;

		yourPokePic.setVisible(false);
		enemyPokePic.setVisible(false);
	    } else if (currentPoke.getSpecies() == "bulbasaur"){
		if (move1){
		    currentPoke.attack2(currentEnemy);
		    dialogue.append("Your BULBASAUR used TACKLE on the enemy " + currentEnemy.getSpecies().toUpperCase()  + newline);
		    dialogue.append(endline+newline);
		} else if (move2){
		    currentPoke.attack2(currentEnemy);
		    dialogue.append("Your BULBASAUR used VINE WHIP on the enemy " + currentEnemy.getSpecies().toUpperCase()  + newline);
		    dialogue.append(endline+newline);
		} else if (move3){
		    currentPoke.attack3(currentEnemy);
		    dialogue.append("Your BULBASAUR used LEAF STORM on the enemy " + currentEnemy.getSpecies().toUpperCase()  + newline);
		    dialogue.append(endline+newline);
		}
	    } else if (currentPoke.getSpecies() == "charmander"){
		if (move1){
		    currentPoke.attack1(currentEnemy);
		    dialogue.append("Your CHARMANDER used CUT on the enemy " + currentEnemy.getSpecies().toUpperCase()  + newline); 
		    dialogue.append(endline+newline);
		} else if (move2){
		    currentPoke.attack2(currentEnemy);
		    dialogue.append("Your CHARMANDER used EMBER on the enemy " + currentEnemy.getSpecies().toUpperCase()  + newline);
		    dialogue.append(endline+newline);
		} else if (move3){
		    currentPoke.attack3(currentEnemy);
		    dialogue.append("Your CHARMANDER used FLAMETHROWER on the enemy " + currentEnemy.getSpecies().toUpperCase()  + newline);
		    dialogue.append(endline+newline);
		}
	    } else if (currentPoke.getSpecies() == "pikachu"){
		if (move1){
		    currentPoke.attack1(currentEnemy);
		    dialogue.append("Your PIKACHU used HEADBUTT on the enemy " + currentEnemy.getSpecies().toUpperCase()  + newline);
		    dialogue.append(endline+newline);
		} else if (move2){
		    currentPoke.attack2(currentEnemy);
		    dialogue.append("Your PIKACHU used SPARK on the enemy " + currentEnemy.getSpecies().toUpperCase()  + newline);
		    dialogue.append(endline+newline);
		} else if (move3){
		    currentPoke.attack3(currentEnemy);
		    dialogue.append("Your PIKACHU used THUNDER on the enemy " + currentEnemy.getSpecies().toUpperCase()  + newline);
		    dialogue.append(endline+newline);
		}
	    } else if (currentPoke.getSpecies() == "squirtle"){
		if (move1){
		    currentPoke.attack1(currentEnemy);
		    dialogue.append("Your SQUIRTLE used SCRATCH on the enemy " + currentEnemy.getSpecies().toUpperCase()  + newline);
		    dialogue.append(endline+newline);
		} else if (move2){
		    currentPoke.attack2(currentEnemy);
		    dialogue.append("Your SQUIRTLE used WATERSPOUT on the enemy " + currentEnemy.getSpecies().toUpperCase()  + newline);
		    dialogue.append(endline+newline);
		} else if (move3){
		    currentPoke.attack3(currentEnemy);
		    dialogue.append("Your SQUIRTLE used WATERGUN on the enemy " + currentEnemy.getSpecies().toUpperCase()  + newline);
		    dialogue.append(endline+newline);
		}
	    }
	    
	    move1 = false;
	    move2 = false;
	    move3 = false;
	    ashturn = false;
	    enemyTurn();	  
	}
	
	myHP.setText(""+currentPoke.getHealth());
	enemyHP.setText(""+currentEnemy.getHealth());
    }
    
    
    public void enemyTurn(){
	int rand = randomNumber.nextInt(3);
	if (encounter) {
	    text.setVisible(false);
	    if (currentEnemy.getHealth() <= 0){
		encounter = false;
		text.setVisible(true);	
		send.setVisible(false); 
		ashturn = true;
		canMove = true;

		yourPokePic.setVisible(false);
		enemyPokePic.setVisible(false);
	    } else if (currentPoke.getSpecies() == "bulbasaur"){
		if (rand == 0){
		    currentEnemy.attack2(currentPoke);
		    dialogue.append("Enemy BULBASAUR used TACKLE on your " + currentPoke.getSpecies().toUpperCase()  + newline);
		    dialogue.append(endline+newline);
		} else if (rand == 1){
		    currentEnemy.attack2(currentPoke);
		    dialogue.append("Enemy BULBASAUR used VINE WHIP on your " + currentPoke.getSpecies().toUpperCase()  + newline);
		    dialogue.append(endline+newline);
		} else if (rand == 2){
		    currentEnemy.attack3(currentPoke);
		    dialogue.append("Enemy BULBASAUR used LEAF STORM on your " + currentPoke.getSpecies().toUpperCase()  + newline);
		    dialogue.append(endline+newline);
		}
	    } else if (currentEnemy.getSpecies() == "charmander"){
		if (rand == 0){
		    currentEnemy.attack1(currentPoke);
		    dialogue.append("Enemy CHARMANDER used CUT on your " + currentPoke.getSpecies().toUpperCase()  + newline); 
		    dialogue.append(endline+newline);
		} else if (rand == 1){
		    currentEnemy.attack2(currentPoke);
		    dialogue.append("Enemy CHARMANDER used EMBER on your " + currentPoke.getSpecies().toUpperCase()  + newline);
		    dialogue.append(endline+newline);
		} else if (rand == 2){
		    currentEnemy.attack3(currentPoke);
		    dialogue.append("Enemy CHARMANDER used FLAMETHROWER on your " + currentPoke.getSpecies().toUpperCase()  + newline);
		    dialogue.append(endline+newline);
		}
	    } else if (currentEnemy.getSpecies() == "pikachu"){
		if (rand == 0){
		    currentEnemy.attack1(currentPoke);
		    dialogue.append("Enemy PIKACHU used HEADBUTT on your " + currentPoke.getSpecies().toUpperCase()  + newline);
		    dialogue.append(endline+newline);
		} else if (rand == 1){
		    currentEnemy.attack2(currentPoke);
		    dialogue.append("Enemy PIKACHU used SPARK on your " + currentPoke.getSpecies().toUpperCase()  + newline);
		    dialogue.append(endline+newline);
		} else if (rand == 2){
		    currentEnemy.attack3(currentPoke);
		    dialogue.append("Enemy PIKACHU used THUNDER on your " + currentPoke.getSpecies().toUpperCase()  + newline);
		    dialogue.append(endline+newline);
		}
	    } else if (currentEnemy.getSpecies() == "squirtle"){
		if (rand == 0){
		    currentEnemy.attack1(currentPoke);
		    dialogue.append("Enemy SQUIRTLE used SCRATCH on your " + currentPoke.getSpecies().toUpperCase()  + newline);
		    dialogue.append(endline+newline);
		} else if (rand == 1){
		    currentEnemy.attack2(currentPoke);
		    dialogue.append("Enemy SQUIRTLE used WATERSPOUT on your " + currentPoke.getSpecies().toUpperCase()  + newline);
		    dialogue.append(endline+newline);
		} else if (rand == 2){
		    currentEnemy.attack3(currentPoke);
		    dialogue.append("Enemy SQUIRTLE used WATERGUN on your " + currentPoke.getSpecies().toUpperCase() + newline);
		    dialogue.append(endline+newline);
		}
	    }
	    
	    ashturn = true;
	}
	
	myHP.setText(""+currentPoke.getHealth());
	enemyHP.setText(""+currentEnemy.getHealth());
    }
    

    // DRIVER
    public static void main(String[] args){
	guimon f = new guimon();
	f.setTitle("JAVAMON - A POKEMON CLONE");
	f.setSize(400,720);
	f.setVisible(true);
	f.text.setRows(f.getyBound());
	f.text.setColumns(f.getxBound());
    
    }

}
