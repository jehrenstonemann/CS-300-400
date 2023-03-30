import java.util.ArrayList;

public class DW_Location implements ILocation {

  public String name;

  public ArrayList<Edge> edgesList;


  /**
   * constructor that takes in the name and sets the Location's name field to name and initializes
   * the edgesList array
   */
  public DW_Location(String name) {
    this.name = name;
    this.edgesList = new ArrayList<Edge>();
  }



  /**
   * adds an Edge object the the list of edges in this Location object
   */
  public void addEdge(Edge edge) {
    edgesList.add(edge);
  }


  /**
   * @return the name of the location
   */
  public String getName() {
    return this.name;
  }


  /**
   * returns the distance between two adjacent Locations
   * 
   * @returns the distance between two adjacent locations, and -1 if it is not adjacent
   */
  public double getDistance(ILocation destination) {

    for (int i = 0; i < edgesList.size(); i++) {
      if (edgesList.get(i).target.equals(destination)) {
        return edgesList.get(i).weight;
      }
    }

    return -1;
  }


  /**
   * @returns the edgesList field
   */
  public ArrayList<Edge> getEdgesList() {

    return edgesList;

  }



}
