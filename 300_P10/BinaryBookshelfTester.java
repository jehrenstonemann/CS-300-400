//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    BinaryBookshelfTester
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
// Persons:      NONE
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Tester for BinaryBookshelf class
 * <p>
 * @author Huang Xiangyu
 *
 */
public class BinaryBookshelfTester {
  
  /**
   * test whether generic class TreeNode is correct in implementation
   * <p>
   * @return true if it is correct
   */
  public static boolean testTreeNode() {
    // case 1: a single TreeNode with no children
	TreeNode<Integer> testCaseOne = new TreeNode<Integer>(0);
	if (testCaseOne.getLeft() != null || testCaseOne.getRight() != null) {
      System.out.println("case 1 Error");
	  return false;
	}
	if (testCaseOne.getData()!=0) {
	  System.out.println("case 1 Error");
	  return false;
	}
	if (!testCaseOne.toString().equals("0")) {
	  System.out.println("case 1 Error");
	  return false;
	}
	
	// case 2: a simple collection of TreeNodes, including only set right child 
	// or only left child to be null
	TreeNode<Integer> testCaseTwo1 = new TreeNode<Integer>(0);
	TreeNode<Integer> testCaseTwo2 = new TreeNode<Integer>(10);
	testCaseTwo1.setLeft(testCaseTwo2);
    if (testCaseTwo1.getLeft() == null || testCaseTwo1.getRight() != null) {
      System.out.println("case 2 Error");
      return false;
    }
    testCaseTwo1.setLeft(null);
    if (testCaseTwo1.getLeft() != null) {
      return false;
    }
    
	// case 3: multiple-arg constructor
    TreeNode<Integer> testCaseThree1 = new TreeNode<Integer>(0);
	TreeNode<Integer> testCaseThree2 = new TreeNode<Integer>(10);
	TreeNode<Integer> testCaseThree3 = 
			new TreeNode<Integer>(100, testCaseThree1, testCaseThree2);
	if (!testCaseThree1.equals(testCaseThree3.getLeft())) {
      System.out.println("case 3 Error");
	  return false;
	}
	if (!testCaseThree2.equals(testCaseThree3.getRight())) {
	  System.out.println("case 3 Error");
	  return false;
	}
    return true;
  }
  
  /**
   * test whether basic methods of a BinaryBookshelf are valid, before any Books have
   * 	been added to the shelf
   * <p>
   * @return true if it is correct
   */
  public static boolean testEmptyTree() {
	// case 1: invalid constructor inputs
	try {
	  BinaryBookshelf test = new BinaryBookshelf(new Attribute[0]);
	  return false;
	}catch(IllegalArgumentException e) {
	  
	}
	try {
	  Attribute[] testList = new Attribute[2];
	  BinaryBookshelf test = new BinaryBookshelf(testList);
	  return false;
	}catch(IllegalArgumentException e) {
		
	}
	try {
	  Attribute[] testList = new Attribute[4];
	  testList[0] = Attribute.AUTHOR;
	  testList[1] = Attribute.AUTHOR;
	  testList[2] = Attribute.ID;
	  testList[3] = Attribute.PAGECOUNT;
	  BinaryBookshelf test = new BinaryBookshelf(testList);
	  return false;
	}catch(IllegalArgumentException e) {
	  
	}
	try {
	  Attribute[] testList = new Attribute[4];
	  testList[0] = Attribute.ID;
	  testList[1] = Attribute.AUTHOR;
	  testList[2] = Attribute.TITLE;
	  testList[3] = Attribute.PAGECOUNT;
	  BinaryBookshelf test = new BinaryBookshelf(testList);
	  return false;
	}catch(IllegalArgumentException e) {
	  
	}
	// case 2: valid input
	Attribute[] test = new Attribute[4];
	test[0] = Attribute.AUTHOR;
	test[1] = Attribute.ID;
	test[2] = Attribute.PAGECOUNT;
	test[3] = Attribute.TITLE;
    BinaryBookshelf binaryBookshelfTest = new BinaryBookshelf(test);
    if (binaryBookshelfTest.size() != 0) {
      System.out.println("case 2 Error");
      return false;
    }
    if (binaryBookshelfTest.isEmpty() != true) {
      System.out.println("case 2 Error"); 
      return false;
    }
    if (!binaryBookshelfTest.toString().equals("")) {
      System.out.println("case 2 Error");
      return false;
    }
    if (binaryBookshelfTest.getRoot() != null) {
      System.out.println("case 2 Error");
      return false;
    }
    if (!binaryBookshelfTest.getAttributeOrder()
    		.equals("1:AUTHOR 2:ID 3:PAGECOUNT 4:TITLE")) {
      System.out.println("case 2 Error");
      return false;
    }
    if (binaryBookshelfTest.contains(new Book("BookName", 1))) {
      System.out.println("case 2 Error");
      return false;
    }

    if (binaryBookshelfTest.getBooksByAuthor("AuthorName").size() != 0) {
      System.out.println("case 2 Error");
      return false;
    }
    return true;
  }
  
