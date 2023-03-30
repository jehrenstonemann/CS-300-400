//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    ExceptionalClimbingTester.java
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
// Persons:         Liu Zhenye
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.util.zip.DataFormatException;

/**
 * This class contains the main method for the project, along with the test 
 * of finding whether this program works out as intended
 * @author Huang Xiangyu
 */
public class ExceptionalClimbingTester {

	/**
	 * This method runs all the tests
	 * @param args a string used to hold the command line arguments
	 */
	public static void main(String[] args) {
	    System.out.println(runAllTests());
	}
	
	  /**
	   * this method checks whether sendClimb works as intended
	   * @return false if sendClimb does not work as intended
	   */
	public static boolean testSendClimb(){
		String gradeInvalid = "V100";
		String[] send = {"V3" , "V2", "V2", "V5", "V1"};
		int numSendValid = 5;
		String[] sendInvalid = {null, null, null, null, null};
		int numSendInvalid = -1;
		String gradeValid = "V3";
		
		//try grade is invalid
		try{
			ExceptionalClimbing.sendClimb(send, numSendValid, gradeInvalid);
		}catch(IllegalArgumentException e) {
			if(!("V100 is not a valid grade".equals(e.getMessage()))) {
				return false;
			}
		}catch(Exception e) {
			return false;
		}

		
		//try provided array is full
		try {
			ExceptionalClimbing.sendClimb(send, numSendValid, gradeValid);
		}catch(IllegalArgumentException e) {
			if(!(("cannot add new value to full length" +numSendValid+ "array").equals(e.getMessage()))) {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
		//try provided array has null elements between index 0 (inclusive) and index numSend(exclusive)
		try {
			ExceptionalClimbing.sendClimb(sendInvalid, numSendValid, gradeValid);
		}catch(DataFormatException e) {
			if(!("invalid oversize array".equals(e.getMessage()))) {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
		//try negative value for numSend
		try {
			ExceptionalClimbing.sendClimb(send, numSendInvalid, gradeValid);
		}catch(DataFormatException e) {
			if(!("invalid oversize array".equals(e.getMessage()))) {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
		
		//try grade is invalid(type one for example) and provided array is full, 
		try {
			ExceptionalClimbing.sendClimb(send, numSendValid, gradeInvalid);
		}catch(IllegalArgumentException e) {
			if(!("V100 is not a valid grade".equals(e.getMessage()))) {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	    return true;
	  }
	  
	  /**
	   * this method checks whether failClimb, which works similar to sendClimb,
	   * works as intended
	   * @return false if failClimb does not work as intended
	   */
	 public static boolean testFailClimb()
	  {
		String gradeInvalid = "V100";
		String[] fail = {"V3" , "V2", "V2", "V5", "V1"};
		int numFailValid = 5;
		String[] failInvalid = {null, null, null, null, null};
		int numFailInvalid = -1;
		String gradeValid = "V3";
		
		//try grade is invalid (total length is 3)
		try{
			ExceptionalClimbing.sendClimb(fail, numFailValid, gradeInvalid);
		}catch(IllegalArgumentException e) {
			if(!("V100 is not a valid grade".equals(e.getMessage()))) {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
		
		//try provided array is full
		try {
			ExceptionalClimbing.failClimb(fail, numFailValid, gradeValid);
		}catch(IllegalArgumentException e) {
			if(!(("cannot add new value to full length" + numFailValid + "array").equals(e.getMessage()))) {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
		//try provided array has null elements between index 0 (inclusive) and index numFail(exclusive)
		try {
			ExceptionalClimbing.failClimb(failInvalid, numFailValid, gradeValid);
		}catch(DataFormatException e) {
			if(!("invalid oversize array".equals(e.getMessage()))) {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
		//try negative value for numFail
		try {
			ExceptionalClimbing.failClimb(fail, numFailInvalid, gradeValid);
		}catch(DataFormatException e) {
			if(!("invalid oversize array".equals(e.getMessage()))) {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
		
		//try grade is invalid(type one for example) and provided array is full, 
		try {
			ExceptionalClimbing.failClimb(fail, numFailValid, gradeInvalid);
		}catch(IllegalArgumentException e) {
			if(!("V100 is not a valid grade".equals(e.getMessage()))) {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
			
	    return true;
	  }
	  
	  /**
	   * this method checks whether getStats works as intended
	   * @return false if getStats does not work as intended
	   */
	 public static boolean testGetStats()
	  {
		 String[] sendInvalid = {null, null, null, null}; 
			String[] failInvalid = {null, null, null, null};
			String[] sendValid = {"V0", null, null, null};
			int numSend = 1;
			int numFail = 1;
			int historyLengthInvalid = 0;
			int historyLengthValid = 1;
			
			//try if both arrays are empty with historyLength is valid and catch it
			try {
				ExceptionalClimbing.getStats(sendInvalid, numSend, failInvalid, numFail, historyLengthValid);
			}catch(RuntimeException e){
				if(!"no climbs provided".equals(e.getMessage())) {
					return false;
				}
			}catch(Exception e) {
				return false;
			}
			
			//try if both arrays are empty with history Length is invalid and catch it
			try {
				ExceptionalClimbing.getStats(sendInvalid, numSend, failInvalid, numFail, historyLengthInvalid);
			}catch(RuntimeException e) {
				if(!"no climbs provided".equals(e.getMessage())) {
					return false;
				}
			}catch(Exception e) {
				return false;
			}
			
			//try if one array is empty with historyLength is invalid and catch it
			try {
				ExceptionalClimbing.getStats(sendValid, numSend, failInvalid, numFail, historyLengthInvalid);
			}catch(IllegalArgumentException e){
				if(!"0 is not a valid history length".equals(e.getMessage())) {
					return false;
				}
			}catch(Exception e) {
				return false;
			}
		    return true;

	  }
	  
	  /**
	   * this method checks whether getHistogram works as intended
	   * @return false if getHistogram does not work as intended
	   */
	 public static boolean testGetHistogram()
	  {
		String[] send = {null, null, null}; 
		String[] fail = {null, null, null, null, null};
		int numSend = 0;
		int numFail = 0;
		
		//try if both arrays are empty and catch it
		try {
			ExceptionalClimbing.getHistogram(send, numSend, fail, numFail);
		}catch(RuntimeException e) {
			if(!"no climbs provided".equals(e.getMessage())) {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
		
		return true;
	  }
	  
	  /**
	   * this method checks whether all the above tests work as intended
	   * @return true if all the above tests work as intended
	   */
	 public static boolean runAllTests()
	  {
		 if(!testSendClimb()) {
			 return false;
		 }
		 if(!testFailClimb()) {
			 return false;
		 }
		 if(!testGetStats()) {
			 return false;
		 }
		 if(!testGetHistogram()) {
			 return false;
		 }
		 return true;
	  }
}
