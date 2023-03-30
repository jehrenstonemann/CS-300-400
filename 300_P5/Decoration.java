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
// Persons: Haixi Zhang  
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Class Header comes here
 *
 */
public class Decoration {
	  // Fields defined to draw this decoration object in the application display window
	  private static PApplet processing; // PApplet object that represents the display window

	  private PImage image; // image of this decoration object

	  private float x; // x-position of this decoration object in the display window
	  private float y; // y-position of this decoration object in the display window

	  private boolean isDragging; // indicates whether this decoration object is being dragged or not

	  private static int oldMouseX; // old x-position of the mouse
	  private static int oldMouseY; // old y-position of the mouse


	  // Creates a new decoration object located at a specific position of the display window
	  // Add a javadoc style method header for each method
	  public Decoration(PApplet processing, float x, float y, String imageFileName) {
	    // Set drawing parameters
	    Decoration.processing = processing; // set the PApplet Object where this decoration object will
	                                        // be drawn
	    this.image = processing.loadImage(imageFileName);
	    // sets the position of this decoration object
	    this.x = x;
	    this.y = y;
	    isDragging = false; // initially the fish is not dragging
	  }

	  // Draws this decoration object to the display window.
	  // Add a javadoc style method header for each method
	  public void draw() {
	    // if this object is dragging, set its position to follow the mouse moves
	    if (this.isDragging) {
	      int dx = processing.mouseX - oldMouseX;
	      int dy = processing.mouseY - oldMouseY;
	      move(dx, dy);
	      oldMouseX = processing.mouseX;
	      oldMouseY = processing.mouseY;
	    }

	    // draw this decoration object at its current position
	    processing.image(this.image, this.x, y);

	  }


	  // Moves this decoration object with dx and dy
	  public void move(int dx, int dy) {
	    x += dx;
	    y += dy;
	  }


	  // Returns the image of this decoration object
	  public PImage getImage() {
	    return image;
	  }


	  // Returns the x-position of this decoration object in the display window
	  public float getPositionX() {
	    return x;
	  }

	  // Returns the y-position of this decoration object in the display window
	  public float getPositionY() {
	    return y;
	  }


	  // Checks whether this decoration object is being dragged   
	  public boolean isDragging() {
	    return isDragging;
	  }

	  // Starts dragging this decoration object
	  public void startDragging() {
	    oldMouseX = processing.mouseX;
	    oldMouseY = processing.mouseY;
	    this.isDragging = true;
	  }

	  // Stops dragging this decoration object
	  public void stopDragging() {
	    this.isDragging = false;
	  }

	  // Checks whether the mouse is over this decoration object
	  public boolean isMouseOver() {
	    // checks if the mouse is over this object
	    return processing.mouseX >= x - image.width / 2 && processing.mouseX <= x + image.width / 2
	        && processing.mouseY >= y - image.height / 2 && processing.mouseY <= y + image.height / 2;
	  }


}
