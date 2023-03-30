//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    AssignmentPlannerState
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

/**
 * Represents the current state of the assignment planner application
 */
public enum AssignmentPlannerState {
  MAIN_MENU {
    /**
     * Returns whether the state is DONE
     * 
     * @return false
     */
    public boolean isDone() {
      return false;
    }

    /**
     * Prints possible options for actions to take to the user, and collects their input. If the
     * user's input is not a valid action, a warning message should be printed, and the next state
     * should also be MAIN_MENU.
     *
     * If option [1] Add an assignment is selected, the queue should not be modified, and the next
     * state should be ADD_ASSIGNMENT.
     *
     * If option [2] Show highest priority assignment is selected, the earliest assignment in the
     * queue should be printed, and the next state should be MAIN_MENU. If the queue is empty, a
     * warning message should be printed.
     *
     * If option [3] Complete highest priority assignment is selected, the earliest assignment in
     * the queue should be printed and removed, and the next state should be MAIN_MENU. If the queue
     * is empty, a warning message should be printed.
     *
     * If option [4] List all assignments is selected, all assignments in the queue should be
     * printed in order from earliest to latest, and the next state should be MAIN_MENU.
     *
     * If option [5] Clear planner is selected, all assignments should be removed from the queue,
     * and the next state should be MAIN_MENU.
     *
     * If option [0] Quit planner is selected, a goodbye message should be printed to the user, and
     * the next state should be DONE.
     *
     * @param scanner scanner for user input
     * @param queue   current Assignment queue
     * @return the next state of the AssignmentPlanner
     */
    public AssignmentPlannerState runState(Scanner scanner, AssignmentQueue queue) {
      int num;
      // print menu and prompt user command line
      System.out.println("\n[1] Add an assignment");
      System.out.println("[2] Show highest priority assignment");
      System.out.println("[3] Complete highest priority assignment");
      System.out.println("[4] List all assignments");
      System.out.println("[5] Clear planner");
      System.out.println("[0] Quit planner");
      System.out.print("Select a command: ");
      String cmd = scanner.nextLine(); // read user command
      try {
        num = Integer.parseInt(cmd);
      } catch (NumberFormatException ignored) {
        System.out.println("Invalid command \"" + cmd + "\"");
        return MAIN_MENU;
      }

      if (num == 1) {
        return ADD_ASSIGNMENT;
      } else if (num == 2) { // Show/peek highest priority assignment
        // implement calling peek() method on queue. 
        // Make sure to consider the case when queue is empty
        try{
          System.out.println("Highest priority assignment is: "+"/n"+queue.peek());
        }catch(Exception e) {
          System.out.println("Error");
        }
        return MAIN_MENU;
      } else if (num == 3) { // Complete highest priority assignment
        // implement calling dequeue() method on queue. 
        // Make sure to consider the case when queue is empty
        try {
          System.out.println("Highest priority assignment "+"/n"+queue.dequeue()+"/n"+"has been completed.");
        }catch(Exception e) {
          System.out.println("Error");
        }
        return MAIN_MENU;
      } else if (num == 4) { // List all assignments
        // print a string representation of queue
        System.out.println(queue.toString());
        return MAIN_MENU;
      } else if (num == 5) { // Clear planner
        // clear queue
        queue.clear();
        System.out.println("Planner cleared");
        return MAIN_MENU;
      } else if (num == 0) {
        System.out.println("Goodbye!");
        return DONE;
      } else {
        System.out.println("Warning: Invalid command \"" + cmd + "\"");
        return MAIN_MENU;
      }
    }
  },

  DONE {
    /**
     * Returns whether the state is DONE
     * 
     * @return true
     */
    public boolean isDone() {
      return true;
    }

    /**
     * Does nothing, as the application has ended
     * 
     * @param scanner scanner for user input
     * @param queue   current Assignment queue
     * @return the next state of the AssignmentPlanner
     */
    public AssignmentPlannerState runState(Scanner scanner, AssignmentQueue queue) {
      return DONE;
    }
  },

  ADD_ASSIGNMENT {
    /**
     * Returns whether the state is DONE
     * 
     * @return false
     */
    public boolean isDone() {
      return false;
    }

    /**
     * Asks the user for the information of the assignment they would like to add, in the order
     * name, month, day of month, and hour.
     *
     * If the queue is at capacity, a warning message should be printed, and the next state should
     * be MAIN_MENU.
     *
     * If there is a problem with the user's input, no new Assignment should be added to the queue,
     * and the next state should be ADD_ASSIGNMENT.
     *
     * If the user correctly inputs all fields, an assignment with the desired fields should be
     * created and added to the queue, and the next state should be MAIN_MENU.
     *
     * @param scanner scanner for user input
     * @param queue   current Assignment queue
     * @return the next state of the AssignmentPlanner
     */
    public AssignmentPlannerState runState(Scanner scanner, AssignmentQueue queue) {
      // add to a full queue
      if (queue.size() == queue.capacity()) {
        System.out.println("Queue is full. Complete some assignments first!!");
        return MAIN_MENU;
      }

      Assignment assignment = null; // assignment to be added

      // read assignment's details (name and due date)
      System.out.println("Enter name for assignment:");
      String name = scanner.nextLine();
      System.out.println("Enter due date in the format MM/DD HH (24-hour format):"); 
      String date = scanner.nextLine();
      // parse assignment's due date
      String[] dates = date.split(" ");
      if (dates.length != 2) { // invalid format
        System.out.println("Invalid date format");
        return ADD_ASSIGNMENT;
      }

      try { // try to parse month, day of the month, and hour of the due date
        int hour = Integer.parseInt(dates[1]);
        String[] parts = dates[0].split("/");
        if (parts.length != 2) {
          System.out.println("Invalid date format");
          return ADD_ASSIGNMENT;
        }
        int month = Integer.parseInt(parts[0]); // month of the due date of the assignment
        int dayOfMonth = Integer.parseInt(parts[1]); // day of the month
        // create a new assignment with the above parameters (name and due date)
        assignment = new Assignment(name,month,dayOfMonth,hour);
      } catch (NumberFormatException e) {
        System.out.println("Invalid date format");
        return ADD_ASSIGNMENT;
      } catch (RuntimeException e) {
        System.out.println("Invalid Assignment");
        return ADD_ASSIGNMENT;
      }

      // enqueue assignment
      queue.enqueue(assignment);
      return MAIN_MENU;
    }
  };

  /**
   * Returns whether the state is DONE
   * 
   * @return true if this assignment is DONE
   */
  public abstract boolean isDone();

  /**
   * Performs the behavior of this state by utilizing the values given by the scanner, updating the
   * queue, and returning the next state
   * 
   * @param scanner scanner for user input
   * @param queue   current Assignment queue
   * @return the next state of the AssignmentPlanner
   */
  public abstract AssignmentPlannerState runState(Scanner scanner, AssignmentQueue queue);
}