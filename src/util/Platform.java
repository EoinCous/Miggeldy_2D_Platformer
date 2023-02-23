package util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Platform {
	private Rectangle rect;
	private Color color;
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Platform(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		rect = new Rectangle(x, y, width, height);
		this.color = color;
	}
	
	public Rectangle getRect() {
		return rect;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(rect.x , rect.y, rect.width, rect.height);
	}
	
	public void drawWithPlayersPosition(Graphics g, int x) {
		g.setColor(color);
		g.fillRect(rect.x - x, rect.y, rect.width, rect.height);
	}
	
	public void setX(int x) {
		rect.setLocation(x, y);
	}
	
	public int getX() {
		return x;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

}
