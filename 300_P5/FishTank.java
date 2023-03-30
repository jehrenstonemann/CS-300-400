//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    FishTank behavior (contain main method)
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
//    Write-up states that pair programming is allowed for this assignment.
//    We have both read and understand the course Pair Programming Policy.
//    We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: Haixi Zhang  
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * it contains the methods related to all the interactive objects in fish tanks 
 * and also the main methods
 * <p>
 * @author Huang Xiangyu
 *
 */
public class FishTank extends PApplet{
	private PImage backgroundImage; // PImage object which represents the background image
	protected ArrayList<TankListener> objects; // list storing interactive objects
	protected Random randGen; // Generator of random numbers
	
	/**
	 * This main method starts the application
	 * <p>
	 * @param args input arguments if any
	 */
	public static void main(String[] args) {
		PApplet.main("FishTank"); 
	}
	
	/**
	 * sets the size of this PApplet to 800 width x 600 height
	 */
	@Override
	public void settings() {
	  size(800, 600);
	}

	/**
	 * Defines initial environment properties such as screen size and
	 * loads the background image and fonts as the program starts.
	 * It also initializes all data fields.
	 */
	@Override
	public void setup() {
		// Set and display the title of the display window
		this.getSurface().setTitle("Fish Tank 3000");
		
	    // Set the location from which images are drawn to CENTER
	    this.imageMode(PApplet.CENTER);
	    
	    // Set the location from which rectangles are drawn.
	    this.rectMode(PApplet.CORNERS);
	    // rectMode(CORNERS) interprets the first two parameters of rect() method
	    // as the location of one corner, and the third and fourth parameters as
	    // the location of the opposite corner.
	    // rect() method draws a rectangle to the display window

	    this.focused = true; // Confirms that our Processing program is focused,
	    // meaning that it is active and will accept mouse or keyboard input.

	    // sets the text alignment to center
	    this.textAlign(PApplet.CENTER, PApplet.CENTER);

	    // load the background image and store the loaded image to backgroundImage
	    backgroundImage = this.loadImage("images/background.png");


	    // create an empty array list of objects
	    objects = new ArrayList <TankListener> ();


	    // set randGen to the reference of a new Random objects
	    randGen = new Random();
	    
	    TankObject.setProcessing(this);
	    Button.setProcessing(this);
	    
	    TankObject flower = new TankObject(430, 60, "images" + File.separator + "flower.png");
	    TankObject log = new TankObject(580, 470, "images" + File.separator + "log.png");
	    TankObject shell = new TankObject(65, 520, "images" + File.separator + "shell.png");
	    TankObject ship = new TankObject(280, 535, "images" + File.separator + "ship.png");
	    addObject(flower);
	    addObject(log);
	    addObject(shell);
	    addObject(ship);
	    addObject(new BlackFish(log, flower));
	    addObject(new BlackFish(shell, flower)); 
	    addObject(new AddBlueFishButton(43, 16));
	    addObject(new AddOrangeFishButton(129, 16));
	    addObject(new AddYellowFishButton(215, 16));
	    addObject(new ClearTankButton(301, 16));
	}

	/**
	 * Continuously draws and updates the application display window
	 */
	@Override
	public void draw() {
		// clear the display window by drawing the background image
		image(backgroundImage, this.width / 2, this.height / 2);
		
		//traverse the objects list and draw each of the objects to this display window
		for (TankListener tankListener : objects) {
			tankListener.draw();
		}
	 }

	/**
	 * Callback method called each time the user presses the mouse
	 */
	@Override
	public void mousePressed() {
		// traverse the objects list and call mousePressed method
	    // of the first object being clicked in the list
		for (TankListener tankListener : objects) {
			if (tankListener.isMouseOver()) {
				tankListener.mousePressed();
				return;
			}
	    }
	}

	/**
	 * Callback method called each time the mouse is released
	 */
	@Override
	public void mouseReleased() {
		// traverse the fishes array and stop dragging any fish
		for (TankListener tankListener : objects) {
			if(tankListener.isMouseOver()) {
				tankListener.mouseReleased();
				return;
			}
		}
	}

	/**
	 * adds an instance of TankListener passed as input to the objects ArrayList
	 * <p>
	 * @param object an instance of TankListener
	 */
	public void addObject(TankListener object) {
		this.objects.add(object); 
	}

	/**
	 * Callback method called each time the user presses a key
	 */
	@Override
	public void keyPressed() {

		switch (Character.toUpperCase(key)) {
		case 'O': // add a new orange fish when O or o is pressed
			addObject(new Fish());
			break;

	    case 'Y': // add a new yellow fish whose speed is 2 
	    	// when Y or y is pressed
	    	addObject(new Fish(2,"images" + File.separator + "yellow.png"));
	    	break;
	    	  
	    case 'R': // delete the clicked fish when R or r is pressed
	    	TankListener removed = null;
	        for (TankListener tankListener : objects) {
	          if (tankListener instanceof Fish && tankListener.isMouseOver()) {
	            removed = tankListener;
	          }
	        }
	        objects.remove(removed);
	        break;
	        
	    case 'S': // trigger start swimming every fish 
	    	// when S or s is pressed
	    	for (TankListener tankListener : objects) {
	            if (tankListener instanceof Fish || tankListener instanceof BlueFish
	                || tankListener instanceof BlackFish) {
	              Fish fish = (Fish) tankListener;
	              fish.startSwimming();
	            }
	        }
	    	break;
	    
	    case 'X': // stop swimming simulation every fish
	    	// when X or x is pressed
	    	for (TankListener tankListener : objects) {
	    		if (tankListener instanceof Fish || tankListener instanceof BlueFish
	    				|| tankListener instanceof BlackFish) {
	    			Fish fish = (Fish) tankListener;	
	    			fish.stopSwimming();
	    		}
	    	}
	    	break;
	      
	    case 'C': // remove all instances of the Fish class 
	    	// from this tank when C or c is pressed
	    	clear();
	    	break;
	    	
	    case 'B': // add a blue fish 
	    	// from this tank when B or b is pressed
	    	addObject(new BlueFish());
	    	break;
		}
	}
	  
	/**
	 * Removes instances of the class Fish from this tank
	 */
	public void clear() {
		ArrayList<TankListener> removed2 = new ArrayList<TankListener> ();
        for (TankListener tankListener : objects) {
          if (tankListener instanceof Fish) {
            removed2.add(tankListener);
          }
        }
        objects.removeAll(removed2);
	}
}
