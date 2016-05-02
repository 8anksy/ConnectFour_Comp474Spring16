package com.connectfour.viewactions;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import com.connectfour.model.Board;
import com.connectfour.view.Boot;
import com.connectfour.view.MainMenu;

public class StateManager {
	
	public static enum GameState {
		MAINMENU, GAME, GAMEPUSH, SINGLE_PLAYER_EASY
	}
	
	public static GameState gameState = GameState.MAINMENU;
	public static MainMenu mainMenu;
	public static Boot game;
	public static Board board;
	
	public static void initializeMainMenu() {
		if(mainMenu==null)
			mainMenu=new MainMenu();
		mainMenu.menuUpdate();
	}
	
	public static void stateUpdate(){
		if ((Mouse.isButtonDown(0))) {
			mainMenu.updateButtons();
		}
		
	}
	
	public static void setState(GameState newState){
		gameState = newState;
	}

}
