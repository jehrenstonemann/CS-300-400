import java.util.LinkedList;

/**
 * placeholder for the iterable data structure
 * @author Huang Xiangyu
 *
 */
public class BDIterableRBTree implements IIterableRBTreeADT<IPlayer>{
	
	private LinkedList<IPlayer> testList;  // uses Linked list to simulate an iterable data structure
	
	/**
	 * constructor
	 */
	public BDIterableRBTree() {
		testList = new LinkedList<>();
	}
	
	/**
	 * check if there are more nodes in the tree
	 */
	@Override
	public boolean hasNext() {
		if(testList.peek()!=null)
			return true;
		return false;
	}
	  
	/**
	   * Return the next node
	   * 
	   * @return the next node
	   */
	@Override
	public IPlayer next() {
		return testList.pop();
	}
	
	  /**
	   * Insert a new node into the tree
	   * 
	   * @param node node need to be inserted
	   * @return true if the insertion is successful, false otherwise
	   */
	@Override
	public boolean insert(IPlayer node) {
		testList.add(node);
		return true;
	}
	  /**
	   * Method to check if the linked list is empty
	   * 
	   * @return true if it is empty; false otherwise
	   */
	@Override
	public boolean isEmpty() {
		if(testList.size()==0)
			return true;
		return false;
	}

	public int size() {
		return testList.size();
	}
	
	public void iterator() {
		// don't need this for BD placeholder
	}
	
	  
}
