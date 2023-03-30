//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Fish behaviors
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

import java.io.File;

/**
 * It stores the behavior of all Fishes (which extends the TankObject class)
 * @author Huang Xiangyu
 *
 */
public class Fish extends TankObject{
	
	private int speed; //the speed of the Fish object
	private boolean isSwimming; //whether the Fish object is swimming, 
								//return true if it is
	
	/**
	 * a constructor for a fish object which takes its speed and 
	 * image file name as input
	 * <p>
	 * @param speed the speed of a particular fish
	 * @param fishImageFileName the image file name for the fish
	 */
	public Fish(int speed, String fishImageFileName){
		super((float)tank.randGen.nextInt(tank.width), 
				(float)tank.randGen.nextInt(tank.height), fishImageFileName);
		this.speed = speed;
		if(speed <= 0)
			throw new IllegalArgumentException("Warning: speed cannot be negative");
	}
	
	/**
	 * constructor for a fish object which constructs an orange fish
	 * with speed be 5
	 */
	public Fish(){
		this(5, "images" + File.separator + "orange.png");
	}
	
	/**
	 * This method sets the position of this fish to follow the
	 * mouse moves if it is dragging, moves horizontally
	 * the fish one speed step from left to right if it is swimming &
	 * and draw the fish at its current position
	 */
	@Override
	public void draw() {
		// if the fish is being dragged, move with the mouse
		if(isDragging()) {
			move(tank.mouseX, tank.mouseY);
		}
		// if the fish is swimming, call swim(): moves horizontally
		// the fish one speed step from left to right
		if(isSwimming) {
			swim();
		}
		// draw the fish at its current position
		tank.image(image, getX(), getY());
	}
	
	/**
	 * Checks whether this fish is swimming
	 * <p>
	 * @return true if the fish is swimming
	 */
	public boolean isSwimming() {
		return isSwimming;
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
	 * Gets the speed of this fish
	 * <p>
	 * @return the speed of this fish (an int)
	 */
	public int speed() {
		return speed;
	}
	
	/**
	 * Moves horizontally the fish one speed step from left to right.
	 */
	public void swim() {
		setX((getX() + speed) % tank.width);
	}

}
