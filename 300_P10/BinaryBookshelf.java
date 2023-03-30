//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    BinaryBookshelf
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
// Persons:      Zhang Haixi
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;

/**
 * defines the methods and behaviors of this binary bookshelf
 * <p>
 * @author Huang Xiangyu
 *
 */
public class BinaryBookshelf {
	
  private TreeNode<Book> root;  // The root node of the BST
  private int size;  // The number of nodes currently contained in the BST
  private Attribute[] sortList;  // The ordered array of attributes by 
  								 //which the BST nodes are sorted
	
  /**
   * One-argument constructor, initializes an empty BinaryBookshelf
   * <p>
   * @param sortList an ordered array of Attributes, 
   * 		must begin with AUTHOR and contain exactly 
   * 		one copy of each Attribute in the enum
   * @throws IllegalArgumentException  if the sortList argument is 
   * 		not a four-element array of unique attributes,
   * 		beginning with Attribute.AUTHOR
   */
  public BinaryBookshelf(Attribute[] sortList) {
    // throw exception if not a four-element and begin with author
    if (sortList == null || sortList.length < 4) {
      throw new IllegalArgumentException();
    }
    if (!sortList[0].equals(Attribute.AUTHOR)) {
      throw new IllegalArgumentException();
    }
    // TITLE, AUTHOR, PAGECOUNT, ID
    int titleNum = 0;
    int authorNum = 0;
    int pageCountNum = 0;
    int idNum = 0;
    for (Attribute attribute : sortList) {
      if (attribute.equals(Attribute.AUTHOR))
        authorNum++;
      if (attribute.equals(Attribute.ID))
        idNum++;
      if (attribute.equals(Attribute.TITLE))
        titleNum++;
      if (attribute.equals(Attribute.PAGECOUNT))
        pageCountNum++;
    }
    if (sortList.length == 4 && titleNum != 1 
      || authorNum != 1 || pageCountNum != 1
      || idNum != 1) {
      throw new IllegalArgumentException();
    }
    
    //initialize a sortList
    this.sortList = sortList;
  }
	
  /**
   * Get the number of nodes currently in the BST
   * O(1)
   * <p>
   * @return the number of nodes currently in the BST
   */
  public int size() {
    return size;
  }
	
  /**
   * Determine whether the BST is empty
   * O(1)
   * <p>
   * @return true if the BST is empty, false otherwise
   */
  public boolean isEmpty() {
	return size == 0;
  }
	
  /**
   * provides a String-formatted list of the attributes 
   * 	in the order in which they are used
   * <p>
   * @return a String-formatted list of the sorting attributes
   */
  public String getAttributeOrder() {
    String result = "";
    int i = 1;
    for (Attribute attribute : sortList) {
      result += i + ":" + attribute;
      if (!attribute.equals(sortList[sortList.length - 1])) {
        result += " ";
      }
      i++;
    }
    return result;
  }
	
  /**
   * Searches for the input book in the bookshelf.
   * O(logN)
   * <p>
   * @param book the book to search for
   * @return true if the book is present in the shelf, false otherwise
   */
  public boolean contains(Book book) {
    return containsHelper(book, root);
  }
	
  /**
   * Recursive helper method; searches for the input book 
   * 	in the subtree rooted at current
   * <p>
   * @param book the query book to search for
   * @param current the root of the current subtree
   * @return true if the book is contained in this subtree, false otherwise
   */
  protected boolean containsHelper(Book book, TreeNode<Book> current) {
    // base case:
	if(current == null)
	  return false;
	if(current.getData() == book)
	  return true;
	//recursive case
	if(compareToHelper(current.getData(),book)<0)
	  return containsHelper(book,current.getRight());
	if(compareToHelper(current.getData(),book)>0)
	  return containsHelper(book,current.getLeft());
    return true;
  }
	
