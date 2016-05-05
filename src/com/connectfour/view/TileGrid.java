package com.connectfour.view;
import static com.connectfour.viewactions.Artist.*;

import org.lwjgl.input.Mouse;

import com.connectfour.model.Board;
import com.connectfour.robot.EasyRobot;
import com.connectfour.viewactions.StateManager;
import com.connectfour.viewactions.UI;
import com.connectfour.viewactions.StateManager.GameState;

/**
  * This class is a container for our drawable pieces. It refers to the basic Board
  * data object and mirrors its state with Tile pieces. It also holds our clickable buttons
  * for the user and listens for click events. 
*/
public class TileGrid {
	public UI boardUI;
	public Tile[][] map;
	private Board boardDisplay;
	
	public static boolean isWinChecked = false;
	public static boolean isUpdateNeeded = false;
	public static boolean isReset = false;
	private EasyRobot easyRobot;
	
	
	public TileGrid(){
		map = new Tile[7][7];
		for (int i = 0; i <map.length; i++){
			for (int j = 0; j<map[i].length; j++){
				map[i][j] = new Tile(j * 64, i * 64, 64,64, TileType.EmptySlot);
			}
		}
	}
	
	public TileGrid(Board newMap){
		this.boardDisplay = newMap;
		map = new Tile [7][7];
		for (int i = 0; i <map.length; i++){
			
			for (int j = 0; j<map[i].length; j++){
				/* 
				 * Checks the value board location 
				 * blank is empty square 
				 * r is red piece
				 * b is black piece
				 */
				switch(newMap.checker[i][j]){
				case ' ':
					map[i][j] = new Tile(j * 64, i * 64, 64,64, TileType.EmptySlot);
					break;					
				case 'R':
					map[i][j] = new Tile(j * 64, i * 64, 64,64, TileType.RedPiece);
					break;
				case 'B':
					map[i][j] = new Tile(j * 64, i * 64, 64,64, TileType.BlackPiece);
					break;				
				}				
			}
		}
		this.easyRobot = new EasyRobot(boardDisplay);
	}
	
	/**
	  * to be placed in boot while-loop to update the view of the board
	  * Updates the TileGrid to reflect Board state
	  */
	public void updateBoard(){
		for (int i = 0; i <map.length; i++){
			
			for (int j = 0; j<map[i].length; j++){
				/* 
				 * Checks the value board location 
				 * blank is empty square 
				 * r is red piece
				 * b is black piece
				 */
				switch(boardDisplay.checker[i][j]){
				case ' ':
					map[i][j] = new Tile(j * 64, i * 64, 64,64, TileType.EmptySlot);
					break;					
				case 'R':
					map[i][j] = new Tile(j * 64, i * 64, 64,64, TileType.RedPiece);
					break;
				case 'B':
					map[i][j] = new Tile(j * 64, i * 64, 64,64, TileType.BlackPiece);
					break;				
				}				
			}
		}
		this.Draw();
	}
	
	/**
	  * The listener method used to take user input when selecting a column to place a piece.
	  * Also updates the Board 
	 */
	public void takeInput(){
		
		if (StateManager.gameState == GameState.SINGLE_PLAYER_EASY && boardDisplay.currentColor == 'R'||
				StateManager.gameState == GameState.SINGLE_PLAYER_EASY_PUSH && boardDisplay.currentColor == 'R') {
			int boardColumn = easyRobot.getColumn();
			boardDisplay.putColorChar(boardColumn, boardDisplay.currentColor);
			isWinChecked = false;
			isUpdateNeeded = true;
			return;
		}
		
		//if (Mouse.isButtonDown(0)){
		while(Mouse.next()){
			if(Mouse.getEventButton() > -1){
				if(Mouse.getEventButtonState()){
					
					if(boardUI.isButtonClicked("DropButton0")){							
						boardDisplay.putColorChar(0, boardDisplay.currentColor);
						isWinChecked = false;
						isUpdateNeeded = true;
					}
					if(boardUI.isButtonClicked("DropButton1")){							
						boardDisplay.putColorChar(1, boardDisplay.currentColor);
						isWinChecked = false;
						isUpdateNeeded = true;
					}
					if(boardUI.isButtonClicked("DropButton2")){							
						boardDisplay.putColorChar(2, boardDisplay.currentColor);
						isWinChecked = false;
						isUpdateNeeded = true;
					}
					if(boardUI.isButtonClicked("DropButton3")){							
						boardDisplay.putColorChar(3, boardDisplay.currentColor);
						isWinChecked = false;
						isUpdateNeeded = true;
					}
					if(boardUI.isButtonClicked("DropButton4")){							
						boardDisplay.putColorChar(4, boardDisplay.currentColor);
						isWinChecked = false;
						isUpdateNeeded = true;
					}
					if(boardUI.isButtonClicked("DropButton5")){							
						boardDisplay.putColorChar(5, boardDisplay.currentColor);
						isWinChecked = false;
						isUpdateNeeded = true;
					}
					if(boardUI.isButtonClicked("DropButton6")){							
						boardDisplay.putColorChar(6, boardDisplay.currentColor);
						isWinChecked = false;
						isUpdateNeeded = true;
					}
					if(boardUI.isButtonClicked("Reset")){
						boardDisplay.initializeBoard();
					}
				}
            }
		}
	}
	
	/**
	  * Draws our board to the Display
	  */
	public void Draw(){
		boardUI = new UI();
		
		DrawQuadTex(FastTex("CurrentPlayer"), (float)448, (float)0, (float)64, (float)64);
		//Display current player
		if (boardDisplay.currentColor=='R'){
			DrawQuadTex(FastTex("RedPlayer"), (float)448, (float)64, (float)64, (float)64);
		}
		else{
			DrawQuadTex(FastTex("BlackPlayer"), (float)448, (float)64, (float)64, (float)64);
		}
		for (int i = 0; i < map.length; i++){
			for (int j = 0 ; j < map[i].length; j++){
				Tile t = map[i][j];
				DrawQuadTex(t.getTexture(), t.getX(), t.getY(), t.getWidth(), t.getHeight());
			}
		}
		//Draw line of buttons
		for (int k = 0; k < 7; k++){
			boardUI.addButton("DropButton"+k, "DropButton", k*64, 448);						
		}
		boardUI.addButton("Reset", "Reset", 448, 128,64,384);
		boardUI.draw();	
	}
}
