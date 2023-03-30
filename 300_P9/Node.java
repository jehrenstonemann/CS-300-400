// DO NOT SUBMIT THIS FILE TO GRADESCOPE
/**
 * This class models a linked node carrying an instance of Tile
 *
 */
public class Node {

  private Tile tile; // tile carried by this linked node
  private Node next; // reference to the next node in the chain of linked nodes

  /**
   * Creates a new node with a given tile 
   * @param tile tile to be carried by this node
   */
  public Node(Tile tile) {
    this.tile = tile;
  }
  
  /**
   * Creates a new node with a given tile and a given reference to the next node in the list
   * @param tile tile to be carried by this node
   * @param next reference to the next node
   */
  public Node(Tile tile, Node next) {
    this.tile = tile;
    this.next = next;
  }

  /**
   * Gets the tile carried by this node
   * @return the tile of this node
   */
  public Tile getTile() {
    return tile;
  }

  /**
   * Gets the reference to the next node
   * @return the reference to the next node
   */
  public Node getNext() {
    return next;
  }

  /**
   * Sets the reference to the next node
   * @param next the reference to the next node to set
   */
  public void setNext(Node next) {
    this.next = next;
  }
}