//package game;
//
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.event.KeyEvent;
//
//public class Pong extends Game {
//	
//	Ball ball;
//	Paddle1 paddle1;
//	Paddle2 paddle2;
//	Player player;
//	Computer computer;
//
//	public Pong() {
//		super("Pong", 500, 400);
//		this.setFocusable(true);
//		this.requestFocus();
//		
//		Point[] ballPoints = { new Point(0,0), new Point(20,0), new Point(20,20), new Point(0,20) };
//		Point ballPosition = new Point(75, 150);
//		double ballRotation = 0;
//		
//		Point[] paddle1Points = { new Point(0,0), new Point(50,0), new Point(50,50), new Point(0,50) };
//		Point paddle1Position = new Point(75, 150);		
//		
//		ball = new Ball(ballPoints, ballPosition, ballRotation);
//		paddle1 = new Paddle1(paddle1Points, paddle1Position, ballRotation);
//		paddle2 = new Paddle2(ballPoints, new Point(375, 100), ballRotation);
//		
//		player = new Player();
//		computer = new Computer();
//		
//	}
//
//	@Override
//	public void paint(Graphics brush) {
//		// Draw Bounds
//		brush.setColor(Color.WHITE);
//		brush.fillRect(0, 0, width, height);
//		
//		// Draw Center Circle and Halfway Line
//		brush.drawLine(width/2, 0, width/2, height);
//		brush.drawOval(50, 50, 25, 25);
//	}
//	
//	public void keyPressed(KeyEvent e) {
//		int key = e.getKeyCode();
//		if(key == KeyEvent.VK_UP) {
//			paddle1.moveUp();
//		} else if(key == KeyEvent.VK_DOWN) {
//			paddle1.moveDown();
//		}
//			
//	}
//	
//	public boolean paddle1Collision(Polygon object1, Polygon object2) {
//		// Get the points of each object
//		Point[] points1 = object1.getPoints();
//		Point[] points2 = object2.getPoints();
//
//		// Loop through each point in the first object
//		for (Point point1 : points1) {
//			// Check if the point is inside the second object
//			if (object2.contains(point1)) {
//				return true; // Collision detected
//			}
//		}
//
//		// Loop through each point in the second object
//		for (Point point2 : points2) {
//			// Check if the point is inside the first object
//			if (object1.contains(point2)) {
//				return true; // Collision detected
//			}
//		}
//		// No collision detected
//		return false;
//	}
//
//	
//	public boolean paddle2Collision(Polygon object1, Polygon object2) {
//		// Get the points of each object
//				Point[] points1 = object1.getPoints();
//				Point[] points2 = object2.getPoints();
//
//				// Loop through each point in the first object
//				for (Point point1 : points1) {
//					// Check if the point is inside the second object
//					if (object2.contains(point1)) {
//						return true; // Collision detected
//					}
//				}
//
//				// Loop through each point in the second object
//				for (Point point2 : points2) {
//					// Check if the point is inside the first object
//					if (object1.contains(point2)) {
//						return true; // Collision detected
//					}
//				}
//				// No collision detected
//				return false;
//	}
//	
//	public boolean boundCollision(Polygon object1, Polygon object2) {
//		
//	}
//
//	
//	class Player() {
//		int score;
//		public Player() {
//			this.score = 0;
//		}
//	}
//	
//	class Computer() {
//		int score;
//		public Computer() {
//			this.score = 0;
//		}
//	}
//	
//	public static void main (String[] args) {
//   		Pong a = new Pong();
//		a.repaint();
//	}
//}
//	
//
