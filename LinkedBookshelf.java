//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    LinkedBookshelf
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
// Persons: Pranav,  yunhao jiang
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * methods and behavior of a linked bookshelf
 * <p>
 * @author Huang Xiangyu
 * @author Haixi Zhang
 *
 */
public class LinkedBookshelf {

    private  LinkedNode<Book> front; // front node
    private  LinkedNode<Book> back;	// last node
    private  int size = 0;			// size of the list
    private  Attribute sortedBy;	// defines sorted by which 
    								// criteria (ID, author, pagecount, title)

    /**
     * constructor of a linked bookshelf
     */
    public LinkedBookshelf() {
        front = null;
        back = null;
        size = 0;
        sortedBy = Attribute.ID;
    }

    /**
     * getter of the size of the list(bookshelf)
     * <p>
     * @return size of the list(bookshelf)
     */
    public int size(){
        return size;
    }

    /**
     * whether the bookshelf is empty or not
     * <p>
     * @return true if it is empty
     */
    public boolean isEmpty(){
    	return size == 0;
    }

    /**
     * override the toString method
     */
    @Override
    public String toString(){
        String result = sortedBy.toString() + "\n";
        for (int i = 0; i < size; i++) {
          result += getNode(i).toString() + "\n";
        }
        return result;
    }

    /**
     * get the node at a specific index in the bookshelf
     * <p>
     * @param index the index in the bookshelf
     * @return the node at this index
     */
    public LinkedNode<Book> getNode(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if(size == 0) {
        	return null;
        }
        LinkedNode<Book> linkedNode = front;
        for(int i = 0;i < index; i++){
        	linkedNode = linkedNode.getNext();
        }
        return linkedNode;
    }

    /**
     * get the Book object at this node at this index
     * <p>
     * @param index the index in the list
     * @return a Book object stored at this node at this index
     */
    public Book get(int index){
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Wrong index");
          }
        return getNode(index).getData();
    }

    /**
     * get the first node Book object
     * <p>
     * @return the Book object stored in the first node
     */
    public Book getFirst(){
        return front.getData();
    }

    /**
     * get the last node Book object
     * <p>
     * @return the Book object stored in the first node
     */
    public Book getLast(){
        return back.getData();
    }

    /**
     * clear all the contents in the bookshelf
     */
    public void clear(){
        size=0;
        front = null;
        back = null;
    }

    /**
     * add a Book Object to the bookshelf
     * <p>
     * @param toAdd a book object to add into the bookshelf
     */
    public void appendBook(Book toAdd){
        if (front == null) {
            front = new LinkedNode<Book>(toAdd);
            back = front;
        } else {
            back.setNext(new LinkedNode<Book>(toAdd));
            back = this.back.getNext();
        }
        size++;
    }

    /**
     * insert a Book Object to the bookshelf
     * referenced to Pranav's work
     * <p>
     * @param toAdda book object to insert into the bookshelf
     */
    public void insertBook(Book toAdd){
    	LinkedNode<Book> current = front;
    	LinkedNode<Book> a = new LinkedNode<Book>(toAdd);
    	if(current!=null) {
    		if(current.getData().compareTo(toAdd,sortedBy)>0) {
    			a.setNext(current);
    			if(current==front) {
    				front=a;
    			}
    			size++;
    			return;
    		}
    		else if(current.getNext()==null && current.getData().compareTo(toAdd,sortedBy)<0) {
    			current.setNext(a);
    			back =a;
    			size++;
    			return;
    		}
    	}
    	if(current.getNext()==null) {
    		current.setNext(a);
    		back = a;
    		size++;
    	}
    	while(current.getNext()!=null) {
    		if(current.getNext().getData().compareTo(toAdd,sortedBy)<0) {
    			current = current.getNext();
    		}else {
    			a.setNext(current.getNext());
    			current.setNext(a);
    			size++;
    			break;
    		}
    	}
    }

    /**
     * sort all the books by defined attribute in the bookshelf
     * <p>
     * @param b the bookshelf
     * @param sortedBy the criteria(ID, author, page count, or title)
     */
    public static void sort(LinkedBookshelf b, Attribute sortedBy){
        b.sortedBy = sortedBy;
        if (!(b.size() == 0 || b.size() == 1)) {
          LinkedNode<Book> current = b.front.getNext();
          b.front.setNext(null);
          while (current != null) {
            b.insertBook(current.getData());
            b.size--;
            current = current.getNext();
          }
        }
    }

}
