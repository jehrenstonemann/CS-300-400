import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class constructs the backend allowing for filtering of the map data and
 * passing inputs into the algorithm
 * @author Bryce
 *
 */
public class MapNavigationBackend implements IMapNavigationBackend{

	private double distFilter; 							//distance filter
	private ILocation currLoc;							//current location
	public ExtendedGraphADT<ILocation, Double> map;	//map of locations
	
	/**
	 * This is the contructor method for the Backend
	 * it initializes the current location and filter
	 */
	public MapNavigationBackend() {
		distFilter = Double.MAX_VALUE;
		currLoc = null;
		map = new ExtendedCS400Graph<ILocation,Double>();
	}
	 
	/**
	 * this method adds a Location to the map
	 */
	@Override
	public void addLocation(ILocation location) {
		map.insertVertex(location);
	}
	
	/**
	 * this method adds an edge to the map
	 */
	@Override
	public void addEdge(ILocation location1, ILocation location2, double cost) {
		map.insertEdge(location1, location2, cost);
	}
	
	/**
	 * this method sets the distance filter
	 */
	@Override
	public void setDistanceFilter(String dist) {
		this.distFilter = Double.parseDouble(dist);
	}

	/**
	 * this method resets the distance filter
	 */
	@Override
	public void resetDistanceFilter() {
		this.distFilter = Double.MAX_VALUE;
	}

	/**
	 * this method returns the current distant filter
	 */
	@Override
	public double getDistanceFilter() {
		return this.distFilter;
	}

	/**
	 * This method sets the current location on
	 * the map
	 */
	@Override
	public void setCurrLocation(String location) {
		for(int i = 0; i < map.getNodes().size(); i++) {
			if(map.getNodes().get(i).getName().equals(location.replaceAll(" ", ""))) {
				currLoc = map.getNodes().get(i);
			}
		}	
	}

	/**
	 * This method resets the current location on
	 * the map
	 */
	@Override
	public void resetCurrLocation() {
		currLoc = null;
		
	}

	/**
	 * This method returns the current location otherwise 
	 * null
	 */
	@Override
	public String getCurrLocation() {
		if(currLoc == null) {
			return null;
		}
		return currLoc.getName();
	}

	/**
	 * This method displays building within the distance filter
	 * that are near to the current location
	 */
	@Override
	public List<String> displayNearbyBuildings() {
		List<String> nearby = new ArrayList<String>();
		List<String> nearbyStable = new ArrayList<String>();
		List<Double> nearbyDistances = new ArrayList<Double>();
		String temp;
		
		Double pathCost = 0.0;
		for(int i = 0; i < map.getNodes().size(); i++) {
			if (!map.getNodes().get(i).getName().equals(currLoc.getName())) {
				pathCost = shortestPathCost(map.getNodes().get(i).getName());
				if (pathCost < distFilter) {
				  temp = map.getNodes().get(i).getName();
				  nearby.add(temp);
				  nearbyStable.add(temp);
				  nearbyDistances.add(pathCost);
				}
			}
		}
		Collections.sort(nearby, new Comparator<String>() {
		    public int compare(String left, String right) {
		        return Double.compare(nearbyDistances.get(nearbyStable.indexOf(left)), nearbyDistances.get(nearbyStable.indexOf(right)));
		    }
		});
		return nearby;
	}

	/**
	 * This method returns the cost of traveling to 
	 * a specified destination if one does not exist it returns -1
	 */
	@Override
	public double shortestPathCost(String building) {

		ILocation destination = null;
		
		for(int i = 0; i < map.getNodes().size(); i++) {
			if(map.getNodes().get(i).getName().equals(building.replaceAll(" ", ""))) {
				destination = map.getNodes().get(i);
			}
		}
		if(destination == null) {
			return -1;
		}
		
		return map.getPathCost(currLoc, destination);
	}

	/**
	 * This method returns the path to the specified
	 * location if it exists otherwise null
	 */
	@Override
	public List<String> shortestPath(String building) {
		
		ILocation destination = null;
		List<ILocation> path = null;
		List<String> locations = new ArrayList<String>();
		
		for(int i = 0; i < map.getNodes().size(); i++) {
			if(map.getNodes().get(i).getName().equals(building.replaceAll(" ", ""))) {
				destination = map.getNodes().get(i);
			}
		}
		
		if(destination == null) {
			return new ArrayList<String>();
		}
		path = map.shortestPath(currLoc, destination);
		
		for(int i = 0; i < path.size(); i++) {
			locations.add(path.get(i).getName());
		}	
		return locations;
	}

}
