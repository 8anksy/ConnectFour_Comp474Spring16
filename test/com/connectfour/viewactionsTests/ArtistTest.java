package com.connectfour.viewactionsTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.lwjgl.opengl.Display;

import com.connectfour.viewactions.Artist;

public class ArtistTest {

	@Before
	public void setUp() throws Exception {
		Artist.BeginSession();
	}

	@After
	public void tearDown() throws Exception {
		Display.destroy();
	}

	@Test
	public void testBeginSession() {
		assertTrue(Display.isActive());
	}

	@Test
	public void testFastTex() {
		try {
			Artist.FastTex("BlackPiece");
		}
		catch (RuntimeException e) {
			fail("Resource not found");
		}
	}

}
