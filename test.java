public class Driver {
    public static void main(String[] args){
	new String ANSI_RED = "\u001B[31m";
	System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
    }
}