  /**
   * helper method to compare two Book objects according to the sortList of attributes. 
   * 		Uses both equals() and compareTo() from the Book class
   * <p>
   * @param one the first Book
   * @param two the second Book
   * @return a negative value if one < two, a positive value if one > two, 
   *     and 0 if they are equal
   */
  protected int compareToHelper (Book one, Book two) {
    int result = 0;
    if(one.equals(two))
      return result;
    for(int i=0;i<sortList.length;i++) {
    	if(one.compareTo(two, sortList[i])<0){
    	  result=-1;
    	  break;
    	}
    	if(one.compareTo(two, sortList[i])>0){
    	  result=1;
      	  break;
    	}
    }
    return result;
  }
	
  /**
   * returns a list of books in the bookshelf written by the given author
   * <p>
   * @param authorName the author name to filter on
   * @return a list of books by the author
   */
  public ArrayList<Book> getBooksByAuthor (String authorName){
    return getBooksByAuthorHelper(authorName,root);
  }
	
  /**
   * Recursive helper method; returns a list of books in the subtree rooted at 
   * 		current which were written by the given author
   * <p>
   * @param authorName the author name to filter on
   * @param current the root of the current subtree
   * @return a list of books by the author in the current subtree
   */
  protected ArrayList<Book> getBooksByAuthorHelper (String authorName, TreeNode<Book> current){
    ArrayList<Book> result = new ArrayList<Book>();
    if(isEmpty())
      return result;
    if(current.getLeft()!=null)
      result.addAll(getBooksByAuthorHelper(authorName,current.getLeft()));
    if(current.getData().getAuthor().equals(authorName))
      result.add(current.getData());
    if(current.getRight()!=null)
      result.addAll(getBooksByAuthorHelper(authorName,current.getRight()));
    return result;
  }
	
  /**
   * Creates and returns an in-order traversal of the BST,
   * 		with each Book on a separate line
   * O(N)
   * <p>
   * @return an in-order traversal of the BST, with each Book on a separate line
   */
  @Override
  public String toString() {
    return toStringHelper(root);
  }
	
  /**
   * Recursive helper method; creates and returns the 
   * 		String representation of the subtree rooted at the current node
   * <p>
   * @param current the root of the current subtree
   * @return the string representation of this subtree
   */
  protected String toStringHelper (TreeNode<Book> current) {
    String s = "";
	if(current != null){
	  s+= toStringHelper(current.getLeft());
	  s+= current.getData().toString()+"\n";
	  s+= toStringHelper(current.getRight());
	}
	return s;
  }
	
  /**
   * returns a shallow copy of the root node so that 
   * 	test tree structures may be constructed manually rather 
   * 	than by using the insertBook() method
   * <p>
   * @return a reference to the current root node
   */
  protected TreeNode<Book> getRoot (){
    return root;
  }
	
  /**
   * Resets the BST to be empty
   */
  public void clear() {
    root = null;
    size = 0;
    sortList=null;
  }
	
  /**
   * Adds a new Book to the BST in sorted order, 
   * 	relative to this BST's sortList attributes
   * <p>
   * @param book the Book object to be added to the BST
   * @throws IllegalArgumentException if this Book is already in the BST
   */
  public void insertBook (Book book) {
	if(contains(book))
	  throw new IllegalArgumentException();
	if(root ==null) {
	  root = new TreeNode<Book>(book);
	  size++;
	}
	else {
      insertBookHelper(book, root);
      size++;
	}
  }
	
  /**
   * Recursive helper method; adds the given Book to the subtree rooted at current.
   * <p>
   * @param book the Book object to be added to the BST
   * @param current the root of the current subtree
   * @throws IllegalArgumentException if this Book is already in the BST
   */
  protected void insertBookHelper (Book book, TreeNode<Book> current) {
    if(compareToHelper(book,current.getData())<0) {
	  if(current.getLeft()==null) {
	    current.setLeft(new TreeNode<Book> (book));
	  }else {
	    insertBookHelper(book, current.getLeft());
	  }
    }
    else if(compareToHelper(book,current.getData())>0) {
      if(current.getRight()==null) {
        current.setRight(new TreeNode<Book> (book)); 
  	  }else {
  	    insertBookHelper(book, current.getRight());
  	  }
    }else {
      throw new IllegalArgumentException();
    }
  }
}
