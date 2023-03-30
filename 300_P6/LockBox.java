//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Lock box
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
// Persons:         NONE
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Random;

/**
 * This class contains all the behaviors and methods of a lock box
 * @author Huang Xiangyu
 *
 */
public class LockBox {
	
	protected static Random randGen; // help generate a new random password
	private String password; // the password, which is a string
	private boolean isOpen; //true if the lock is opened, false otherwise
	
	/**
	 * constructs a new lock box
	 * <p>
	 * @param passwordLength the provided length of the password
	 */
	public LockBox(int passwordLength) {
		if(randGen == null) {
			randGen = new Random();
		}
		if(passwordLength <= 0) {
			throw new IllegalArgumentException("Invalid password length");
		}
		password = "";
		for(int i = 0; i<passwordLength; i++) {
			password += randGen.nextInt(10);
		}
	}
	
	/**
	 * Checks the provided guess against the stored password
	 * <p>
	 * @param guess provided password for guess
	 */
	public void authenticate(String guess) {
		if(guess.equals(password))
			isOpen = true;
	}
	
	/**
	 * Returns the stored password in plain text
	 * <p>
	 * @return stored password
	 */
	public String hackMe() {
		return password;
	}
	
	/**
	 * getter for the isOpen field, to check whether the
	 * authentication was successful
	 * @return isOpen field
	 */
	public boolean isOpen() {
		return isOpen;
	}
	
	/**
	 * resets isOpen field to false
	 */
	public void reset() {
		isOpen = false;
	}
}
