//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    TileMatchingGame
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
 * models a tile matching game which consists of a certain
 *		number of columns of stacks of tiles
 * <p>
 * @author Huang Xiangyu
 *
 */
public class TileMatchingGame {
	
	private TileStack[] columns; // an array of TileStacks
	
	/**
	 * Creates a new matching tile game with a given 
	 * 		number of columns and initializes its contents
	 * 		A new matching tile game stores an empty TileStack at each of its columns
	 * <p>
	 * @param columnCount number of columns in this game
	 */
	public TileMatchingGame(int columnCount) {
		columns = new TileStack[columnCount];
        for(int i=0;i<=columns.length-1;i++){
            columns[i]=new TileStack();
        }
	}
	
	/**
	 * Gets the number of columns in this tile matching game
	 * <p>
	 * @return the number of columns in this tile matching game
	 */
	public int getColumnsNumber() {
		return columns.length;
	}
	
	/**
	 * Drops a tile at the top of the stack located at the given column index 
	 * 		If tile will be dropped at the top of an equal tile (of same color) 
	 * 		both tiles will be removed from the stack of tiles at column index.
	 * <p>
	 * @param tile a tile to drop
	 * @param index column position of the stack of tiles where tile will be dropped
	 * @throws java.lang.IndexOutOfBoundsException if index is out of bounds
	 * 		of the indexes of the columns of this game
	 */
	public void dropTile(Tile tile, int index) {
		if(index<0 || index >= columns.length)
			throw new IndexOutOfBoundsException("invalid index");
		columns[index].push(tile);
	}

	/**
	 * Removes all the tiles from a column with a given index
	 * <p>
	 * @param index index of the column to clear
	 * @throws java.lang.IndexOutOfBoundsException if index is 
	 * 		out of bounds of the indexes of the columns of this game
	 */
	public void clearColumn(int index) {
		if(index<0 || index >= columns.length)
			throw new IndexOutOfBoundsException("invalid index");
		columns[index] = new TileStack();
	}
	
	/**
	 * Restarts the game 
	 * All stacks of tiles in the different columns of this game will be empty
	 */
	public void restartGame() {
		for (int i = 0; i < columns.length; i++) {
			clearColumn(i);
		}
	}
	
	/**
	 * Returns a string representation of the stack of tiles at a given column
	 * 		index or an empty string "" if the stack is empty
	 * <p>
	 * @param index the index of a column in this game
	 * @return a string representation of the column at a given index of this game
	 * @throws java.lang.IndexOutOfBoundsException - if index is out of bounds 
	 * 		of the indexes of the columns of this game
	 */
	public String column(int index) {
		if(index<0 || index >= columns.length)
			throw new IndexOutOfBoundsException("invalid index");
		if(columns[index].isEmpty())
			return "";
		String result = "";
		for(Tile tile:columns[index]) {
			result+=result.toString()+" ";
		}
		return result;
	}
	
	/**
	 * Returns a string representation of this tile matching game
	 * <p>
	 * @return a string representation of this tile matching game
	 */
	@Override
	public String toString() {
		String result = "GAME COLUMNS:\n";
		for(int i=0; i<columns.length;i++) {
			result += i+": "+column(i)+"/n";
		}
		return result;
	}
}
