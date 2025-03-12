package game;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle2 extends Polygon implements Movable {

	Ball ball;
	public Point[] points;
	Point position;
	double rotation;
	
	
	public Paddle2(Point[] shape, Point position, double rotation, Ball ball) {
		super(shape, position, rotation);
		this.points = shape;
		this.position = position;
		this.rotation = rotation;
		this.ball = ball;
		
		Movable moveLambda = () -> {
            int paddleSpeed = 5;            
            int ballY = (int) ball.getPosition().y;

            int tolerance = 50; // Paddle will stop moving if it's within 10 pixels of the ball's Y position

            if (position.y + tolerance < ballY) {
                // Move paddle down if ball is lower (with tolerance)
                position.y += paddleSpeed;
            } else if (position.y > ballY + tolerance) {
                // Move paddle up if ball is higher (with tolerance)
                position.y -= paddleSpeed;
            }

            // Prevent the paddle from moving out of bounds
            if (position.getY() < 20) {
                position.setY(20);
            }
            if (position.getY() > 482) {
                position.setY(482);
            }
        };
        move = moveLambda;
    }

    private Movable move;

	@Override
	public void move() {
	   move.move();
	}

		
	
	public void paint(Graphics brush) {
		brush.setColor(Color.WHITE);
		brush.drawRect((int)position.x, (int)position.y, 20, 75);
		brush.fillRect((int)position.x, (int)position.y, 20, 75);
	}

}
