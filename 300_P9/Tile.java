//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Tile
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
//     Write-up states that pair programming is allowed for this assignment.
//     We have both read and understand the course Pair Programming Policy.
//     We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class models a Tile of a specific color
 * <p>
 * @author mouna
 * @author Huang Xiangyu
 *
 */
public class Tile {
	
  private Color color; // color of this Tile

  /**
   * Creates a Tile with a specific color
   * <p>
   * @param color color to be assigned to this tile
   */
  public Tile(Color color) {
    this.color = color;
  }

  /**
   * Gets the color of this tile
   * <p>
   * @return the color of this tile
   */
  public Color getColor() {
    return color;
  }

  /**
   * Returns a string representation of this tile
   * <p>
   * @return the color of this tile as a string
   */
  @Override
  public String toString() {
    return color.name();
  }

  /**
   * Checks whether this tile equals to the other object provided as input
   * <p>
   * @return true if other is a Tile and has the same color as this tile
   */
  @Override
  public boolean equals(Object other) {
    if(other instanceof Tile && ((Tile) other).getColor().equals(color))
    	return true;
    return false;
  }
}