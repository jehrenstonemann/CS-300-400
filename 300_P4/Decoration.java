//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Decoration.java
// Course:   CS 300 Fall 2021
//
// Author:   Xiangyu Huang
// Email:    xhuang438@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:  
// Partner Email:
// Partner Lecturer's Name:
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//    Write-up states that pair programming is allowed for this assignment.
//    We have both read and understand the course Pair Programming Policy.
//    We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE  
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Constructors, getters, and setters related to decorations
 * @author Huang Xiangyu
 *
 */
public class Decoration {
	//stores the reference to the PApplet object which represents the display window of this application
	private static PApplet processing;
	//stores the reference to the image object of this fish
	private PImage image;
	//represents the x-position of this object
	private float x;
	//represents the y-position of this object
	private float y;
	//represents the swimming speed of this fish
	private boolean isDragging;
	//indicate whether this fish is swimming or not
	private static int oldMouseX;
	//stores the old y-position of the mouse
	private static int oldMouseY;

	/**
	 * Creates a new decoration object (contain the information for image file name) 
	 * located at a specific (x, y) position of the display window
	 * @param processing PApplet object that represents the display window
	 * @param x x-position of the image of this decoration in the display window
	 * @param y y-position of the image of this decoration in the display window
	 * @param imageFileName file name of the image of the decoration to be created
	 */
	public Decoration(PApplet processing, float x, float y, String imageFileName){
		Decoration.processing = processing;
		this.x = x;
		this.y = y;
		image = processing.loadImage(imageFileName);
	}
	
	/**
	 * getter of the image of this decoration object
	 * @return the image of this decoration object
	 */
	public PImage getImage() {
		return this.image;
	}

	/**
	 * getter of the x-position of this decoration object
	 * @return the x-position of this decoration object
	 */
	public float getPositionX() {
		return this.x;
	}
	
	/**
	 * getter of the y-position of this decoration object
	 * @return the y-position of this decoration object
	 */
	public float getPositionY() {
		return this.y;
	}
	
	/**
	 * Checks whether this decoration object is being dragged
	 * @return true if the object is being dragged, false otherwise
	 */
	public boolean isDragging() {
		return isDragging;
	}
	
	/**
	 * Starts dragging this decoration object
	 */
	public void startDragging() {
		oldMouseX = processing.mouseX;
		oldMouseY = processing.mouseY;
		isDragging = true;
	}
	
	/**
	 * Stops dragging this decoration object
	 */
	public void stopDragging() {
		isDragging = false;
	}
	
	/**
	 * Checks whether the mouse is over this decoration object
	 * @return true if the mouse is over this decoration object
	 */
	public boolean isMouseOver() {
		Decoration decoration = this;
	    int decorationWidth = decoration.getImage().width;
	    int decorationHeight = decoration.getImage().height;
	    
	    // checks if the mouse is over the decoration object
	    return processing.mouseX >= decoration.getPositionX() - decorationWidth / 2
	        && processing.mouseX <= decoration.getPositionX() + decorationWidth / 2
	        && processing.mouseY >= decoration.getPositionY() - decorationHeight / 2
	        && processing.mouseY <= decoration.getPositionY() + decorationHeight / 2;
	}
	
	/**
	 * Moves this decoration object with dx and dy
	 * @param dx the amount moved in the x-dimension
	 * @param dy the amount moved in the y-dimension
	 */
	public void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
	
	/**
	 * Draws this decoration object to the display window
	 */
	public void draw() {
		int dx = processing.mouseX - oldMouseX;
		int dy = processing.mouseY - oldMouseY;
		if(isDragging() == true) {
			move(dx, dy);
			startDragging();
		}
		processing.image(image,x,y);
	}

}
