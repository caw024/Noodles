public class TicTacToe extends Matrix{

    private final static int default_size = 3;

    private String[][] _array;

    public TicTacToe{
	_array = new String[default_size][default_size];
    }
    
    public TicTacToe(int row, int column){
	if (row > 3 && column > 3)
	    _array = new String[row][column];
	else{
	    System.out.println("Invalid _array: all sizes must be of length 3 or greater. Setting to default 3 by 3 tic tac toe.");
	    this.
		}
    }

  
    public void setup(){
	for (i = 0; i < _array.size() ; i++){
	    for (j = 0; j < _array[].size(); j++)
		_array[i,j] = "";
	}
    }

    public String rules(){
	return "These are the rules for tic tac toe";
    }

    public boolean check3O(){
	for (i = 0; i < _array.size() ; i++){
	    for (j = 0; j < _array[].size(); j++)
		_array[i,j];
	}
    }

    public void placeO(int row, int column){
	_array[row][column] = "O";
    }

    public void placeX(int row, int column){
	_array[row][column] = "X";
    }
    
    public static void main(String[] args){
	
    }
}
