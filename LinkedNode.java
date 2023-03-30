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
// Persons:      NONE
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * define the behavior and methods for a singly linked list
 * <p>
 * @author Huang Xiangyu
 * @author Haixi Zhang
 *
 * @param <T> an object
 */
public class LinkedNode<T> {

    private T data; //data stored in each node
    private LinkedNode<T> next; //next node

   /**
    * Constructor for the linked node
    * <p>
    * @param data data stored in the node
    */
   public LinkedNode(T data){
        this.data=data;
    }

   /**
    * Constructor for the linked node
    * <p>
    * @param data data stored in the node
    * @param next next node
    */
    public LinkedNode(T data, LinkedNode<T> next){
        this.data=data;
        this.next=next;
    }

    /**
     * get the next node
     * <p>
     * @return the next node
     */
    public LinkedNode<T> getNext(){
       return next;
    }

    /**
     * get the data stored
     * <p>
     * @return data stored
     */
    public T getData(){
       return data;
    }

    /**
     * override the toString method for a node
     */
    @Override
    public String toString(){
       return data.toString();
    }

    /**
     * set the next node
     * <p>
     * @param next the next node
     */
    public void setNext(LinkedNode<T> next){
       this.next=next;
    }

}
