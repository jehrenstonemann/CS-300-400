import java.util.ArrayList;



// --== CS400 File Header Information ==--
// Name: <Yancheng Zhu>
// Email: <zhu436@wisc.edu>
// Team: <your team name: two letters>
// TA: <Callie>
// Lecturer: <Gary Dahl>
// Notes to Grader: <optional extra notes>
public interface ILocation {


  /**
   * Return the name of the current location
   * 
   * @return name of the current location
   */
  public String getName();
  
  /**
   * adds a given edge object to the array of edges within the location
   * 
   * 
   */
  public void addEdge(Edge edge);
   
  
  /**
   * Return the distance between the current location and destination
   * 
   * @param destination the place user wants to go from the current location
   * @return the distance between the current location and destination
   */
  public double getDistance(ILocation destination);

  /**
   * returns the array of this objects' edges
   * 
   * 
   */
  public ArrayList<Edge> getEdgesList();
   
  
}