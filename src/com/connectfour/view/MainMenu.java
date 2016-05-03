package com.connectfour.view;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import com.connectfour.viewactions.StateManager;
import com.connectfour.viewactions.StateManager.GameState;
import com.connectfour.viewactions.UI;

import static com.connectfour.viewactions.Artist.*;

public class MainMenu {

	private Texture background;
	private Texture classButton;
	private UI menuUI;
	
	public MainMenu(){
		background = FastTex("MainMenu");		
		menuUI = new UI();		
		menuUI.addButton("TwoPlayerReg", "Class", 36, 240);
		menuUI.addButton("SingleRegE", "ClassEasy", 198, 240);
		menuUI.addButton("SingleRegH", "ClassHard", 360, 240);
		menuUI.addButton("TwoPlayerPush", "Push", 36, 334);
		menuUI.addButton("SinglePushE", "PushEasy", 198, 334);
		menuUI.addButton("SinglePushH", "PushHard", 360, 334);
		
	}
	
	public void updateButtons(){
		if(Mouse.isButtonDown(0)){
			if (menuUI.isButtonClicked("TwoPlayerReg")){
				System.out.println("BUTTON PRESSED");
				StateManager.setState(GameState.GAME);
			} 
			if (menuUI.isButtonClicked("SingleRegE")){
				StateManager.setState(GameState.SINGLE_PLAYER_EASY);
			} 
			if (menuUI.isButtonClicked("SingleRegH")){
				StateManager.setState(GameState.GAME);
			} 
			if (menuUI.isButtonClicked("TwoPlayerPush")){
				StateManager.setState(GameState.GAMEPUSH);
			} 
			if (menuUI.isButtonClicked("SinglePushE")){
				StateManager.setState(GameState.SINGLE_PLAYER_EASY_PUSH);
			} 
			if (menuUI.isButtonClicked("SinglePushH")){
				StateManager.setState(GameState.GAMEPUSH);
			}
		
		}		
		
	}
	
	public void menuUpdate() {
		DrawQuadTex(background,0,0,512,512);		
		menuUI.draw();
		updateButtons();
		
	}

}
