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


// ADD CONSTRUCTOR FOR POKEMON AND MAKE WILD WEAKER!!!!!!!!


public class guimon extends JFrame implements ActionListener{

    Random randomNumber = new Random();
    String newline = "\n"+" ";
    String endline = "~~~~~~~~~~~~~~~~~~";

    ash a = new ash();

    // BOOLEANS
    boolean canMove = true;
    boolean caught = false;
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
    JLabel versus = new JLabel();
    ImageIcon titleicon = new ImageIcon("javamon.PNG");
    JButton catchorna = new JButton();
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

    ImageIcon pidgFront = new ImageIcon("pidgeyfront.png");
    ImageIcon pidgBack = new ImageIcon("pidgeyback.png");

    ImageIcon rattFront = new ImageIcon("rattatafront.png");
    ImageIcon rattBack = new ImageIcon("rattataback.png");

    ImageIcon furrFront = new ImageIcon("furretfront.png");
    ImageIcon furrBack = new ImageIcon("furretback.png");

    ImageIcon vs = new ImageIcon("VS.png");

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
    int exp = 5;
    String newName = "";
    String starter;
    String attackMethod;
    String currentString;
    boolean dead = false;
    //    pokemon currentPoke;
    
    // String[] party = new String[6];
    pokemon[] party = new pokemon[6];
    int catchnum = 0; // always 6 or less
    int pokenum = 0; // changes based on which pokemon you want to use

    // POKEMON INITIALIZATION

    
    bulbasaur bulb1 = new bulbasaur();
    
    charmander char1 = new charmander();
    
    squirtle squi1 = new squirtle();


    pikachu pika1 = new pikachu();
    pikachu pika2= new pikachu();
    pikachu pika3= new pikachu();
    pikachu pika4= new pikachu();
    pikachu pika5= new pikachu();

    furret furr1 = new furret();
    furret furr2 = new furret();
    furret furr3 = new furret();
    furret furr4 = new furret();
    furret furr5 = new furret();

    rattata ratt1 = new rattata();
    rattata ratt2 = new rattata();
    rattata ratt3 = new rattata();
    rattata ratt4 = new rattata();
    rattata ratt5 = new rattata();

    pidgey pidg1 = new pidgey();
    pidgey pidg2 = new pidgey();
    pidgey pidg3 = new pidgey();
    pidgey pidg4 = new pidgey();
    pidgey pidg5 = new pidgey();
    
    pokemon[] pikachus = new pokemon[5];  
    pokemon[] furrets = new pokemon[5];  
    pokemon[] pidgeys = new pokemon[5];  
    pokemon[] rattatas = new pokemon[5];  
  
    int rattnum = 0;
    int pikanum = 0;
    int pidgnum = 0;
    int furrnum = 0;

    public void makeCatchInventory(){
	for (int i = 0; i<5; i++){
	    if (i == 0){
		pikachus[i] = pika1;
		furrets[i] = furr1;
		pidgeys[i] = pidg1;
		rattatas[i] = ratt1;
	    }
	    if (i == 1){
		pikachus[i] = pika2;
		furrets[i] = furr2;
		pidgeys[i] = pidg2;
		rattatas[i] = ratt2;
	    }
	    if (i == 2){
		pikachus[i] = pika3;
		furrets[i] = furr3;
		pidgeys[i] = pidg3;
		rattatas[i] = ratt3;
	    }
	    if (i == 3){
		pikachus[i] = pika4;
		furrets[i] = furr4;
		pidgeys[i] = pidg4;
		rattatas[i] = ratt4;
	    }
	    if (i == 4){
		pikachus[i] = pika5;
		furrets[i] = furr5;
		pidgeys[i] = pidg5;
		rattatas[i] = ratt5;
	    }
	}
    }

    String whichPoke;
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
    /*
    bulbasaur wildbulb1 = new bulbasaur(30);
    charmander wildchar1 = new charmander(30);
    squirtle wildsqui1 = new squirtle(30);
    */
    
    pikachu wildpika1 = new pikachu(20);
    pidgey wildpidg1 = new pidgey(30);
    furret wildfurr1 = new furret(30);
    rattata wildrat1 = new rattata(30);
    
    ArrayList<pokemon> wildpoke = new ArrayList<pokemon>();

