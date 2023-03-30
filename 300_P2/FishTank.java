//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    FishTank.java
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
// Persons: Zhenye Liu   
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

public class FishTank {
	private static PApplet processing; // PApplet object that represents the graphic
	// interface of the JunglePark application
	private static PImage backgroundImage; // PImage object that represents the
	// background image
	private static Fish[] fishes; // perfect size array storing the different fish present
	// in the fish tank. These fish can be of different species.
	private static Random randGen; // Generator of random numbers

	public static void main(String[] args) {
		Utility.startApplication();
	}
	
	/**
	* Defines the initial environment properties of this application
	* @param processingObj a reference to the graphic display window of this application
	*/
	public static void setup(PApplet processingObj) {
		processing = processingObj;
		backgroundImage = processing.loadImage("images/background.png");
		fishes = new Fish[] {null,null,null,null,null,null,null,null};
		randGen = new Random();
	}
	
	/**
	* Draws and updates the application display window.
	* This callback method called in an infinite loop.
	*/
	public static void draw() {
		processing.image(backgroundImage, processing.width / 2, processing.height / 2);
		for(int g = 0; g<fishes.length; g++) {
			if(fishes[g]!=null)
			fishes[g].draw();
		}
	}
	
	/**
	* Checks if the mouse is over a specific Fish whose reference is provided
	* as input parameter
	*
	* @param Fish reference to a specific fish
	* @return true if the mouse is over the specific Fish object (i.e. over
	* the image of the Fish), false otherwise
	*/
	public static boolean isMouseOver(Fish Fish) {
		//center-width/2,center+width/2,center+height/2,center-height/2
		if (Fish != null) {
            // see if the mouse is in the range of the Image
            return processing.mouseX <= (Fish.getPositionX() + Fish.getImage().width / 2) && processing.mouseX >= (Fish.getPositionX() - Fish.getImage().width / 2)
                    && processing.mouseY <= (Fish.getPositionY() + Fish.getImage().height / 2) && processing.mouseY >= (Fish.getPositionY() - Fish.getImage().height / 2);
        }
        return false;
	}
	
	/**
	* Callback method called each time the user presses the mouse
	*/
	public static void mousePressed() {
		for(int i = 0; i<fishes.length; i++) {
			if(isMouseOver(fishes[i]) == true) {
				fishes[i].setDragging(true);
				break;
			}
		}
	}
	
	/**
	* Callback method called each time the mouse is released
	*/
	public static void mouseReleased() {
		for(int i = 0; i<fishes.length; i++) {
			if(fishes[i] != null) {
				fishes[i].setDragging(false);
			}
		}
	}
	
	/**
	* Callback method called each time the user presses a key
	*/
	public static void keyPressed() {
		if(processing.key == 'F' || processing.key == 'f') {
			for(int i = 0; i<8; i++) {
				if(fishes[i] == null) {
					fishes[i] = new Fish(processing, (float)randGen.nextInt(processing.width), 
							(float)randGen.nextInt(processing.height));
					fishes[i].draw();
					break;
				}
			}
		}
		if(processing.key == 'R' || processing.key == 'r') {
			for(int i =0;i<fishes.length;i++) {
				if(isMouseOver(fishes[i])) {
					fishes[i] = null;
				}
			}
			
		}
	}
}
