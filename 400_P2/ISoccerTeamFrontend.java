import java.util.List;

/**
 * This interface allows a user to access the red black tree via console
 * commands and display the roster with the ability to filter the roster
 * 
 * @author Bryce Lardinois
 *
 */
public interface ISoccerTeamFrontend {

    /**
     * This method starts the command loop for the frontend, and will
     * terminate when the user exists the app.
     */
    public void runCommandLoop();       //runs the frontend and selection options

    public void displayMainMenu(); // prints command options to System.out

    public void displayRoster(); // displays a list of players

    public void marketValueFilter(); // reads market value from System.in, displays results
    
    public void playerRatingFilter(); // reads player rating from System.in, displays results

}