package vvijayakumar471.carrom;

import vvijayakumar471.shapes.Line;
import vvijayakumar471.shapes.Circle;

public class Coin extends Circle {
	private double vx, vy;
	private double friction;
	private boolean shot;

	public Coin(double x, double y, double extent) {
		super(x, y, extent);
		vx = 0;
		vy = 0;
		shot = false;

		friction = 0.995;
	}
	
	public void setShot(boolean exp) {
		shot = exp;
	}
	
	public boolean getShot() {
		return shot;
	}
	
	public void addVelX(double num) {
		if (shot == false)
			vx += num;
	}
	
	public void addVelY(double num) {
		if (shot == false)
			vy += num;
	}
	
	public void act(Line leftBorder, Line rightBorder, Line topBorder, Line downBorder) {
		Line motion = new Line(this.getX(), this.getY(), this.getX() + vx, this.getY() + vy);
		boolean bounced = false;

		if (motion.intersects(leftBorder)) {
			bounceOff(leftBorder);
			bounced = true;
		}
		
		if (motion.intersects(rightBorder)) {
			bounceOff(rightBorder);
			bounced = true;
		}
		
		if (motion.intersects(topBorder)) {
			bounceOff(topBorder);
			bounced = true;
		}
		
		if (motion.intersects(downBorder)) {
			bounceOff(downBorder);
			bounced = true;
		}

		if (bounced == false) {
			this.translate(vx, vy);
		}

		vy *= friction;
		vx *= friction;
	}


	
	public void bounceOff(Line l1) {
		double sAngle = Math.atan(vy / vx);
		if (vx < 0) {
			sAngle += Math.PI;
		}

		double l1Angle = Math.atan((l1.getY2() - l1.getY()) / (l1.getX2() - l1.getX()));
		if (l1.getX2() < l1.getX()) {
			l1Angle += Math.PI;
		}

		sAngle = 2 * l1Angle - sAngle;
		vx = (Math.sqrt(Math.pow(vx, 2) + Math.pow(vy, 2))) * Math.cos(sAngle);
		vy = (Math.sqrt(Math.pow(vx, 2) + Math.pow(vy, 2))) * Math.sin(sAngle);
	}

}
