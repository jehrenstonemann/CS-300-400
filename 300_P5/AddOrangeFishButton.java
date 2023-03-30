//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    AddOrangeFishButton behaviors
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
 * When this button is pressed, one orange fish
 * with its behavior will be added
 * <p>
 * @author Huang Xiangyu
 *
 */
public class AddOrangeFishButton extends Button{
	
	/**
	 * Add a button that is used for adding orange fishes that will be 
	 * arranged at position x,y of the display window
	 * with label which represents this button
	 * <p>
	 * @param x x-position of button used 
	 * 		for adding orange fish in the display window
	 * @param y y-position of button used 
	 * 		for adding orange fish in the display window
	 */
	public AddOrangeFishButton(float x, float y) {
		super("Add Orange", x, y);
	}
	
	/**
	 * when mouse is pressed, a new orange fish will be added
	 */
	@Override
	public void mousePressed() {
		tank.addObject(new Fish());
	}
}
