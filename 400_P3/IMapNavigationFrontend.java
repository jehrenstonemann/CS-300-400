
/**
 * This interface allows a user to access the graph via console
 * commands and perform functions such as finding shortest path between 2 spots and 
 * find the nearest distance to each location
 *
 * @author Chengjun Wu
 *
 */
public interface IMapNavigationFrontend {
    
    /**
       * This method starts the command loop for the frontend, and will
       * terminate when the user exists the app.
       */
      public void runCommandLoop();

      public void displayMainMenu(); // prints command options to System.out

      public void displaynearestlocations(); // find neartest locations 

      public void displayshortestpath(); // reads starting point and ending from System.in, displays results

      public void distanceFilter(); // reads cost from System.in, displays results

}

  

