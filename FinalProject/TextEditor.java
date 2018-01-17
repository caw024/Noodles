import java.util.Scanner;
import java.util.ArrayList;
public class TextEditor{
    public static int linelength = 100;
    public static ArrayList<String> paragraph = new ArrayList<String>(1);
    public static void write(String b){
	String c = "";
	if(b.length()>linelength){
	    c = b.substring(0,linelength);
	    paragraph.add(c);
	    write(b.substring(linelength+1,b.length()));
	}
	else paragraph.add(b);
    }
    public static void printparagraph(){
	for(int i = 0; i < paragraph.size(); i++){
	    System.out.println(paragraph.get(i));
	}
    }
    public static void next(){
	Scanner scana = new Scanner(System.in);
	System.out.println("Do you wish to continue? y for continue, r for remove and continue");
	String z = scana.next();
	if (z.equals("y")){
	    System.out.println("Your paragraph:");
	    write(scana.next());
	    System.out.println("Justified:");
	    printparagraph();
	    next();
	}
	else if (z.equals("r")){
	    System.out.println("Which row?");
	    remove(scana.nextInt());
	    System.out.println("Removed");
	    printparagraph();
	    next();
	}
    }
    public static void remove(int x){
	paragraph.remove(x);
    }
    public static void main(String[]Args){
	Scanner scanb = new Scanner(System.in);
	System.out.println("TextEditor 1.0");
	System.out.println("What line length would you like to use?");
	linelength = scanb.nextInt();
	next();
	printparagraph();
    }
}
