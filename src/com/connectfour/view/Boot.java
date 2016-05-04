package com.connectfour.view;

import org.lwjgl.LWJGLException;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import com.connectfour.model.Board;
import com.connectfour.model.BoardPush;
import com.connectfour.model.WinCheck;
import com.connectfour.viewactions.StateManager;
import com.connectfour.viewactions.StateManager.GameState;
import com.connectfour.viewactions.UI;

import static org.lwjgl.opengl.GL11.*;

import static com.connectfour.viewactions.Artist.*;


/**
  * This class is responsible for creating/closing the windowed game
  * It is the mediator between all the supporting game classes
  */
public class Boot {
	
	//private UI gameUI;
	public Board map;
	public TileGrid grid;
	public boolean isPlayed = true;
	String value = null;
	public char result;

	//take in board variable from main
	public Boot(Board gameBoard){
		this.map = gameBoard;
	}

	/**
	  * Instantiates the game and creates the display window
	  * Checks for win conditions while the game is played until the window is closed
	  */
	public void playGame() {
		System.err.println("Booting up view now...");

		BeginSession();
		StateManager.initializeMainMenu();
		while(StateManager.gameState==GameState.MAINMENU){
			StateManager.initializeMainMenu();
			Display.update();
			Display.sync(60);
			if (Display.isCloseRequested()){
				System.err.println("Closing from menu...");
				Display.destroy();
				System.err.println("Display destroyed");
				System.exit(0);
			}
        }
		 if(StateManager.gameState==GameState.GAMEPUSH || StateManager.gameState == GameState.SINGLE_PLAYER_EASY_PUSH) {
			 this.map=new BoardPush(); 
		 }
		map.initializeBoard();		
		grid = new TileGrid(map);
		while(!Display.isCloseRequested() && map.isFinished==false) {
            /*
             * Originally starts game in main menu 
             * when button is clicked state changes
             * then starts game
             */
			
			
			grid.updateBoard();
			grid.takeInput();
			
			Display.update();
			Display.sync(60);
			
			
			
			if (TileGrid.isUpdateNeeded) {
				grid.updateBoard();
				Display.update();
				Display.sync(60);
				TileGrid.isUpdateNeeded = false;
			}
			
			if (! TileGrid.isWinChecked) {
				WinCheck winCheck = new WinCheck(map);
	            this.result = winCheck.getWinner();
	            TileGrid.isWinChecked = true;
			}
			//below will display who won the game for two seconds before closing
            if (result=='B'){
            	System.out.println("Black wins!");
            	Display.update();
            	DrawQuadTex(FastTex("BlackWinner"),0,0,512,512);
            	Display.update();
            	
            	try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}            	
            	map.isFinished=true;
            }
            
            if (result=='R'){
            	System.out.println("Red wins!");
            	Display.update();
            	DrawQuadTex(FastTex("RedWinner"),0,0,512,512);
            	Display.update();
            	
            	try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}            	
            	map.isFinished=true;
            }
            
            if (result=='D'){
            	System.out.println("It is a draw!");
            	Display.update();
            	DrawQuadTex(FastTex("NoWinner"),0,0,512,512);
            	Display.update();
            	
            	try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}            	
            	map.isFinished=true;
            }
        }
		
		
		Display.destroy();
		System.err.println("Display destroyed");
	}
}
