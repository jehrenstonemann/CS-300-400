import java.io.FileNotFoundException;
import java.util.List;

/**
 * Instances of this interface can be used to load player data from a XML file.
 */
public interface IPlayerLoader {
  
  /**
   * This method loads the list of players from a XML file.
   * @param filepathToXML path to the XML file relative to the executable
   * @return a list of player objects
   * @throws FileNotFoundException
   */
  List<IPlayer> loadPlayers(String filepathToXML) throws FileNotFoundException;

}





