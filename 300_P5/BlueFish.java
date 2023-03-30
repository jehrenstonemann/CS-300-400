//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    BlueFish behaviors
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
 * how a blue fish behaves specially
 * <p>
 * @author Huang Xiangyu
 *
 */
public class BlueFish extends Fish{
	
	/**
	 * creates a new fish located at a random position of the screen, 
	 * whose speed is 2, and whose image file name is 
	 * "images" + File.separator + "blue.png"
	 */
	public BlueFish() {
		super (2, "images" + File.separator + "blue.png");
	}
	
	/**
	 * how the blue fish swims
	 */
	@Override
	public void swim() {
		setX((getX() - speed()) % tank.width);
		if(getX() <= 0)
			setX(tank.width);
	}
}
