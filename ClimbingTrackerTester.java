//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    ClimbTrackerTester.java
// Course:   CS 300 Fall 2021
//
// Author:   Xiangyu Huang
// Email:    xhuang438@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Shangyuan Yang
// Partner Email:   syang589@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   X Write-up states that pair programming is allowed for this assignment.
//   X We have both read and understand the course Pair Programming Policy.
//   X We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         NONE
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class contains the main method for the project, along with the test 
 * of finding whether this program works out as intended
 * @author Huang Xiangyu
 * @author Yang Shangyuan
 *
 */
public class ClimbingTrackerTester {

	/**
	 * This method runs all the tests
	 * @param args a string used to hold the command line arguments
	 */
	  public static void main(String[] args)
	  {
	    System.out.println(runAllTests());
	  }
	  
	  /**
	   * this method checks whether sendClimb works as intended
	   * @return false if sendClimb does not work as intended
	   */
	  public static boolean testSendClimb()
	  {
	    String[] send = new String[5];
	    int numSend = 0;
	    
	    numSend = ClimbingTracker.sendClimb(send, numSend, "V0");
	    if(numSend!=1)
	      return false;
	    numSend = ClimbingTracker.sendClimb(send, numSend, "V1");
	    if(numSend!=2)
	      return false;
	    numSend = ClimbingTracker.sendClimb(send, numSend, "V2");
	    if(numSend!=3)
	      return false;
	    
	    numSend = ClimbingTracker.sendClimb(send, numSend, "v3");
	    if(numSend!=3)
	      return false;
	    numSend = ClimbingTracker.sendClimb(send, numSend, "V10");
	    if(numSend!=3)
	      return false;
	    numSend = ClimbingTracker.sendClimb(send, numSend, "VA");
	    if(numSend!=3)
	      return false;
	    numSend = ClimbingTracker.sendClimb(send, numSend, "V8");
	    if(numSend!=3)
	      return false;
	    
	    numSend = ClimbingTracker.sendClimb(send, numSend, "V3");
	    if(numSend!=4)
	      return false;
	    numSend = ClimbingTracker.sendClimb(send, numSend, "V4");
	    if(numSend!=5)
	      return false;
	    numSend = ClimbingTracker.sendClimb(send, numSend, "V5");
	    if(numSend!=5)
	      return false;
	    
	    return true;
	  }
	  
	  /**
	   * this method checks whether failClimb, which works similar to sendClimb,
	   * works as intended
	   * @return false if failClimb does not work as intended
	   */
	  public static boolean testFailClimb()
	  {
	    String[] fail = new String[5];
	    int numFail = 0;
	    
	    numFail = ClimbingTracker.failClimb(fail, numFail, "V0");
	    if(numFail!=1)
	      return false;
	    numFail = ClimbingTracker.failClimb(fail, numFail, "V1");
	    if(numFail!=2)
	      return false;
	    numFail = ClimbingTracker.failClimb(fail, numFail, "V2");
	    if(numFail!=3)
	      return false;
	    
	    numFail = ClimbingTracker.failClimb(fail, numFail, "v3");
	    if(numFail!=3)
	      return false;
	    numFail = ClimbingTracker.failClimb(fail, numFail, "V10");
	    if(numFail!=3)
	      return false;
	    numFail = ClimbingTracker.failClimb(fail, numFail, "VA");
	    if(numFail!=3)
	      return false;
	    numFail = ClimbingTracker.failClimb(fail, numFail, "V8");
	    if(numFail!=3)
	      return false;
	    
	    numFail = ClimbingTracker.failClimb(fail, numFail, "V3");
	    if(numFail!=4)
	      return false;
	    numFail = ClimbingTracker.failClimb(fail, numFail, "V4");
	    if(numFail!=5)
	      return false;
	    numFail = ClimbingTracker.failClimb(fail, numFail, "V5");
	    if(numFail!=5)
	      return false;
	    
	    return true;
	  }
	  
	  /**
	   * this method checks whether getStats works as intended
	   * @return false if getStats does not work as intended
	   */
	  public static boolean testGetStats()
	  {
	    String[] send = {"V0", "V1", "V0", "V0", null};
	    int numSend = 4;
	    String[] fail = {"V2", "V1", null, null, null};
	    int numFail = 2;
	    
	    String tester = new String();
	    tester = ClimbingTracker.getStats(send, numSend, fail, numFail, 1);
	    if (!tester.equals("send: 0.0\nfail: 1.0"))
	      return false;
	    tester = ClimbingTracker.getStats(send, numSend, fail, numFail, 2);
	    if (!tester.equals("send: 0.0\nfail: 1.5"))
	      return false;
	    tester = ClimbingTracker.getStats(send, numSend, fail, numFail, 3);
	    if (!tester.equals("send: 0.333\nfail: 1.5"))
	      return false;
	    tester = ClimbingTracker.getStats(send, numSend, fail, 0, 3);
	    if (!tester.equals("send: 0.333\nfail: --"))
	      return false;
	    tester = ClimbingTracker.getStats(send, numSend, fail, numFail, -1);
	    if (!tester.equals("send: --\nfail: --"))
	      return false;
	    tester = ClimbingTracker.getStats(send, 0, fail, 0, 0);
	    if (!tester.equals("send: --\nfail: --"))
	      return false;
	    
	    return true;
	  }
	  
	  /**
	   * this method checks whether getHistogram works as intended
	   * @return false if getHistogram does not work as intended
	   */
	  public static boolean testGetHistogram()
	  {
	    String[] send = {"V0", "V1", "V0", "V0", null};
	    int numSend = 4;
	    String[] fail = {"V2", "V1", null, null, null};
	    int numFail = 2;
	    
	    String tester = new String();
	    tester = ClimbingTracker.getHistogram(send, numSend, fail, numFail);
	    if (!tester.equals("V0: + + + \nV1: - + \nV2: - \n"))
	      return false;
	    tester = ClimbingTracker.getHistogram(send, 0, fail, 0);
	    if (!tester.equals("Error: no data to display\n"))
	      return false;
	    
	    String[] send1 = {"V0", "V1", "V0", "V0", null};
	    String[] fail1 = {"V3", "V1", null, null, null};
	    
	    tester = ClimbingTracker.getHistogram(send1, numSend, fail1, numFail);
	    if (!tester.equals("V0: + + + \nV1: - + \nV2: \nV3: - \n"))
	      return false;
	    
	    return true;
	  }
	  
	  /**
	   * this method checks whether all the above tests work as intended
	   * @return true if all the above tests work as intended
	   */
	  public static boolean runAllTests()
	  {
	    return testSendClimb() && testFailClimb() && testGetStats() && testGetHistogram();
	  }
}
