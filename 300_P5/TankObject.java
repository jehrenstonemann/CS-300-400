//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    TankObject behaviors
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
// Persons: Haixi Zhang  
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

import processing.core.PImage;

/**
 * It stores the behavior of all TankObjects
 * @author Huang Xiangyu
 *
 */
public class TankObject implements TankListener{
	
	protected static FishTank tank; // PApplet object which represents
	// the display window
	protected PImage image; // image of this tank object
	private float x; // x-position of this tank in the display window
	private float y; // y-position of this tank in the display window
	private boolean isDragging; // indicates whether this tank object
	// is being dragged or not
	private static int oldMouseX; // old x-position of the mouse
	private static int oldMouseY; // old y-position of the mouse

	/**
	 * create a new tank object located at a specific position of the 
	 * display window
	 * <p>
	 * @param x x-coordinate of the image of this object in the display window
	 * @param y y-coordinate of the image of this object in the display window
	 * @param imageFileName  filename of the image of this object
	 */
	public TankObject(float x, float y, String imageFileName) {
	    // sets the position of this decoration object
	    this.x = x;
	    this.y = y;
	    isDragging = false; // initially the fish is not dragging
	    image = tank.loadImage(imageFileName);
	}
	
	/**
	 * Sets the PApplet graphic display window for all TankObjects
	 * <p>
	 * @param tank this FishTank object
	 */
	public static void setProcessing(FishTank tank) {
		TankObject.tank = tank;
	}
	
	/**
	 * Moves this tank object with dx and dy
	 * <p>
	 * @param dx the amount move to the x-position of this tank object
	 * @param dy the amount move to the y-position of this tank object
	 */
	public void move(int dx, int dy) {
	    x = dx;
	    y = dy;
	}
	
	/**
	 * gets the x-position of this tank object
	 * <p>
	 * @return x-position of this tank object
	 */
	public float getX() {
		return x;
	}
	
	/**
	 * gets the y-position of this object
	 * <p>
	 * @return y-position of this tank object
	 */
	public float getY() {
		return y;
	}
	
	/**
	 * Sets the x-position of this object
	 * <p>
	 * @param x x-position of this object
	 */
	public void setX(float x) {
		this.x = x;
	}
	
	/**
	 * Sets the y-position of this object
	 * <p>
	 * @param y y-position of this object
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	/**
	 * getter of the image field
	 * <p>
	 * @return the image of this tank object
	 */
	public PImage getImage() {
		return image;
	}
	
	/**
	 * Getter of the isDragging field.
	 * <p>
	 * @return true if this object is being dragged, false otherwise
	 */
	public boolean isDragging() {
		return isDragging;
	}
	
	/**
	 * Starts dragging this tank object
	 */
	public void startDragging() {
	    oldMouseX = tank.mouseX;
	    oldMouseY = tank.mouseY;
	    isDragging = true;
	}
	
	/**
	 * Stops dragging this tank object
	 */
	public void stopDragging() {
		isDragging = false;
	}
	
	/**
	 * draw objects follows the move of the mouse
	 */
	@Override
	public void draw() {
		if (isDragging) {
            move(tank.mouseX, tank.mouseY);
            oldMouseX = tank.mouseX;
            oldMouseY = tank.mouseY;
        }
        tank.image(image, x, y);
	}

	/**
	 * when mouse is pressed, start dragging
	 */
	@Override
	public void mousePressed() {
		startDragging();
	}

	/***
	 * when mouse is released, stop dragging
	 */
	@Override
	public void mouseReleased() {
		stopDragging();
	}

	/**
	 * checks whether the mouse if over the provided fish
	 * <p>
	 * @return true if the mouse is over the provided fish
	 */
	@Override
	public boolean isMouseOver() {
		int fishWidth = getImage().width;
        int fishHeight = getImage().height;
        
        // checks if the mouse is over the provided fish
        return tank.mouseX >= x - fishWidth / 2
                && tank.mouseX <= x + fishWidth / 2
                && tank.mouseY >= y - fishHeight / 2
                && tank.mouseY <= y + fishHeight / 2;
	}
	
}
