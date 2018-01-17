import cs1.Keyboard;

public class TicTacToe{

    private final static int default_size = 3;

    private Object[][] _matrix;
    private Object[][] _final;

    
    //default constructor
    public TicTacToe(){
	_matrix = new Object[default_size][default_size];
	_final = new Object[0][0];
    }

    //constructor for a 9 by 9
    public TicTacToe(int size){
	_matrix = new Object[size][size];
	_final = new Object[3][3];
    }
    
    //sets up the board for a 3 by 3
    public void setup3(){
	for (int i = 0; i < size() ; i++){
	    for (int j = 0; j < size(); j++)
		_matrix[i][j] = "_";
	}
    }

    //checks if a matrix is full
    public boolean full(int rlow, int rhigh, int clow, int chigh){
	for (; rlow <= rhigh ; rlow++){
	    for (; clow <= chigh; clow++){
		if (get(rlow,clow) == "_")
		    return false;
	    }
	}
	return true;
    }

    //sets up a 9 by 9 tic tac toe board
    public void setup9(){
	for (int i = 0; i < size() ; i++){
	    for (int j = 0; j < size(); j++){
		_matrix[i][j] = "_";
	    }
	}
	
	for (int i = 0; i < 3; i++){
	    for (int j = 0; j < 3; j++){
		_final[i][j] = "_";
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

    private Object getF (int r, int c){
	return _final[r][c];
    }
    
    //prints the matrix and final matrix (if final is applicable)
    public String toString() 
    {
	String foo = "\nTic Tac Toe Board:\n    ";
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

	if (_final.length == 3){
	    foo += "\nFinal matrix\n";
	    for( int i = 0; i < 3; i++ ) {
		foo += " | ";
	
		for( int j=0; j < 3; j++ ) {
		    foo += _final[i][j] + " "; //get(i+1,j+1)
		}

		foo += "|\n";

	    }
	}

	
	return foo;
    }


    //prints the rules of the game
    public void rules3(){
	System.out.println( "Rules:\n The player is assigned with the icon 'O' and the AI is assigned with the icon 'X'. The player chooses who goes first or second. You win when you create a row, column, or diagonal with 3 consecutive O's. Similarly, the AI wins if they make 3 consecutive X's. Neither player can place their (O/X) on top of an existing icon (O/X).");
    }

    //prints the rules of the game
    public void rules9(){
	System.out.println( "Rules\n The player is assigned with the icon 'O' and the AI is assigned with the icon 'X'. The player chooses who goes first or second. If you partition the 9 by 9 matrix into nine 3 by 3 matrices and Player 1 makes a move, the possible moves of the next player is the 3 by 3 matrix on the 9 by 9 matrix positioned similarly to Player 1's move with respect to the 3 by 3 matrix it is on. If such a matrix is full, the player can move whereever they want. The first victory in a 3 by 3 matrix will be marked on the final matrix and whoever wins the final matrix wins the game." );
    }

    //places an O on the board
    public void placeO(int row, int column){
	_matrix[row-1][column-1] = "O";
    }

    //places an X on the board
    public void placeX(int row, int column){
	_matrix[row-1][column-1] = "X";
    }

    //places string x onto the final board
    public void placeF(String x, int row, int column){
	_final[row-1][column-1] = x;
    }



    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~Checking 2 in a row of 3 by 3~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    
    //gives the row of the first appearance of 2 O's in a row (outputs -1 otherwise)
    public int check2ORow(){
	int ctr = 0;
	
	for (int i = 0; i < size() ; i++){
	   

	    for (int j = 0; j < size(); j++){
		if (_matrix[i][2] == "X"){
		    break;
		}
		
		if (_matrix[i][j] == "X"){
		    break;
		}
		if (_matrix[i][j] == "O"){
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

    
    //gives column of the first appearance of 2 O's in a column (outputs -1 otherwise)
    public int check2OColumn(){
	int ctr = 0;
	
	for (int i = 0; i < size() ; i++){
	   
	    for (int j = 0; j < size(); j++){
		if (_matrix[2][i] == "X"){
		    break;
		}
		if (_matrix[j][i] == "X"){
		    break;
		}
		if (_matrix[j][i] == "O"){
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


    //gives row of the first appearance of 2 O's in the main diagonal (outputs -1 otherwise)
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


    //gives row of the first appearance of 2 O's in the back diagonal (outputs -1 otherwise)
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
	    else if (ctr == 2 && _matrix[0][2] == "O"){
		return 1;
	    }
	    else if (ctr == 2 && _matrix[2][0] == "O"){
		return 0;
	    }
	}

	return -1;
    }


    // Checks whether there exists two consecutive O's
    public boolean check2O(){
	return ( (check2ORow() != -1) || (check2OColumn() != -1) ) || ( (check2OMain() != -1) || (check2OBack() != -1) );
    }

    



    //gives row of the first appearance of 2 X's in a row (outputs -1 otherwise)
    public int check2XRow(){
	int ctr = 0;
	
	for (int i = 0; i < size() ; i++){
	 
	    for (int j = 0; j < size(); j++){
		if (_matrix[i][2] == "O"){
		    break;
		}
		
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


    //gives column of the first appearance of 2 X's in a column (outputs -1 otherwise)
    public int check2XColumn(){
	int ctr = 0;
	
	for (int i = 0; i < size() ; i++){
	  
	    for (int j = 0; j < size(); j++){
		if (_matrix[2][i] == "O"){
		    break;
		}
		
		if (_matrix[j][i] == "O"){
		    break;
		}
		if (_matrix[j][i] == "X"){
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


     //gives row of the first appearance of 2 X's in the main diagonal (outputs -1 otherwise)
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
    

    //gives row of the first appearance of 2 X's in the back diagonal (outputs -1 otherwise)
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

    //Checks to see if there exists 2 consecutive X's
    public boolean check2X(){
	return  ((check2XRow() != -1) || (check2XColumn() != -1)) || ((check2XMain() != -1) || (check2XBack() != -1));
    }






    

    //Checks if there are 3 consecutive O's    
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
	


    // Checks to see if there are 3 consecutive X's
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






    // Checks the final matrix to see whether there are 3 consecutive O's
    public boolean check3Of(){
	//Checks row
	for (int i = 0; i < 3 ; i++){
	    if (_final[i][0] == _final[i][1] && _final[i][2] == _final[i][1] && _final[i][0] == "O")
		return true;
	}


	//Checks column
	for (int i = 0; i < 3 ; i++){
	    if (_final[0][i] == _final[1][i] && _final[2][i] == _final[1][i] && _final[0][i] == "O")
		return true;
	}

	//Checks main diagonal

	if (_final[0][0] == _final[1][1] && _final[2][2] == _final[1][1] && _final[0][0] == "O")
	    return true;

	//Checks back diagonal
	if (_final[0][2] == _final[1][1] && _final[2][0] == _final[1][1] && _final[1][1] == "O")
	    return true;
    
	return false;
    }
	


    // Checks the final matrix to see whether there are 3 consecutive X's
    public boolean check3Xf(){
	//Checks row
	for (int i = 0; i < 3 ; i++){
	    if (_final[i][0] == _final[i][1] && _final[i][2] == _final[i][1] && _final[i][0] == "X")
		return true;
	}

	//Checks column
	for (int i = 0; i < 3 ; i++){
	    if (_final[0][i] == _final[1][i] && _final[2][i] == _final[1][i] && _final[0][i] == "X")
		return true;
	}

	//Checks main diagonal
	if (_final[0][0] == _final[1][1] && _final[2][2] == _final[1][1] && _final[0][0] == "X")
	    return true;

	//Checks back diagonal
	if (_final[0][2] == _final[1][1] && _final[2][0] == _final[1][1] && _final[1][1] == "X")
	    return true;
    
	return false;
	
    }


    


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Checking 2 in a row for 9 by 9~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//




    //gives row of the first appearance of 2 O's in a row (outputs -1 otherwise)
    public int check2ORow(int rlow, int rhigh, int clow, int chigh){
	int ctr = 0;
	
	
	for (; rlow <= rhigh ; rlow++){
	   
	    for (;clow <= chigh; clow++){
	
		if (get(rlow,clow) == "X"){
		    ctr = 0;
		    break;
		}
		if (get(rlow,clow) == "O"){
		    ctr += 1;
		}
	    }

	    if (ctr == 2){
		return rlow;
	    }
	    ctr = 0;
	}

	return -1;
    }

    //gives column of the first appearance of 2 O's in a column(outputs -1 otherwise)    
    public int check2OColumn(int rlow, int rhigh, int clow, int chigh){
	int ctr = 0;	
	
	for (; clow <= chigh ; clow++){
	   
	    for (; rlow <= rhigh; rlow++){
	
		if (get(rlow,clow) == "X"){
		    ctr = 0;
		    break;
		}
		if (get(rlow,clow) == "O"){
		    ctr += 1;
		}
	    }
	    if (ctr == 2){
		return clow;
	    }
	    ctr = 0;
	}

	return -1;
    }

    //gives row of the first appearance of 2 O's in the main diagonal (outputs -1 otherwise)
    public int check2OMain(int rlow, int rhigh, int clow, int chigh){
	int ctr = 0;
	int take = rlow+2;

	    if (get(rlow,clow) == "X" || get(rlow+1,clow+1) == "X" || get(rlow+2,clow+2) == "X")
		return -1;

	
	for (int move = 0; move < 3; move++){
	    if (get(rlow,clow) == "O"){
		ctr += 1;
	    }
	    else{
		take = rlow;
	    }
	 
	    if (ctr == 2){
		return take;
	    }

	    rlow += 1;
	    clow += 1;
      	}
	

	return -1;
    }

   //gives row of the first appearance of 2 O's in the back diagonal (outputs -1 otherwise)
    public int check2OBack(int rlow, int rhigh, int clow, int chigh){
	int ctr = 0;
	int take = rlow+2;
	
	if ( get(rlow,chigh) == "X" || get(rlow+1,chigh-1) == "X" || get(rlow+2,chigh-2) == "X"){
	    return -1;
	}
	
	for (int move = 0; move < 3; move++){
	    if (get(rlow,chigh) == "O"){
		ctr += 1;
	    }
	    else if (get(rlow,chigh) == "_"){
		take = rlow;
	    }
	    
	    if (ctr == 2){
		return take;
	    }

	    rlow += 1;
	    chigh -=1;
      	}

	return -1;
    }

    //checks if there are 2 O's in a row
    public boolean check2O(int rlow, int rhigh, int clow, int chigh){
	return ( (check2ORow(rlow, rhigh, clow, chigh) != -1) || (check2OColumn(rlow, rhigh, clow, chigh) != -1) ) || ( (check2OMain(rlow, rhigh, clow, chigh) != -1) || (check2OBack(rlow, rhigh, clow, chigh) != -1) );
    }



    

    
    //gives the row of the first appearance of 2 X's in a row (outputs -1 otherwise)
    public int check2XRow(int rlow, int rhigh, int clow, int chigh){
	int ctr = 0;
	
	
	for (; rlow <= rhigh ; rlow++){
	   
	    for (;clow <= chigh; clow++){
		if (get(rlow,clow) == "O"){
		    ctr = 0;
		    break;
		}
		if (get(rlow,clow) == "X"){
		    ctr += 1;
		}
	    }

	    if (ctr == 2){
		return rlow;
	    }
	    ctr = 0;
	}

	return -1;
    }


    //gives the column of the first appearance of 2 X's in a column (outputs -1 otherwise)
    public int check2XColumn(int rlow, int rhigh, int clow, int chigh){
	int ctr = 0;	
	
	for (; clow <= chigh ; clow++){
	   
	    for (; rlow <= rhigh; rlow++){

		if (get(rlow,clow) == "O"){
		    ctr = 0;
		    break;
		}
		if (get(rlow,clow) == "X"){
		    ctr += 1;
		}
	    }
	    if (ctr == 2){
		return clow;
	    }
	    ctr = 0;
	}

	return -1;
    }

    
    //gives the row of the first appearance of 2 X's in the main diagonal (outputs -1 otherwise)
    public int check2XMain(int rlow, int rhigh, int clow, int chigh){
	int ctr = 0;
	int take = rlow+2;


	if (get(rlow,clow) == "O" || get(rlow+1,clow+1) == "O" || get(rlow+2,clow+2) == "O")
	    return -1;

	
	for (int move = 0; move < 3; move++){
	    if (get(rlow,clow) == "X"){
		ctr += 1;
	    }
	    else{
		take = rlow;
	    }
	    
	    if (ctr == 2){
		return take;
	    }

	    rlow += 1;
	    clow +=1;
      	}
	

	return -1;
    }


    //gives the row of the first appearance of 2 X's in the back diagonal (outputs -1 otherwise)
    public int check2XBack(int rlow, int rhigh, int clow, int chigh){
	int ctr = 0;
	int take = rlow+2;
	
	if (get(rlow,chigh) == "O" || get(rlow+1,chigh-1) == "O" || get(rlow+2,chigh-2) == "O"){
	    return -1;
	}
	
	for (int move = 0; move < 3; move++){
	    if (get(rlow,chigh) == "X"){
		ctr += 1;
	    }
	    else{
		take = rlow;
	    }
	    
	    if (ctr == 2){
		return take;
	    }

	    rlow += 1;
	    chigh -=1;
      	}

	return -1;
    }


    // Checks to see if there exists 2 consecutive X's
    public boolean check2X(int rlow, int rhigh, int clow, int chigh){
	return ( (check2XRow(rlow, rhigh, clow, chigh) != -1) || (check2XColumn(rlow, rhigh, clow, chigh) != -1) ) || ( (check2XMain(rlow, rhigh, clow, chigh) != -1) || (check2XBack(rlow, rhigh, clow, chigh) != -1) );
    }







    //Checks to see if a 3 by 3 square bounded by the parameters has 3 consecutive O's
    public boolean check3O(int rlow, int rhigh, int clow, int chigh){
	//bumps everything down 1;
	rlow -= 1;
	rhigh -= 1;
	clow -= 1;
	chigh -= 1;

	//Checks row
	for (;clow <= chigh; clow ++){
	    if (_matrix[rlow][clow] == _matrix[rlow + 1][clow] && _matrix[rlow + 1][clow] == _matrix[rlow + 2][clow] && _matrix[rlow][clow] == "O")
		return true;
	}

	clow -= 3;
	
	for(;rlow <= rhigh; rlow ++){
	    //Checks column
	    if (_matrix[rlow][clow] == _matrix[rlow][clow+1] && _matrix[rlow][clow] == _matrix[rlow][clow+2] && _matrix[rlow][clow] == "O")
		return true;
	}

	rlow -= 3;

	//Checks main diagonal
	if (_matrix[rlow][clow] == _matrix[rlow + 1][clow + 1] && _matrix[rlow][clow] == _matrix[rlow + 2][clow + 2] && _matrix[rlow][clow] == "O")
	    return true;
    

	//Checks back diagonal
	if (_matrix[rlow][chigh] == _matrix[rlow + 1][chigh - 1] && _matrix[rlow][chigh] == _matrix[rlow + 2][chigh - 2] && _matrix[rlow][chigh] == "O")
	    return true;
	
	return false;
    }
	


    //Checks to see if a 3 by 3 square bounded by the parameters has 3 consecutive X's
    public boolean check3X(int rlow, int rhigh, int clow, int chigh){
	rlow -= 1;
	rhigh -= 1;
	clow -= 1;
	chigh -= 1;

	//Checks row
	for (;clow <= chigh; clow ++){
	    if (_matrix[rlow][clow] == _matrix[rlow + 1][clow] && _matrix[rlow + 1][clow] == _matrix[rlow + 2][clow] && _matrix[rlow][clow] == "X")
		return true;
	}

	clow -= 3;
	
	for(;rlow <= rhigh; rlow ++){
	    //Checks column
	    if (_matrix[rlow][clow] == _matrix[rlow][clow+1] && _matrix[rlow][clow] == _matrix[rlow][clow+2] && _matrix[rlow][clow] == "X")
		return true;
	}

	rlow -= 3;

	//Checks main diagonal
	if (_matrix[rlow][clow] == _matrix[rlow + 1][clow + 1] && _matrix[rlow][clow] == _matrix[rlow + 2][clow + 2] && _matrix[rlow][clow] == "X")
	    return true;
    

	//Checks back diagonal
	if (_matrix[rlow][chigh] == _matrix[rlow + 1][chigh - 1] && _matrix[rlow][chigh] == _matrix[rlow + 2][chigh - 2] && _matrix[rlow][chigh] == "X")
	    return true;
	
	return false;
    }






    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Play for 3 by 3~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    //Plays a 3 by 3 tic tac toe game
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

	        if( moves <= 0 ) {
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
		    moves--;
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
		    System.out.println("Middle");
		    _matrix[1][1] = "X";
		}

		//Place in unoccupied square
		else{
		    System.out.println("Random");
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




    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Play for 9 by 9~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //plays a 9 by 9 tic tac toe game
    public void play9(){
	int moves = 81;
	int rowO = 0;
	int columnO = 0;
	int rowX, columnX, choice;
	int a = 0;
	int b = 0;
	int rhigh = 9;
	int rlow = 1;
	int chigh = 9;
	int clow = 1;
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
		if (check3Xf() == true){
		    System.out.println("AI wins!");
		    return;
		}

	        if( moves <= 0 ) {
		    System.out.println("It's a draw!");
		    return;
		}

		

		System.out.println("Row bound: " + rlow + "-" + rhigh);
		System.out.println("Column bound: " + clow + "-" + chigh);
		System.out.println("Which row (between " + rlow + " and " + rhigh + ") do you want to put your letter?");
		rowO = Keyboard.readInt();

		System.out.println("Which column (between " + clow  + " and " + chigh + ") do you want to put your letter?");
		columnO = Keyboard.readInt();

		System.out.println();
		
		if (rowO > rhigh || rowO < rlow || columnO > chigh || columnO < clow){
		    System.out.println("Invalid numbers! Try again.\n");
		    break;
		}

		else if (get(rowO,columnO) == "_"){
		    moves--;
		    placeO(rowO, columnO);
		    System.out.println(toString());
		    turn = false;

		    if (! (rlow == 1 && rhigh == 9)){
			if (check3O(rlow, rhigh, clow, chigh) == true){
			    if (_final[rlow/3][clow/3] == "_"){
				_final[rlow/3][clow/3] = "O";
			    }
			}
		    }

		    if (rowO % 3 == 0){
			rlow = 7;
			rhigh = 9;
		    }
		    else if (rowO % 3 == 1){
			rlow = 1;
			rhigh = 3;
		    }
		    else{
			rlow = 4;
			rhigh = 6;
		    }

		    
		    if (columnO % 3 == 0){
			clow = 7;
			chigh = 9;
		    }
		    else if (columnO % 3 == 1){
			clow = 1;
			chigh = 3;
		    }
		    else{
			clow = 4;
			chigh = 6;
		    }

		    break;

		}

		else if (full(rlow, rhigh, clow, chigh) == false){
		    System.out.println("Choose another square on the 3 by 3 corresponding board");	     
		}
		else if (full(rlow, rhigh, clow, chigh) == true){
		    System.out.println("Move to another square in the board");
		    rlow = 1;
		    rhigh = 9;
		    clow = 1;
		    chigh = 9;
		}
		else{
		    System.out.println("Not an integer");
		}
	    }

	  

	    
	    
	    //AI move
	    if( turn == false ) {
		// Determines result of game
		if (check3Of() == true){
		    System.out.println("You win!");
		    return;
		}
		
		if( moves == 0 ) {
		    System.out.println("It's a draw!");
		    return;
		}

		System.out.println("AI moves\n");
		 System.out.println("Before\t" + rlow + "\t" + rhigh + "\t" + clow + "\t" + chigh);

		    

		
		//Aim for victory
		
		if (check2X(rlow, rhigh, clow, chigh) == true){
		    
		    if (check2XRow(rlow, rhigh, clow, chigh) != -1){
			System.out.println("2XRow = " + check2XRow(rlow, rhigh, clow, chigh));
			sub = check2XRow(rlow, rhigh, clow, chigh);
			a = clow;
			while (a <= chigh){
			    if (get(sub,a) != "X"){
				placeX(sub,a);
				break;
			    }
			    a+=1;
			}
			if (getF((sub-1)/3,(a-1)/3) == "_"){
			    _final[(sub-1)/3][(a-1)/3] = "X";
			}

			rlow = sub;
			clow = a;
			
		    }
		    
		    else if (check2XColumn(rlow, rhigh, clow, chigh) != -1){
			System.out.println("2XCol = " + check2XColumn(rlow, rhigh, clow, chigh));
			sub = check2XColumn(rlow, rhigh, clow, chigh);
			a = rlow;
			while (a <= rhigh){
			    if (get(a,sub) != "X"){
				placeX(a,sub);
				break;
			    }
			    a+=1;
			}

			if (getF((a-1)/3,(sub-1)/3) == "_"){
			    _final[(a-1)/3][(sub-1)/3] = "X";
			}
			
			rlow = a;
			clow = sub;

		    }
		    else if (check2XMain(rlow, rhigh, clow, chigh) != -1){
			System.out.println("2XMain = " + check2XMain(rlow, rhigh, clow, chigh));			
		
			sub = rlow;
			rlow = check2XMain(rlow, rhigh, clow, chigh);
			clow += ((check2XMain(sub, rhigh, clow, chigh)+2) % 3);
			if (getF(rlow/3,clow/3) == "_"){
			    _final[rlow/3][clow/3] = "X";
			}
			placeX(check2XMain(rlow, rhigh, clow, chigh),check2XMain(rlow, rhigh, clow, chigh));
		    }
		    
		    else {
			System.out.println("2XBack = " + check2XBack(rlow, rhigh, clow, chigh));			
			sub = rlow;
			rlow = check2XBack(rlow, rhigh, clow, chigh);
			clow = chigh - ((check2XBack(sub, rhigh, clow, chigh) + 2) % 3);
			if (getF(rlow/3,clow/3) == "_"){
			    _final[rlow/3][clow/3] = "X";
			}

			placeX(check2XBack(rlow, rhigh, clow, chigh), chigh - ((check2XBack(rlow, rhigh, clow, chigh) + 2) % 3 ));


		    }
   
		}


		// Block opponent's victory
		else if (check2O(rlow, rhigh, clow, chigh) == true){
		    
		    if (check2ORow(rlow, rhigh, clow, chigh) != -1){
			System.out.println("2ORow = " + check2ORow(rlow, rhigh, clow, chigh));
			sub = check2ORow(rlow, rhigh, clow, chigh);
			b = clow;
			while (b <= chigh){
			    if (get(sub,b) != "O"){
				placeX(sub,b);
			    }
			    b+=1;
			}
			rlow = sub;
			clow = b;
		
			
		    }
		    else if (check2OColumn(rlow, rhigh, clow, chigh) != -1){
			System.out.println("2OCol = " + check2OColumn(rlow, rhigh, clow, chigh));
			sub = check2OColumn(rlow, rhigh, clow, chigh);
			b = rlow;
			while (b <= rhigh){
			    if (get(b,sub) != "O"){
				placeX(b,sub);
			    }
			    b+=1;			    
			}

			rlow = b;
			clow = sub;
		
		    }
		    else if (check2OMain(rlow, rhigh, clow, chigh) != -1){
			System.out.println("2OMain = " + check2OMain(rlow, rhigh, clow, chigh));
		
			sub = rlow;
			rlow = check2OMain(rlow, rhigh, clow, chigh);
			clow += ((check2OMain(sub, rhigh, clow, chigh)+2) % 3);

			placeX(check2OMain(rlow, rhigh, clow, chigh), ((check2OMain(rlow, rhigh, clow, chigh)+2) % 3) + clow);
			
		    }
		    else {
			System.out.println("2OBack = " + check2OBack(rlow, rhigh, clow, chigh));
			sub = rlow;
			rlow = check2OBack(rlow, rhigh, clow, chigh);
			clow = chigh - ((check2OBack(sub, rhigh, clow, chigh) + 2) % 3);
			placeX(check2OBack(rlow, rhigh, clow, chigh), chigh - ((check2OBack(rlow, rhigh, clow, chigh) + 2) % 3 ));
		    }
		    
		}


		else{
		    System.out.println("Random");

		    if (full(rlow,rhigh,clow,chigh)){
			rlow = 1;
			clow = 1;
			rhigh = 9;
			chigh = 9;
		    }
		   
		    while (true ){
			if ((rhigh - rlow) == 2){
			    a = (int) (3 * Math.random());
			    b = (int) (3 * Math.random());
			}
			else{
			    a = (int) (9 * Math.random());
			    b = (int) (9 * Math.random());
			}
		
		
			if (get(rlow+a,clow+b) == "_"){
			    placeX(rlow+a,clow+b);

			    rlow += a;
			    rhigh += a;
			    clow += b;
			    chigh += b;

			    break;
			}
			
		    }					
		}
	
				
		System.out.println("Summary\t" + rlow + "\t" + rhigh + "\t" + clow + "\t" + chigh);
		  
		    	    
		if (rlow % 3 == 0){
		    rlow = 7;
		    rhigh = 9;
		}
		else if (rlow % 3 == 1){
		    rlow = 1;
		    rhigh = 3;
		}
		else{
		    rlow = 4;
		    rhigh = 6;
		}

		    
		if (clow % 3 == 0){
		    clow = 7;
		    chigh = 9;
		}
		else if (clow % 3 == 1){
		    clow = 1;
		    chigh = 3;
		}
		else{
		    clow = 4;
		    chigh = 6;
		}
		
		System.out.println(toString());
		turn = true;
		moves--; 

	    }
	   
	}
    }





    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Main method~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    
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
	
		catch ( Exception e ){}
	    }

	
	    if (hi == 1){
		TicTacToe yay = new TicTacToe();
		while (true){
		    yay.setup3();
		    yay.rules3();
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
			    String[] c = new String[1];
			    MiniDesktop.main(c);

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
		    yay.rules9();
		    System.out.print(yay);
		    yay.play9();
		    System.out.println("What do you want to do next?\n1. Play again\n2. I'm done");
		    try{
			hi = Keyboard.readInt();
			if (hi == 1){
			    System.out.println( "\nCool!\n" );
			}

			if (hi == 2){
			    System.out.println( "\nAlright!\n" );
			    String[] c = new String[1];
			    MiniDesktop.main(c);

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

