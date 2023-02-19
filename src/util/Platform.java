package util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Platform {
	private Rectangle rect;
	private Color color;
	
	public Platform(int x, int y, int width, int height, Color color) {
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

}
