//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    AssignmentQueue
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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Array-based heap implementation of a priority queue containing Assignments. Guarantees the
 * min-heap invariant, so that the Assignment at the root should have the earliest due date, and
 * children always have a due date after or at the same time as their parent. The root of a
 * non-empty queue is always at index 0 of this array-heap.
 */
public class AssignmentQueue implements PriorityQueueADT<Assignment>, Iterable<Assignment> {
  private Assignment[] queue; // array min-heap of assignments representing this priority queue
  private int size; // size of this priority queue


  /**
   * Creates a new empty AssignmentQueue with the given capacity
   * 
   * @param capacity Capacity of this AssignmentQueue
   * @throws IllegalArgumentException with a descriptive error message if the capacity is not a
   *                                  positive integer
   */
  public AssignmentQueue(int capacity) {
	if(capacity <= 0)
      throw new IllegalArgumentException("capacity is not a positive integer");
	size=0;
	queue = new Assignment[capacity];
    
  }

  /**
   * Checks whether this AssignmentQueue is empty
   * 
   * @return {@code true} if this AssignmentQueue is empty
   */
  @Override
  public boolean isEmpty() {
    return size==0;
  }

  /**
   * Returns the size of this AssignmentQueue
   * 
   * @return the size of this AssignmentQueue
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Returns the capacity of this AssignmentQueue
   * 
   * @return the capacity of this AssignmentQueue
   */
  public int capacity() {
    return queue.length;
  }
  
  
  /**
   * Removes all elements from this AssignmentQueue
   */
  @Override
  public void clear() {
	for(int i=0;i<queue.length;i++) {
	  queue[i]=null;
	}
	size=0;
  }
  
  /**
   * Returns the Assignment at the root of this AssignmentQueue, i.e. the Assignment with the
   * earliest due date.
   * 
   * @return the Assignment in this AssignmentQueue with the earliest due date
   * @throws NoSuchElementException if this AssignmentQueue is empty
   */
  @Override
  public Assignment peek() {
    if(isEmpty())
      throw new NoSuchElementException();
    return queue[0];
  }


  /**
   * Adds the given Assignment to this AssignmentQueue at the correct position based on the min-heap
   * ordering. This queue should maintain the min-heap invariant, so that the Assignment at each
   * index has an earlier or equivalent due-date than the Assignments in its child nodes.
   * Assignments should be compared using the Assignment.compareTo() method.
   * 
   * @param e Assignment to add to this AssignmentQueue
   * @throws NullPointerException  if the given Assignment is null
   * @throws IllegalStateException with a descriptive error message if this AssignmentQueue is full
   */
  @Override
  public void enqueue(Assignment e) {
	if(e==null)
	  throw new NullPointerException();
	if(size()==capacity())
	  throw new IllegalStateException("Assignment Queue already full");
    // add the new data to the end of the array
    queue[size]=e;
    // percolate up if array was not empty
    percolateUp(size);
    size++;
  }

  /**
   * Removes and returns the Assignment at the root of this AssignmentQueue, i.e. the Assignment
   * with the earliest due date.
   * 
   * @return the Assignment in this AssignmentQueue with the earliest due date
   * @throws NoSuchElementException with a descriptive error message if this AssignmentQueue is
   *                                empty
   */
  @Override
  public Assignment dequeue() {
    if(isEmpty())
      throw new NoSuchElementException("Queue is empty");
    // get the root value
    Assignment best = queue[0];
    // replace root with last leaf
    if(size>1) {
      queue[0] = queue[size-1];
      queue[size-1]=null;
    }
    else {
      size--;
      return queue[0];
    }
    // percolate down
    percolateDown(0);
    size--;
    return best;
  }

