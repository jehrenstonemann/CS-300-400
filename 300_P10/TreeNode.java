	//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    TreeNode
// Course:   CS 300 Fall 2021
//
// Author:   Xiangyu Huang
// Email:    xhuang438@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: 
// Partner Email: 
// Partner Lecturer's Name: 
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//     Write-up states that pair programming is allowed for this assignment.
//     We have both read and understand the course Pair Programming Policy.
//     We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * generic binary tree
 * <p>
 * @author Huang Xiangyu
 * @param <T> type in the tree node
 */
public class TreeNode<T> extends Object {
	
  private T data;  // the data contained in this node
  private TreeNode<T> left;  // the left child of this node
  private TreeNode<T> right;  // the right child of this node
	
  /**
   * Constructs a node with the given data and no children
   * <p>
   * @param data the data to be contained in this node
   */
  public TreeNode(T data) {
    this.data = data;
  }
	
  /**
   * Constructs a node with the given data and children
   * <p>
   * @param data the data to be contained in this node
   * @param left the left child of this node, may be null
   * @param right the right child of this node, may be null
   */
  public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
    this.data = data;
	this.left = left;
	this.right = right;
  }
	
  /**
   * Accessor for the data contained in the node
   * <p>
   * @return the data contained in the node
   */
  public T getData() {
    return data;
  }
	
  /**
   * Accessor for the left child of the node
   * <p>
   * @return a reference to the left child of this node
   */
  public TreeNode<T> getLeft(){
    return left;
  }
	
  /**
   * Accessor for the right child of the node
   * <p>
   * @return a reference to the right child of this node
   */
  public TreeNode<T> getRight(){
	return right;
  }
	
  /**
   * Change the left child reference of this node; may be null
   * <p>
   * @param left the new left child reference
   */
  public void setLeft(TreeNode<T> left) {
    this.left = left;
  }
	
  /**
   * Change the right child reference of this node; may be null
   * <p>
   * @param right the new right child reference
   */
  public void setRight(TreeNode<T> right) {
	this.right = right;
  }
	
  /**
   * Returns a string representation of this node's data
   * <p>
   * @return a string representation of this node's data
   */
  @Override
  public String toString() {
	return data.toString();
  }
}
