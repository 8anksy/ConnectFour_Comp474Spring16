package com.connectfour.view;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import com.connectfour.model.Board;

import static org.lwjgl.opengl.GL11.*;

import static com.connectfour.viewactions.Artist.*;

public class Boot {

	public Boot(){
		System.err.println("booting up view now...");
		BeginSession();
		
		Board map = new Board(7,7);
		map.initializeBoard();
		map.checker[4][3] = 'r';
		TileGrid grid = new TileGrid(map);
		//Tile empTile = new Tile(0, 0, 64, 64, TileType.EmptySlot);
		while(!Display.isCloseRequested()){
		 
			
			grid.Draw();
			//DrawQuadTex(redPiece, 0, 0, 64, 64);
			
			Display.update();
			Display.sync(60);
			
		}
		Display.destroy();
	}
	
}
