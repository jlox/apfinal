import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class guimon extends JFrame implements ActionListener{
    // BOOLEANS
    boolean talk = true;
    boolean canMove = true;

    // GUI SETUP
    JOptionPane textField = new JOptionPane();
    Container pane;
    JTextArea text = new JTextArea();
    JPanel canvas;
    JTextArea dialogue = new JTextArea();
    JScrollPane scroll = new JScrollPane(dialogue, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

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
    boolean encounter;
    String currentString;
    int nomorenamesplz = 0;

    // RIVAL SETUP
    String rivalName = "";
    String rivalStarter;

    // INPUT SETUP
    boolean input1 = true;
    boolean input2 = false;
    boolean input3 = false;
    boolean input4 = false;

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
	}

    }

    public guimon(){
	getCurrentMap();
	g.makehome();
	g.makefirst();
	g.makesec();

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
	dialogue.setRows(6);
	dialogue.setColumns(30);
	dialogue.setEditable(false);
	pane.add(scroll);
	getCurrentMap();
	swagger = currentMap;
	text.setText(swagger);
	
	JButton send = new JButton("INPUT");
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
		    }
		}
	    });
	pane.add(send);
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
		}
		if ((mapnum == 1) &&
		    (ycor == 11) &&
		    (xcor == 13) &&
		    (rivalName == "")) {
		    canMove = false;
		    input2 = true;
		    rivalSelect();
		}
		if ((mapnum == 1) &&
		    (ycor == 11) &&
		    (xcor == 13)) {

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
			    dialogue.append("Your name is "+newName+"."+"\n"+" ");
			    dialogue.append("Your rival's name is "+rivalName+"."+"\n"+" ");
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
		    }
		}
		
		defaultMap[ycor][xcor] = '@';
		getCurrentMap();
		swagger = currentMap;
		text.setText(swagger);
		if (xcor == 5 && newName != ""){
		    dialogue.append(newName+"\n"+" ");
		}
	    }
	}
    
    // STORYLINE + DIALOGUE FUNCTIONS

	public void nameSelect() {
	    String newline = "\n" + " ";
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
	}

	public void rivalSelect() {
	    String newline = "\n"+" ";
	    String g1 = "Oh wait! What's your RIVAL's name?";
	    String g2 = "Please open the INPUT box and type his name.";
	    String g3 = "Afterwards, click the red GAME SCREEN to resume.";
	    String g4 = "If left blank, he will be defaulted to GARY";

	    dialogue.append(g1+newline);
	    dialogue.append(g2+newline);
	    dialogue.append(g3+newline);
	    dialogue.append(g4+newline);
	    
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
