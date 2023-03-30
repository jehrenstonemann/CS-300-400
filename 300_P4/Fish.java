//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Fish.java
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
// Persons: Wendi Cai
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Constructors, getters, and setters related to fishes
 * @author Huang Xiangyu
 *
 */
public class Fish {
	//stores the reference to the PApplet object which represents the display window of this application
	private static PApplet processing;
	//stores the reference to the image object of this fish
	private PImage image;
	//represents the x-position of this fish
	private float x;
	//represents the y-position of this fish
	private float y;
	//represents the swimming speed of this fish
	private int speed;
	//indicate whether this fish is being dragged or not
	private boolean isDragging;
	//indicate whether this fish is swimming or not
	private boolean isSwimming;
	//stores the old x-position of the mouse
	private static int oldMouseX;
	//stores the old y-position of the mouse
	private static int oldMouseY;

	/**
	 * Creates a new fish object (contain the information for speed and fish image file name) 
	 * located at a specific (x, y) position of the display window
	 * @param processing PApplet object that represents the display window
	 * @param x x-position of the image of this fish in the display window
	 * @param y y-position of the image of this fish in the display window
	 * @param speed the swimming speed of this fish
	 * @param fishImageFileName file name of the image of the fish to be created
	 */
	public Fish(PApplet processing, float x, float y, int speed,
	String fishImageFileName) {
		Fish.processing = processing;
		this.x = x;
		this.y = y;
		this.speed = speed;
		image = processing.loadImage(fishImageFileName);
	}
	
	/**
	 * Creates a new fish object which speed is 5 and positioned at the center of the display window
	 * @param processing PApplet object that represents the display window
	 */
	public Fish(PApplet processing) {
		this.image = processing.loadImage("images" + File.separator + "orange.png");
		speed = 5;
		this.x = processing.width / 2;
		this.y = processing.height / 2;
	}
	
	/**
	 * getter of the image instance field
	 * @return the image of type PImage of this fish
	 */
	public PImage getImage() {
		return this.image;
	}
	
	/**
	 * getter of the x-position of this fish
	 * @return the x-position of this fish in the display window
	 */
	public float getPositionX() {
		return this.x;
	}
	
	/**
	 * getter of the y-position of this fish
	 * @return the y-position of this fish in the display window
	 */
	public float getPositionY() {
		return this.y;
	}
	
	/**
	 * Moves this fish with dx and dy
	 * @param dx the amount moved in the x-dimension
	 * @param dy the amount moved in the y-dimension
	 */
	public void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
	
	/**
	 * a getter for the isDragging instance field
	 * Checks whether this fish is being dragged
	 * @return true if this fish is being dragged
	 */
	public boolean isDragging() {
		return isDragging;
	}
	
	/**
	 * Starts dragging this fish
	 */
	public void startDragging() {
		oldMouseX = processing.mouseX;
		oldMouseY = processing.mouseY;
		isDragging = true;
	}
	
	/**
	 * Stops dragging this fish
	 */
	public void stopDragging() {
		isDragging = false;
	}
	
	/**
	 * Draws this fish to the display window and 
	 * sets the position of this fish to follow the moves of the
	 * mouse if it is being dragged
	 */
	public void draw() {
		int dx = processing.mouseX - oldMouseX;
		int dy = processing.mouseY - oldMouseY;
		if(isDragging() == true) {
			move(dx, dy);
			startDragging();
		}
		if(isSwimming == true) {
			swim();
		}
		processing.image(image,x,y);
	}
	
	/**
	 * Starts swimming this fish
	 */
	public void startSwimming() {
		stopDragging();
		isSwimming = true;
	}
	
	/**
	 * Stops swimming this fish
	 */
	public void stopSwimming() {
		isSwimming = false;
	}
	
	/**
	 * Moves horizontally the fish one speed step from left to right
	 */
	public void swim(){
		x = (x + speed) % processing.width;
	}
	
	/**
	 * Checks if the mouse is over a given fish whose reference is provided as input parameter
	 * @return true if the mouse is over the given fish object (i.e. over the image of the fish),
	 *         false otherwise
	 */
	public boolean isMouseOver() {
		Fish fish = this;
		int fishWidth = fish.getImage().width;
		int fishHeight = fish.getImage().height;
    
		// checks if the mouse is over the provided fish
		return processing.mouseX >= fish.getPositionX() - fishWidth / 2
				&& processing.mouseX <= fish.getPositionX() + fishWidth / 2
				&& processing.mouseY >= fish.getPositionY() - fishHeight / 2
				&& processing.mouseY <= fish.getPositionY() + fishHeight / 2;
  }
}
