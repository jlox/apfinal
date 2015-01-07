public class map{
    char[][] home = new char[10][19];
    char[] home1 = {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'}
    char[] home2 = {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'}
    char[] home3 = {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'}
    char[] home4 = {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'}
    char[] home5 = {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'}
    char[] home6 = {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'}
    char[] home7 = {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'}
    char[] home8 = {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'}
    
    char[][] m1 = new char[20][20];
    
    public void makeroof(int r){
	char[] roof = new char[r];
	int n = 0;
	while (n < r){
	    char[n] = '_';
	    n = n+1
	}
    }
    public void makefloor(int r){
	char[] floor = new char[r];
	int n = 0;
	while (n < r){
	    char[n] = '-';
	    n = n+1
	}
    }	

    public void makehome(){
	r = 0;
	while (r < 10){
	    if (r = 0){
		home[r]=makeroof(19);
	    } else {
		if (r = 1) {
		    home[r]=home1[];
		}
	    } else {
		if (r = 2) {
		    home[r]=home2[];
		}
	    } else {
		if (r = 3) {
		    home[r]=home3[];
		}
	    } else {
		if (r = 4) {
		    home[r]=home4[];
		}
	    } else {
		if (r = 5) {
		    home[r]=home5[];
		}
	    } else {
		if (r = 6) {
		    home[r]=home6[];
		}
	    } else {
		if (r = 7) {
		    home[r]=home7[];
		}
	    } else {
		if (r = 8) {
		    home[r]=home8[];
		}
	    } else {
		if (r = 9) {
		    home[r]=makefloor(19);
		}
	    }
	    r = r + 1;
	}
    }
}

/*
Font font = new Font("Monospaced", Font.PLAIN, 12);
text.setFont(font);
*/
