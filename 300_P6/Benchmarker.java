//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    See run time for different ways of opening the lock box
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

/**
 * This class computes and races elapsed time for two approaches
 * @author Huang Xiangyu
 *
 */
public class Benchmarker {

	/**
	 * elapsed time for opening lock box using brute force
	 * <p>
	 * @param ph a PasswordHacker object
	 * @return a long which stores the elapsed time
	 */
	public static long timeBruteForce(PasswordHacker ph) {
		long timeBefore = System.currentTimeMillis();
		ph.bruteForce();
		long timeAfter = System.currentTimeMillis();
		return timeAfter - timeBefore;
	}
	
	/**
	 * elapsed time for opening lock box using hack
	 * <p>
	 * @param ph a PasswordHacker object
	 * @return a long which stores the elapsed time
	 */
	public static long timeHack(PasswordHacker ph) {
		long timeBefore = System.currentTimeMillis();
		ph.hack();
		long timeAfter = System.currentTimeMillis();
		return timeAfter - timeBefore;
	}
	
	/**
	 * race the two approaches against each other
	 * <p>
	 * @param passwordLength provided length of the password
	 * @param numRuns number of runs
	 * @return the results of this race as a string
	 */
	public static String race(int passwordLength, int numRuns) {
		long timeForceSum = 0L;
	    long timeHackSum = 0L;
	    for (int i = 0; i < numRuns; i++) {
	      PasswordHacker ph = new PasswordHacker(passwordLength);
	      timeForceSum += timeBruteForce(ph);
	      timeHackSum += timeHack(ph);
	    }
	    return "Brute force " + passwordLength + ": " + timeForceSum / numRuns + "\nHack "
	        + passwordLength + ": " + timeHackSum / numRuns;
	}
	
	/**
	 * the main method do nothing
	 * @param args input arguments if any
	 */
	public static void main(String[] args) {
		
	}
	
	
}
