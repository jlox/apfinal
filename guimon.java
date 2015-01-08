import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class guimon extends JFrame implements ActionListener{

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
    int ybound;
    int xbound;
    int mapnum = 0;
    String currentMap;

    public void getBoundaries(){
	ybound = g.home.length;
	xbound = g.home[0].length;
    }
    public int getyBound(){
	return g.home.length;
    }
    public int getxBound(){
	return g.home[0].length;
    }


    public void getCurrentMap(){
	if (mapnum == 0){
	    currentMap = g.showMap(g.home);
	}
    }

    // To implement:
    
    /* Make a getCurrentMap function that will check the currentMap variable
       and then based on that will pull the specific map (ex. g.board) for
       moving around in.

     */


    public guimon(){
	g.makehome();
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
    }
		
 
    public void actionPerformed(ActionEvent e) {}

    public class Key implements KeyListener {
		
	public void direction(int x, int y){
	    getBoundaries();
	    if ((xcor - x > 0) && (xcor - x < xbound - 1) &&
		(ycor - y > 0) && (ycor - y < ybound - 1) && 
		(g.home[ycor-y][xcor-x] == ' ')) 
		{
		g.home[ycor][xcor] = oldtile;
		xcor = xcor - x;
		ycor = ycor - y;
		oldtile = g.home[ycor][xcor];
		g.home[ycor][xcor] = '@';
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
