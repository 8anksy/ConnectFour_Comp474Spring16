package com.connectfour.modelTests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import com.connectfour.model.Board;

public class BoardTest {

	Board board;
	
	@Before
	public void setup() {
		board = new Board();
	}
	@After
	public void tearDown() {
		board = null;
	}
	
	@Test
	//assert that the Board was constructed with the correct values
	public void testBoard() {
		assertEquals(7, board.getHeight());
		assertEquals(7, board.getWidth());
	}

	@Test
	public void testGetChecker() {
		assertNotNull(board.getChecker());
	}

	@Test
	//tests that the array that we initialized has no null values
	public void testInitializeBoard() {
		board.initializeBoard();
		for (int i = 0; i < board.getHeight(); i ++) {
			for (int j = 0; j < board.getWidth(); j++) {
				assertNotNull(board.getChecker()[i][j]);
				assertEquals(' ', board.getChecker()[i][j]);
			}
		}
	}
	
	@Test
	//Initialize the board, fill a column, and then add one more
	//to test the placement and overflow of pieces
	public void testPutColorChar() {
		board.initializeBoard();
		for (int i = 0; i < board.getHeight(); i++) {
			assertTrue(board.putColorChar(0, 'R'));
		}
		//test that a full column responds appropriately
		assertFalse(board.putColorChar(0, 'R'));
	}

	@Test
	public void testColorSwitch() {
		assertEquals('R', board.colorSwitch('B'));
		assertEquals('B', board.colorSwitch('R'));
	}

}
