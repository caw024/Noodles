//Letter Crush
import java.util.Scanner;
public class LetterCrush{
    public static String[][] a = new String[6][10];
    public static int turn;
    public static int score;
    public static int gameOn = 1;
    public static void rules(){
	System.out.println("Letter Crush 1.0");
	System.out.println("Rules:");
	System.out.println("You must score by eliminating rows of letters, ranging from row 0 to row 5");
	System.out.println("Every letter in the row you chose that is next to a matching letter will be eliminated.");
	System.out.println("The amount of letters you eliminate will be added to your score");
	System.out.println("The letters will fall if you eliminate letters from rows under them");
	System.out.println("If you try to eliminate a row of letters that has no consecutive letters, you lose");
    }
    public static void pop(){
	String b = "";
	String a1 = " A" ;
	String a2 = " B" ;
	String a3 = " C";
	String a4 = " D";
	for(int i = 0; i < a.length; i++){
	    for(int j = 0; j < a[0].length; j++){
		if (a[i][j] != a1 && a[i][j] != a2 && a[i][j] != a3 && a[i][j] != a4){
		    if (Math.random()>0.5) b = a1;
		    else if (Math.random()>0.5) b = a2;
		    else if (Math.random()>0.5) b = a3;
		    else b = a4;

		    a[i][j]= b;
		}
	    }
	}
	    
    }
    public static void display(){
	String b = "";
	int rowNum = 0;
	System.out.println("----------");
	for(int i = 0; i < a.length; i++){
	    for(int j = 0; j < a[0].length; j++){
	        b += a[i][j];
	    }
	    System.out.println("Row " + rowNum + " " + b);
	    rowNum += 1;
	    b="";
	}
	System.out.println("----------");
    }
    public static void eliminate(int row){
        int savedScore = score;
	
	String[][] b = new String[a.length][a[row].length];
	
        for (int i = 0; i < a.length; i++){
	    for (int j = 0; j < a[row].length; j++){
		b[i][j]=a[i][j];
	    }
	}
	
	for (int i = 0; i < b[row].length-1; i++){
	    if(b[row][i]==b[row][i+1] && !(a[row][i+1].equals("  "))){
	        if(a[row][i].equals("  ")) score +=1;
		else score +=2;
		a[row][i]="  ";
		a[row][i+1]="  ";

		
	    }
	
	}
	display();
	System.out.println("After the letters fall:");
	for (int h = 0; h < b.length-1; h++){
	for (int i = 0; i < b.length-1; i++){
	    for (int j = 0; j< b[row].length; j++){
		if(a[i+1][j]=="  "){
		    a[i+1][j]=a[i][j];
		    a[i][j]="  ";
		}
	    }
	}
	}
	if (savedScore==score){
	    gameOn = 0;
	}
    }
    public static void next(){
	display();
	System.out.println("Turn: " + turn);
	System.out.println("Score: "+ score);
	System.out.println("continue y/n?");
	Scanner scanA = new Scanner(System.in);
	Scanner scanB = new Scanner(System.in);
	if (gameOn == 1 && scanA.next().equals("y")){
	    turn += 1;
	    eliminate(scanB.nextInt());
	    next();
	}
	else{
	    System.out.println("Game over");
	    String[] c = new String[1];
	    MiniDesktop.main(c);
	}
    }

    public static void main(String[] args){
	LetterCrush z = new LetterCrush();
	pop();
	rules();
	next();
    

    }
}

//arrays
//arraylist
//search algorithms
