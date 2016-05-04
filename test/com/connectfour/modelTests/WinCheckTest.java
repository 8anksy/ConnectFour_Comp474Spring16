package com.connectfour.modelTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.connectfour.model.Board;
import com.connectfour.model.WinCheck;

public class WinCheckTest {

	Board board;
	WinCheck wc;
	@Before
	public void setUp() {
		board = new Board();
		board.initializeBoard();
		wc = new WinCheck(board);
	}

	@After
	public void tearDown() {
		board = null;
	}
	
	@Test
	public void testGetWinnerHorizontal() {
		for (int i = 0; i < 4; i++) {
			board.putColorChar(i, 'R');
		}
		assertEquals('R', wc.getWinner());
	}

	@Test
	public void testGetWinnerVertical() {
		for (int i = 0; i < 4; i++) {
			board.putColorChar(0, 'R');
		}
		assertEquals('R', wc.getWinner());
	}

	@Test
	public void testGetWinnerLeftToRightUpwards() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < i; j++) {
				board.putColorChar(i, 'B');
			}
		}
		for (int i = 0; i < 4; i++) {
			board.putColorChar(i, 'R');
		}
		assertEquals('R', wc.getWinner());
	}
	
	@Test
	public void testLeftToRightDownwards() {
		for (int i = 0; i < 3; i++) {
			for (int j = 3; j > i; j--) {
				board.putColorChar(i, 'B');
			}
		}
		for (int i = 0; i < 4; i++) {
			board.putColorChar(i, 'R');
		}
		assertEquals('R', wc.getWinner());
	}
}