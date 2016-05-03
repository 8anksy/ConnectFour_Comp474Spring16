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
	
	public void playGame() {
		System.err.println("booting up view now...");

		BeginSession();
		StateManager.initializeMainMenu();
		while(StateManager.gameState==GameState.MAINMENU){
			StateManager.initializeMainMenu();
			Display.update();
			Display.sync(60);
			
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
			
			
			grid.updateBoard(map);
			grid.takeInput(map);
			
			Display.update();
			Display.sync(60);
			
			
			
			if (TileGrid.isUpdateNeeded) {
				grid.updateBoard(map);
				Display.update();
				Display.sync(60);
				TileGrid.isUpdateNeeded = false;
			}
			
			if (! TileGrid.isWinChecked) {
				WinCheck winCheck = new WinCheck(map);
	            this.result = winCheck.getWinner(map);
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
	
	/*public static void main(String[] args){
		new Boot(new Board(7,7) );
	}*/
}
