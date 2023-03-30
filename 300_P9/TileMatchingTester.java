//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    TileMatchingTester
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
// Persons: Junhao Fu
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.util.NoSuchElementException;

/**
 * tester for the tile matching game
 * <p>
 * @author Huang Xiangyu
 *
 */
public class TileMatchingTester {
	
	/**
	 * check the correctness of any implementation of the 
	 * 		Tile.equals() method
	 * <p>
	 * @return true if perfect implementation
	 */
	public static boolean tileEqualsTester() {
		try{
			// case 1: compare a tile to an object
			{
				Tile test = new Tile(Color.BLACK);
				Object testCompare =  new Object();
				if(test.equals(testCompare)) {
					return false;
				}
			}
		
			// case 2: compare a tile to another tile of the same color
			{
				Tile test = new Tile(Color.BLACK);
				Tile testCompare = new Tile(Color.BLACK);
				if(test.equals(testCompare)==false) {
					return false;
				}
			}
	
			// case 3: compare a tile to another tile of different color.
			{
				Tile test = new Tile(Color.BLACK);
				Tile testCompare = new Tile(Color.BLUE);
				if(test.equals(testCompare)) {
					return false;
				}
			}
		
			//case 4: test whether a tile equals to itself returns true
			{
				Tile test = new Tile(Color.BLACK);
				if(test.equals(test) == false) {
					return false;
				}
			}
		
			//case 5: passing null reference
			{
				Tile test = new Tile(Color.BLACK);
				Tile testCompare = null;
				if(test.equals(testCompare)) {
					return false;
				}
			}
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * check for the correctness of TileListIterator class
	 * <p>
	 * @return true if this class is implemented correctly
	 */
	public static boolean  tileListIteratorTester(){
		//create a chain of linked tiles
		Tile one = new Tile(Color.BLACK);
		Tile two = new Tile(Color.ORANGE);
		Node nodeOne = null;
		Node nodeTwo = new Node(one,nodeOne);
		Node nodeThree = new Node(two,nodeTwo);
		TileListIterator test1 = new TileListIterator(nodeOne);
		TileListIterator test2 = new TileListIterator(nodeTwo);
		TileListIterator test3 = new TileListIterator(nodeThree);
		//check the correctness of both hasNext() and next() methods
		try {
			if(test1.hasNext())
				return false;
			if(!test2.hasNext()||test2.next()!=one)
				return false;
			if(!test3.hasNext())
				return false;
			if(test3.next()!=two)
				return false;
			try {
				test1.next();
				return false;
			}catch(NoSuchElementException e) {
			
			}
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * check for the correctness of TileStack class
	 * <p>
	 * @return true if this class is implemented correctly
	 */
	public static boolean tileStackTester(){
        TileStack tileStack = new TileStack();
        Tile test1 = new Tile(Color.BLACK);
        Tile test2 = new Tile(Color.BLUE);
        Tile test3 = new Tile(Color.ORANGE);
        tileStack.push(test1);
        tileStack.push(test2);
        if(tileStack.size()!=2){
            return false;
        }
        if(tileStack.peek()!=test2){
            return false;
        }
        if(tileStack.pop()!=test2){
            return false;
        }
        tileStack.pop();
        tileStack.push(test3);
        tileStack.pop();
        if(!tileStack.isEmpty()){
            return false;
        }
        TileStack test = new TileStack();
        test.push(new Tile(Color.YELLOW));
        test.push(new Tile(Color.BLUE));
        test.push(new Tile(Color.BLACK));
        test.push(new Tile(Color.ORANGE));
        String result = "";
        for(Tile tile : test) {
        	result += tile.toString();
        }
        String correct = "ORANGE" +"BLACK"+"BLUE"+"YELLOW";
        if(!result.equals(correct))
        	return false;
        return true;
	}
	
	/**
	 * check for the correctness of TileMatchingGame class
	 * 		referenced to Junhao Fu
	 * <p>
	 * @return true if this class is implemented correctly
	 */
	public static boolean tileMatchingGameTester(){
		try {
			TileMatchingGame test = new TileMatchingGame(5);
			if(test.getColumnsNumber()!=5)
				return false;
			Tile testTile = new Tile(Color.BLACK);
			try {
				test.dropTile(testTile, -1);
			}catch(IndexOutOfBoundsException e) {
				
			}
			test.dropTile(testTile, 0);
			try {
				test.column(-1);
			}catch(IndexOutOfBoundsException e) {
				
			}
			if(!test.column(0).equals("BLACK"))
				return false;
			if(!test.toString().equals("GAME COLUMNS:\n"+0+": "+"BLACK"+"\n"
					+1+": \n"+2+": \n"+3+": \n"+4+": \n"))
				return false;
			try {
				test.clearColumn(-1);
			}catch(IndexOutOfBoundsException e) {
				
			}
			test.clearColumn(0);
			if(!test.column(0).equals(""))
				return false;
			test.dropTile(testTile, 1);
			test.restartGame();
			if(!test.column(1).equals(""))
				return false;
		}catch(Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * whether the implementation of classes is correct is printed out
	 * <p>
	 * @param args inputs argument if any
	 */
	public static void main(String[] args) {
		System.out.println(tileEqualsTester());
		System.out.println(tileListIteratorTester());
		System.out.println(tileStackTester());
		System.out.println(tileMatchingGameTester());
	}
}
