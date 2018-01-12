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

    
    public boolean check2Orow(){
	 int ctr = 0;
	
	for (int i = 0; i < _matrix.length ; i++){
	    for (int j = 0; j < _matrix.length; j++){
		if (_matrix[i][j] == "O"){
		    ctr += 1;
		}
	    }

	    if (ctr == 2){
		return true;
	    }
	}

	return false;
    }

    
   public boolean check2Ocolumn(){
	 int ctr = 0;
	
	for (int i = 0; i < _matrix.length ; i++){
	    for (int j = 0; j < _matrix.length; j++){
		if (_matrix[j][i] == "O"){
		    ctr += 1;
		}
	    }

	    if (ctr == 2){
		return true;
	    }
	}

	return false;
    }

    
    public boolean check2Omain(){
	int ctr = 0;
	
	for (int i = 0; i < _matrix.length; i++){
	    if (_matrix[i][i] = "O")
		ctr += 1;
	}
	if (ctr == 2){
	    return true;
	}

	return false;
    }

    
     public boolean check2Oback(){
	int ctr = 0;
	
	for (int i = 0; i < _matrix.length; i++){
	    if (_matrix[i][2-i] = "O")
		ctr += 1;
	}
	if (ctr == 2){
	    return true;
	}

	return false;
    }

    
    public boolean check2O(){
	return check2Orow() || check2Ocolumn() || check2Omain() || check2Oback();
    }

    
     public boolean check2Xrow(){
	 int ctr = 0;
	
	for (int i = 0; i < _matrix.length ; i++){
	    for (int j = 0; j < _matrix.length; j++){
		if (_matrix[i][j] == "X"){
		    ctr += 1;
		}
	    }

	    if (ctr == 2){
		return true;
	    }
	}

	return false;
    }

    
   public boolean check2Xcolumn(){
	 int ctr = 0;
	
	for (int i = 0; i < _matrix.length ; i++){
	    for (int j = 0; j < _matrix.length; j++){
		if (_matrix[j][i] == "X"){
		    ctr += 1;
		}
	    }

	    if (ctr == 2){
		return true;
	    }
	}

	return false;
    }

    
    public boolean check2Xmain(){
	int ctr = 0;
	
	for (int i = 0; i < _matrix.length; i++){
	    if (_matrix[i][i] = "X")
		ctr += 1;
	}
	if (ctr == 2){
	    return true;
	}

	return false;
    }

    
     public boolean check2Xback(){
	int ctr = 0;
	
	for (int i = 0; i < _matrix.length; i++){
	    if (_matrix[i][2-i] = "X")
		ctr += 1;
	}
	if (ctr == 2){
	    return true;
	}

	return false;
    }

    
    public boolean check2X(){
	return check2Xrow() || check2Xcolumn() || check2Xmain() || check2Xback();
    }


    
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
	int rowO, columnO, rowX, columnX, choice;
	boolean turn = false;

	while (true){
	    System.out.println("Do you want to: \n1. Go first\n2. Go second\n");

	    
	    try{
		choice = Keyboard.readInt();
		
		if (choice < 3){
		    break;
		}
		
		else if (choice > 2){
		    throw new IllegalArgumentException("Integer not within range, try again!");
		}

	    }
	
	    catch ( Exception e ){
	    }
	}	


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
		    System.out.println(toString());
		    turn = false;
		    break;
		}

		else
		    System.out.println("Space is already occupied, try again");

		moves--;
	    }

	    
	    //AI move
	    if( turn == false ) {
		// Determines result of game
		if (check3O() == true){
		    System.out.println("AI wins!");
		    return;
		}
	
		else if( moves == 0 ) {
		    System.out.println("It's a draw!");
		    return;
		}

		// Block opponent's victory
		if (check2O() == true){
		    
		}

		//Aim for victory
		else if (check2X() == true){
		}

		//Place in middle
		else if ( ){
		}

		else{
		}
		
		if (get(rowX, columnX) == "_"){
		    placeX(rowX, columnX);
		  
		}
		
		
		System.out.println(toString());
		turn = true;

		moves--;
	    }

	}
    }


    
    public static void main(String[] args){

	int hi = 0;
	while (true){
	    while (true){
		System.out.println("\nDo you want to play\n\n1: Regular 3 by 3 tic tac toe\n2: Ultimate 9 by 9 tic tac toe\n");
	    
		try{
		    hi = Keyboard.readInt();
		
		    if (hi < 3){
			break;
		    }
		
		    else if (hi > 2){
			throw new IllegalArgumentException("Integer not within range, try again!");
		    }

		}
	
		catch ( Exception e ){
		}
	    }

	
	    if (hi == 1){
		TicTacToe yay = new TicTacToe();
		yay.setup();
		System.out.print(yay);
		yay.play3();
		System.out.println("What do you want to do next?");
	        break;
	    }
	    else if (hi == 2){
		System.out.print("In progress");
		break;
	    }
	    else{
		System.out.println("Requires an integer input");
	    }
	}
        
    }
}


