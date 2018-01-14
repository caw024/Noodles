import java.util.Scanner;
public class MiniDesktop{
    
    public static void select(){
	System.out.println("Welcome to MiniDesktop 1.0");
	System.out.println("Which program would you like to open? Type the name below.");
	System.out.println("texteditor");
	System.out.println("calculator");
	System.out.println("lettercrush");
	System.out.println("tictactoe");
	Scanner a = new Scanner(System.in);
	String b = a.next();
	if (b.equals("texteditor")){
	    
	}
	else if (b.equals("calculator")){

	}
	else if (b.equals("lettercrush")){
	    String[] c = new String[1];
	    System.out.println("Opening LetterCrush 1.0");
	    System.out.println("");
	    LetterCrush.main(c);
	}
	else if (b.equals("tictactoe")){

	}
    }
    public static void main(String[] args){
	select();
    }
}
