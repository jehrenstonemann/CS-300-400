import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;

/**
 * This class runs the Map Navigation Application
 * it calls the frontend and backend providing user input
 */
public class MapNavigation{

        /**
         * main method to run the Map Navigation Application
        */
        public static void main(String[] args) throws FileNotFoundException{
                // load the buildings from the data file
                IMapLoader uwMap = new DW_MapLoader();
                List<ILocation> buildings = ((IMapLoader) uwMap).loadMap("UWMap.gv"); 

                // instantiate the backend
                IMapNavigationBackend backend = new MapNavigationBackend();

                // add all the buildings and their edges to the map
                for(int i = 0; i < buildings.size(); i++) {
                        backend.addLocation(buildings.get(i));

                }
                for(int i = 0; i < buildings.size(); i++) {
                  
                        for(int j = 0; j < buildings.get(i).getEdgesList().size(); j++) {

                                if((buildings.get(i) != null) && (buildings.get(i).getEdgesList().get(j).target != null)) {

                                        backend.addEdge(buildings.get(i),buildings.get(i).getEdgesList().get(j).target,buildings.get(i).getEdgesList().get(j).weight);
                                }
                        }
                }

                // instantiate the scanner for user input (to be used by the front end)
                Scanner userInputScanner = new Scanner(System.in);

                // instantiate the front end
                IMapNavigationFrontend frontend = new MapNavigationFrontend(userInputScanner, backend);

                // start the input loop of the front end
                frontend.runCommandLoop();
        }

}