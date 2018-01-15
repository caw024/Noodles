import cs1.Keyboard;

public class TicTacToe{

    private final static int default_size = 3;

    private Object[][] _matrix;

    
    //default constructor
    public TicTacToe(){
	_matrix = new Object[default_size][default_size];
    }

    public TicTacToe(int size){
	_matrix = new Object[size][size];
    }
    
    //sets up the board
    public void setup3(){
	for (int i = 0; i < size() ; i++){
	    for (int j = 0; j < size(); j++)
		_matrix[i][j] = "_";
	}
    }

    public void setup9(){
	for (int i = 0; i < size() ; i++){
	    for (int j = 0; j < size(); j++){
		_matrix[i][j] = "_";
	    }
	}
    }
    
    //returns size of matrix
    private int size(){
	return _matrix.length;
    }

    
    //gets an element in the matrix
    private Object get( int r, int c ){
	return _matrix[r-1][c-1];
    }

    
    //prints the matrix
    public String toString() 
    {
	String foo = "    ";
	for (int i = 0; i < size(); i++){
	    foo += i + 1  + " ";
	    if ((i + 1) % 3 == 0)
		foo += "  ";
	}
	
	foo += "\n";
	
	for( int i = 0; i < size(); i++ ) {
	    foo += i+1  + " | ";
	
	    for( int j=0; j < size(); j++ ) {
		foo += _matrix[i][j]; //get(i+1,j+1)
		if ((j+1) % 3 == 0){
		    foo += " |";
		}
		foo += " ";
	    }
	    foo += "\n";
	    if ((i + 1) % 3 == 0)
		foo += "\n";
	}
	return foo;
    }


    //prints the rules of the game
    public String rules3(){
	return "These are the rules for tic tac toe";
    }


    //gives the row of the first 2 O's in a row (outputs -1 otherwise)
    public int check2ORow(){
	int ctr = 0;
	
	for (int i = 0; i < size() ; i++){
	    if (_matrix[i][2] == "X"){
		break;
	    }

	    for (int j = 0; j < size(); j++){
		if (_matrix[i][j] == "X"){
		    break;
		}
		else if (_matrix[i][j] == "O"){
		    ctr += 1;
		}
	    }

	    if (ctr == 2){
		return i;
	    }
	    ctr = 0;
	}

	return -1;
    }

    
    public int check2OColumn(){
	int ctr = 0;
	
	for (int i = 0; i < size() ; i++){
	    if (_matrix[2][i] == "X"){
		break;
	    }
	    for (int j = 0; j < size(); j++){
		if (_matrix[j][i] == "X"){
		    break;
		}
		if (_matrix[j][i] == "O"){
		    ctr += 1;
		}
		if (ctr == 2){
		    return i;
		}

	    }
	
	    ctr = 0;
	}

	return -1;
    }


    public int check2OMain(){
	int ctr = 0;
	
	for (int i = 0; i < size(); i++){
	    if (_matrix[i][i] == "X"){
		return -1;
	    }
	}
	
	for (int i = 0; i < size(); i++){
	    if (_matrix[i][i] == "O"){
		ctr += 1;
	    }
	    if (ctr == 2 && i == 1){
	        return 2;
	    }
	    if (ctr == 2 && _matrix[0][2] == "O"){
		return 1;
	    }
	    if (ctr == 2 && _matrix[1][1] == "O"){
		return 0;
	    }
	}

	return -1;
    }

    
    public int check2OBack(){
	int ctr = 0;
	
	for (int i = 0; i < size(); i++){
	    if (_matrix[i][2-i] == "X"){
		return -1;
	    }
	}
	     
	for (int i = 0; i < size(); i++){
	    if (_matrix[i][2-i] == "O"){
		ctr += 1;
	    }
	    
	    if (ctr == 2 && i == 1){
	        return 2;
	    }
	    if (ctr == 2 && _matrix[0][2] == "O"){
		return 1;
	    }
	    if (ctr == 2 && _matrix[2][0] == "O"){
		return 0;
	    }
	}

	return -1;
    }

    
    public boolean check2O(){
	return (check2ORow() != -1) || (check2OColumn() != -1) || (check2OMain() != -1) || (check2OBack() != -1);
    }

    









