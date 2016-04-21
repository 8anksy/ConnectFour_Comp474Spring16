package com.connectfour.viewactions;

import java.util.ArrayList;
import static com.connectfour.viewactions.Artist.*;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

public class UI {
	
	private ArrayList<Button> buttonList;
	
	public UI(){
		buttonList = new ArrayList<Button>();
	}
	
	public void addButton(String name, String texName, int x, int y){
		buttonList.add(new Button(name, FastTex(texName), x, y));
	}
	
	public void addButton(String name, String texName, int x, int y, int width, int height){
		buttonList.add(new Button(name, FastTex(texName), x, y, width, height));
	}
	
	public boolean isButtonClicked(String buttonName){
		Button b = getButton(buttonName);
		float mouseY = HEIGHT - Mouse.getY() - 1;
		// Check to see if mouse click is over button
		if(Mouse.getX() > b.getX() && Mouse.getX() < b.getX()+ b.getWidth() &&
				mouseY > b.getY() && mouseY <b.getY() + b.getHeight()){
			return true;
		}
		return false;
	}
	
	private Button getButton(String buttonName){
		for (Button b: buttonList){
			if (b.getName().equals(buttonName)){
				return b;
			}
		}
		return null;
	}
	
	public void draw(){
		for (Button b: buttonList){
			DrawQuadTex(b.getTexture(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
		}
	}

}
