package vvijayakumar471.carrom;

import vvijayakumar471.shapes.Circle;
import vvijayakumar471.shapes.Line;
import vvijayakumar471.shapes.Rectangle;
import processing.core.PApplet;


public class DrawingSurface extends PApplet {
	
	private Coin coin1;
	private Line leftBorder, rightBorder, topBorder, downBorder;

	private double initialMouseX, initialMouseY;
	private boolean clickedCoin;

	public DrawingSurface() {
		coin1 = new Coin(20, 20, 20);
		leftBorder = new Line(5, 5, 5, 250);
		rightBorder = new Line(250, 5, 250, 250);
		topBorder = new Line(5, 5, 250, 5);
		downBorder = new Line(5, 250, 250, 250);
		initialMouseX = 0;
		initialMouseY = 0;
		clickedCoin = false;
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {

	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() {
		background(255);
		
		coin1.draw(this);
		leftBorder.draw(this);
		rightBorder.draw(this);
		topBorder.draw(this);
		downBorder.draw(this);
		
		coin1.act(leftBorder, rightBorder, topBorder, downBorder);


	}

	
	// Called once after every time a mouse button is pressed
	public void mousePressed() {
//		System.out.println("Mouse is Pressed");
		if (coin1.isPointInside(mouseX, mouseY) && clickedCoin == false) {	// if the initial click is inside a coin & you haven't clicked a coin
			System.out.println("Click inside coin");
			initialMouseX = mouseX;		// store inital mouse vals
			initialMouseY = mouseY;
			System.out.println("imx " + initialMouseX + " imy " + initialMouseY);
			clickedCoin = true;
		}
	}
	
	// Called once every time the mouse moves and a mouse button is pressed
	public void mouseDragged () {
		System.out.println("Mouse Dragged");
		if (clickedCoin == true) {	// if u clicked on a coin and released your mouse
			System.out.println("Coin Clicked and released");
			double diffX = mouseX - initialMouseX;	// how much mouse has been dragged
			double diffY = mouseY - initialMouseY;
			System.out.println("DX " + diffX + " DY " + diffY);
		}
	}

}
