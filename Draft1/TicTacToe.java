import java.util.ArrayList;
import cs1.Keyboard;

public class TicTacToe{

    private final static int default_size = 3;

    private String[][] _array;

    public TicTacToe{
	_array = new String[default_size][default_size];
    }

    /*
    public TicTacToe(int row, int column){
	if (row >= 3 && column >= 3)
	    _array = new String[row][column];
	else{
	    System.out.println("Invalid _array: all sizes must be of length 3 or greater. Setting to default 3 by 3 tic tac toe.");
	   
		}
    }
    */
  
    public void setup(){
	for (i = 0; i < _array.size() ; i++){
	    for (j = 0; j < _array[].size(); j++)
		_array[i,j] = " ";
	}
    }

    public String rules(){
	return "These are the rules for tic tac toe";
    }

    /*
    public boolean check2O(){
	int ctr = 0;
	for (i = 0; i < _array.size() ; i++){
	    for (j = 0; j < _array.size(); j++){
		if (_array[i][j] == "O"){
		    ctr += 1;
		}
	    }
	    
	}
	return false;
    }
    */
    
    /*   public boolean check3O(){
	for (i = 0; i < _array.size() ; i++){
	    if (_array[i][0] == _array[i][1] && _array[i][2] == _array[i][1] && _array[i][0] == "O")
		return true;
	}
	for (i = 0; i < _array.size() ; i++){
	    if (_array[0][i] == _array[1][i] && _array[2][i] == _array[1][i] && _array[0][i] == "O")
		return true;
	}
	 for (i = 0; i < _array.size() ; i++){
	    if (_array[0][i] == _array[1][i] && _array[2][i] == _array[1][i] && _array[0][i] == "O")
		return true;
	}
	return false;
	
    }
    */
    public void placeO(int row, int column){
	_array[row][column] = "O";
    }
    /*
    public void placeX(int row, int column){
	_array[row][column] = "X";
    }
    */

    public void play(){
	  int guess;

    while( true ) {
	int moves = 9;
	System.out.print("Do you want to: \n1. Go first\n2. Go second");
	choice = Keyboard.readInt();
	if( moves == 0 ) {
	    System.out.println("W00T! It took " + _guessCtr + " guesses");
	    break;
	}
	else if( guess > _target ) {
	    _hi = guess - 1;
	    System.out.println("Too high, chump.");
	}
	else {
	    _lo = guess + 1;
	    System.out.println("Too low, sucker.");
	}
	_guessCtr++;
    }
    
    public static void main(String[] args){
	System.out.println("What kind of tic tac toe do you want to play?");
	
	TicTacToe yay = new Matrix();
    }
}