    public void makeWildPoke(){
	/*
	wildpoke.add(wildbulb1);
	wildpoke.add(wildchar1);
	wildpoke.add(wildsqui1);
	*/
	wildpoke.add(wildpika1);
	wildpoke.add(wildpidg1);
	wildpoke.add(wildrat1);
	wildpoke.add(wildfurr1);
				
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
	} else if (mapnum == 5){
	    currentMap = g.showMap(g.fou);
	    defaultMap = g.fou;
	} else if (mapnum == 6){
	    currentMap = g.showMap(g.pc);
	    defaultMap = g.pc;
	} else if (mapnum == 7){
	    currentMap = g.showMap(g.gym);
	    defaultMap = g.gym;
	}
    }
    
    public guimon(){
	// party[pokenum] = bulb1;
	makeWildPoke();
	getCurrentMap();
	g.makehome();
	g.makefirst();
	g.makesec();
	g.makelab();
	g.makethi();
	g.makefou();
	g.makepc();
	g.makegym();

	makeCatchInventory();

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
	pane.add(versus);
	versus.setIcon(vs);
	versus.setVisible(false);
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
	ability1.setVisible(false);
	ability2.setVisible(false);
	ability3.setVisible(false);

	catchorna = new JButton("THROW A POKEBALL?");
	catchorna.setVisible(false);
	catchorna.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    catchPoke(currentEnemy);
		    catchorna.setVisible(false);
		}
	    });
	
	    
	// "CONTINUE CONVERSATION" BUTTON
	goTalk = new JButton("OK");
	goTalk.setVisible(false);
	goTalk.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    if (!(talkedToOak1)){
			talkedToOak1 = true;
		    }
		    if (dead){
			heal();
			teleportPC();
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
			String[] options = new String[] {"BULBASAUR", "CHARMANDER", "SQUIRTLE"};
			    int response = JOptionPane.showOptionDialog(null, "Pick a pokemon!", "Choose!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	
			    if (response == 0){
				party[0] = bulb1;
			    } else if (response == 1){
				party[0] = char1;
			    } else if (response == 2){
				party[0] = squi1;
			    }
			    input3 = false;
			    talkedToOak2 = true;
			    send.setVisible(false);
			    dialogue.append("Great decision! "+newline);
			    dialogue.append("You picked "+party[catchnum].getSpecies()+"!"+newline + endline+newline);
			    goTalk.setVisible(true);
			    door1 = true;
			    catchnum = catchnum + 1;
			/*
			String input = JOptionPane.showInputDialog(guimon.this, "Please type in the name of the pokemon you want to select.");
			dialogue.append(input+newline);
			if (((input != null) && (!input.isEmpty())) || input.toUpperCase() == "BULBASAUR" || input.toUpperCase() == "CHARMANDER" || input.toUpperCase() == "SQUIRTLE") {
			    whichPoke = input.toUpperCase();
			} else if (input.isEmpty()) {
			    whichPoke = "BULBASAUR";
			}*/

			
			/*
			  if (whichPoke == "BULBASAUR"){
			    party[catchnum] = bulb1;
			} else if (whichPoke == "SQUIRTLE"){
			    party[catchnum] = squi1;
			} else if (whichPoke == "CHARMANDER"){
			    party[catchnum] = char1;
			} else {
			    party[catchnum] = bulb1;
			}
			*/
			// dialogue.append(party[pokenum].getSpecies());
		    }
		    // FOR BATTLING

		    if (encounter && ashturn){
			if (party[pokenum].getSpecies() == "bulbasaur"){
			    String[] options = new String[] {"TACKLE", "VINE WHIP", "LEAF STORM"};
			    int response = JOptionPane.showOptionDialog(null, "Choose an attack!", "BATTLE!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			    if (response == 0){
				move1 = true;
			    } else if (response == 1){
				move2 = true;
			    } else if (response == 2){
				move3 = true;
			    }
			}
			if (party[pokenum].getSpecies() == "charmander"){
			    String[] options = new String[] {"CUT", "EMBER", "FLAMETHROWER"};
			    int response = JOptionPane.showOptionDialog(null, "Choose an attack!", "BATTLE!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			    if (response == 0){
				move1 = true;
			    } else if (response == 1){
				move2 = true;
			    } else if (response == 2){
				move3 = true;
			    }
			}
			if (party[pokenum].getSpecies() == "squirtle"){
			    String[] options = new String[] {"SCRATCH", "WATER SPOUT", "WATER GUN"};
			    int response = JOptionPane.showOptionDialog(null, "Choose an attack!", "BATTLE!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			    if (response == 0){
				move1 = true;
			    } else if (response == 1){
				move2 = true;
			    } else if (response == 2){
				move3 = true;
			    }
			}
			if (party[pokenum].getSpecies() == "rattata"){
			    String[] options = new String[] {"TACKLE", "BITE", "SCRATCH"};
			    int response = JOptionPane.showOptionDialog(null, "Choose an attack!", "BATTLE!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			    if (response == 0){
				move1 = true;
			    } else if (response == 1){
				move2 = true;
			    } else if (response == 2){
				move3 = true;
			    }
			}
			if (party[pokenum].getSpecies() == "pidgey"){
			    String[] options = new String[] {"PECK", "SCRATCH", "WING ATTACK"};
			    int response = JOptionPane.showOptionDialog(null, "Choose an attack!", "BATTLE!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			    if (response == 0){
				move1 = true;
			    } else if (response == 1){
				move2 = true;
			    } else if (response == 2){
				move3 = true;
			    }
			}
			if (party[pokenum].getSpecies() == "furret"){
			    String[] options = new String[] {"BODY SLAM", "TAILWHIP", "HEADBUTT"};
			    int response = JOptionPane.showOptionDialog(null, "Choose an attack!", "BATTLE!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			    if (response == 0){
				move1 = true;
			    } else if (response == 1){
				move2 = true;
			    } else if (response == 2){
				move3 = true;
			    }
			}
			
			yourTurn();
		    }
		}
	    });
	pane.add(send);
	pane.add(goTalk);
	pane.add(catchorna);
    }
	    
    public void checkDead(){
	int check = 0;
	for (int i = 0;i<catchnum;i++){
	    if (party[i].getHealth() <= 0){
		check = check + 1;
	    }
	}
	if (check == catchnum){
	    dead = true;
	} else {
	    dead = false;
	}
    }
 
    public void catchPoke(pokemon other){
	int chance = randomNumber.nextInt(10);
	if (chance < 3){
	    if (other.getSpecies() == "pikachu"){
		party[catchnum] = pikachus[pikanum];
		pikanum = pikanum + 1;
		catchnum = catchnum + 1;
	    } else if (other.getSpecies() == "rattata"){
		party[catchnum] = rattatas[rattnum];
		rattnum = rattnum + 1;
		catchnum = catchnum + 1;
	    } else if (other.getSpecies() == "pidgey"){
		party[catchnum] = pidgeys[pidgnum];
		pidgnum = pidgnum + 1;
		catchnum = catchnum + 1;
	    } else if (other.getSpecies() == "furret"){
		party[catchnum] = rattatas[rattnum];
		furrnum = furrnum + 1;
		catchnum = catchnum + 1;
	    }	    
	    caught = true;
	} else {
	    dialogue.append("Your pokeball failed!"+newline+endline+newline);
	}
    }
    
    public void heal(){
	for (int i = 0;i<catchnum;i++){
	    party[i].setHealth(100);
	}
	dead = false;
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
			    versus.setVisible(true);
			    text.setVisible(false);
			    encounter = true;
			    canMove = false;
			    send.setText("CHOOSE AN ATTACK!");
			    // CurrentPoke();
			    // getCurrentEnemy();
			    // getMoveNames(party[pokenum]);
			    // getMoveNames();
			    currentEnemy = wildpoke.get(randomNumber.nextInt(wildpoke.size()));
			    
			    System.out.println(party[pokenum].getSpecies()); // THIS IS THE PROBLEM
			    
			    System.out.println(currentEnemy.getSpecies());
			    
			    dialogue.append("Your "+party[pokenum].getSpecies()+" encounters a wild "+currentEnemy.getSpecies()+"!"+newline+endline+newline+endline+newline+endline+newline);


			    myHP.setVisible(true);
			    enemyHP.setVisible(true);
			    myHP.setText(""+party[pokenum].getHealth());
			    enemyHP.setText(""+currentEnemy.getHealth());

			    if (party[pokenum].getSpecies() == "bulbasaur"){
				yourPokePic.setIcon(bulbBack);
			    } else if (party[pokenum].getSpecies() == "charmander"){
				yourPokePic.setIcon(charBack);
			    } else if (party[pokenum].getSpecies() == "squirtle"){
				yourPokePic.setIcon(squiBack);
			    } else if (party[pokenum].getSpecies() == "pikachu"){
				yourPokePic.setIcon(pikaBack);
			    } else if (party[pokenum].getSpecies() == "pidgey"){
				yourPokePic.setIcon(pidgBack);
			    } else if (party[pokenum].getSpecies() == "furret"){
				yourPokePic.setIcon(furrBack);
			    } else if (party[pokenum].getSpecies() == "rattata"){
				yourPokePic.setIcon(rattBack);
			    }
			    if (currentEnemy.getSpecies() == "bulbasaur"){
				enemyPokePic.setIcon(bulbFront);
			    } else if (currentEnemy.getSpecies() == "charmander"){
				enemyPokePic.setIcon(charFront);
			    } else if (currentEnemy.getSpecies() == "squirtle"){
				enemyPokePic.setIcon(squiFront);
			    } else if (currentEnemy.getSpecies() == "pikachu"){
				enemyPokePic.setIcon(pikaFront);
			    } else if (currentEnemy.getSpecies() == "pidgey"){
				enemyPokePic.setIcon(pidgFront);
			    } else if (currentEnemy.getSpecies() == "furret"){
				enemyPokePic.setIcon(furrFront);
			    } else if (currentEnemy.getSpecies() == "rattata"){
				enemyPokePic.setIcon(rattFront);
			    } 
			}else {
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
		/*if ((mapnum == 1) &&
		    (ycor == 11) &&
		    (xcor == 13) &&
		    (rivalName == "")) {
		    canMove = false;
		    input2 = true;
		    rivalSelect();
		    send.setText("RIVAL?");
		    send.setVisible(true);
		  }
*/
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
		
		if ((mapnum == 4) && 
		    (((ycor == 7) && 
		      ((xcor == 5) || (xcor == 7))) || 
		     ((ycor == 8) && (xcor == 6)))){
		    canMove = false;
		    goTalk.setVisible(true);
		    infoTalk(0);
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
			if ((ycor == 5) && (xcor == 23)){
			    mapnum = 5;
			    getCurrentMap();
			    swagger = currentMap;
			    text.setText(swagger);
			    ycor = 10;
			    xcor = 2;
			    allowedBlock = ' ';
			    oldtile = ' ';
			}
		    }
		
		    if (mapnum == 5){
			if ((ycor == 10) && (xcor == 1)){
			    mapnum = 4;
			    getCurrentMap();
			    swagger = currentMap;
			    text.setText(swagger);
			    ycor = 5;
			    xcor = 22;
			    allowedBlock = ' ';
			    oldtile = ' ';
			}
			if ((ycor == 5) && ((xcor == 12)||(xcor == 13))){
			    mapnum = 6;
			    getCurrentMap();
			    swagger = currentMap;
			    text.setText(swagger);
			    ycor = 8;
			    xcor = 9;
			    allowedBlock = ' ';
			    oldtile = ' ';
			}
			if ((ycor == 8) && (xcor == 23)){
			    mapnum = 7;
			    getCurrentMap();
			    swagger = currentMap;
			    text.setText(swagger);
			    ycor = 8;
			    xcor = 9;
			    allowedBlock = ' ';
			    oldtile = ' ';
			}
		    }
		    if (mapnum == 6){
			if ((ycor == 9) && (xcor == 9)){
			    mapnum = 5;
			    getCurrentMap();
			    swagger = currentMap;
			    text.setText(swagger);
			    ycor = 6;
			    xcor = 13;
			    allowedBlock = ' ';
			    oldtile = ' ';
			}
		    }
		    if (mapnum == 7){
			if ((ycor == 9) && (xcor == 9)){
			    mapnum = 5;
			    getCurrentMap();
			    swagger = currentMap;
			    text.setText(swagger);
			    ycor = 9;
			    xcor = 23;
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
	    dialogue.append("Please select a pokemon."+newline);
	    dialogue.append("~~~~~~~~~~~~~~~~~~~~~~~"+newline);	    
	    
	}

	public void infoTalk(int i){
	    if (i == 0){
		dialogue.append("I've restored all of your Pokemon to full HP."+newline);
		dialogue.append("Be wary of the tall grass, marked by (!)." + newline);
		dialogue.append("It's said to be inhabited by wild Pokemon."+newline);
		dialogue.append(endline+newline);
		heal();
	    }

	    if (i == 1){
		
	    }
	    if (i == 2){

	    }
	    if (i == 3){

	    }
	    if (i == 4){

	    }


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
    
    
    /* public void getCurrentPoke(){
	party[pokenum] = party[pokenum];
    }
    */

    public void getCurrentEnemy(){
	currentEnemy = wildpoke.get(randomNumber.nextInt(wildpoke.size()));
    }

    public void healWild(){
	for (int i = 0;i<wildpoke.size();i++){
	    wildpoke.get(i).setHealth(100);
	}
    }
   
   
    public void teleportPC(){
	defaultMap[ycor][xcor] = oldtile;
	mapnum = 5;
	getCurrentMap();
	swagger = currentMap;
	text.setText(swagger);
	ycor = 6;
	xcor = 13;
	allowedBlock = ' ';
	oldtile = ' ';
	
	defaultMap[ycor][xcor] = '@';
	getCurrentMap();
	swagger = currentMap;
	text.setText(swagger);
    }


    
    public void yourTurn(){ // edit the "enemy" and boolean things
	if (encounter) {
	    text.setVisible(false);
	    /*
	      if ((currentEnemy.getHealth() < 10) && (currentEnemy.getHealth() > 0)){
	         catchorna.setVisible(true);		
	      }
	    */
	    // currentEnemy.setStrength(party[pokenum].getStrength() + (randomNumber.nextInt(6) - 5));
	    if ((party[pokenum].getHealth() <= 0 ) || caught){
		encounter = false;
		text.setVisible(true);
		send.setVisible(false);
		ashturn = true;

		goTalk.setVisible(true);
		myHP.setVisible(false);
		enemyHP.setVisible(false);
		versus.setVisible(false);
		yourPokePic.setVisible(false);
		enemyPokePic.setVisible(false);
		checkDead();

		if (caught){
		    dialogue.append("You have caught the wild "+currentEnemy.getSpecies()+"!"+newline+endline+newline);
		}
		if (dead){
		    dialogue.append("You have run out of usable pokemon!"+newline);
		    dialogue.append("You will be sent to the nearest Pokemon Center."+newline);
		    dialogue.append(endline+newline);
		}
	    } else if (party[pokenum].getSpecies() == "bulbasaur"){
		if (move1){
		    party[pokenum].attack2(currentEnemy);
		    dialogue.append("Your BULBASAUR used TACKLE!" + newline);
		    dialogue.append(endline+newline);
		} else if (move2){
		    party[pokenum].attack2(currentEnemy);
		    dialogue.append("Your BULBASAUR used VINE WHIP!" + newline);
		    dialogue.append(endline+newline);
		} else if (move3){
		    party[pokenum].attack3(currentEnemy);
		    dialogue.append("Your BULBASAUR used LEAF STORM!" + newline);
		    dialogue.append(endline+newline);
	    }
	} else if (party[pokenum].getSpecies() == "charmander"){
		if (move1){
		    party[pokenum].attack1(currentEnemy);
		    dialogue.append("Your CHARMANDER used CUT!" + newline); 
		    dialogue.append(endline+newline);
		} else if (move2){
		    party[pokenum].attack2(currentEnemy);
		    dialogue.append("Your CHARMANDER used EMBER!" + newline);
		    dialogue.append(endline+newline);
		} else if (move3){
		    party[pokenum].attack3(currentEnemy);
		    dialogue.append("Your CHARMANDER used FLAMETHROWER!" + newline);
		    dialogue.append(endline+newline);
		}
	    } else if (party[pokenum].getSpecies() == "pikachu"){
		if (move1){
		    party[pokenum].attack1(currentEnemy);
		    dialogue.append("Your PIKACHU used HEADBUTT!"+newline);
		    dialogue.append(endline+newline);
		} else if (move2){
		    party[pokenum].attack2(currentEnemy);
		    dialogue.append("Your PIKACHU used SPARK!" + newline);
		    dialogue.append(endline+newline);
		} else if (move3){
		    party[pokenum].attack3(currentEnemy);
		    dialogue.append("Your PIKACHU used THUNDER!" + newline);
		    dialogue.append(endline+newline);
		}
	    } else if (party[pokenum].getSpecies() == "squirtle"){
		if (move1){
		    party[pokenum].attack1(currentEnemy);
		    dialogue.append("Your SQUIRTLE used SCRATCH!"  + newline);
		    dialogue.append(endline+newline);
		} else if (move2){
		    party[pokenum].attack2(currentEnemy);
		    dialogue.append("Your SQUIRTLE used WATERSPOUT!" + newline);
		    dialogue.append(endline+newline);
		} else if (move3){
		    party[pokenum].attack3(currentEnemy);
		    dialogue.append("Your SQUIRTLE used WATERGUN!" + newline);
		    dialogue.append(endline+newline);
		}
	    } else if (currentEnemy.getSpecies() == "pidgey"){
		if (move1){
		    party[pokenum].attack1(currentEnemy);
		    dialogue.append("Your PIDGEY used PECK!" + newline);
		    dialogue.append(endline+newline);
		} else if (move2){
		    party[pokenum].attack2(currentEnemy);
		    dialogue.append("Your PIDGEY used WING ATTACK!" + newline);
		    dialogue.append(endline+newline);
		} else if (move3){
		    party[pokenum].attack3(currentEnemy);
		    dialogue.append("Your PIDGEY used SCRATCH!" + newline);
		    dialogue.append(endline+newline);
		}
	    } else if (party[pokenum].getSpecies() == "furret"){
		if (move1){
		    party[pokenum].attack1(currentEnemy);
		    dialogue.append("Your FURRET used TACKLE!" + newline);
		    dialogue.append(endline+newline);
		} else if (move2){
		    party[pokenum].attack2(currentEnemy);
		    dialogue.append("Your FURRET used HEADBUTT!" + newline);
		    dialogue.append(endline+newline);
		} else if (move3){
		    party[pokenum].attack3(currentEnemy);
		    dialogue.append("Your FURRET used TAILWHIP!" + newline);
		    dialogue.append(endline+newline);
		}
	    } else if (party[pokenum].getSpecies() == "rattata"){
		if (move1){
		    party[pokenum].attack1(currentEnemy);
		    dialogue.append("Your RATTATA used TACKLE!" + newline);
		    dialogue.append(endline+newline);
		} else if (move2){
		    party[pokenum].attack2(currentEnemy);
		    dialogue.append("Your RATTATA used BITE!" + newline);
		    dialogue.append(endline+newline);
		} else if (move3){
		    party[pokenum].attack3(currentEnemy);
		    dialogue.append("Your RATTATA used SCRATCH!" + newline);
		    dialogue.append(endline+newline);
		}
	    }
	    
	    
	    move1 = false;
	    move2 = false;
	    move3 = false;
	    enemyTurn();	  
	}
	
	myHP.setText(""+party[pokenum].getHealth());
	enemyHP.setText(""+currentEnemy.getHealth());
    }
 
    public void enemyTurn(){
	int rand = randomNumber.nextInt(3);
	if (encounter) {
	    text.setVisible(false);
	    /*
	      if ((currentEnemy.getHealth() < 10) && (currentEnemy.getHealth() > 0)){
		catchorna.setVisible(true);		
	    }
	    */
	    if ((currentEnemy.getHealth() <= 0) || caught){
		encounter = false;
		text.setVisible(true);	
		send.setVisible(false); 
		ashturn = true;
		goTalk.setVisible(true);
		myHP.setVisible(false);
		enemyHP.setVisible(false);
		versus.setVisible(false);
		yourPokePic.setVisible(false);
		enemyPokePic.setVisible(false);
		if (caught){
		    dialogue.append("You have caught the wild "+currentEnemy.getSpecies()+"!"+newline+endline+newline);
		}
		healWild();
		checkDead();
		if (!dead){
		    dialogue.append("You have defeated the enemy "+currentEnemy.getSpecies()+"!"+newline);
		    dialogue.append(endline+newline);
		    // party[pokenum].setStrength(party[pokenum].getStrength() + exp);
		} else {
		    dialogue.append("You have run out of usable pokemon!"+newline);
		    dialogue.append("You will be sent to the nearest Pokemon Center."+newline);
		    dialogue.append(endline+newline);
		}
	    } else if (currentEnemy.getSpecies() == "bulbasaur"){
		if (rand == 0){
		    currentEnemy.attack1(party[pokenum]);
		    dialogue.append("Enemy BULBASAUR used TACKLE!" + newline);
		    dialogue.append(endline+newline);
		} else if (rand == 1){
		    currentEnemy.attack2(party[pokenum]);
		    dialogue.append("Enemy BULBASAUR used VINE WHIP!" + newline);
		    dialogue.append(endline+newline);
		} else if (rand == 2){
		    currentEnemy.attack3(party[pokenum]);
		    dialogue.append("Enemy BULBASAUR used LEAF STORM!" + newline);
		    dialogue.append(endline+newline);
		}
	    } else if (currentEnemy.getSpecies() == "charmander"){
		if (rand == 0){
		    currentEnemy.attack1(party[pokenum]);
		    dialogue.append("Enemy CHARMANDER used CUT!"+ newline); 
		    dialogue.append(endline+newline);
		} else if (rand == 1){
		    currentEnemy.attack2(party[pokenum]);
		    dialogue.append("Enemy CHARMANDER used EMBER!" + newline);
		    dialogue.append(endline+newline);
		} else if (rand == 2){
		    currentEnemy.attack3(party[pokenum]);
		    dialogue.append("Enemy CHARMANDER used FLAMETHROWER!"  + newline);
		    dialogue.append(endline+newline);
		}
	    } else if (currentEnemy.getSpecies() == "pikachu"){
		if (rand == 0){
		    currentEnemy.attack1(party[pokenum]);
		    dialogue.append("Enemy PIKACHU used HEADBUTT!" + newline);
		    dialogue.append(endline+newline);
		} else if (rand == 1){
		    currentEnemy.attack2(party[pokenum]);
		    dialogue.append("Enemy PIKACHU used SPARK!" + newline);
		    dialogue.append(endline+newline);
		} else if (rand == 2){
		    currentEnemy.attack3(party[pokenum]);
		    dialogue.append("Enemy PIKACHU used THUNDER!" + newline);
		    dialogue.append(endline+newline);
		}
	    } else if (currentEnemy.getSpecies() == "squirtle"){
		if (rand == 0){
		    currentEnemy.attack1(party[pokenum]);
		    dialogue.append("Enemy SQUIRTLE used SCRATCH!" + newline);
		    dialogue.append(endline+newline);
		} else if (rand == 1){
		    currentEnemy.attack2(party[pokenum]);
		    dialogue.append("Enemy SQUIRTLE used WATERSPOUT!" + newline);
		    dialogue.append(endline+newline);
		} else if (rand == 2){
		    currentEnemy.attack3(party[pokenum]);
		    dialogue.append("Enemy SQUIRTLE used WATERGUN!" + newline);
		    dialogue.append(endline+newline);
		}
	    } else if (currentEnemy.getSpecies() == "pidgey"){
		if (rand == 0){
		    currentEnemy.attack1(party[pokenum]);
		    dialogue.append("Enemy PIDGEY used PECK!" + newline);
		    dialogue.append(endline+newline);
		} else if (rand == 1){
		    currentEnemy.attack2(party[pokenum]);
		    dialogue.append("Enemy PIDGEY used WING ATTACK!" + newline);
		    dialogue.append(endline+newline);
		} else if (rand == 2){
		    currentEnemy.attack3(party[pokenum]);
		    dialogue.append("Enemy PIDGEY used SCRATCH!" + newline);
		    dialogue.append(endline+newline);
		}
	    } else if (currentEnemy.getSpecies() == "furret"){
		if (rand == 0){
		    currentEnemy.attack1(party[pokenum]);
		    dialogue.append("Enemy FURRET used TACKLE!" + newline);
		    dialogue.append(endline+newline);
		} else if (rand == 1){
		    currentEnemy.attack2(party[pokenum]);
		    dialogue.append("Enemy FURRET used HEADBUTT!" + newline);
		    dialogue.append(endline+newline);
		} else if (rand == 2){
		    currentEnemy.attack3(party[pokenum]);
		    dialogue.append("Enemy FURRET used TAILWHIP!" + newline);
		    dialogue.append(endline+newline);
		}
	    } else if (currentEnemy.getSpecies() == "rattata"){
		if (rand == 0){
		    currentEnemy.attack1(party[pokenum]);
		    dialogue.append("Enemy RATTATA used TACKLE!" + newline);
		    dialogue.append(endline+newline);
		} else if (rand == 1){
		    currentEnemy.attack2(party[pokenum]);
		    dialogue.append("Enemy RATTATA used BITE!" + newline);
		    dialogue.append(endline+newline);
		} else if (rand == 2){
		    currentEnemy.attack3(party[pokenum]);
		    dialogue.append("Enemy RATTATA used SCRATCH!" + newline);
		    dialogue.append(endline+newline);
		}
	    }
	    
	    ashturn = true;
	}
	
	myHP.setText(""+party[pokenum].getHealth());
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
