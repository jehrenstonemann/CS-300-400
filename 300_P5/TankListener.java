//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    TankListener behaviors
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

/**
 * @author Huang Xiangyu
 *
 */
public interface TankListener {
	//draws this tank object to the display window
	public void draw();
	// called each time the mouse is Pressed
	public void mousePressed();
	// called each time the mouse is Released
	public void mouseReleased();
	// checks whether the mouse is over this Tank GUI
	// return true if the mouse is over this tank GUI object, false otherwise
	public boolean isMouseOver();
}
