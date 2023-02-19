package util;

import java.awt.Color;
import java.awt.Graphics;

public class Ground {
    
    private int x;   // ground X position
    private int y;   // ground Y position
    private int width;   // ground width
    private int height;  // ground height
    private int[] heights;
    private Color color;   // ground color
    
    public Ground(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    
    public void draw(Graphics g) {
        // Draw the ground as a filled rectangle
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    /*
    public void draw(Graphics g) {
    	g.setColor(color);
    	for(int i = 0; i < heights.length; i++) {
    		g.fillRect(i, y - heights[i], 1, heights[1]);
    	}
    }*/
    
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public Color getColor() {
        return color;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
}
