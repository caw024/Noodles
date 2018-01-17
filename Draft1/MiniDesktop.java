import java.util.Scanner;
public class MiniDesktop{
    
    public static void select(){
	while (true){
	    System.out.println("Welcome to MiniDesktop 1.0");
	    System.out.println("Which program would you like to open? Type the name (verbatim) below. If you would like to exit, type 'exit'.");
	    System.out.println("texteditor");
	    System.out.println("lettercrush");
	    System.out.println("tictactoe");
	    Scanner a = new Scanner(System.in);
	    String b = a.next();
	    if (b.equals("texteditor")){
	    
	    }
	    else if (b.equals("lettercrush")){
		String[] c = new String[1];
		System.out.println("Opening LetterCrush 1.0");
		System.out.println("");
		LetterCrush.main(c);
	    }
	    else if (b.equals("tictactoe")){
		String[] c = new String[1];
		System.out.println("Opening Tic Tac Toe");
		System.out.println("");
		TicTacToe.main(c);
	    
	    }
	    else if (b.equals("exit")){
		System.out.println("\nExiting...");
		return;
	    }
	    else{
		System.out.println("Application not available. Try again.\n\n");
	    }
	}
      
    }
    public static void main(String[] args){
	select();
    }
}
