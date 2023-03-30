// --== CS400 Project One File Header ==--
// Name: Coleman Richard Nelson
// CSL Username: cnelson
// Email: crnelson25@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader:
public interface IIterableRBTreeADT<Node> {
		  /**
		   * check if there are more nodes in the tree
		   */
		  public boolean hasNext();

		  /**
		   * Return the next node of the current parent
		   * 
		   * @return the next node of the current parent
		   */
		  public Node next();

		  /**
		   * Insert a new node into the tree
		   * 
		   * @param node node need to be inserted
		   * @return true if the insertion is successful, false otherwise
		   */
		  public boolean insert(IPlayer node);


		  /**
		   * Method to check if the tree is empty (does not contain any node).
		   * 
		   * @return true of this.size() return 0, false if this.size() > 0
		   */
		  public boolean isEmpty();
		  
		  public String toString();

		  public void iterator();
}