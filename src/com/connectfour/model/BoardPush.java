package com.connectfour.model;

public class BoardPush extends Board {
	
	
	
	/**
	  * Default Constructor
	  * 
	  * Calls the constructor from the Board superclass
	  */
	public BoardPush() {
		super();
	}
	
	/**
	  * Constructor
	  * 
	  * Calls the constructor from the Board superclass
	  * @param rows : the desired number of rows on the board
	  * @param cols : the desired number of columns on the board
	  */
	public BoardPush(int rows, int cols) {
		super(rows, cols);
	}
	
	/**
	  * This method places a piece at the bottom of the specified column
	  * and shifts all other pieces upwards in the column
	  * @param column (required) the column in which the piece is placed
	  * @param color (required) the color of the piece to be placed
	  * @return True if the piece is placed. False if there is no room in the column
	  */
	
	@Override
	public boolean putColorChar(int column, char color) {
        // If the first char is there, the column is filled, returning false.
        if (checker[0][column] != ' ') {
        	return false;
        }
        
        for (int row = 1; row < super.getHeight(); row++) {
        	//Move each char "up" one in the column
        	checker[row-1][column] = checker[row][column];
        	//Set the newest char at the bottom of the column
        	if (row == super.getHeight() - 1) {
                checker[row][column] = color;
                super.currentColor = colorSwitch(super.currentColor);
            }
        }
        return true;
    }
}