    //Consider the case XXO: (contrdiction)
    public int check2XRow(){
	int ctr = 0;
	
	for (int i = 0; i < size() ; i++){
	    if (_matrix[i][2] == "O"){
		break;
	    }
	    for (int j = 0; j < size(); j++){
		if (_matrix[i][j] == "O"){
		    break;
		}
		else if (_matrix[i][j] == "X"){
		    ctr += 1;
		}
	    }

	    if (ctr == 2){
		return i;
	    }
	    ctr = 0;
	}

	return -1;
    }

    
    public int check2XColumn(){
	int ctr = 0;
	
	for (int i = 0; i < size() ; i++){
	    if (_matrix[2][i] == "O"){
		break;
	    }
	    for (int j = 0; j < size(); j++){
		if (_matrix[j][i] == "O"){
		    break;
		}
		if (_matrix[j][i] == "X"){
		    ctr += 1;
		}
		if (ctr == 2){
		    return j;
		}
	    }

	    ctr = 0;
	}

	return -1;
    }


    public int check2XMain(){
	int ctr = 0;
	
	for (int i = 0; i < size(); i++){
	    if (_matrix[i][i] == "O"){
		return -1;
	    }
	}

	for (int i = 0; i < size(); i++) {
	    if (_matrix[i][i] == "X"){
		ctr += 1;
	    }
	    if (ctr == 2 && i == 1){
	        return 2;
	    }
	    if (ctr == 2 && _matrix[0][2] == "X"){
		return 1;
	    }
	    if (ctr == 2 && _matrix[1][1] == "X"){
		return 0;
	    }
	}

	return -1;
    }

    
    public int check2XBack(){
	int ctr = 0;
	
	for (int i = 0; i < size(); i++){
	    if (_matrix[i][2-i] == "O"){
		return -1;
	    }
	}

	for (int i = 0; i < size(); i++){

	    if (_matrix[i][2-i] == "X"){
		ctr += 1;
	    }
	    
	    if (ctr == 2 && i == 1){
	        return 2;
	    }
	    if (ctr == 2 && _matrix[0][2] == "X"){
		return 1;
	    }
	    if (ctr == 2 && _matrix[2][0] == "X"){
		return 0;
	    }
	}

	return -1;
    }
    
