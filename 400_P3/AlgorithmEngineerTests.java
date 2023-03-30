// --== CS400 File Header Information ==--
// Name: Huang Xiangyu
// Email: xhuang438@wisc.edu
// Team: AY
// TA: Callie Kim
// Lecturer: Gary Dahl
// Notes to Grader: 

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class AlgorithmEngineerTests {

    private ExtendedCS400Graph<String,Integer> graph;
    
    /**
     * Instantiate graph.
     */
    @BeforeEach
    public void createGraph() {
        graph = new ExtendedCS400Graph<>();
        // insert vertices A-F
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertVertex("TEST");
        graph.removeVertex("TEST");
        // insert edges
        graph.insertEdge("A","C",1);
        graph.insertEdge("B","A",1);
        graph.insertEdge("B","C",2);
        graph.insertEdge("D","B",10);
        graph.insertEdge("C","D",2);
        graph.insertEdge("D","A",2);
        graph.insertEdge("B","E",3);
        graph.insertEdge("E","D",1);
        graph.removeEdge("E", "D");

    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * E to D.
     */
    @Test
    public void testPathEtoD() {
        assertTrue(graph.shortestPath("E", "D").toString().equals(
            "[E, B, A, D]"
        ));
    }
    
    /**
     * Checks the distance/total weight cost from the vertex E to D.
     */
    @Test
    public void testPathCostEtoD() {
        assertTrue(graph.getPathCost("E", "D") == 6);
    }
    
    /**
     * Checkes getNodes method functions correctly
     */
    @Test
    public void testGetNodes() {
    	assertTrue(graph.getNodes().size()==5);
    }
    
    /**
     * Checkes number of vertices is correct
     */
    @Test
    public void testGetVertexCount() {
    	assertTrue(graph.getVertexCount()==5);
    }
    
    /**
     * Checkes number of edges is correct
     */
    @Test
    public void testGetEdgeCount() {
    	assertTrue(graph.getEdgeCount()==7);
    }
    
    /**
     * Checkes containsVertex is correct
     */
    @Test
    public void testContainsVertex() {
    	assertTrue(graph.containsVertex("TEST")==false);
    	assertTrue(graph.containsVertex("A")==true);
    }
    
    /**
     * Checkes getWeight is correct
     */
    @Test
    public void testGetWeight() {
    	assertTrue(graph.getWeight("A", "B").equals(1));
    }

    /**
     * Checkes isEmpty is correct
     */
    @Test
    public void testIsEmpty() {
    	assertTrue(graph.isEmpty()==false);
    }
    
    /**
     * test correctness of all functions except dijkstra implementation
     */
    @Test
    public void IntegrationTest1() {
        IMapLoader uwMap = new DW_MapLoader();
        List<ILocation> buildings = null;
        try {
        buildings = ((IMapLoader) uwMap).loadMap("UWMap.gv");
        } catch (Exception e) {
          fail();
        }
        MapNavigationBackend backend = new MapNavigationBackend();
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
        
        ExtendedCS400Graph<ILocation, Double> test = (ExtendedCS400Graph<ILocation, Double>) backend.map;
        assertTrue(test.containsVertex(test.getNodes().get(0))==true);
        assertTrue(test.isEmpty()==false);
        assertTrue(test.getVertexCount()==8);
        assertTrue(test.getEdgeCount()==14);
        assertTrue(test.getNodes().size()==8);
    }
    
    /**
     * test correctness of dijkstra path cost functionality
     */
    @Test
    public void IntegrationTest2() {
        IMapLoader uwMap = new DW_MapLoader();
        List<ILocation> buildings = null;
        try {
        buildings = ((IMapLoader) uwMap).loadMap("UWMap.gv");
        } catch (Exception e) {
          fail();
        }
        MapNavigationBackend backend = new MapNavigationBackend();
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
        
        ExtendedCS400Graph<ILocation, Double> test = (ExtendedCS400Graph<ILocation, Double>) backend.map;
        int j = 0;
        for(int i=0; i<test.getNodes().size();i++) {
        	if(test.getNodes().get(i).getName().equals("VanHise"))
        		j=i;
        }
        int z=0;
        for(int i=0; i<test.getNodes().size();i++) {
        	if(test.getNodes().get(i).getName().equals("FedEx"))
        		z=i;
        }
        assertTrue(test.getPathCost(test.getNodes().get(j), test.getNodes().get(z)) == 1470.0);
    }
    
    /**
     * test correctness of loading data
     */
    @Test
    public void CodeReviewOfDataWranger1() {
    	 DW_MapLoader test = new DW_MapLoader();
    	    try {
    	    	test.loadMap("UWMap.gv");
    	    } catch (FileNotFoundException e) {
    	      fail("no such file");
    	    }
    	    assertTrue(test.locations.size() == 8);
    	    assertTrue(test.locations.get(0).getName().equals("FedEx"));
    }
    
    /**
     * test correctness of loading data
     */
    @Test
    public void CodeReviewOfDataWranger2() {
    	 DW_MapLoader test = new DW_MapLoader();
    	    try {
    	    	test.loadMap("UWMap.gv");
    	    } catch (FileNotFoundException e) {
    	      fail("no such file");
    	    }
    	    assertTrue(test.contains("FedEx"));
    }
}