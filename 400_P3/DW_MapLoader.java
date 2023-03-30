import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class DW_MapLoader implements IMapLoader {
  public ArrayList<ILocation> locations;

  public ArrayList<ILocation> loadMap(String filepathToDOT) throws FileNotFoundException {

    this.locations = new ArrayList<ILocation>();

    File file = new File(filepathToDOT); // send in file
    Scanner scnr = new Scanner(file);
    String thisLine;
    String thisLocation;
    String thisDestination;
    double thisWeight;
    int tempIndex;
    ILocation thisLocObj;

    scnr.nextLine(); // the first line we dont care about

    while (scnr.hasNextLine()) {

      thisLine = scnr.nextLine().trim();
      if (thisLine.contains("}")) {
        break;
      }
      tempIndex = thisLine.indexOf("--"); // find the index where the location ends
      thisLocation = thisLine.substring(0, tempIndex - 1); // get the location name

      if (!this.contains(thisLocation)) { // if we dont already have a location of this name, then
                                          // make a new one
        this.locations.add(new DW_Location(thisLocation));
      }
      thisDestination = thisLine.substring(tempIndex + 3, thisLine.indexOf('[') - 1);
      if (!this.contains(thisDestination)) { // if we dont already have a location of this name,
                                             // then
        // make a new one
        this.locations.add(new DW_Location(thisDestination));
      }

      thisWeight = Double.parseDouble( // get the weight of the edge
          thisLine.substring(thisLine.indexOf("\"") + 1, thisLine.lastIndexOf("\"")));

      thisLocObj = this.getLocation(thisLocation); // create a new edge object and add it to the
                                                   // current location
      thisLocObj.addEdge(new Edge((DW_Location) this.getLocation(thisDestination), thisWeight));
    }


    return this.locations;
  }

  public boolean contains(String name) {
    for (int i = 0; i < locations.size(); i++) {
      if (locations.get(i).getName().equals(name)) {
        return true;
      }
    }
    return false;

  }

  public ILocation getLocation(String name) {

    for (int i = 0; i < locations.size(); i++) {
      if (locations.get(i).getName().equals(name)) {
        return locations.get(i);
      }
    }
    return null; // should have found it if its there(it will always be there if the code functions
                 // correctly in the loadMap method)
  }


}
