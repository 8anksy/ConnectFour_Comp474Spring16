package com.connectfour.viewactions;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import com.connectfour.model.Board;
import com.connectfour.view.Boot;
import com.connectfour.view.MainMenu;

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
	
	
		
	
	
	public static void setState(GameState newState){
		gameState = newState;
	}

}
