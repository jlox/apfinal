public class map{

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

    char[][] home = new char[10][19];
    char[] home1 = {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '['};
    char[] home2 = {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '[', '[', '[', '|'};
    char[] home3 = {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'};
    char[] home4 = {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'};
    char[] home5 = {'|', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'};
    char[] home6 = {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'};
    char[] home7 = {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'};
    char[] home8 = {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'};

    
    char[][] first = new char[20][20];
    char[] first0 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] first1 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] first2 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] first3 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '/', '\\', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] first4 = {'#', '#', '#', '#', '#', '#', '#', '#', '/', ' ', ' ', '\\', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] first5 = {'#', '#', '#', '#', '#', '#', '#', '/', ' ', ' ', ' ', ' ', '\\', '#', '#', '#', '#', '#', '#', '#',};
    char[] first6 = {'#', '#', '#', '#', '#', '#', '#', '|', ' ', '_', '_', ' ', '|', '#', '#', '#', '#', '#', '#', '#',};
    char[] first7 = {'#', '#', '#', '#', '#', '#', '#', '|', ' ', '|', '|', ' ', '|', '#', '#', '#', '#', '#', '#', '#',};
    char[] first8 = {'#', '#', '#', '#', '#', '#', '#', '|', '_', '_', '_', '_', '|', '#', '#', '#', '#', '#', '#', '#',};
    char[] first9 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] firs10 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] firs11 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] firs12 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] firs13 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] firs14 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] firs15 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] firs16 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] firs17 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] firs18 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] firs19 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};

    char[][] sec = new char [20][20];
    char[] sec0 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] sec1 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] sec2 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] sec3 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] sec4 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] sec5 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] sec6 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] sec7 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] sec8 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] sec9 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] se10 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] se11 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] se12 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] se13 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] se14 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] se15 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] se16 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] se17 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] se18 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
    char[] se19 = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};

    public char[] makeroof(int r){
	char[] roof = new char[r];
	int n = 0;
	while (n < r){
	    roof[n] = '_';
	    n = n+1;
	}
	return roof;
    }
    public char[]  makefloor(int r){
	char[] floor = new char[r];
	int n = 0;
	while (n < r){
	    floor[n] = '-';
	    n = n+1;
	}
	return floor;
    }	

    public void makehome(){
	int r = 0;
	while (r < 10){
	    if (r == 0){
		home[r] = makeroof(19);
	    } else if (r == 1) {
		home[r] = home1;
	    }
	    else if (r == 2) {
		home[r] = home2;
	    }
	    else if (r == 3) {
		home[r] = home3;
	    }
	    else if (r == 4) {
		home[r] = home4;
	    }
	    else if (r == 5) {
		home[r] = home5;
	    }
	    else if (r == 6) {
		home[r] = home6;
	    }
	    else if (r == 7) {
		home[r] = home7;
	    }
	    else if (r == 8) {
 		home[r] = home8;
	    }
	    else if (r == 9) {
		home[r] = makefloor(19);
	    }
	    r = r + 1;
	}
    }

    public void makefirst(){
	int r = 0;
	while (r < 20){
	    if (r == 0){
		first[r] = first0;
	    } 
	    else if (r == 1){
		first[r] = first1;
	    }
	    else if (r == 2){
		first[r] = first2;
	    }
	    else if (r == 3){
		first[r] = first3;
	    }
	    else if (r == 4){
		first[r] = first4;
	    }
	    else if (r == 5){
		first[r] = first5;
	    }
	    else if (r == 6){
		first[r] = first6;
	    }
	    else if (r == 7){
		first[r] = first7;
	    }
	    else if (r == 8){
		first[r] = first8;
	    }
	    else if (r == 9){
		first[r] = first9;
	    }
	    else if (r == 10){
		first[r] = firs10;
	    }
	    else if (r == 11){
		first[r] = firs11;
	    }
	    else if (r == 12){
		first[r] = firs12;
	    }
	    else if (r == 13){
		first[r] = firs13;
	    }
	    else if (r == 14){
		first[r] = firs14;
	    }
	    else if (r == 15){
		first[r] = firs15;
	    }
	    else if (r == 16){
		first[r] = firs16;
	    }
	    else if (r == 17){
		first[r] = firs17;
	    }
	    else if (r == 18){
		first[r] = firs18;
	    }
	    else if (r == 19){
		first[r] = firs19;
	    }
	}
    }


    public void makesec(){
	int r = 0;
	while (r < 20){
	    if (r == 0){
		sec[r] = sec0;
	    } 
	    else if (r == 1){
		sec[r] = sec1;
	    }
	    else if (r == 2){
		sec[r] = sec2;
	    }
	    else if (r == 3){
		sec[r] = sec3;
	    }
	    else if (r == 4){
		sec[r] = sec4;
	    }
	    else if (r == 5){
		sec[r] = sec5;
	    }
	    else if (r == 6){
		sec[r] = sec6;
	    }
	    else if (r == 7){
		sec[r] = sec7;
	    }
	    else if (r == 8){
		sec[r] = sec8;
	    }
	    else if (r == 9){
		sec[r] = sec9;
	    }
	    else if (r == 10){
		sec[r] = se10;
	    }
	    else if (r == 11){
		sec[r] = se11;
	    }
	    else if (r == 12){
		sec[r] = se12;
	    }
	    else if (r == 13){
		sec[r] = se13;
	    }
	    else if (r == 14){
		sec[r] = se14;
	    }
	    else if (r == 15){
	        sec[r] = se15;
	    }
	    else if (r == 16){
		sec[r] = se16;
	    }
	    else if (r == 17){
		sec[r] = se17;
	    }
	    else if (r == 18){
		sec[r] = se18;
	    }
	    else if (r == 19){
		sec[r] = se19;
	    }
	}
    }
}

/*
Font font = new Font("Monospaced", Font.PLAIN, 12);
text.setFont(font);
*/