  /**
   * test whether the BinaryBookshelf insertBook() method works as expected
   * <p>
   * @return true if it is working as expected
   */
  public static boolean testInsertBook() {
	try {
	  // case 1: inserting into an empty tree
      Attribute[] test = new Attribute[4];
	  test[0] = Attribute.AUTHOR;
	  test[1] = Attribute.TITLE;
	  test[2] = Attribute.PAGECOUNT;
	  test[3] = Attribute.ID;
      BinaryBookshelf binaryBookshelfTest = new BinaryBookshelf(test);
      Book bookTest = new Book("The Fellowship of the Ring",10,"Tolkien","JRR");
      binaryBookshelfTest.insertBook(bookTest);
      if(binaryBookshelfTest.size()!=1)
        return false;
      if(binaryBookshelfTest.getRoot()==null)
        return false;
      if(binaryBookshelfTest.isEmpty())
        return false;
      if(binaryBookshelfTest.getRoot().getData()!=bookTest)
        return false;
    
	  // case 2: inserting a unique, smaller value into a non-empty tree
      Book bookTest2 = new Book("ABC",10,"LeGuin","Ursula");
      binaryBookshelfTest.insertBook(bookTest2);
      if(binaryBookshelfTest.size()!=2)
        return false;
      if(binaryBookshelfTest.getRoot().getLeft().getData()!=bookTest2)
        return false;
    
	  // case 3: inserting a value with a shared author attribute
	  Book bookTest3 = new Book("The Two Towers",10,"Tolkien","JRR");
	  binaryBookshelfTest.insertBook(bookTest3);
	  if(binaryBookshelfTest.size()!=3)
		return false;
      if(binaryBookshelfTest.getRoot().getRight().getData()!=bookTest3)
        return false;
    
	  // case 4: inserting a duplicate value
      try {
	    binaryBookshelfTest.insertBook(bookTest3);
	    return false;
      }catch(IllegalArgumentException e) {
      
      }
    }catch(Exception e) {
      return false;
    }
    return true;
  }
  
