package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

public class Paddle1 extends Polygon implements Movable {

	private final int speed = 40;
	public Point[] points;
	Point position;
	double rotation;
	private KeyListener keyListener;
	
	public Paddle1(Point[] shape, Point position, double rotation) {
		super(shape, position, rotation);
		this.points = shape;
		this.position = position;
		this.rotation = rotation;
		
		// Anonymous Class
		keyListener = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if(keyCode == KeyEvent.VK_UP) {
					moveUp();
				} else if (keyCode == KeyEvent.VK_DOWN) {
					moveDown();
				}
			}
		};
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
	}
	
	public void paint(Graphics brush) {
		brush.setColor(Color.WHITE);
		brush.drawRect((int)position.x, (int)position.y, 20, 75);
		brush.fillRect((int)position.x, (int)position.y, 20, 75);
	}
	
	public void moveUp() {
	    // Move the paddle up (subtract speed from Y position)
	    position.setY(position.getY() - speed);

	    // Ensure the paddle doesn't go above the upper bound (y = 10)
	    if (position.getY() < 20) {
	        position.setY(20);
	    }
	}

	public void moveDown() {
	    // Move the paddle down (add speed to Y position)
	    position.setY(position.getY() + speed);

	    // Ensure the paddle doesn't go below the lower bound 
	    if (position.getY() > 480) {
	        position.setY(480);
	    }
	}
	
	public void addKeyListener(YourGameName pong) {
		pong.addKeyListener(keyListener);
		
	}
	
	public void removeKeyListener(YourGameName pong) {
		pong.removeKeyListener(keyListener);
		
	}
	
}
