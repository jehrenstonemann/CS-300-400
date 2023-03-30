import java.util.List;

/**
 * This ADT represents an undirected graph data structure with positive edge weights.
 *
 * @param NodeType the data type stored at each graph vertex
 * @param EdgeType the data type stored at each graph edge as a Number whose doubleValue() method returns a value >=0.0
 */
public interface ExtendedGraphADT<NodeType,EdgeType extends Number> extends GraphADT<NodeType,EdgeType>{
	
	/**
	 * get a list of data within node
	 * 
	 * @return a list of data within node
	 */
	public List<NodeType> getNodes();
	
}