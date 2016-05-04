/**
 * 
 */
package com.connectfour.modelTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.connectfour.model.Board;
import com.connectfour.model.BoardPush;


public class BoardPushTest {
	
	Board board;

	@Before
	public void setUp() {
		board = new BoardPush();
	}

	@After
	public void tearDown() {
		board = null;
	}

	@Test
	public void testPutColorChar() {
		char color = 'B';
		board.initializeBoard();
		for (int i = 0; i < 2; i++) {
			assertTrue(board.putColorChar(0, color));
			color = board.colorSwitch(color);
		}
		//test that a full column responds appropriately
		assertEquals('B', board.getChecker()[board.getHeight() - 2][0]);
		assertEquals('R', board.getChecker()[board.getHeight() - 1][0]);
	}

}
