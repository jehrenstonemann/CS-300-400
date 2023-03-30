// DO NOT submit this file to gradescope

import java.util.Scanner;

/**
 * Driver method which allows the user to modify and view the contents of an AssignmentQueue
 */
public class AssignmentPlanner {
  
  private static final String WELCOME_MSG= "========================================================\n"+
                                           "               Assignment Planner (v1.0)                \n"+
                                           "========================================================\n";
  
  /**
   * Main method for this AssignmentPlanner
   * 
   * @param args input args if any
   */
  public static void main(String[] args) {
    System.out.println(WELCOME_MSG);
    // creates a new assignment planner and launch the application
    AssignmentPlannerState state = AssignmentPlannerState.MAIN_MENU;
    AssignmentQueue queue = new AssignmentQueue(10);
    Scanner scanner = new Scanner(System.in);

    while (!state.isDone()) {
      state = state.runState(scanner, queue);
    }
    // close the scanner
    scanner.close();
    
  }
}