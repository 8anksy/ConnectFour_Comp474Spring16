package com.connectfour.view;

/**
  * We set each tile texture here and if the tile is clickable
  * We can add more attributes to pieces if needed
  */

public enum TileType {
	
	EmptySlot("emptySlot", false), RedPiece("RedPiece",false), CurrentPlayer("CurrentPlayer",false),
	BlackPiece("BlackPiece",false), DropButton("DropButton",true), Reset("Reset",true),
	RedPlayer("RedPlayer", false), BlackPlayer("BlackPlayer", false);

	String textureName;
	boolean pressable;
	
	/**
	  * Constructor
	  * 
	  * @param textureName (required) the name of the Texture to be used
	  * @param pressable (required) true if the object can be clicked. Else, false.
	  */
	TileType(String textureName, boolean pressable){
		this.textureName= textureName;
		this.pressable = pressable;
	}
}
