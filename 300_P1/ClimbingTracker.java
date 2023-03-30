//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    ClimbTracker.java
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
 * This class contains all the methods in this program. This program is used to record down
 * the level (which is represented by "V" + an integer from 0-7) an individual climber is challenging
 * and his or her respective grades.
 * @author Huang Xiangyu
 * @author Yang Shangyuan
 *
 */
public class ClimbingTracker {
      
	  /**
       * This method adds a successfully-completed ("sent") climb's grade to the end of the array of 
       * successful climbs if there is room and the provided grade is valid
       * @param send a string array of successful climbs 
       * @param numSend number of successful climbs
       * @param grade a string which stores the grade(V + 0-7)
       * @return the size of the send oversize array
       */
	  public static int sendClimb(String[] send, int numSend, String grade)
	  {
	    if (isValidGrade(grade) && numSend < send.length)
	    {
	      send[numSend] = grade;
	      numSend++;
	    }
	    return numSend;
	  }
	  
	  /**
	   * This method adds an unsuccessful climb's grade to the end of the array of 
       * unsuccessful climbs if there is room and the provided grade is valid
	   * @param fail a string array of unsuccessful climbs
	   * @param numFail number of unsuccessful climbs
	   * @param grade a string which stores the grade(V + 0-7)
	   * @return the size of the fail oversize array
	   */
	  public static int failClimb(String[] fail, int numFail, String grade)
	  {
	    if (isValidGrade(grade) && numFail < fail.length)
	    {
	      fail[numFail] = grade;
	      numFail++;
	    }
	    return numFail;
	  }
	  
	  /**
	   * This method intends to check whether the provided grade is valid
	   * @param grade a string which stores the provided grade
	   * @return true if the provided grade is valid (V+0-7)
	   */
	  private static boolean isValidGrade(String grade)
	  {
	    return grade.charAt(0) == 'V' && grade.length() == 2 && grade.charAt(1) >= '0' && grade.charAt(1) <= '7';
	  }
	  
	  /**
	   * This method creates and returns a formatted String containing the average(mean) climb grade over 
	   * the most recent historyLength number of climbs in each of the send and fail arrays.
	   * @param send a string array of successful climbs 
	   * @param numSend number of successful climbs
	   * @param fail a string array of unsuccessful climbs
	   * @param numFail number of unsuccessful climbs
	   * @param historyLength number of grades used to calculate the average
	   * @return string containing the average climb grades
	   */
	  public static String getStats(String[] send, int numSend, String[] fail, int numFail, int historyLength)
	  {
	    double sendSum = 0;
	    double failSum = 0;
	    String sendAverage;
	    String failAverage;
	    
	    if (historyLength <= numSend)
	    {
	      for (int k = numSend-1; k >= numSend-historyLength; k--)
	        sendSum += Double.parseDouble(send[k].substring(1));
	      sendAverage = String.valueOf((int) (sendSum / historyLength * 1000 + 0.5) / 1000.0);
	    }
	    else
	    {
	      for (int k = numSend-1; k >= 0; k--)
	        sendSum += Double.parseDouble(send[k].substring(1));
	      sendAverage = String.valueOf((int) (sendSum / numSend * 1000 + 0.5) / 1000.0);
	    }
	    if (historyLength <= numFail)
	    {
	      for (int k = numFail-1; k >= numFail-historyLength; k--)
	        failSum += Double.parseDouble(fail[k].substring(1));
	      failAverage = String.valueOf((int) (failSum / historyLength * 1000 + 0.5) / 1000.0);
	    }
	    else
	    {
	      for (int k = numFail-1; k >= 0; k--)
	        failSum += Double.parseDouble(fail[k].substring(1));
	      failAverage = String.valueOf((int) (failSum / numFail * 1000 + 0.5) / 1000.0);
	    }

	    if (numSend == 0)
	      sendAverage = "--";
	    if (numFail == 0)
	      failAverage = "--";
	    if (historyLength <= 0)
	      sendAverage = failAverage = "--";
	    
	    return "send: " + sendAverage + "\nfail: " + failAverage;
	  }
	  
	  /**
	   * This method creates and returns a formatted String containing the number of climbs at each grade
	   * from V0 to the highest graded climb in either array. Failures are reported first, and are
	   * represented with a "-"; successes are represented with a "+" and are listed second
	   * @param send a string array of successful climbs 
	   * @param numSend number of successful climbs
	   * @param fail a string array of unsuccessful climbs 
	   * @param numFail number of unsuccessful climbs
	   * @return a string containing the histogram
	   */
	  public static String getHistogram(String[] send, int numSend, String[] fail, int numFail)
	  {
	    String[] histogram = {"V0: ", "V1: ", "V2: ", "V3: ", "V4: ", "V5: ", "V6: ", "V7: "};
	    int highestGrade = 0;
	    
	    for (int k = 0; k < numFail; k++)
	    {
	      int grade = Integer.parseInt(fail[k].substring(1));
	      histogram[grade] += "- ";
	      if (grade > highestGrade)
	        highestGrade = grade;
	    }
	    for (int k = 0; k < numSend; k++)
	    {
	      int grade = Integer.parseInt(send[k].substring(1));
	      histogram[grade] += "+ ";
	      if (grade > highestGrade)
	        highestGrade = grade;
	    }
	    
	    String output = "";
	    for (int k = 0; k <= highestGrade; k++)
	      output += histogram[k] + "\n";
	    
	    if (numSend == 0 && numFail == 0)
	      output = "Error: no data to display\n";
	    
	    return output;
	  }
	  
	}

