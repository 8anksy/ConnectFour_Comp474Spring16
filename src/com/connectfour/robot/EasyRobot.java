package com.connectfour.robot;

import java.util.Random;

import com.connectfour.model.Board;

/**
  * This is a simple AI that chooses columns at random to play against the user
  */
public class EasyRobot {
	
	private Board board;
	private static final int CONNECT_WIN_CRITERIA = 4;
	
	public EasyRobot(Board board) {
		this.board = board;
	}
	
	
	/**
	  * Makes random piece placements against the user
	  *  @return an int that corresponds to a column on the board
	  */
	public int getColumn() {
		Random random = new Random();
		int[] countAndPositionHorizontalCheck= getHorizontalPosition();
		int[] countAndPositionVerticalCheck= getVerticalPosition(); 
		if (countAndPositionHorizontalCheck[0] > 0 || countAndPositionVerticalCheck[0] > 0) {
			if (countAndPositionHorizontalCheck[0] > countAndPositionVerticalCheck[0]) {
				return countAndPositionHorizontalCheck[2];
			}
			if (countAndPositionVerticalCheck[0] > countAndPositionHorizontalCheck[0]) {
				return countAndPositionVerticalCheck[2];
			}
			return random.nextBoolean() ? countAndPositionVerticalCheck[2] : countAndPositionHorizontalCheck[2];
		}
		return random.nextInt(7);
	}
	
	private int[] getHorizontalPosition() {
		int[] countAndPosition= new int[3];
		int maxCount = 0;
		char[][] checker = board.getChecker();
		for (int row = 0; row < board.getHeight(); ++row) {
            int count = 0;
            // Comparing current element with the previous
            int valueFoundFirstColumn = 0;
            for (int column = 1; column < board.getWidth(); ++column) {
                if (checker[row][column] != ' ' && checker[row][column] == checker[row][column-1]) {
                	if (column == 1) {
                		count++;
                	}
                	++count;
                	if (valueFoundFirstColumn == 0) {
                		valueFoundFirstColumn = column-1;
                	}
                } else {
                	count = 1;
                }
                
                if (count < CONNECT_WIN_CRITERIA && count > 0 && count >= maxCount 
                		&& column < board.getWidth() - 1) {
                	maxCount = count;
                	countAndPosition[0] = count;
                	countAndPosition[1] = row;
                	if (checker[row][column + 1] == ' ') {
                		countAndPosition[2] = column + 1;
                	} else if (valueFoundFirstColumn > 0){
                		countAndPosition[2] = valueFoundFirstColumn - 1;
                	} else {
                		countAndPosition[2] = 0;
                	}
                	
                }
                
                if (count < CONNECT_WIN_CRITERIA && count > 0 && count >= maxCount 
                		&& column < board.getWidth() - 1 && checker[row][column + 1] == ' ') {
                	maxCount = count;
                	countAndPosition[0] = count;
                	countAndPosition[1] = row;
                	countAndPosition[2] = column + 1;
                }
            }
        }
        
        /*if (maxCount >= 3 && checker[countAndPosition[1]][countAndPosition[1] - 1] == 'B') {
            return countAndPosition;
        }
        
        if (count >= 2 && column < board.getWidth() - 1 && checker[row][column] == 'R') {
        	countAndPosition[0] = count;
        	countAndPosition[1] = column + 1;
            return countAndPosition;
        }
        
        if (count >= 2 && column < board.getWidth() - 1 && checker[row][column] == 'B') {
        	countAndPosition[0] = count;
        	countAndPosition[1] = column + 1;
            return countAndPosition;
        }
        
        if (count >= 1 && column < board.getWidth() - 1 && checker[row][column] == 'R') {
        	countAndPosition[0] = count;
        	countAndPosition[1] = column + 1;
            return countAndPosition;
        }*/
        // Otherwise returning empty character, which means nobody win in rows.
        return countAndPosition;
	}
	
	/**
	  * Checks the entire board for any 4 pieces of the same color in a row vertically
	  *  @return the char of the winning color ('R' or 'B')
	  */
	private int[] getVerticalPosition() {
		int[] countAndPosition= new int[3];
		int maxCount = 0;
		char[][] checker = board.getChecker();
		for (int column = 0; column < board.getWidth(); ++column) {
            int count = 0;
            // Comparing current element with the previous
            for (int row = board.getHeight() - 1; row >= 1; --row) {
                if (checker[row][column] != ' ' && checker[row][column] == checker[row-1][column]) {
                	if (row == board.getHeight() - 1) {
                		count++;
                	}
                	++count;
                } else {
                	count = 1;
                }
                if (count < CONNECT_WIN_CRITERIA && count > maxCount 
                		&& row > 1 && checker[row - 2][column] == ' ') {
                	maxCount = count;
                	countAndPosition[0] = count;
                	countAndPosition[1] = row - 2;
                	countAndPosition[2] = column;
                }
            }
        }
        // Otherwise returning empty character, which means nobody win in rows.
        return countAndPosition;
	}

}
