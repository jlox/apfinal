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



    public testmap(){
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = getContentPane();
	pane.setLayout(new FlowLayout());
	text.setColumns(50);
	text.setRows(30);
	text.setBorder(BorderFactory.createLineBorder(Color.red,2));
	text.setEditable(false);
	pane.add(text);
	text.addKeyListener(new Key());
    }
		
 
    public void actionPerformed(ActionEvent e) {}

    public class Key implements KeyListener {
		
	public void keyPressed(KeyEvent e) {
	    int c = e.getKeyCode();
	    if (c == KeyEvent.VK_SPACE){
		g.board[1][1] = '▓';
		xcor = 1;
		ycor = 1;
	    }
	    if (c == KeyEvent.VK_LEFT){
		if (xcor - 1 >= 0) {
		g.board[ycor][xcor] = '▒';
		xcor = xcor - 1;
		g.board[ycor][xcor] = '▓';
		swagger = g.toString();
		text.setText(swagger);
		}
	    }
	    if (c == KeyEvent.VK_RIGHT){
		if (xcor + 1 < 10) {
		    g.board[ycor][xcor] = '▒';
		    xcor = xcor + 1;
		    g.board[ycor][xcor] = '▓';
		    swagger = g.toString();
		    text.setText(swagger);
		}
	    }
	    if (c == KeyEvent.VK_UP){
		if (ycor - 1 >= 0) {
		    g.board[ycor][xcor] = '▒';
		    ycor = ycor - 1;
		    g.board[ycor][xcor] = '▓';
		    swagger = g.toString();
		    text.setText(swagger);
		}
	    }
	    if (c == KeyEvent.VK_DOWN){
		if (ycor + 1 < 10) {
		    g.board[ycor][xcor] = '▒';
		    ycor = ycor + 1;
		    g.board[ycor][xcor] = '▓';
		    swagger = g.toString();
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
	f.setSize(600,400);
	f.setVisible(true);
    
    }


}



