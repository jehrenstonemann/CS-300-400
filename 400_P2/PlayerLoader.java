import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Instances of this class can be used to load player data from a XML file.
 */
public class PlayerLoader implements IPlayerLoader {

  /**
   * This method loads the list of players from a XML file.
   * 
   * @param filepathToXML path to the XML file relative to the executable
   * @return a list of player objects
   * @throws FileNotFoundException
   */
  @Override
  public List<IPlayer> loadPlayers(String filepathToXML) throws FileNotFoundException {
    List<IPlayer> list = new ArrayList<>();
    File file;
    try {
      file = new File(filepathToXML);
    } catch (Exception e) {
      throw new FileNotFoundException();
    }
    Scanner scnr = new Scanner(file);
    String text = "";
    String name = "";
    String rating = "";
    String value = "";
    int editable = 0;
    while (scnr.hasNext()) {
      text += scnr.nextLine();
    }    String[] textArray = text.split("<");
    String[][] textDoubleArray = new String[textArray.length][];
    for (int i = 0; i < textArray.length; i++) {
      textDoubleArray[i] = textArray[i].split(">");
      if (textDoubleArray[i][0].equals("dataitem")) {
        editable = 1;
      }
      if (editable == 1) {
        if (textDoubleArray[i][0].equals("name")) {
          name = textDoubleArray[i][1].trim();
        }
        if (textDoubleArray[i][0].equals("rating")) {
          rating = textDoubleArray[i][1].trim();
        }
        if (textDoubleArray[i][0].equals("value")) {
          value = textDoubleArray[i][1].trim();
        }
      }
      if (textDoubleArray[i][0].equals("/dataitem")) {
        Player player = new Player();
        player.setName(name);
        player.setRating(rating);
        player.setValue(value);
        list.add(player);
        name = "";
        rating = "";
        value = "";
        editable = 0;
      }
    }
    scnr.close();    
    return list;
  }
  
}
