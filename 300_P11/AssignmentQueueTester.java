//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    AssignmentQueueTester
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
// Persons:      NONE
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.Arrays;

/**
* Tester class for the AssignmentQueue implementation of PriorityQueueADT
*/
public class AssignmentQueueTester {
	
  /**
  * Tests the functionality of the constructor for AssignmentQueue Should implement at least the
  * following tests:
  *
  * - Calling the AssignmentQueue with an invalid capacity should throw an IllegalArgumentException
  * - Calling the AssignmentQueue with a valid capacity should not throw any errors, and should
  * result in a new AssignmentQueue which is empty, and has size 0
  *
  * @return true if the constructor of AssignmentQueue functions properly
  * @see AssignmentQueue#AssignmentQueue(int)
  */
  public static boolean testConstructor() {
	// case 1:
	try {
	  AssignmentQueue test = new AssignmentQueue(0);
	  return false;
	}catch(IllegalArgumentException e) {
		
	}
	// case 2:
	AssignmentQueue test =new AssignmentQueue(1);
	if(test.size()!=0)
	  return false;
	if(!test.isEmpty())
	  return false;
    return true; 
  }

  /**
  * Tests the functionality of the enqueue() and peek() methods Should implement at least the
  * following tests:
  *
  * - Calling peek on an empty queue should throw a NoSuchElementException 
  * - Calling enqueue on a queue which is empty should add the Assignment, and increment the size 
  *   of the queue
  * - Calling enqueue on a non-empty queue should add the Assignment at the proper position, 
  *   and increment the size of the queue. Try add at least 5 assignments 
  * - Calling peek on a non-empty queue should always return the Assignment with the earliest due date
  * - Calling enqueue on a full queue should throw an IllegalStateException 
  * - Calling enqueue with a null Assignment should throw a NullPointerException
  *
  * @return true if AssignmentQueue.enqueue() and AssignmentQueue.peek() function properly
  */
  public static boolean testEnqueue() {
	try {
	  AssignmentQueue test = new AssignmentQueue(10);
	  Assignment testAssignment = new Assignment("Project 11",12,12,23);
	  try {
	    test.peek();
	    return false;
	  }catch(NoSuchElementException e) {
		
	  }
	  test.enqueue(testAssignment);
	  if(!test.peek().equals(testAssignment))
        return false;
	  if(test.size()!=1)
	    return false;
	  AssignmentQueue test2 = new AssignmentQueue(5);
	  Assignment testAssignment2 = new Assignment("Project 14",8,8,23);
	  Assignment testAssignment3=new Assignment("Project 13",9,9,23);
	  Assignment testAssignment4=new Assignment("Project 12",10,10,23);
	  Assignment testAssignment5=new Assignment("Project 11",11,11,23);
	  Assignment testAssignment6=new Assignment("Project 10",12,12,23);
	  Assignment testAssignment7=new Assignment("Project 15",7,7,23);
	  test2.enqueue(testAssignment6);
	  test2.enqueue(testAssignment5);
	  test2.enqueue(testAssignment4);
	  test2.enqueue(testAssignment3);
	  test2.enqueue(testAssignment2);
	  if(!test2.peek().equals(testAssignment2))
        return false;
	  if(test2.size()!=5)
	    return false;
	  Iterator<Assignment> iterator = test2.iterator();
	  if(iterator.next()!=testAssignment2)
	    return false;
	  if(iterator.next()!=testAssignment3)
	    return false;
	  if(iterator.next()!=testAssignment4)
	    return false;
	  if(iterator.next()!=testAssignment5)
	    return false;
	  if(iterator.next()!=testAssignment6)
	    return false;
	  try {
	    test2.enqueue(testAssignment7);
	    return false;
	  }catch(IllegalStateException e) {
		
	  }
	  try {
	    test2.enqueue(null);
	    return false;
	  }catch(NullPointerException e) {
		
	  }
	}catch(Exception e) {
	  return false;
	}
    return true;
  }

  /**
  * Tests the functionality of dequeue() and peek() methods. The peek() method must return without
  * removing the assignment with the highest priority in the queue. The dequeue() method must
  * remove, and return the assignment with the highest priority in the queue. The size must be
  * decremented by one, each time the dequeue() method is successfully called. Try to check the
  * edge cases (calling peek and dequeue on an empty queue, and calling dequeue on a queue of size
  * one). For normal cases, try to consider dequeuing from a queue whose size is at least 6. Try to
  * consider cases where percolate-down recurses on left and right.
  * 
  * @return true if AssignmentQueue.dequeue() and AssignmentQueue.peek() function properly
  */
  public static boolean testDequeuePeek() {
	AssignmentQueue test = new AssignmentQueue(6);
	// enqueue 5 assignments
	Assignment assignment1 = new Assignment("Project 10",12,12,23);
	Assignment assignment2 = new Assignment("Project 11",11,11,23);
	Assignment assignment3 = new Assignment("Project 12",10,10,23);
	Assignment assignment4 = new Assignment("Project 13",9,9,23);
	Assignment assignment5 = new Assignment("Project 14",8,8,23);
	Assignment assignment6 = new Assignment("Project 1",13,13,23);
	test.enqueue(assignment1);
	test.enqueue(assignment2);
	test.enqueue(assignment3);
	test.enqueue(assignment4);
	test.enqueue(assignment5);
	test.enqueue(assignment6);
	if(test.size()!=6)
	  return false;
	if(!test.peek().equals(assignment5))
	  return false;
	if(test.size()!=6)
	  return false;
	if(!test.dequeue().equals(assignment5))
	  return false;
	if(test.size()!=5)
	  return false;
	test.dequeue();
	test.dequeue();
	test.dequeue();
	test.dequeue();
	if(test.size()!=1)
	  return false;
	if(!test.peek().equals(assignment6))
	  return false;
	if(test.size()!=1)
	  return false;
	if(!test.dequeue().equals(assignment6))
	  return false;
	if(test.size()!=0)
	  return false;
	AssignmentQueue test2 = new AssignmentQueue(1);
	try {
	  test2.dequeue();
	  return false;
	}catch(NoSuchElementException e) {
	  
	}
	try {
      test2.peek();
      return false;
	}catch(NoSuchElementException e) {
		
	}
	test2.enqueue(assignment4);
	test2.dequeue();
	if(test2.size()!=0)
	  return false;
    return true;
  }

  /**
  * Tests the functionality of the clear() method Should implement at least the following scenarios: 
  * - clear can be called on an empty queue with no errors 
  * - clear can be called on a non-empty queue with no errors - After calling clear, the queue should contain no Assignments
  *
  * @return true if AssignmentQueue.clear() functions properly
  */
  public static boolean testClear() {
	AssignmentQueue test = new AssignmentQueue(10);
	test.clear();
	AssignmentQueue test2 = new AssignmentQueue(10);
	test2.enqueue(new Assignment("Project 10",12,12,23));
	test2.enqueue(new Assignment("Project 11",11,11,23));
	test2.enqueue(new Assignment("Project 12",10,10,23));
	test2.enqueue(new Assignment("Project 13",9,9,23));
	test2.enqueue(new Assignment("Project 14",8,8,23));
	test2.clear();
	if(test2.size()!=0)
	  return false;
    return true;
  }

  /**
  * Tests all the methods of the AssignmentQueue class
  * 
  * @return true if everything is running OK
  */
  public static boolean runAllTests() {
	return testConstructor()&&testEnqueue()&&testDequeuePeek()&&testClear();
  }

  /**
  * Main method
  * 
  * @param args input arguments if any
  */
  public static void main(String[] args) {
    System.out.println(runAllTests());
  }
}