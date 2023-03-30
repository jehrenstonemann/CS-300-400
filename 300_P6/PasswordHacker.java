//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Hack password
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
// Persons:         Junhao Fu, Haixi Zhang
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class tries to open the lock box 
 * by either hacking or using brute force
 * @author Huang Xiangyu
 *
 */
public class PasswordHacker {
	
	private LockBox toPick; // a LockBox object to hack with
	private int passwordLength; //password length of this lock box
	
	/**
	 * constructs a new lock box
	 * <p>
	 * @param passwordLength the provided length of the password
	 */
	public PasswordHacker(int passwordLength) {
		this.passwordLength =  passwordLength;
		toPick = new LockBox(passwordLength);
	}
	
	/**
	 * Complexity: O(1)
	 * hack the lock box using password
	 */
	public void hack() {
		toPick.reset();
		toPick.authenticate(toPick.hackMe());
	}
	
	/**
	 * Complexity: O(N)
	 * try opening the lock box using brute force 
	 * (by guessing the possible password)
	 */
	public void bruteForce() {
		toPick.reset();
		int count = 0;
		do {
			String password = generateGuess(count);
			toPick.authenticate(password);
			count++;
		}while(!toPick.isOpen());
	}
	
	/**
	 * Given the number of times guessing, produce the password
	 * to try on this iteration.
	 * <p>
	 * @param count number of times guessing the password
	 * @return the possible password
	 */
	public String generateGuess(int count) {
		String result = count + "";
	    if (result.length() > passwordLength) {
	      result = result.substring(result.length() - passwordLength);
	    }
	    if (result.length() < passwordLength) {
	      int temp = result.length();
	      for (int i = 0; i < passwordLength - temp; i++) {
	        result = "0" + result;
	      }
	    }
	    return result;
	}
}
