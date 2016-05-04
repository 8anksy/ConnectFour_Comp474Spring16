package com.connectfour.model;

public class WinCheck {
	
	private Board board;
	private static final int CONNECT_WIN_CRITERIA = 4;
	
	/**
	  * Default Constructor
	  * 
	  * @param board (required) a Board object 
	  */
	public WinCheck(Board board) {
		this.board = board;
	}
	
	/**
	  * Default Constructor
	  * Calls a series of private methods that contain the logic for checking
	  * the win conditions against the state of the board.
	  * @return the character of the winning piece (R for red and B for black) 
	  */
	public char getWinner() {
		char winner = checkHorizontal();
        if (winner != ' ') {        	
        	return winner;
        }
        winner = checkVertical();
        if (winner != ' ') {        	
        	return winner;
        }
        winner = checkDiagonals();
        if (winner != ' ') {        	
        	return winner;
        }
        
        char[][] checker = board.getChecker();
        
        // Now we need to check if there are empty positions, otherwise it is a draw
        for (int i = 0; i < board.getHeight(); ++i){
        	for (int j = 0; j < board.getWidth(); ++j) {
        		if (checker[i][j] == ' ') {
        			return ' ';
        		}
        	}
        }    

        return 'D';
	}
	
	/**
	  * Checks the entire board for any 4 pieces of the same color in a row horizontally
	  *  @return the char of the winning color ('R' or 'B')
	  */
	private char checkHorizontal() {
		char[][] checker = board.getChecker();
		for (int row = 0; row < board.getHeight(); ++row) {
            int count = 0;
            // Comparing current element with the previous
            for (int column = 1; column < board.getWidth(); ++column) {
                if (checker[row][column] != ' ' && checker[row][column] == checker[row][column-1]) {
                	if (column == 1) {
                		count++;
                	}
                	++count;
                } else {
                	count = 1;
                }
                
                if (count >= CONNECT_WIN_CRITERIA) {
                    return checker[row][column];
                }
            }
        }
        // Otherwise returning empty character, which means nobody win in rows.
        return ' ';
	}
	
	/**
	  * Checks the entire board for any 4 pieces of the same color in a row vertically
	  *  @return the char of the winning color ('R' or 'B')
	  */
	private char checkVertical() {
		char[][] checker = board.getChecker();
		for (int column = 0; column < board.getWidth(); ++column) {
            int count = 0;
            // Comparing current element with the previous
            for (int row = 1; row < board.getHeight(); ++row) {
                if (checker[row][column] != ' ' && checker[row][column] == checker[row-1][column]) {
                	if (row == 1) {
                		count++;
                	}
                	++count;
                } else {
                	count = 1;
                }
                if (count >= CONNECT_WIN_CRITERIA) {
                    return checker[row][column];
                }
            }
        }
        // Otherwise returning empty character, which means nobody win in rows.
        return ' ';
	}
	
	/**
	  * Checks the entire board for any 4 pieces of the same color in a row in
	  * both diagonal directions
	  *  @return the char of the winning color ('R' or 'B')
	  */
	private char checkDiagonals() {
		
		char[][] checker = board.getChecker();
		
		//check left to right upwards diagonals
        char winner = leftToRightUpwards(checker);
        if (winner != ' ') {
        	return winner;
        }
        winner = leftToRightDownwards(checker);
        return winner;
	}
	
    private char leftToRightUpwards(char[][] checker) {
		for (int row = board.getHeight() - 1; row >= CONNECT_WIN_CRITERIA - 1; --row) {
            int count = 1;
            // Comparing current element with the previous
            int previousRow = row;
            for (int column = 0; column < board.getWidth() - 1; ++column) {
            	if (!((board.getWidth() - column) >= (CONNECT_WIN_CRITERIA - count))) {
            		break;
            	}
                if (checker[previousRow][column] != ' ' && checker[previousRow - 1][column + 1] != ' ') {
                	if (checker[previousRow - 1][column + 1] == checker[previousRow][column]) {
                    	count++;
                    	if (count >= CONNECT_WIN_CRITERIA) {
                        	return checker[previousRow][column];
                        }
                    	previousRow--;
                	} else {
                    	count = 1;
                    	previousRow = row;
                    }
                } else {
                	count = 1;
                	previousRow = row;
                }
                
                if (previousRow < 1) {
            		break;
            	}
                
            }
        }
		// Otherwise returning empty character, which means nobody win in left to right upwards diagonal
        return ' ';
	}


    private char leftToRightDownwards(char[][] checker) {
        for (int row = 0; row <= board.getHeight() - CONNECT_WIN_CRITERIA; ++row) {
            int count = 1;
            // Comparing current element with the next
            int nextRow = row;
            for (int column = 0; column < board.getWidth() - 1; ++column) {
                
                if (!((board.getWidth() - column) >= (CONNECT_WIN_CRITERIA - count))) {
                    break;
                }
                if (checker[nextRow][column] != ' ' && checker[nextRow + 1][column + 1] != ' ') {
                    if (checker[nextRow + 1][column + 1] == checker[nextRow][column]) {
                        count++;
                        if (count >= CONNECT_WIN_CRITERIA) {
                            return checker[nextRow][column];
                        }
                        nextRow++;
                    } else {
                        count = 1;
                        nextRow = row;
                    }
                } else {
                    count = 1;
                    nextRow = row;
                }
                if (nextRow >= board.getHeight() - 1) {
                    break;
                }
                
            }
        }
        // Otherwise returning empty character, which means nobody win in left to right downwards diagonal
        return ' ';
    }
}
