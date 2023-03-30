//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    BlackFish behaviors
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
// Persons:  NONE
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;

/**
 * how a black fish behaves specially
 * <p>
 * @author Huang Xiangyu
 *
 */
public class BlackFish extends Fish{
	private TankObject source; // the source decoration object 
								// that the black fish swims from
	private TankObject destination; // the destination decoration object 
									// that the black fish swims to
	
	/**
	 * create a new black fish located at a random position of the screen, 
	 * speed is 2
	 * <p>
	 * @param source one of the two favorable decoration tank objects 
	 * 		that the black fish swims from
	 * @param destination one of the two favorable decoration tank objects 
	 * 		that the black fish swims to
	 */
	public BlackFish(TankObject source, TankObject destination) {
		super(2, "images" + File.separator + "black.png");
		this.source = source;
		this.destination = destination;
	}
	
	/**
	 * makes one speed move towards destination
	 */
	public void moveTowardsDestination() {
		float dx = destination.getX() - getX();
	    float dy = destination.getY() - getY();
	    int d = (int) Math.sqrt(dx * dx + dy * dy);
	    float newXPosition = (getX() + (speed() * (destination.getX() - getX())) / d);
	    float newYPosition = (getY() + (speed() * (destination.getY() - getY())) / d);
	    setX(newXPosition);
	    setY(newYPosition);
	}
	
	/**
	 * check whether this black fish is over another tank object
	 * <p>
	 * @param other the TankObject stuff
	 * @return true if this black fish is over another tank object, 
	 * 		and false otherwise
	 */
	public boolean isOver(TankObject other) {
		int fishWidth = getImage().width;
		int fishHeight = getImage().height;
		
		//checks if the fish is over a another tank object
		return getX() >= other.getX() - fishWidth / 2 
				&& getX() <= other.getX() + fishWidth / 2
				&& getY() >= other.getY() - fishHeight / 2 
				&& getY() <= other.getY() + fishHeight / 2;
	}
	
	/**
	 * move the fish towards its destination if destination is reached 
	 * (meaning this fish is over its destination) 
	 * switch source and destination
	 */
	@Override
	public void swim() {
		// move the fish towards its destination
		moveTowardsDestination();
		// if destination is reached (meaning this fish is over its destination)
		if(isOver(destination)) {
			//switch source and destination (make deep copies)
			TankObject temp = destination;
			destination = source;
			source = temp;
		}
	}
}
