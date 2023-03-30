//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    AddBlueFishButton behaviors
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
 * When this button is pressed, one blue fish
 * with its behavior will be added
 * <p>
 * @author Huang Xiangyu
 *
 */
public class AddBlueFishButton extends Button{
	
	/**
	 * Add Button that is used for adding blue fishes that will be 
	 * arranged at position x,y of the display window
	 * with label which represents this button
	 * <p>
	 * @param x x-position of button used 
	 * 		for adding blue fish in the display window
	 * @param y y-position of button used 
	 * 		for adding blue fish in the display window
	 */
	public AddBlueFishButton(float x, float y) {
		super("Add Blue", x, y);
	}
	
	/**
	 * when mouse is pressed, a new blue fish will be added
	 */
	@Override
	public void mousePressed() {
		tank.addObject(new BlueFish());
	}
}
