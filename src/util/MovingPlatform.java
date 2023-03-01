package util;

import java.awt.Color;
import java.awt.Graphics;

public class MovingPlatform extends Platform{
	private int startX;
	private int endX;
	private int speed;
	private boolean movingRight;

	public MovingPlatform(int x, int y, int width, int height, Color color, int startX, int endX, int speed) {
		super(x, y, width, height, color);
		this.startX = startX;
		this.endX = endX;
		this.speed = speed;
		movingRight = true;
	}
	
	public void update() {
        if (movingRight) {
            setX(getX() + speed);
            if (getX() >= endX) {
                movingRight = false;
            }
        } else {
            setX(getX() - speed);
            if (getX() <= startX) {
                movingRight = true;
            }
        }
    }
	
	@Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(getX(), y, width, height);
    }

}
