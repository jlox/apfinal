import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class guimon extends JFrame implements ActionListener{

    JTextField textField = new JTextField(30);
    Container pane;
    JTextArea text = new JTextArea();
    JPanel canvas;
    JTextArea dialogue = new JTextArea();
    JScrollPane scroll = new JScrollPane(dialogue, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    boolean canMove = true;
    int ycor = 5;
    int xcor = 3;
    String swagger = "what??";
    map g = new map();
    char oldtile = ' ';
    char allowedBlock = ' ';
    char door = '+';
    int ybound;
    int xbound;
    int mapnum = 0;
    String currentMap;
    char[][] defaultMap;

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
	}
    }

    // To implement:
    
    /* Make a getCurrentMap function that will check the currentMap variable
       and then based on that will pull the specific map (ex. g.board) for
       moving around in.

     */


    public guimon(){
	getCurrentMap();
	g.makehome();
	g.makefirst();

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
	pane.add(textField);
    }
		
 
    public void actionPerformed(ActionEvent e) {}

    public class Key implements KeyListener {
		
	public void direction(int x, int y){
	    getBoundaries();
	    
	    
	    if ((xcor - x > 0) && (xcor - x < xbound - 1) &&
		(ycor - y > 0) && (ycor - y < ybound - 1) && 
		((defaultMap[ycor-y][xcor-x] == allowedBlock) || 
		 (defaultMap[ycor-y][xcor-x] == door))) {
		defaultMap[ycor][xcor] = oldtile;
		xcor = xcor - x;
		ycor = ycor - y;
		oldtile = defaultMap[ycor][xcor];

		if (defaultMap[ycor][xcor] == '+'){
		    if (mapnum == 0){
			mapnum = 1;
			getCurrentMap();
			swagger = currentMap;
			text.setText(swagger);
			ycor = 9;
			xcor = 10;
			allowedBlock = '#';
			oldtile = '#';
		    }
		    
		    if ((mapnum == 1) && (ycor == 8) && (xcor == 10)) {
			mapnum = 0;
			getCurrentMap();
			swagger = currentMap;
			text.setText(swagger);
			ycor = 1;
			xcor = 16;
			allowedBlock = ' ';
			oldtile = ' ';
		    }
			
		}
		
		defaultMap[ycor][xcor] = '@';
		getCurrentMap();
		swagger = currentMap;
		text.setText(swagger);
		
		
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

}
