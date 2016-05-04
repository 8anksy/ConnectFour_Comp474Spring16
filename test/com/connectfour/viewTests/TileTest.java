package com.connectfour.viewTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import com.connectfour.view.Tile;
import com.connectfour.view.TileType;
import com.connectfour.viewactions.Artist;

public class TileTest {

	private Tile tile;
	
	@Before
	public void setUp() {
		Artist.BeginSession();
		tile = new Tile(64, 64, 64, 64, TileType.RedPiece);
	}

	@After
	public void tearDown() throws Exception {
		tile = null;
		Display.destroy();
		
	}

	@Test
	public void testTile() {
		assertEquals(64, tile.getX(), 0.0002);
		assertEquals(64, tile.getY(), 0.0002);
		assertEquals(64, tile.getHeight(), 0.0002);
		assertEquals(64, tile.getWidth(), 0.0002);
		assertTrue(tile.getTexture() instanceof Texture);
		assertTrue(tile.getType() instanceof TileType);
	}

	@Test
	public void testDraw() {
		try {
			tile.Draw();
		}
		catch (RuntimeException e){
			fail("Tile not drawn");
		}
	}

}
