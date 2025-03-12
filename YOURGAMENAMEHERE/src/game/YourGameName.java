package game;

import java.awt.*;
import java.awt.event.KeyEvent;

public class YourGameName extends Game {
	
	private static final long serialVersionUID = 1L;
	Ball ball;
	Paddle1 paddle1;
	Paddle2 paddle2;
	Player player;
	Computer computer;

	public YourGameName() {
		super("Pong", 1000, 600);
		this.setFocusable(true);
		this.requestFocus();
		
		Point[] ballPoints = { new Point(0,0), new Point(25,0), new Point(25,25), new Point(0,25) };
		Point ballPosition = new Point(488, height/2);
		double ballRotation = 0;
		
		Point[] paddle1Points = { new Point(0,0), new Point(20,0), new Point(20,75), new Point(0,75) };
		Point paddle1Position = new Point(width - 990, height/2);		
		
		ball = new Ball(ballPoints, ballPosition, ballRotation);
		paddle1 = new Paddle1(paddle1Points, paddle1Position, 0);
		paddle1.addKeyListener(this);
		paddle2 = new Paddle2(paddle1Points, new Point(width - 25, height/2), 0, ball);
		
		player = new Player();
		computer = new Computer();
		
	}

	@Override
	public void paint(Graphics brush) {
		// Draw Bounds
		brush.setColor(Color.BLACK);
		brush.fillRect(0, 0, width, height);
		
		brush.setColor(Color.WHITE);
		Graphics2D g2d = (Graphics2D) brush;
		g2d.setStroke(new BasicStroke(25));
		
		// Upper Bound Line
		g2d.drawLine(10, 10, 1000, 10);
		// Lower Bound Line
		g2d.drawLine(10, 560, 1000, 560);

		Font font = new Font("Arial", Font.BOLD, 50);
		brush.setFont(font);
		// Player Score
		brush.drawString(Integer.toString(player.score), width/2 -100, height/2 - 200);
		// Computer Score
		brush.drawString(Integer.toString(computer.score), width/2 +100, height/2 - 200);
		
		g2d.setStroke(new BasicStroke(1));
		// Draw Halfway Line
		brush.drawLine(width/2, 0, width/2, height);
		
		paddle1.paint(brush);
		paddle2.paint(brush);
		ball.paint(brush);
		ball.move();
		paddle2.move();
		
		// Collision when Ball hits paddle1
		if(this.paddle1Collision(paddle1, ball)) {
			ball.position.setX(ball.position.getX() + 10); // Move ball away from paddle
	        ball.reverseXDirection(); // Reverse X direction
	        ball.rotate(5);
		}
		
		// Collision when Ball hits paddle2
		if(this.paddle2Collision(paddle2, ball)) {
			ball.position.setX(ball.position.getX() - 10); // Move ball away from paddle
			ball.reverseXDirection(); // Reverse X direction
			ball.rotate(5);
		}
		
		// Collision when Ball hits topBound
		
		// Collision when Ball hits bottomBound
		
		// Check if Ball hits compLine
		if(ball.position.getX() >= 975) {
			player.score++;
			brush.drawString(Integer.toString(player.score), width/2 -100, height/2 - 200);
			
			ball.position.setX(488);
			ball.position.setY(height/2);
			
		}	
		// Check if Ball hits playerLine
		if(ball.position.getX() <= 25) {
			computer.score++;
			brush.drawString(Integer.toString(computer.score), width/2 +100, height/2 - 200);
			
			ball.position.setX(488);
			ball.position.setY(height/2);
		}
		
		if (player.score == 10) {
			brush.setColor(Color.GREEN);
			brush.drawString("YOU WIN", width/2, height/2);
		}
		
		if (computer.score == 10) {
			brush.setColor(Color.RED);
			brush.drawString("YOU LOST", width/2 - 100, height/2);
		}
		
		repaint();
	}
	


	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_UP) {
			paddle1.moveUp();
		} else if(key == KeyEvent.VK_DOWN) {
			paddle1.moveDown();
		}
			
	}
	
	public boolean paddle1Collision(Polygon object1, Polygon object2) {
		// Get the points of each object
		Point[] points1 = object1.getPoints();
		Point[] points2 = object2.getPoints();

		// Loop through each point in the first object
		for (Point point1 : points1) {
			// Check if the point is inside the second object
			if (object2.contains(point1)) {
				return true; // Collision detected
			}
		}

		// Loop through each point in the second object
		for (Point point2 : points2) {
			// Check if the point is inside the first object
			if (object1.contains(point2)) {
				return true; // Collision detected
			}
		}
		// No collision detected
		return false;
	}

	
	public boolean paddle2Collision(Polygon object1, Polygon object2) {
		// Get the points of each object
		Point[] points1 = object1.getPoints();
		Point[] points2 = object2.getPoints();

				// Loop through each point in the first object
		for (Point point1 : points1) {
			// Check if the point is inside the second object
			if (object2.contains(point1)) {
				return true; // Collision detected
				}
			}

				// Loop through each point in the second object
		for (Point point2 : points2) {
			// Check if the point is inside the first object
			if (object1.contains(point2)) {
				return true; // Collision detected
			}
		}
		// No collision detected
		return false;
	}
	
//	public boolean boundCollision(Polygon object1, Polygon object2) {
//		
//	}

	
	class Player {
		int score;
		public Player() {
			this.score = 0;
		}
	}
	
	class Computer {
		int score;
		public Computer() {
			this.score = 0;
		}
	}
	
	public static void main (String[] args) {
   		YourGameName a = new YourGameName();
		a.repaint();
	}
}
	

