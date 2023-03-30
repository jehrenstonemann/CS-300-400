//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    TileListIterator
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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * iterate through any chain of linked nodes starting from head
 * <p>
 * @author Huang Xiangyu
 *
 */
public class TileListIterator implements Iterator<Tile>{
	
	private Node next; // next element in the iteration
	
	/**
	 * Creates a new iterator to iterate through a list of tiles
	 * 		starting from its head
	 * <p>
	 * @param head a reference to the head of the linked list of tiles
	 */
	public TileListIterator(Node head) {
		next = head;
	}
	
	/**
	 * return true if the iteration has more elements
	 * <p>
	 * @return true if the iteration has more elements
	 */
	@Override
	public boolean hasNext() {
		return next != null;
	}

	/**
	 * return next element in iteration
	 * <p>
	 * @return next element in iteration
	 */
	@Override
	public Tile next() {
		if(!hasNext())
			throw new NoSuchElementException("no more tiles in the iteration");
		Tile returnValue = next.getTile();
		next = next.getNext();
		return returnValue;
	}
}
