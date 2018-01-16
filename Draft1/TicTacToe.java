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

    public TicTacToe(int size){
	_matrix = new Object[size][size];
	_final = new Object[3][3];
    }
    
    //sets up the board
    public void setup3(){
	for (int i = 0; i < size() ; i++){
	    for (int j = 0; j < size(); j++)
		_matrix[i][j] = "_";
	}
    }

    public boolean full(int rlow, int rhigh, int clow, int chigh){
	for (; rlow < rhigh ; rlow++){
	    for (; clow < chigh; clow++){
		if (_matrix[rlow][clow] == "_")
		    return false;
	    }
	}
	return true;
    }

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

    
    //prints the matrix
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
    public String rules3(){
	return "These are the rules for regular 3x3 tic tac toe";
    }

    //prints the rules of the game
    public String rules9(){
	return "These are the rules for ultimate 9x9 tic tac toe";
    }

    public void placeO(int row, int column){
	_matrix[row-1][column-1] = "O";
    }

    
    public void placeX(int row, int column){
	_matrix[row-1][column-1] = "X";
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
	    else if (ctr == 2 && _matrix[0][2] == "O"){
		return 1;
	    }
	    else if (ctr == 2 && _matrix[2][0] == "O"){
		return 0;
	    }
	}

	return -1;
    }

    
    public boolean check2O(){
	return ( (check2ORow() != -1) || (check2OColumn() != -1) ) || ( (check2OMain() != -1) || (check2OBack() != -1) );
    }

    







  
    //Consider the case XXO: (contrdiction)
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
	return  ((check2XRow() != -1) || (check2XColumn() != -1)) || ((check2XMain() != -1) || (check2XBack() != -1));
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




    
    //gives the row of the first appearance of 2 O's in a row (outputs -1 otherwise)
    public int check2ORow(int rlow, int rhigh, int clow, int chigh){
	int ctr = 0;
   	rlow -= 1;
	rhigh -= 1;
	clow -= 1;
	chigh -= 1;
		
	for (; rlow < rhigh ; rlow++){
	   

	    for (;clow < chigh; clow++){
		if (_matrix[rlow][chigh-1] == "X"){
		    break;
		}
		
		if (_matrix[rlow][clow] == "X"){
		    break;
		}
		if (_matrix[rlow][clow] == "O"){
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

    
    public int check2OColumn(int rlow, int rhigh, int clow, int chigh){
	int ctr = 0;
	int take = 0;
   	rlow -= 1;
	rhigh -= 1;
	clow -= 1;
	chigh -= 1;
		
	for (; clow < chigh ; clow++){
	   
	    for (; rlow < rhigh; rlow++){
		if (_matrix[rhigh - 1][clow] == "X"){
		    break;
		}
		if (_matrix[rlow][clow] == "X"){
		    break;
		}
		if (_matrix[rlow][clow] == "O"){
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


    public int check2OMain(int rlow, int rhigh, int clow, int chigh){
	int ctr = 0;
	int take = 0;
   	rlow -= 1;
	rhigh -= 1;
	clow -= 1;
	chigh -= 1;

	
	if (_matrix[rlow][clow] == "X" || _matrix[rlow+1][clow+1] == "X" || _matrix[rlow+2][clow+2] == "X")
	    return -1;

	
	for (int move = 0; move < 3; move++){
	    if (_matrix[rlow][clow] == "O"){
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

    
    public int check2OBack(int rlow, int rhigh, int clow, int chigh){
	int ctr = 0;
	int take = 0;
   	rlow -= 1;
	rhigh -= 1;
	clow -= 1;
	chigh -= 1;
	
	
	if (_matrix[rlow][chigh] == "X" || _matrix[rlow+1][chigh-1] == "X" || _matrix[rlow+2][chigh-2] == "X"){
	    return -1;
	}
	
	for (int move = 0; move < 3; move++){
	    if (_matrix[rlow][chigh] == "O"){
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

    
    public boolean check2O(int rlow, int rhigh, int clow, int chigh){
	return ( (check2ORow(rlow, rhigh, clow, chigh) != -1) || (check2OColumn(rlow, rhigh, clow, chigh) != -1) ) || ( (check2OMain(rlow, rhigh, clow, chigh) != -1) || (check2OBack(rlow, rhigh, clow, chigh) != -1) );
    }

    




    
    //gives the row of the first appearance of 2 X's in a row (outputs -1 otherwise)
    public int check2XRow(int rlow, int rhigh, int clow, int chigh){
	int ctr = 0;
	   	rlow -= 1;
	rhigh -= 1;
	clow -= 1;
	chigh -= 1;
	
	
	for (; rlow < rhigh ; rlow++){
	   

	    for (;clow < chigh; clow++){
		if (_matrix[rlow][chigh-1] == "O"){
		    break;
		}
		
		if (_matrix[rlow][clow] == "O"){
		    break;
		}
		if (_matrix[rlow][clow] == "X"){
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

    
    public int check2XColumn(int rlow, int rhigh, int clow, int chigh){
	int ctr = 0;
	rlow -= 1;
	rhigh -= 1;
	clow -= 1;
	chigh -= 1;
	
	
	for (; clow < chigh ; clow++){
	   
	    for (; rlow < rhigh; rlow++){
		if (_matrix[rhigh - 1][clow] == "O"){
		    break;
		}
		if (_matrix[rlow][clow] == "O"){
		    break;
		}
		if (_matrix[rlow][clow] == "X"){
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


    public int check2XMain(int rlow, int rhigh, int clow, int chigh){
	int ctr = 0;
	int take = 0;

	rlow -= 1;
	rhigh -= 1;
	clow -= 1;
	chigh -= 1;
	
	
	if (_matrix[rlow][clow] == "O" || _matrix[rlow+1][clow+1] == "O" || _matrix[rlow+2][clow+2] == "O")
	    return -1;

	
	for (int move = 0; move < 3; move++){
	    if (_matrix[rlow][clow] == "X"){
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

    
    public int check2XBack(int rlow, int rhigh, int clow, int chigh){
	int ctr = 0;
	int take = 0;
       	rlow -= 1;
	rhigh -= 1;
	clow -= 1;
	chigh -= 1;
	
	if (_matrix[rlow][chigh] == "O" || _matrix[rlow+1][chigh-1] == "O" || _matrix[rlow+2][chigh-2] == "O"){
	    return -1;
	}
	
	for (int move = 0; move < 3; move++){
	    if (_matrix[rlow][chigh] == "X"){
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

    
    public boolean check2X(int rlow, int rhigh, int clow, int chigh){
	return ( (check2XRow(rlow, rhigh, clow, chigh) != -1) || (check2XColumn(rlow, rhigh, clow, chigh) != -1) ) || ( (check2XMain(rlow, rhigh, clow, chigh) != -1) || (check2XBack(rlow, rhigh, clow, chigh) != -1) );
    }







    
    public boolean check3O(int rlow, int rhigh, int clow, int chigh){
	rlow -= 1;
	rhigh -= 1;
	clow -= 1;
	chigh -= 1;

	//Checks row
	for (;rlow < rhigh; rlow ++){
	    if (_matrix[rlow][clow] == _matrix[rlow + 1][clow] && _matrix[rlow + 1][clow] == _matrix[rlow + 2][clow] && _matrix[rlow][clow] == "O")
		return true;
	}

	rlow -= 2;
	
	for(;clow < chigh; clow ++){
	    //Checks column
	    if (_matrix[rlow][clow] == _matrix[rlow][clow+1] && _matrix[rlow + 1][clow] == _matrix[rlow + 2][clow] && _matrix[rlow][clow] == "O")
		return true;
	}

	clow -= 2;

	//Checks main diagonal
	if (_matrix[rlow][clow] == _matrix[rlow + 1][clow + 1] && _matrix[rlow][clow] == _matrix[rlow + 2][clow + 2] && _matrix[rlow][clow] == "O")
	    return true;
    

	//Checks back diagonal
	if (_matrix[rlow][chigh] == _matrix[rlow + 1][chigh - 1] && _matrix[rlow][chigh] == _matrix[rlow + 2][chigh - 2] && _matrix[rlow][chigh] == "O")
	    return true;
	
	return false;
    }
	


      
    public boolean check3X(int rlow, int rhigh, int clow, int chigh){
	rlow -= 1;
	rhigh -= 1;
	clow -= 1;
	chigh -= 1;

	//Checks row
	for (;rlow < rhigh; rlow ++){
	    if (_matrix[rlow][clow] == _matrix[rlow + 1][clow] && _matrix[rlow + 1][clow] == _matrix[rlow + 2][clow] && _matrix[rlow][clow] == "X")
		return true;
	}

	rlow -= 2;
	
	for(;clow < chigh; clow ++){
	    //Checks column
	    if (_matrix[rlow][clow] == _matrix[rlow][clow+1] && _matrix[rlow + 1][clow] == _matrix[rlow + 2][clow] && _matrix[rlow][clow] == "X")
		return true;
	}

	clow -= 2;

	//Checks main diagonal
	if (_matrix[rlow][clow] == _matrix[rlow + 1][clow + 1] && _matrix[rlow][clow] == _matrix[rlow + 2][clow + 2] && _matrix[rlow][clow] == "X")
	    return true;
    

	//Checks back diagonal
	if (_matrix[rlow][chigh] == _matrix[rlow + 1][chigh - 1] && _matrix[rlow][chigh] == _matrix[rlow + 2][chigh - 2] && _matrix[rlow][chigh] == "X")
	    return true;
	
	return false;
    }






    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Play for 3 by 3~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    
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

    
    public void play9(){
	int moves = 81;
	int rowO = 0;
	int columnO = 0;
	int rowX, columnX, choice;
	int a = 0;
	int b = 0;
	int upperrow = 9;
	int lowerrow = 1;
	int uppercolumn = 9;
	int lowercolumn = 1;
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

       
		    

		// Determines a) who goes and b) where the O/X is put
		System.out.println("Row bound: " + lowerrow + "-" + upperrow);
		System.out.println("Column bound: " + lowercolumn + "-" + uppercolumn);
		System.out.println("Which row (between " + lowerrow + " and " + upperrow + ") do you want to put your letter?");
		rowO = Keyboard.readInt();

		System.out.println("Which column (between " + lowercolumn  + " and " + uppercolumn + ") do you want to put your letter?");
		columnO = Keyboard.readInt();

		System.out.println();
		
		if (rowO > upperrow || rowO < lowerrow || columnO > uppercolumn || columnO < lowercolumn){
		    System.out.println("Invalid numbers! Try again.\n");
		    break;
		}

		else if (get(rowO,columnO) == "_"){
		    moves--;
		    placeO(rowO, columnO);
		    System.out.println(toString());
		    turn = false;
		    
		    if (rowO % 3 == 0){
			lowerrow = 7;
			upperrow = 9;
		    }
		    else if (rowO % 3 == 1){
			lowerrow = 1;
			upperrow = 3;
		    }
		    else{
			lowerrow = 4;
			upperrow = 6;
		    }

		    
		    if (columnO % 3 == 0){
			lowercolumn = 7;
			uppercolumn = 9;
		    }
		    else if (columnO % 3 == 1){
			lowercolumn = 1;
			uppercolumn = 3;
		    }
		    else{
			lowercolumn = 4;
			uppercolumn = 6;
		    }

		    break;

		}

		else if (full(lowerrow, upperrow, lowercolumn, uppercolumn) == false){
		    System.out.println("Choose another square on the 3 by 3 corresponding board");	     
		}
		else{
		    System.out.println("Move to another square in the board");
		    lowerrow = 1;
		    upperrow = 9;
		    lowercolumn = 1;
		    uppercolumn = 9;
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
		    

		
		//Aim for victory
		
		if (check2X(lowerrow, upperrow, lowercolumn, uppercolumn) == true){
		    a = lowercolumn;
		    
		    if (check2XRow(lowerrow, upperrow, lowercolumn, uppercolumn) != -1){
			System.out.println("2XRow = " + check2XRow(lowerrow, upperrow, lowercolumn, uppercolumn));
			sub = check2XRow(lowerrow, upperrow, lowercolumn, uppercolumn);
			while (a < uppercolumn){
			    if (_matrix[sub][a] != "X"){
				_matrix[sub][a] = "X";
				break;
			    }
			   
			    a+=1;
			}
			_final[sub][a] = "X";

			
		    }
		    else if (check2XColumn(lowerrow, upperrow, lowercolumn, uppercolumn) != -1){
			System.out.println("2XCol = " + check2XColumn(lowerrow, upperrow, lowercolumn, uppercolumn));
			sub = check2XColumn(lowerrow, upperrow, lowercolumn, uppercolumn);
			while (a < upperrow){
			    if (_matrix[a][sub] != "X"){
				_matrix[a][sub] = "X";
				break;
			    }
			    a+=1;
			}
			_final[a][sub] = "X";

		    }
		    else if (check2XMain(lowerrow, upperrow, lowercolumn, uppercolumn) != -1){
			System.out.println("2XMain = " + check2XMain(lowerrow, upperrow, lowercolumn, uppercolumn));			
			_matrix[check2XMain(lowerrow, upperrow, lowercolumn, uppercolumn)][check2XMain(lowerrow, upperrow, lowercolumn, uppercolumn)] = "X";
		    }
		    else {
			System.out.println("2XBack = " + check2XBack(lowerrow, upperrow, lowercolumn, uppercolumn));			
			_matrix[check2XBack(lowerrow, upperrow, lowercolumn, uppercolumn)][2 - check2XBack(lowerrow, upperrow, lowercolumn, uppercolumn)] = "X";
		    }
   
		}


		// Block opponent's victory
		else if (check2O(lowerrow, upperrow, lowercolumn, uppercolumn) == true){
		    b = 0;
		    
		    if (check2ORow(lowerrow, upperrow, lowercolumn, uppercolumn) != -1){
			System.out.println("2ORow = " + check2ORow(lowerrow, upperrow, lowercolumn, uppercolumn));
			sub = check2ORow(lowerrow, upperrow, lowercolumn, uppercolumn);
			while (b < 3){
			    if (_matrix[sub][b] != "O"){
				_matrix[sub][b] = "X";
			    }
			    b+=1;
			}
		    }
		    else if (check2OColumn(lowerrow, upperrow, lowercolumn, uppercolumn) != -1){
			System.out.println("2OCol = " + check2OColumn(lowerrow, upperrow, lowercolumn, uppercolumn));
			sub = check2OColumn(lowerrow, upperrow, lowercolumn, uppercolumn);
			while (b < 3){
			    if (_matrix[b][sub] != "O"){
				_matrix[b][sub] = "X";
			    }
			    b+=1;
			}
		    }
		    else  if (check2OMain(lowerrow, upperrow, lowercolumn, uppercolumn) != -1){
			System.out.println("2OMain = " + check2OMain(lowerrow, upperrow, lowercolumn, uppercolumn));
			_matrix[check2OMain(lowerrow, upperrow, lowercolumn, uppercolumn)][check2OMain(lowerrow, upperrow, lowercolumn, uppercolumn)] = "X";
		    }
		    else {
			System.out.println("2OBack = " + check2OBack(lowerrow, upperrow, lowercolumn, uppercolumn));
			_matrix[check2OBack(lowerrow, upperrow, lowercolumn, uppercolumn)][2 - check2OBack(lowerrow, upperrow, lowercolumn, uppercolumn)] = "X";
		    }
		    
		}

	
		else{
		    System.out.println("Random");
		    while (true ){
			a = (int) (2 * Math.random());
		
			b = (int) (2 * Math.random());
		
		
			if (_matrix[lowerrow+a][lowercolumn+b] == "_"){
			    placeX(lowerrow+a,lowercolumn+b);
			    System.out.println(lowerrow + "\t" + upperrow + "\t" + lowercolumn + "\t" + uppercolumn);

			    lowerrow += a;
			    upperrow += a;
			    lowercolumn += b;
			    uppercolumn += b;

			    break;
			}
			
		    }					
		}
	
				
			System.out.println(lowerrow + "\t" + upperrow + "\t" + lowercolumn + "\t" + uppercolumn);
		  
		    	    
		    if (lowerrow % 3 == 0){
			lowerrow = 7;
			upperrow = 9;
		    }
		    else if (lowerrow % 3 == 1){
			lowerrow = 1;
			upperrow = 3;
		    }
		    else{
			lowerrow = 4;
			upperrow = 6;
		    }

		    
		    if (lowercolumn % 3 == 0){
			lowercolumn = 7;
			uppercolumn = 9;
		    }
		    else if (lowercolumn % 3 == 1){
			lowercolumn = 1;
			uppercolumn = 3;
		    }
		    else{
			lowercolumn = 4;
			uppercolumn = 6;
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
			yay.play9();
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

