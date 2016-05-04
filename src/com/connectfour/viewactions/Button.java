package com.connectfour.viewactions;

import org.newdawn.slick.opengl.Texture;

/**
  * The button object contains the info required to generate clickable
  * panes on the Display.
  */
public class Button {
	
	private String name;
	private Texture texture;
	private int x, y, width, height;
	
	/**
	  * Constuctor
	  * 
	  * @param name (required) the designated name of the button
	  * @param texture (required) the Texture object pulled from the resources folder
	  * @param x (required) the x position of the button
	  * @param y (required) the y position of the button
	  * @param width : the width of the button
	  * @param height : the height of the button
	 */
	public Button (String name, Texture texture, int x, int y, int width, int height){
		this.name = name;
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/**
	  * Constuctor
	  * 
	  * @param name (required) the designated name of the button
	  * @param texture (required) the Texture object pulled from the resources folder
	  * @param x (required) the x position of the button
	  * @param y (required) the y position of the button
	 */
	public Button (String name, Texture texture, int x, int y){
		
		this.name = name;
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.width = texture.getImageWidth();
		this.height = texture.getImageHeight();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
