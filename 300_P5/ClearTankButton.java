//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    ClearTankButton behaviors
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

/**
 * When this button is pressed, all fishes will be cleared
 * <p>
 * @author Huang Xiangyu
 *
 */
public class ClearTankButton extends Button{
	
	/**
	 * Add Button that is used for clearing all the existing fishes
	 * <p>
	 * @param x x-position of button used 
	 * 		for clearing existing fishes in the display window
	 * @param y y-position of button used 
	 * 		for clearing existing fishes in the display window
	 */
	public ClearTankButton(float x, float y) {
		super("clear", x, y);
	}
	
	/**
	 * when mouse is pressed, all existing fishes will be cleared
	 */
	@Override
	public void mousePressed() {
		tank.clear();
	}
}
