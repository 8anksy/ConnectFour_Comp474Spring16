package com.connectfour.viewactions;

import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;
import java.io.InputStream;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;


/**
 * This class manages the creation of our display and facilitates the drawing of
 * all our drawable objects. Also serves as the entry point for retrieving Textures
 * from our resources file.
 */

public class Artist {
	//Width and Height of the user interface window
	public static final int WIDTH = 512, HEIGHT = 512;
	
	
	/**
	  * Creates our display and intializes the setup of the new window
	  */
	public static void BeginSession() {
		
		Display.setTitle("Connect Four");
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.create();
		} catch (LWJGLException e) {			
			e.printStackTrace();
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		//Next two lines allow us to use transparency in images
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
		
		
	}
	
	/**
	  * Draws our drawable objects
	  * @param x (required) the x position of the object
	  * @param y (required) the y position of the object
	  * @param width (required) the width of the object
	  * @param height (required) the height of the object
	  */
	public static void DrawQuad(float x, float y, float width, float height ){
		glBegin(GL_QUADS);
		glVertex2f(x, y);
		glVertex2f(x + width, y);
		glVertex2f(x + width, y + height);
		glVertex2f(x, y + height);
		glEnd();
	}

	/**
	  * Draws square objects with an applied texture relative to the other drawn objects
	  * @param tex (required) the Texture object to be drawn
	  * @param x (required) the x position of the object
	  * @param y (required) the y position of the object
	  * @param width (required) the width of the object
	  * @param height (required) the height of the object
	  */
	public static void DrawQuadTex(Texture tex, float x, float y, float width, float height){
		tex.bind();
		//lets us make tile positioning relative
		glTranslatef(x,y,0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0,0);
		glTexCoord2f(1,0);
		glVertex2f(width, 0);
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		glTexCoord2f(0,1);
		glVertex2f(0, height);
		glEnd();
		glLoadIdentity();
		
	}
	
	/**
	  * Retrieves the texture from our resource folder
	  * @param path (required) the path of the target resource
	  * @param fileType (required) the filetype of the target resource
	  * @return the texture retrieved by the path given
	  */
	public static Texture LoadTexture(String path, String fileType) {
		Texture tex = null;
		InputStream in = ResourceLoader.getResourceAsStream(path);
		try {
			tex = TextureLoader.getTexture(fileType, in);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return tex;
	}
	
	/**
	  * A helper method to make texture retrieval easier. Only need a filename
	  * @param name (required) the name of the file in the resource folder
	  * @return the texture retrieved by the path given
	  */
	
	public static Texture FastTex(String name){
		Texture tex = null;
		tex = LoadTexture("com/connectfour/res/"+ name + ".png", "PNG");
		return tex;
	}

}
