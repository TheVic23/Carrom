package vvijayakumar471.carrom;

import vvijayakumar471.shapes.Circle;
import vvijayakumar471.shapes.Line;
import vvijayakumar471.shapes.Rectangle;
import processing.core.PApplet;
import vvijayakumar471.carrom.Board;


public class DrawingSurface extends PApplet {
	
	private Coin coin1;
	private Line leftBorder, rightBorder, topBorder, downBorder;

	public DrawingSurface() {
		coin1 = new Coin(20, 20, 20);
		leftBorder = new Line(5, 5, 5, 250);
		rightBorder = new Line(250, 5, 250, 250);
		topBorder = new Line(5, 5, 250, 5);
		downBorder = new Line(5, 250, 250, 250);
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

	public void mouseDragged() {
		if (coin1.isPointInside(mouseX, mouseY)){
			coin1.addVelX(2);
			coin1.setShot(true);
		}
	}
	
	public void mouseReleased() {
		if (coin1.getShot() == true){
			coin1.setShot(false);
		}
	}

}
