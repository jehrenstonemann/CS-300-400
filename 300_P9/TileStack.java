//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    TileStack
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

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * represents a linked stack of tiles
 * <p>
 * @author Huang Xiangyu
 *
 */
public class TileStack implements Iterable<Tile>, StackADT<Tile>{

	private Node top; // top of the linked stack
	private int size; // keeps track of the number of tiles stored in the stack
	
	/**
	 * creates an empty stack of tiles
	 */
	public TileStack() {
		
	}

	/**
	 * Add an element to this stack
	 * <p>
	 * @param element an element to be added
	 */
	@Override
	public void push(Tile element) {
		if(isEmpty()) {
			top = new Node(element);
		}
		else
			top = new Node(element, top);
		size++;
	}

	/**
	 * Remove the element on the top of this stack and return it
	 * <p>
	 * @return the element removed from the top of the stack 
	 * @throws java.util.EmptyStackException without error message 
	 * 		if the stack is empty
	 */
	@Override
	public Tile pop() {
		Tile item;
		if(isEmpty())
			throw new EmptyStackException();
		else {
			item = top.getTile();
		}
		top = top.getNext();
		size--;
		return item;
	}

	/**
	 * Get the element on the top of this stack
	 * <p>
	 * @return the element on the stack top
	 * @throws java.util.EmptyStackException without error message 
	 * 		if the stack is empty
	 */
	@Override
	public Tile peek() {
		if(isEmpty())
			throw new EmptyStackException();
		return top.getTile();
	}

	/**
	 * Check whether this stack is empty or not
	 * <p>
	 * @return true if this stack contains no elements, otherwise false
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Get the number of elements in this stack
	 * <p>
	 * @return the size of the stack
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * return an iterator over elements of type Tile
	 * <p>
	 * @return an iterator over elements of type Tile
	 */
	@Override
	public Iterator<Tile> iterator() {
		return new TileListIterator(top);
	}
}
