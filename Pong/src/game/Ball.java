package game;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Polygon {
	
	public Point[] points;
	double rotation;
	Point position;
	int xSpeed = 5;
	int ySpeed = 5;

	public Ball(Point[] shape, Point position, double rotation) {
		super(shape, position, rotation);
		this.points = shape;
		this.rotation = rotation;
		this.position = position;
	}
	
	
	public void paint(Graphics brush) {
		brush.setColor(Color.WHITE);
		brush.drawOval((int)position.x, (int)position.y, 25, 25);
		brush.fillOval((int) position.x, (int) position.y, 25, 25);
	}

	/**
	 * Updates the position of the element.
	 */
	public void move() {
		position.x += xSpeed;
		position.y += ySpeed;
		if (position.y <= 30 || position.y >= 550) {
			ySpeed = -ySpeed;
		}
	}

//	double amountToMove = this.position.getX();
//
//		if (amountToMove < 950 && amountToMove >= 0) {
//			this.position.setX(++amountToMove);
//			this.position.setY(++amountToMove);
//	public void move() {
//		
//	}
	
	public void rotate(int degrees) {
		rotation = (rotation + degrees) % 360;
	}


	public Point getPosition() {
		return this.position;
	}


	public void reverseXDirection() {
		xSpeed = -xSpeed;
		
	}

}
