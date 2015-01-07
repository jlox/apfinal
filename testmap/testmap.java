import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class testmap extends JFrame implements ActionListener{

    private Container pane;
    private JTextArea text = new JTextArea();
    private JPanel canvas;
    String swagger = "what??";
    mapmaker g = new mapmaker();
    int ycor;
    int xcor;
    int[] currentMap = {1,2,3,4,5,6,7,8,9};
    // To implement:
    
    /* Make a getCurrentMap function that will check the currentMap variable
       and then based on that will pull the specific map (ex. g.board) for
       moving around in.

     */
    
    public void


    public testmap(){
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = getContentPane();
	pane.setLayout(new FlowLayout());
	text.setColumns(50);
	text.setRows(30);
	text.setBorder(BorderFactory.createLineBorder(Color.red,2));
	text.setEditable(false);
	Font font = new Font("Monospaced", Font.PLAIN, 20);
	text.setFont(font);
	text.setForeground(Color.RED);
	pane.add(text);
	text.addKeyListener(new Key());
    }
		
 
    public void actionPerformed(ActionEvent e) {}

    public class Key implements KeyListener {
		
	public void keyPressed(KeyEvent e) {
	    int c = e.getKeyCode();
	    if (c == KeyEvent.VK_SPACE){
		g.board[1][1] = '@';
		xcor = 1;
		ycor = 1;
	    }
	    if (c == KeyEvent.VK_LEFT){
		if (xcor - 1 >= 0) {
		    g.board[ycor][xcor] = ' ';
		    xcor = xcor - 1;
		    g.board[ycor][xcor] = '@';
		    swagger = g.showMap(g.(currentmap));
		    text.setText(swagger);
		}
	    }
	    if (c == KeyEvent.VK_RIGHT){
		if (xcor + 1 < 10) {
		    g.board[ycor][xcor] = ' ';
		    xcor = xcor + 1;
		    g.board[ycor][xcor] = '@';
		    swagger = g.showMap(g.(currentmap));
		    text.setText(swagger);
		}
	    }
	    if (c == KeyEvent.VK_UP){
		if (ycor - 1 >= 0 && (g(ycor - 1)!= "_")) {
		    g.board[ycor][xcor] = ' ';
		    ycor = ycor - 1;
		    g.board[ycor][xcor] = '@';
		    swagger = g.showMap(g.(currentmap));
		    text.setText(swagger);
		}
	    }
	    if (c == KeyEvent.VK_DOWN){
		if (ycor + 1 < 10) {
		    g.board[ycor][xcor] = ' ';
		    ycor = ycor + 1;
		    g.board[ycor][xcor] = '@';
		    swagger = g.showMap(g.(currentmap));
		    text.setText(swagger);
		}
	    }
	}

	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
    }


    public static void main(String[] args) {
	testmap f = new testmap();
	f.setTitle("Testmap");
	f.setSize(1000,700);
	f.setVisible(true);
    
    }


}



