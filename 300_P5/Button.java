//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Button behaviors
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
 * Button behavior class
 * @author Huang Xiangyu
 *
 */
public class Button implements TankListener{
	
	private static final int WIDTH = 85; // Width of this Button
	private static final int HEIGHT = 32; // Height of this Button
	protected static FishTank tank; // PApplet object where 
									// this button will be displayed
	private float x; // x-position of this button in the display window
	private float y; // y-position of this button in the display window
	protected String label; // text/label which represents this button
	
	/**
	 * Creates a new Button at a given position within the display window
	 * and sets its label
	 * <p>
	 * @param label text/label which represents this button
	 * @param x x-position of this button in the display window
	 * @param y y-position of this button in the display window
	 */
	public Button(String label, float x, float y) {
		this.label = label;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * sets the PApplet display window where this button is displayed and handled
	 * <p>
	 * @param tank this FishTank object
	 */
	public static void setProcessing(FishTank tank) {
		Button.tank = tank;
	}

	/**
	 * Checks whether the mouse is over this button
	 * <p>
	 * @return true if the mouse is over this button, false otherwise.
	 */
	@Override
	public boolean isMouseOver() {
		return tank.mouseX >= x - WIDTH / 2
                && tank.mouseX <= x + WIDTH / 2
                && tank.mouseY >= y - HEIGHT / 2
                && tank.mouseY <= y + HEIGHT / 2;
	}


	/**
	 * Draws this button to the display window
	 */
	@Override
	public void draw() {
	  tank.stroke(0);// set line value to black
	    
	  if(isMouseOver()) 
		  tank.fill(100); //set to dark gray
	  else tank.fill(200); //set to light gray
	  
	  // draw the button (rectangle with a centered text)
	  tank.rect(x - WIDTH / 2.0f, y - HEIGHT / 2.0f,
	        x + WIDTH / 2.0f, y + HEIGHT / 2.0f);
	  tank.fill(0); // set the fill color to black
	  tank.text(label, x, y); // display the text of the current button
	}

	/**
	 * prints "A button was pressed." when the mouse is over it
	 */
	@Override
	public void mousePressed() {
		if(isMouseOver())
			System.out.println("A button was pressed.");
	}

	/**
	 * behavior when mouse is released
	 */
	@Override
	public void mouseReleased() { }
}