    public boolean check2X(){
	return (check2XRow() != -1) || (check2XColumn() != -1) || (check2XMain() != -1) || (check2XBack() != -1);
    }













    

    
    public boolean check3O(){
	//Checks row
	for (int i = 0; i < size() ; i++){
	    if (_matrix[i][0] == _matrix[i][1] && _matrix[i][2] == _matrix[i][1] && _matrix[i][0] == "O")
		return true;
	}

	//Checks column
	for (int i = 0; i < size() ; i++){
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
	for (int i = 0; i < size() ; i++){
	    if (_matrix[i][0] == _matrix[i][1] && _matrix[i][2] == _matrix[i][1] && _matrix[i][0] == "X")
		return true;
	}

	//Checks column
	for (int i = 0; i < size() ; i++){
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




    
    public void play3(){
	int moves = 9;
	int rowO, columnO, rowX, columnX, choice;
	int a = 0;
	int b = 0;
	int sub;
	boolean turn = false;

	while (true){
	    System.out.println("\nDo you want to: \n1. Go first\n2. Go second");
	    
	    try{
		choice = Keyboard.readInt();	  
		if (choice < 3){
		    break;
		}	
		else if (choice > 2){
		    throw new IllegalArgumentException("Integer not within range, try again!");
		}
	    }	
	    catch ( Exception e ){}
	}	


	if (choice == 1)
	    turn = true;
	else if (choice == 2)
	    turn = false;

	System.out.println();
	
	System.out.println(toString());

	while (true) {

	    //Player move
	    while( turn == true ) {
		// Determines result of game
		if (check3X() == true){
		    System.out.println("AI wins!");
		    return;
		}

		moves--;

	        if( moves < 0 ) {
		    System.out.println("It's a draw!");
		    return;
		}

		// Determines a) who goes and b) where the O/X is put
		System.out.println("Which row (between 1 and 3) do you want to put your letter?");
		rowO = Keyboard.readInt();

		System.out.println("Which column (between 1 and 3) do you want to put your letter?");
		columnO = Keyboard.readInt();

		System.out.println();
		
		if (rowO > 3 || rowO < 0 || columnO > 3 || columnO < 0){
		    System.out.println("Invalid numbers! Try again.\n");
		    break;
		}

		else if (get(rowO,columnO) == "_"){
		    placeO(rowO, columnO);
		    System.out.println(toString());
		    turn = false;
		    break;
		}

		else{
		    System.out.println("Space is already occupied, try again\n");
		}

	    }






	    
	    
	    //AI move
	    if( turn == false ) {
		// Determines result of game
		if (check3O() == true){
		    System.out.println("You win!");
		    return;
		}
	
		if( moves == 0 ) {
		    System.out.println("It's a draw!");
		    return;
		}

		System.out.println("AI moves\n");


		//Aim for victory
		if (check2X() == true){
		    a = 0;
		    
		    if (check2XRow() != -1){
			System.out.println("2XRow = " + check2XRow());
			sub = check2XRow();
			while (a < 3){
			    if (_matrix[sub][a] != "X"){
				_matrix[sub][a] = "X";
			    }
			   
			    a+=1;
			}
		    }
		    else if (check2XColumn() != -1){
			System.out.println("2XCol = " + check2XColumn());
			sub = check2XColumn();
			while (a < 3){
			    if (_matrix[a][sub] != "X"){
				_matrix[a][sub] = "X";
			    }
			    a+=1;
			}
		    }
		    else if (check2XMain() != -1){
			System.out.println("2XMain = " + check2XMain());			
			_matrix[check2XMain()][check2XMain()] = "X";
		    }
		    else {
			System.out.println("2XBack = " + check2XBack());			
			_matrix[check2XBack()][2 - check2XBack()] = "X";
		    }
   
		}


		
		// Block opponent's victory
		else if (check2O() == true){
		    b = 0;
		    
		    if (check2ORow() != -1){
			System.out.println("2ORow = " + check2ORow());
			sub = check2ORow();
			while (b < 3){
			    if (_matrix[sub][b] != "O"){
				_matrix[sub][b] = "X";
			    }
			    b+=1;
			}
		    }
		    else if (check2OColumn() != -1){
			System.out.println("2OCol = " + check2OColumn());
			sub = check2OColumn();
			while (b < 3){
			    if (_matrix[b][sub] != "O"){
				_matrix[b][sub] = "X";
			    }
			    b+=1;
			}
		    }
		    else  if (check2OMain() != -1){
			System.out.println("2OMain = " + check2OMain());
			_matrix[check2OMain()][check2OMain()] = "X";
		    }
		    else {
			System.out.println("2OBack = " + check2OBack());
			_matrix[check2OBack()][2 - check2OBack()] = "X";
		    }
		    
		}

		//Place in middle
		else if (_matrix[1][1] == "_"){
		    _matrix[1][1] = "X";
		}

		//Place in unoccupied square
		else{
		    
		    while (true ){
			rowX = (int) (3 * Math.random());
			columnX = (int) (3 * Math.random());
			if (_matrix[rowX][columnX] == "_"){
			    placeX(rowX+1,columnX+1);
			    break;
			}
			
		    }					
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
		System.out.println("\nDo you want to play\n\n1: Regular 3 by 3 tic tac toe\n2: Ultimate 9 by 9 tic tac toe");
	    
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
		while (true){
		    yay.setup3();
		    System.out.print(yay);
		    yay.play3();
		    System.out.println("What do you want to do next?\n1. Play again\n2. I'm done");
		    try{
			hi = Keyboard.readInt();
			if (hi == 1){
			    System.out.println( "\nCool!\n" );
			}

			if (hi == 2){
			    System.out.println( "\nAlright!\n" );
			    return;
			}
			
			else if (hi > 3 || hi < 0){
			    throw new IllegalArgumentException("Integer not within range, try again!");
			}
		    }
		    catch ( Exception e ){}
		}
	    }
	    
	    else if (hi == 2){
		TicTacToe yay = new TicTacToe(9);
		while (true){
		    yay.setup9();
		    System.out.print(yay);
		    //yay.play9();
		    System.out.println("What do you want to do next?\n1. Play again\n2. I'm done");
		    try{
			hi = Keyboard.readInt();
			if (hi == 1){
			    System.out.println( "\nCool!\n" );
			}

			if (hi == 2){
			    System.out.println( "\nAlright!\n" );
			    return;
			}
			
			else if (hi > 3 || hi < 0){
			    throw new IllegalArgumentException("Integer not within range, try again!");
			}
		    }
		    catch ( Exception e ){}
		}
	    }
	    
	    else{
		System.out.println("Requires an integer input");
	    }
	}
        
    }
}


