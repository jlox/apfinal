import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class guimon extends JFrame implements ActionListener{

    private Container pane;
    private JTextArea text = new JTextArea();
    private JPanel canvas;
    int ycor = 5;
    int xcor = 5;
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
	text.setColumns(30);
	text.setRows(30);
	text.setBorder(BorderFactory.createLineBorder(Color.red,2));
	text.setEditable(false);
	Font font = new Font("Monospaced", Font.PLAIN, 20);
	text.setFont(font);
	pane.add(text);
	text.addKeyListener(new Key());
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

	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
    }


    public static void main(String[] args) {
	guimon f = new guimon();
	f.setTitle("POKEMON: JAVA EDITION");
	f.setSize(500,500);
	f.setVisible(true);
	f.text.setRows(f.getyBound());
	f.text.setColumns(f.getxBound());
    
    }


}
