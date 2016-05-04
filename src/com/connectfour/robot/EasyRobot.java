package com.connectfour.robot;

import java.util.Random;

/**
  * This is a simple AI that chooses columns at random to play against the user
  */
public class EasyRobot {
	
	
	/**
	  * Makes random piece placements against the user
	  *  @return an int that corresponds to a column on the board
	  */
	public static int getRandomColumn() {
		Random rn = new Random();
		return rn.nextInt(7);
	}

}
