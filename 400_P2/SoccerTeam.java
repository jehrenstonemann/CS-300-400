import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * Class with main method to run the soccer team app.
 * There will be changes made during P2W4
 */
public class SoccerTeam {

	/**
	 * main method to run the soccer team app
	 * @param args input arg if any
	 * @throws FileNotFoundException throw this exception when no file found
	 */
	public static void main(String[] args) throws FileNotFoundException{
        // load the players from the data file
        List<IPlayer> players = (new PlayerLoader()).loadPlayers("player.xml");; //(new PlayerLoader()).loadPlayers("player.xml");
        // instantiate the backend
        SoccerTeamBackend backend = new SoccerTeamBackend();
        // add all the players to the backend
        for (IPlayer player : players) {
            backend.addPlayer(player);
        }
        // instantiate the scanner for user input (to be used by the front end)
        Scanner userInputScanner = new Scanner(System.in);
        // instantiate the front end
        ISoccerTeamFrontend frontend = new SoccerTeamFrontend(userInputScanner, backend);; //new SoccerTeamFrontend();
        // start the input loop of the front end
       frontend.runCommandLoop();
	}
	
}
