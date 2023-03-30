// --== CS400 Project One File Header ==--
// Name: Coleman Richard Nelson
// CSL Username: cnelson
// Email: crnelson25@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader:
import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class IterableRBTree implements IIterableRBTreeADT {
  
  
  
  public IterableRBTree() {
    this.iterator();
  }
/*
 * This class provides the framework for holding players
 */
  protected static class Node<T> {
    public IPlayer player;

    public Node<T> parent; // null for root node
    public Node<T> leftChild;
    public Node<T> rightChild;

    public double playerValue; // what the RBT is sorted by
    public int blackHeight; // 0 = red, 1 = black, 2 = double black

    public Node(IPlayer player) {
      this.player = player;
      this.playerValue = Double.parseDouble(player.getValue());
      this.blackHeight = 0; // any new node starts out red.
    }/**
     * @return true when this node has a parent and is the left child of that parent, otherwise
     *         return false
     */
    public boolean isLeftChild() {
      return parent != null && parent.leftChild == this;
    }
  }
  /*
   * this class allows for the iteration over the array
   */
  public class TeamRBTreeIterator {


    public Stack<Node<IPlayer>> playerList;
    public Node<IPlayer> currentNode;

    public TeamRBTreeIterator(Node<IPlayer> node) { // send in the root node of the RBTree
      this.currentNode = node;
      this.playerList = new Stack<>();
      addNodes(currentNode);
    }

    /**
     * adds the players into the stack with the highest value players at the top of the stack
     */
    private void addNodes(Node<IPlayer> node) {
      if (node != null) {
        addNodes(node.leftChild);
        playerList.push(node);
        addNodes(node.rightChild);
      }
    }
  }
  protected TeamRBTreeIterator RBIterator;
  protected Node<IPlayer> root;
  protected int size;
  /*
   * returns an iterator object that can return players from highest value to lowest
   */
  public void iterator() { 
    
    this.RBIterator = new TeamRBTreeIterator(root);
    
  }



  /**
   * Return the next player in the tree
   * 
   * @return the next player in the tree
   */
  public IPlayer next() {
    
    return RBIterator.playerList.pop().player;
    
    
  }

  /**
   * Return true if there is a next player in the RBTree
   * 
   * @return Return true if there is a next player in the RBTree false otherwise.
   */
  public boolean hasNext() {
    
    if(RBIterator == null) {
      System.out.println("RBIterator is empty");
      return false;
    }
    if (RBIterator.playerList.size() != 0) {
      return true;
    }
    
    return false;
    
  }/**
   * Performs a naive insertion into a binary search tree: adding the input data value to a new node
   * in a leaf position within the tree. After this insertion, no attempt is made to restructure or
   * balance the tree. This tree will not hold null references, nor duplicate data values.
   * 
   * @param data to be added into this binary search tree
   * @return true if the value was inserted, false if not
   * @throws NullPointerException     when the provided data argument is null
   * @throws IllegalArgumentException when the newNode and subtree contain equal data references
   */
  public boolean insert(IPlayer player) throws NullPointerException, IllegalArgumentException {
    // null references cannot be stored within this tree
    if (player == null )
      throw new NullPointerException("This RedBlackTree cannot store null references.");
    try {
      Node<IPlayer> newNode = new Node<>((IPlayer) player);

      if (root == null) {
        root = newNode;
        size++;
        root.blackHeight = 1;
        this.RBIterator = new TeamRBTreeIterator(root);
        return true;
      } // add first node to an empty tree
      else {
        boolean returnValue = insertHelper(newNode, root); // recursively insert into subtree
        if (returnValue) {
          size++;
          root.blackHeight = 1;
          this.RBIterator = new TeamRBTreeIterator(root);

        } else {
          throw new IllegalArgumentException("This RedBlackTree already contains that value.");
        }
        return returnValue;

      }
    } catch (Exception e) {  throw new IllegalArgumentException("error in the insert method. you didnt insert an IPlayer object");
    }

  }

  /**
   * Recursive helper method to find the subtree with a null reference in the position that the
   * newNode should be inserted, and then extend this tree by the newNode in that position.
   * 
   * @param newNode is the new node that is being added to this tree
   * @param subtree is the reference to a node within this tree which the newNode should be inserted
   *                as a descenedent beneath
   * @return true is the value was inserted in subtree, false if not
   */
  private boolean insertHelper(Node<IPlayer> newNode, Node<IPlayer> subtree) {
    int compare = ((Double) newNode.playerValue).compareTo((Double) subtree.playerValue);
    // do not allow duplicate values to be stored within this tree
    if (compare == 0)
      return false;

    // store newNode within left subtree of subtree
    else if (compare < 0) {
      if (subtree.leftChild == null) { // left subtree empty, add here
        subtree.leftChild = newNode;
        newNode.parent = subtree;
        enforceRBTreePropertiesAfterInsert(newNode);
        return true;
        // otherwise continue recursive search for location to insert
      } else
        return insertHelper(newNode, subtree.leftChild);
    }
    else {
        if (subtree.rightChild == null) { // right subtree empty, add here
          subtree.rightChild = newNode;
          newNode.parent = subtree;
          enforceRBTreePropertiesAfterInsert(newNode);
          return true;
          // otherwise continue recursive search for location to insert
        } else
          return insertHelper(newNode, subtree.rightChild);
      }
    }

    /**
     * Performs the rotation operation on the provided nodes within this tree. When the provided child
     * is a leftChild of the provided parent, this method will perform a right rotation. When the
     * provided child is a rightChild of the provided parent, this method will perform a left
     * rotation. When the provided nodes are not related in one of these ways, this method will throw
     * an IllegalArgumentException.
     * 
     * @param child  is the node being rotated from child to parent position (between these two node
     *               arguments)
     * @param parent is the node being rotated from parent to child position (between these two node
     *               arguments)
     * @throws IllegalArgumentException when the provided child and parent node references are not
     *                                  initially (pre-rotation) related that way
     */
    private void rotate(Node<IPlayer> child, Node<IPlayer> parent)
        throws IllegalArgumentException {
      // if the child is on the left
        if (parent.leftChild != child && parent.rightChild != child) { // if not related, throw
            // exception
throw new IllegalArgumentException();
}

if (parent.leftChild == child) { // child is on the left
boolean parentIsLeft = false;
if (parent.isLeftChild()) {
parentIsLeft = true;
}
child.parent = parent.parent;
if (parent.parent != null) {
if (parentIsLeft) {
parent.parent.leftChild = child;
} else {
parent.parent.rightChild = child;
}
} else {
root = child;
}
parent.parent = child;
parent.leftChild = child.rightChild;
if (child.rightChild != null) {
child.rightChild.parent = parent;
}
child.rightChild = parent;
return;
}
// if the child is on the right
else if (parent.rightChild == child) {
    boolean parentIsLeft = false;
    if (parent.isLeftChild()) {
      parentIsLeft = true;
    }
    child.parent = parent.parent;

    if (parent.parent != null) {
      if (parentIsLeft) {
        parent.parent.leftChild = child;
      } else {
        parent.parent.rightChild = child;
      }
    } else {
      root = child;
    }
    parent.parent = child;
    parent.rightChild = child.leftChild;
    if (child.leftChild != null) {
      child.leftChild.parent = parent;
    }

    child.leftChild = parent;
  }
}
    /**
     * Enforce the RBT properties after the insertion of a red node. (a red cannot have a red
     * parent/child)
     * 
     * @param addedRedNode is the node that was added. It is always red
     * 
     */
    protected void enforceRBTreePropertiesAfterInsert(Node<IPlayer> addedRedNode) {
      if (addedRedNode.parent.blackHeight != 0) { // if the parent is not red there is no violation
        return;
      }
      boolean didInitialRotate = false; // used to keep track of if we needed to do a rotate to get it
                                        // into one of the solvable cases



      // check if parent is a left child or right child
      if (addedRedNode.parent.isLeftChild()) {

        if (addedRedNode.parent.parent.rightChild == null) { // if the parent has NO sibling
          // rotate if we need to
          if (!addedRedNode.isLeftChild()) {
            rotate(addedRedNode, addedRedNode.parent);
            didInitialRotate = true;
          }
          if (didInitialRotate) {
            addedRedNode.blackHeight = 1;
            addedRedNode.parent.blackHeight = 0;
            rotate(addedRedNode, addedRedNode.parent);
            if (addedRedNode.parent == null) { // update root if needed
              this.root = addedRedNode;
            }
            return;
          } else { addedRedNode.parent.blackHeight = 1;
          addedRedNode.parent.parent.blackHeight = 0;
          rotate(addedRedNode.parent, addedRedNode.parent.parent);
          if (addedRedNode.parent.parent == null) { // update root if needed
            this.root = addedRedNode.parent;
          }
          return;
        }

      }

      else if (addedRedNode.parent.parent.rightChild.blackHeight == 1) { // if parents sibling is
                                                                         // BLACK

        if (!addedRedNode.isLeftChild()) { // if the added node is on the same side as parent's
                                           // sibling rotate so they are on opposite sides
          rotate(addedRedNode, addedRedNode.parent);
          didInitialRotate = true;
        }

        if (didInitialRotate) { // if we did rotate, then addedRedNode and parent rotate
          // color change before rotate
          addedRedNode.blackHeight = 1;
          addedRedNode.parent.blackHeight = 0;
          rotate(addedRedNode, addedRedNode.parent);

          if (addedRedNode.parent == null) { // update root if needed
            this.root = addedRedNode;
          }
          return;
        } else { // if we didn't rotate, then the parent and grandparent rotate
            // color change before rotate
            addedRedNode.parent.blackHeight = 1;
            addedRedNode.parent.parent.blackHeight = 0;
            rotate(addedRedNode.parent, addedRedNode.parent.parent); // rotate the parent and its
                                                                     // parent

            if (addedRedNode.parent.parent == null) {
              this.root = addedRedNode.parent;
            }

          }
          return;
        }

        else if (addedRedNode.parent.parent.rightChild.blackHeight == 0) { // if the parents sibling
                                                                           // is RED

          addedRedNode.parent.blackHeight = 1; // make parent black
          addedRedNode.parent.parent.blackHeight = 0; // make grandparent red
          addedRedNode.parent.parent.rightChild.blackHeight = 1; // make parent's sibling black

          if (addedRedNode.parent.parent.equals(root)) { // if the grandparent is the root, then set
                                                         // it black and we're done
            root.blackHeight = 1;
            return;
          }
          if (!addedRedNode.parent.parent.equals(root)) { // if, the grandparent is not, then we must
                                                          // go up the tree
            enforceRBTreePropertiesAfterInsert(addedRedNode.parent.parent);
            return;
          }


        }} else {
            if (addedRedNode.parent.parent.leftChild == null) { // if the parent has NO sibling
                // rotate if we need to
                if (addedRedNode.isLeftChild()) {
                  rotate(addedRedNode, addedRedNode.parent);
                  didInitialRotate = true;
                }
                if (didInitialRotate) {
                  addedRedNode.blackHeight = 1;
                  addedRedNode.parent.blackHeight = 0;
                  rotate(addedRedNode, addedRedNode.parent);
                  if (addedRedNode.parent == null) { // update root if needed
                    this.root = addedRedNode;
                  }
                  return;
                } else {
                  addedRedNode.parent.blackHeight = 1;
                  addedRedNode.parent.parent.blackHeight = 0;
                  rotate(addedRedNode.parent, addedRedNode.parent.parent);
                  if (addedRedNode.parent.parent == null) { // update root if needed
                    this.root = addedRedNode.parent;
                  }
                  return;
                }

              }else if (addedRedNode.parent.parent.leftChild.blackHeight == 1) { // if parents sibling is
                  // BLACK

if (addedRedNode.isLeftChild()) { // if the added node is on the same side as parent's
// sibling rotate so they are on opposite sides
rotate(addedRedNode, addedRedNode.parent);
didInitialRotate = true;
}

if (didInitialRotate) { // if we did rotate, then addedRedNode and parent rotate
// color change before rotate
addedRedNode.blackHeight = 1;
addedRedNode.parent.blackHeight = 0;
rotate(addedRedNode, addedRedNode.parent);

if (addedRedNode.parent == null) { // update root if needed
this.root = addedRedNode;
}
return;
} else { // if we didn't rotate, then the parent and grandparent rotate
// color change before rotate
addedRedNode.parent.blackHeight = 1;
addedRedNode.parent.parent.blackHeight = 0;
rotate(addedRedNode.parent, addedRedNode.parent.parent); // rotate the parent and its
             // parent

if (addedRedNode.parent.parent == null) {
this.root = addedRedNode.parent;
}

}
return;
}else if (addedRedNode.parent.parent.leftChild.blackHeight == 0) { // if the parents sibling
    // is RED

addedRedNode.parent.blackHeight = 1; // make parent black
addedRedNode.parent.parent.blackHeight = 0; // make grandparent red
addedRedNode.parent.parent.leftChild.blackHeight = 1; // make parent's sibling black

if (addedRedNode.parent.parent.equals(root)) { // if the grandparent is the root, then set
// it black and we're done
root.blackHeight = 1;
return;
}
if (!addedRedNode.parent.parent.equals(root)) { // if, the grandparent is not, then we must
// go up the tree
enforceRBTreePropertiesAfterInsert(addedRedNode.parent.parent);
return;
}


}

}

}/**
     * Get the size of the tree (its number of nodes).
     * 
     * @return the number of nodes in the tree
     */
    public int size() {
      
      return size;
    }

    /**
     * Method to check if the tree is empty (does not contain any node).
     * 
     * @return true of this.size() return 0, false if this.size() > 0
     */
    public boolean isEmpty() {
      return this.size() == 0;
    }
    /**
     * This method performs an inorder traversal of the tree. The string representations of each data
     * value within this tree are assembled into a comma separated string within brackets (similar to
     * many implementations of java.util.Collection, like java.util.ArrayList, LinkedList, etc). Note
     * that this RedBlackTree class implementation of toString generates an inorder traversal. The
     * toString of the Node class class above produces a level order traversal of the nodes / values
     * of the tree.
     * 
     * @return string containing the ordered values of this tree (in-order traversal)
     */
    public String toInOrderString() {
      // generate a string of all values of the tree in (ordered) in-order
      // traversal sequence
      StringBuffer sb = new StringBuffer();
      sb.append("[ ");
      sb.append(toInOrderStringHelper("", this.root));
      if (this.root != null) {
        sb.setLength(sb.length() - 2);
      }
      sb.append(" ]");
      return sb.toString();
    }
    /*
     * helper method for the toInOrderString()
     * @return the string needed
     */
    private String toInOrderStringHelper(String str, Node<IPlayer> node) {
      if (node == null) {
        return str;
      }
      str = toInOrderStringHelper(str, node.leftChild);
      str += (node.player.getName() + ", ");
      str = toInOrderStringHelper(str, node.rightChild);
      return str;
    }


  }