//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    LinkedBookshelfTester
// Course:   CS 300 Fall 2021
//
// Author:   Xiangyu Huang
// Email:    xhuang438@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:  Haixi Zhang
// Partner Email: hzhang845@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//    x Write-up states that pair programming is allowed for this assignment.
//    x We have both read and understand the course Pair Programming Policy.
//    x We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:      yunhao jiang
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Tester for LinkedBookshelf class and LinkedNode generic class
 * <p>
 * @author Huang Xiangyu
 * @author Haixi Zhang
 *
 */
public class LinkedBookshelfTester {

	/**
	 * tester for Linked Node generic class
	 * <p>
	 * @return true if the constructor, mutator, and accessor in 
	 * 		generic class LinkedNode is correct
	 */
    public static boolean testLinkedNode(){
    	LinkedNode<String> linkedNode1=new LinkedNode<String>("a");
    	LinkedNode<String> linkedNode2=new LinkedNode<String> ("b");
    	linkedNode1.setNext(linkedNode2);
    	if(linkedNode1.getNext()!=linkedNode2)
    		return false;
    	return true;
    }

    /**
     * tester for clear method in LinkedBookshelf class
     * <p>
     * @return true if the clear method is correct in LinkedBookshelf class
     */
    public static boolean testClear(){
        LinkedBookshelf test = new LinkedBookshelf();
        test.appendBook(new Book("CS 100", 123));
        test.appendBook(new Book("CS 200", 23435));
        //test for different constructor from the previous two
        test.appendBook(new Book("CS 400", 342, "Jesus", "Christ"));
        test.clear();
        if (test.size() != 0) {
          return false;
        }
        try {
          test.getFirst();
          return false;
        } catch (NullPointerException e) {

        } catch (Exception e) {
          return false;
        }

        try {
          test.getLast();
          return false;
        } catch (NullPointerException e) {

        } catch (Exception e) {
          return false;
        }
        return true;
    }

    /**
     * tester for appendBook method in LinkedBookshelf class
     * <p>
     * @return true if the appendBook method is correct in LinkedBookshelf class
     */
    public static boolean testAddBooks(){
    	LinkedBookshelf test = new LinkedBookshelf();
        Book.resetGenerator();
	      Book book1 = new Book("CS 100", 123, "Kevin", "Huang");
	      Book book2 = new Book("CS 200", 23435, "Hobbes", "Legault");
	      Book book3 = new Book("CS 300", 143, "Whatever", "Who");
	      Book book4 = new Book("CS 400", 342, "Jesus", "Christ");
        test.appendBook(book1);
        test.appendBook(book2);
        test.appendBook(book3);
        test.appendBook(book4);
        String expected =
            "ID\n" + book1.toString() + "\n" + book2.toString() + "\n" + book3.toString() + "\n"
                + book4.toString() + "\n";
        if (!test.toString().equals(expected) || test.size() != 4) {
          System.out.print(test.toString());
          return false;
        }
      return true;
    }

    /**
     * tester for sort method in LinkedBookshelf class
     * <p>
     * @return true if the sort method is correct in LinkedBookshelf class
     */
    public static boolean testSortBooks(){
    	
    	//case 1: sort by title
    	{
    		LinkedBookshelf test = new LinkedBookshelf();
    		Book.resetGenerator();
    		Book book1 = new Book("A", 123, "Kevin", "Huang");
    		Book book2 = new Book("C", 23435, "Hobbes", "Legault");
    		Book book3 = new Book("B", 143, "Whatever", "Who");
    		Book book4 = new Book("D", 342, "Jesus", "Christ");
    		test.appendBook(book1);
    		test.appendBook(book2);
    		test.appendBook(book3);
    		test.appendBook(book4);
    		
    		LinkedBookshelf.sort(test, Attribute.TITLE);
    		String expected =
    				"TITLE\n" + book1.toString() + "\n" + book3.toString() + "\n" + book2.toString() + "\n"
    				+ book4.toString() + "\n";
    		if (!test.toString().equals(expected)) 
    			return false;
    	}
    	
    	//case 2: sort by author
    	{
    		LinkedBookshelf test = new LinkedBookshelf();
    		Book.resetGenerator();
    		Book book1 = new Book("2001", 296, "Clarke", "Arthur C");
    		Book book2 = new Book("FEED", 608, "Grant", "Mira");
    		Book book3 = new Book("Good Omens", 143, "Gaimen", "Neil");
    		Book book4 = new Book("Snow Crash", 342, "Stephenson", "Neal");
    		test.appendBook(book1);
    		test.appendBook(book2);
    		test.appendBook(book3);
    		test.appendBook(book4);
    		
    		LinkedBookshelf.sort(test, Attribute.AUTHOR);
    		String expected =
    				"AUTHOR\n" + book1.toString() + "\n" + book3.toString() + "\n" + book2.toString() + "\n"
    				+ book4.toString() + "\n";
    		if (!test.toString().equals(expected))
    			return false;
    	}
    	
    	//case 3: sort by page count
    	{
    		LinkedBookshelf test = new LinkedBookshelf();
    		Book.resetGenerator();
    		Book book1 = new Book("CS 100", 123, "Kevin", "Huang");
    		Book book2 = new Book("CS 200", 23435, "Hobbes", "Legault");
    		Book book3 = new Book("CS 300", 143, "Whatever", "Who");
    		Book book4 = new Book("CS 400", 342, "Jesus", "Christ");
    		test.appendBook(book1);
    		test.appendBook(book2);
    		test.appendBook(book3);
    		test.appendBook(book4);
    		LinkedBookshelf.sort(test, Attribute.PAGECOUNT);
    		String expected =
    				"PAGECOUNT\n" + book1.toString() + "\n" + book3.toString() + "\n" + book4.toString()
    				+ "\n" + book2.toString() + "\n";
    		if (!test.toString().equals(expected)) 
    			return false;
    	}
    	
    	//case 4: sort by ID
    	{
    		LinkedBookshelf test = new LinkedBookshelf();
    		Book.resetGenerator();
    		Book book1 = new Book("2001", 296, "Clarke", "Arthur C");
    		Book book2 = new Book("FEED", 608, "Grant", "Mira");
    		Book book3 = new Book("Good Omens", 143, "Gaimen", "Neil");
    		Book book4 = new Book("Snow Crash", 342, "Stephenson", "Neal");
    		test.appendBook(book1);
    		test.appendBook(book2);
    		test.appendBook(book3);
    		test.appendBook(book4);
    		
    		LinkedBookshelf.sort(test, Attribute.ID);
    		String expected =
    				"ID\n" + book1.toString() + "\n" + book2.toString() + "\n" + book3.toString() + "\n"
    				+ book4.toString() + "\n";
    		if (!test.toString().equals(expected))
    			return false;
    	}
    	
    	return true;
    }

   /**
    * run all the tests
    * <p>
    * @return true if all four tests are passed
    */
    public static boolean runAllTests(){
    	return testLinkedNode() && testAddBooks() && testClear() && testSortBooks();
    }
    
    /**
     * print the test result
     * <p>
     * @param args input argument if any
     */
    public static void main(String[] args) {
    	System.out.println(runAllTests());
    }
}
