public class mapmaker {
    char[][] board;

    public mapmaker(int r, int c){
	board = new char[r][c];
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j]=' ';
	    }
	}
		
    }

    public mapmaker(){
	this(10,10);
    }

    public String showMap(char[][] x){
	String s = "";
	for (int i = 0; i < x.length; i++) {
	    for (int j = 0; j < x[i].length; j++) {
		s = s + x[i][j];
	    }
	    s = s + "\n";
	}
	return s;
    }




}