  /**
   * test whether the BinaryBookshelf contains() method works as expected
   * <p>
   * @return true if it is working as expected
   */
  public static boolean testContains() {
	// case 1: non-recursive case
    Attribute[] test = new Attribute[4];
	test[0] = Attribute.AUTHOR;
	test[1] = Attribute.TITLE;
	test[2] = Attribute.PAGECOUNT;
	test[3] = Attribute.ID;
    BinaryBookshelf binaryBookshelfTest = new BinaryBookshelf(test);
    Book bookTest = new Book("Good Omens", 288, "Gaiman", "Neil");
    binaryBookshelfTest.insertBook(bookTest);
    if(!binaryBookshelfTest.contains(bookTest))
      return false;
    Book bookTest2 = new Book("ABC",10,"AB","C");
    if(binaryBookshelfTest.contains(bookTest2))
      return false;
    
	// case 2: recursive case
    BinaryBookshelf binaryBookshelfTest2 = new BinaryBookshelf(test);
    binaryBookshelfTest2.insertBook(new Book("Good Omens", 288, "Gaiman", "Neil"));
    TreeNode<Book> book2 = 
    		new TreeNode<Book>(new Book("FEED", 608, "Grant", "Mira"));
    TreeNode<Book> book3 = 
    		new TreeNode<Book>(new Book("Snow Crash", 468, "Stephenson", "Neal"));
    TreeNode<Book> book4 = 
    		new TreeNode<Book>(new Book("2001", 296, "Clarke", "Arthur C"));
    TreeNode<Book> book5 = 
    		new TreeNode<Book>(new Book("3002", 200, "Clarke", "Arthur C"));
    TreeNode<Book> book6 = 
    		new TreeNode<Book>(new Book("ABC", 1, "A", "BC")); // not added in bookshelf
    binaryBookshelfTest2.getRoot().setLeft(book4);
    binaryBookshelfTest2.getRoot().setRight(book2);
    book4.setRight(book5);
    book2.setRight(book3);
    if(!binaryBookshelfTest2.contains(binaryBookshelfTest2.getRoot().getData()))
      return false;
    if(!binaryBookshelfTest2.contains(book5.getData()))
      return false;
    if(!binaryBookshelfTest2.contains(book4.getData()))
      return false;
    if(binaryBookshelfTest2.contains(book6.getData()))
      return false;
	return true;
  }
  
  /**
   * test whether the BinaryBookshelf getBooksByAuthor() method 
   * 	works as expected
   * <p>
   * @return true if it is working as expected
   */
  public static boolean testGetBooksByAuthor() {
	// case 1: non-recursive case
	Attribute[] test = new Attribute[4];
	test[0] = Attribute.AUTHOR;
	test[1] = Attribute.TITLE;
	test[2] = Attribute.PAGECOUNT;
	test[3] = Attribute.ID;
    BinaryBookshelf binaryBookshelfTest = new BinaryBookshelf(test);
    Book bookTest = new Book("Good Omens", 288, "Gaiman", "Neil");
    binaryBookshelfTest.insertBook(bookTest);
    if(binaryBookshelfTest.getBooksByAuthor("Gaiman, Neil").size()!=1)
      return false;
    if(binaryBookshelfTest.getBooksByAuthor("A, AD").size()!=0)
      return false;
	// case 2: recursive case
    BinaryBookshelf binaryBookshelfTest2 = new BinaryBookshelf(test);
    binaryBookshelfTest2.insertBook(new Book("Good Omens", 288, "Gaiman", "Neil"));
    TreeNode<Book> book2 = 
    		new TreeNode<Book>(new Book("FEED", 608, "Grant", "Mira"));
    TreeNode<Book> book3 = 
    		new TreeNode<Book>(new Book("Snow Crash", 468, "Stephenson", "Neal"));
    TreeNode<Book> book4 = 
    		new TreeNode<Book>(new Book("2001", 296, "Clarke", "Arthur C"));
    TreeNode<Book> book5 = 
    		new TreeNode<Book>(new Book("3002", 200, "Clarke", "Arthur C"));
    binaryBookshelfTest2.getRoot().setLeft(book4);
    binaryBookshelfTest2.getRoot().setRight(book2);
    book4.setRight(book5);
    book2.setRight(book3);
    if(binaryBookshelfTest2.getBooksByAuthor("Gaiman, Neil").size()!=1)
      return false;
    if(binaryBookshelfTest2.getBooksByAuthor("Clarke, Arthur C").size()!=2)
      return false;
    if(binaryBookshelfTest2.getBooksByAuthor("Huang, Xiangyu").size()!=0)
      return false;
	return true;
  }
  
  /**
   * see whether all the tests are passed
   * <p>
   * @return true if all the tests are passed
   */
  public static boolean runAllTests() {
    return testTreeNode()&&testEmptyTree()&&testInsertBook()
			  &&testContains()&&testGetBooksByAuthor();
  }
  
  /**
   * see whether all the tests are passed
   * <p>
   * @param args input argument is any
   */
  public static void main(String[] args) {
    System.out.println(runAllTests());
  }
}
