package com.connectfour.viewactions;

import com.connectfour.model.Board;
import com.connectfour.view.Boot;
import com.connectfour.view.MainMenu;

/**
  * The StateManager is...well, it manages the state of the game.
  */
public class StateManager {
	
	public static enum GameState {
		MAINMENU, GAME, GAMEPUSH, SINGLE_PLAYER_EASY, SINGLE_PLAYER_EASY_PUSH
	}
	
	public static GameState gameState = GameState.MAINMENU;
	public static MainMenu mainMenu;
	public static Boot game;
	public static Board board;
	
	public static void initializeMainMenu() {
		switch(gameState){
		case MAINMENU:
			if(mainMenu==null)
				mainMenu=new MainMenu();
			mainMenu.menuUpdate();
		case GAME:
			break;
		case GAMEPUSH:
			break;
		case SINGLE_PLAYER_EASY:
			break;
		case SINGLE_PLAYER_EASY_PUSH:
			break;
		
		}
	}
	
	
		
	
	/**
	  * Setter method for updating the state of the game
	  * @param newState (required) the desired new state of the game
	  */
	public static void setState(GameState newState){
		gameState = newState;
	}

}
