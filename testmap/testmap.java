import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class testmap extends JFrame implements ActionListener{

    private Container pane;
    private JTextArea text = new JTextArea();
    private JPanel canvas;
    String swagger = "what??";




    public testmap(){
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = getContentPane();
	pane.setLayout(new FlowLayout());
	text.setColumns(40);
	text.setRows(10);
	text.setBorder(BorderFactory.createLineBorder(Color.red,2));
	text.setEditable(false);
	pane.add(text);
	text.addKeyListener(new Key());
    }
		
 
    public void actionPerformed(ActionEvent e) {}

    public class Key implements KeyListener {
		
	public void keyPressed(KeyEvent e) {
	    int c = e.getKeyCode();

	    if (c == KeyEvent.VK_LEFT){
		swagger = "left!!" + "\n wow";
		text.setText(swagger);
	    }
	    if (c == KeyEvent.VK_RIGHT){
		swagger = "right!!";
		text.setText(swagger);
	    }
	    if (c == KeyEvent.VK_UP){
		swagger = "up!!";
		text.setText(swagger);
	    }
	    if (c == KeyEvent.VK_DOWN){
		swagger = "down!!";
		text.setText(swagger);
	    }
	}

	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
    }


    public static void main(String[] args) {
	testmap f = new testmap();
	mapmaker x = new mapmaker();
	System.out.println(x.board);
	f.setTitle("Testmap");
	f.setSize(600,400);
	f.setVisible(true);
    
    }


}



