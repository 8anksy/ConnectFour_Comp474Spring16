package com.connectfour.viewactionsTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import com.connectfour.viewactions.Artist;
import com.connectfour.viewactions.UI;

public class UITest {
	
	Texture t;
	UI ui;
	@Before
	public void setUp() throws Exception {
		Artist.BeginSession();
		t = Artist.FastTex("Reset");
		ui = new UI();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
		ui = null;
		Display.destroy();
	}

	@Test
	public void testAddButtonStringStringIntInt() {
		int before = ui.getButtonListSize();
		ui.addButton("Reset", "Reset", 64, 64);
		int after = ui.getButtonListSize();
		assertTrue(before < after);
	}

	@Test
	public void testAddButtonStringStringIntIntIntInt() {
		int before = ui.getButtonListSize();
		ui.addButton("Reset", "Reset", 64, 64, 64, 64);
		int after = ui.getButtonListSize();
		assertTrue(before < after);
	}

}
