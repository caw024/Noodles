import cs1.Keyboard;

public class TicTacToe{

    private final static int default_size = 3;

    private Object[][] _matrix;

    
    public TicTacToe(){
	_matrix = new Object[default_size][default_size];
    }

    /*
      public TicTacToe(int row, int column){
      if (row >= 3 && column >= 3)
      _matrix = new Object[row][column];
      else{
      System.out.println("Invalid _matrix: all sizes must be of length 3 or greater. Setting to default 3 by 3 tic tac toe.");
	   
      }
      }
    */

    
    public void setup(){
	for (int i = 0; i < size() ; i++){
	    for (int j = 0; j < size(); j++)
		_matrix[i][j] = "_";
	}
    }

    
    private int size(){
	return _matrix.length;
    }

    
    private Object get( int r, int c ){
	return _matrix[r-1][c-1];
    }
  

    public String toString() 
    {
	String foo = "";
	
	for( int i =0; i < size(); i++ ) {
	    foo += i+1 + "  | ";
	    for( int j=0; j < size(); j++ ) {
		foo += _matrix[i][j] + " "; //get(i+1,j+1)
	    }
	    foo += "|\n";
	}
	return foo;
    }
    
    public String rules(){
	return "These are the rules for tic tac toe";
    }

    /*
      public boolean check2O(){
      int ctr = 0;
      for (i = 0; i < _matrix.size() ; i++){
      for (j = 0; j < _matrix.size(); j++){
      if (_matrix[i][j] == "O"){
      ctr += 1;
      }
      }
	    
      }
      return false;
      }
    */

    
    public boolean check3O(){
	//Checks row
	for (int i = 0; i < _matrix.length ; i++){
	    if (_matrix[i][0] == _matrix[i][1] && _matrix[i][2] == _matrix[i][1] && _matrix[i][0] == "O")
		return true;
	}

	//Checks column
	for (int i = 0; i < _matrix.length ; i++){
	    if (_matrix[0][i] == _matrix[1][i] && _matrix[2][i] == _matrix[1][i] && _matrix[0][i] == "O")
		return true;
	}

	//Checks main diagonal

	if (_matrix[0][0] == _matrix[1][1] && _matrix[2][2] == _matrix[1][1] && _matrix[0][0] == "O")
	    return true;

	//Checks back diagonal
	if (_matrix[0][2] == _matrix[1][1] && _matrix[2][0] == _matrix[1][1] && _matrix[1][1] == "O")
	    return true;
    
	return false;
    }
	



    public boolean check3X(){
	//Checks row
	for (int i = 0; i < _matrix.length ; i++){
	    if (_matrix[i][0] == _matrix[i][1] && _matrix[i][2] == _matrix[i][1] && _matrix[i][0] == "X")
		return true;
	}

	//Checks column
	for (int i = 0; i < _matrix.length ; i++){
	    if (_matrix[0][i] == _matrix[1][i] && _matrix[2][i] == _matrix[1][i] && _matrix[0][i] == "X")
		return true;
	}

	//Checks main diagonal

	if (_matrix[0][0] == _matrix[1][1] && _matrix[2][2] == _matrix[1][1] && _matrix[0][0] == "X")
	    return true;

	//Checks back diagonal
	if (_matrix[0][2] == _matrix[1][1] && _matrix[2][0] == _matrix[1][1] && _matrix[1][1] == "X")
	    return true;
    
	return false;
	
    }
    
    public void placeO(int row, int column){
	_matrix[row-1][column-1] = "O";
    }

    
    public void placeX(int row, int column){
	_matrix[row-1][column-1] = "X";
    }

    public Object[] getRow( int r )
    {
	//offset: convert from matrix indexing convention to
	// array indexing convention
	r = r-1;
    
	Object [] foo = new Object[ size() ];
	for( int i = 0; i < _matrix[r].length; i++ ) {
	    foo[i] = _matrix[r][i];
	}//O(n)
	return foo;
    }

    
    public void play3(){
	int moves = 9;
	boolean turn = false;
	System.out.print("Do you want to: \n1. Go first\n2. Go second\n");

	int rowO, columnO, rowX, columnX;
	int choice = Keyboard.readInt();
	if (choice == 1)
	    turn = true;
	else if (choice == 2)
	    turn = false;

	System.out.println(toString());

	while (true) {

	    //Player move
	    while( turn == true ) {
		// Determines result of game
		if (check3X() == true){
		    System.out.println("You win!");
		    return;
		}
	
		else if( moves == 0 ) {
		    System.out.println("It's a draw!");
		    return;
		}

		// Determines a) who goes and b) where the O/X is put
		System.out.println("Which row (between 1 and 3) do you want to put your letter");
		rowO = Keyboard.readInt();

		System.out.println("Which column (between 1 and 3) do you want to put your letter");
		columnO = Keyboard.readInt();

		if (rowO > 3 || rowO < 0 || columnO > 3 || columnO < 0){
		    System.out.println("Invalid numbers! Try again.");
		    break;
		}

		if (get(rowO,columnO) == "_"){
		    placeO(rowO, columnO);
		    System.out.println("success");
		    System.out.println(toString());
		    turn = false;
		    break;
		}

		else
		    System.out.println("Space is already occupied, try again");

		moves--;
	    }

	    
	    //AI move
	    while( turn == false ) {
		// Determines result of game
		if (check3O() == true){
		    System.out.println("AI wins!");
		    return;
		}
	
		else if( moves == 0 ) {
		    System.out.println("It's a draw!");
		    return;
		}

		// Determines a) who goes and b) where the O/X is put
		System.out.println("Which row (between 1 and 3) do you want to put your letter");
		rowX = Keyboard.readInt();

		System.out.println("Which column (between 1 and 3) do you want to put your letter");
		columnX = Keyboard.readInt();

		if (get(rowX, columnX) == "_"){
		    placeX(rowX, columnX);
		    System.out.println("success");
		    System.out.println(toString());
		    turn = true;
		    break;
		}
		
		else
		    System.out.println("Space is already occupied, try again");

		moves--;
	    }

	}
    }


    
    public static void main(String[] args){
	System.out.println("Do you want to play\n\n1: Regular 3 by 3 tic tac toe\n2: Ultimate 9 by 9 tic tac toe\n");
	int hi = Keyboard.readInt();
	if (hi == 1){
	    TicTacToe yay = new TicTacToe();
	    yay.setup();
	    System.out.print(yay);
	    yay.play3();
	    System.out.println("What do you want to do next?");
	}
	else{
	    System.out.print("Sorry");
	}
    }
 
}