  /**
   * Recursive implementation of percolateDown() method. Restores the min-heap invariant of a given
   * subtree by percolating its root down the tree. If the element at the given index does not
   * violate the min-heap invariant (it is due before its children), then this method does not
   * modify the heap. Otherwise, if there is a heap violation, then swap the element with the
   * correct child and continue percolating the element down the heap.
   * 
   * @param i index of the element in the heap to percolate downwards
   * @throws IndexOutOfBoundsException if index is out of bounds - do not catch the exception
   */
  protected void percolateDown(int i) {
    // provide the worst-case runtime complexity of this method assuming that the problem size
    // N is the size of this queue
    // Time complexity: O(logN)
    int left = 2*i+1;
    int right = 2*i+2;
    Assignment leftChild=null;
    Assignment rightChild = null;
    if (left < capacity()) {
      leftChild = queue[left];
    }
    if (right < capacity()) {
      rightChild = queue[right];
    }
    Assignment current=queue[i];
    Assignment newChild;
    int parent;
    if(leftChild !=null&&rightChild!=null) {
      if(leftChild.compareTo(rightChild)<=0) {
    	newChild=leftChild;
    	parent=left;
      }
      else {
    	newChild=rightChild;
    	parent=right;
      }
      if(current.compareTo(newChild)>0) {
    	// swap current with parent
        Assignment temp = queue[i];
        queue[i] = queue[parent];
        queue[parent] = temp;
        // then percolate down repeatedly
        percolateDown(parent);
      }
    } 
    else if (leftChild != null && rightChild == null) {
      if (current.compareTo(leftChild) > 0) {
    	// swap current with left child
        Assignment temp = queue[i];
        queue[i] = queue[left];
        queue[left] = temp;
        // then percolate down repeatedly
        percolateDown(left);
      }
    } else if (leftChild == null && rightChild != null) {
      if (current.compareTo(rightChild) > 0) {
    	// swap current with right child
        Assignment temp = queue[i];
        queue[i] = queue[right];
        queue[right] = temp;
        // then percolate down repeatedly
        percolateDown(right);
      }
    }
  }

  /**
   * Recursive implementation of percolateUp() method. Restores the min-heap invariant of the tree
   * by percolating a leaf up the tree. If the element at the given index does not violate the
   * min-heap invariant (it occurs after its parent), then this method does not modify the heap.
   * Otherwise, if there is a heap violation, swap the element with its parent and continue
   * percolating the element up the heap.
   * 
   * @param i index of the element in the heap to percolate upwards
   * @throws IndexOutOfBoundsException if index is out of bounds - do not catch the exception
   */
  protected void percolateUp(int i) {
    // provide the worst-case runtime complexity of this method assuming that the problem size
    // N is the size of this queue
    // Time complexity: O(logN)
	// parent index
	Assignment current = queue[i];
	int parentIndex = (i - 1) / 2;
	Assignment parent=queue[parentIndex];
	if (current.compareTo(parent)<0) {
      queue[i] = parent;
      queue[parentIndex] = current;
	  percolateUp(parentIndex);
	}
  }
  
  /**
   * Returns a deep copy of this AssignmentQueue containing all of its elements in the same order.
   * This method does not return the deepest copy, meaning that you do not need to duplicate 
   * assignments. Only the instance of the heap (including the array and its size) will be duplicated.
   * 
   * @return a deep copy of this AssignmentQueue. The returned new assignment queue has the same
   *         length and size as this queue.
   */
  public AssignmentQueue deepCopy() {
    AssignmentQueue result = new AssignmentQueue(capacity());
    Assignment[] temp = new Assignment[capacity()];
    for(int i=0;i<capacity();i++) {
    	temp[i]=queue[i];
    }
    result.queue=temp;
    result.size=this.size;
    return result;
  }

  /**
   * Returns a String representing this AssignmentQueue, where each element (assignment) of the
   * queue is listed on a separate line, in order from earliest to latest.
   * 
   * @see Assignment#toString()
   * @see AssignmentIterator
   * @return a String representing this AssignmentQueue
   */
  public String toString() {
    StringBuilder val = new StringBuilder();

    for (Assignment a : this) {
      val.append(a).append("\n");
    }

    return val.toString();
  }

  /**
   * Returns an Iterator for this AssignmentQueue which proceeds from the earliest to the latest
   * Assignment in the queue.
   * 
   * @see AssignmentIterator
   * @return an Iterator for this AssignmentQueue
   */
  @Override
  public Iterator<Assignment> iterator() {
    return new AssignmentIterator(this);
  }
}