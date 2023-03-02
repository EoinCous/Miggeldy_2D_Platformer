package util;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject{
	
	private int jumpTime = 0;
	private static int MAX_JUMP_TIME = 30; // Change this value to adjust the maximum jump time
	private int jumpTimer = 0;
	private int lives = 3;
	private int score = 0; 
	private int width = 30;
	private final int height = 45;
	private boolean powerUp = false;
	private int speed = 2;
	
	private Point3f centre = new Point3f(0,0,0);
	private boolean hasTextured = false;
	private String textureLocation; 
	private String blanktexture="res/blankSprite.png";
	
	public Player(String textureLocation, Point3f centre) {
		//super();
		hasTextured=true;
   	 	this.textureLocation = textureLocation;
		this.centre = centre;
	}
	
	public void powerUp() {
		powerUp = true;
		textureLocation = "res/miggeldy_on_bike.png";
		width = 45;
		MAX_JUMP_TIME = 60;
		//speed *= 2;
		lives++;
		score++;
	}
	
	public void powerDown() {
		powerUp = false;
		MAX_JUMP_TIME = 30;
		width = 30;
	}
	
	public void draw(int x, int y, int width, int height, String texture,Graphics g) {
		super.draw(x, y, width, height, texture, g);
	}
	
	public Point3f getCentre() {
		return centre;
	}

	public void setCentre(Point3f centre) {
		this.centre = centre;
		
		//make sure to put boundaries on the gameObject 
	 
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

	public String getTexture() {
		if(hasTextured) 
			{
			return textureLocation;
			}
		 
		return blanktexture; 
	}
	
	public void setTexture(String textureLocation) {
		this.textureLocation = textureLocation;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)centre.getX(), (int)centre.getY(), width, height);
	}

	public int getJumpTime() {
		return jumpTime;
	}

	public void setJumpTime(int jumpTime) {
		this.jumpTime = jumpTime;
	}

	public static int getMAX_JUMP_TIME() {
		return MAX_JUMP_TIME;
	}

	public static void setMAX_JUMP_TIME(int mAX_JUMP_TIME) {
		MAX_JUMP_TIME = mAX_JUMP_TIME;
	}

	public int getJumpTimer() {
		return jumpTimer;
	}

	public void setJumpTimer(int jumpTimer) {
		this.jumpTimer = jumpTimer;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isPowerUp() {
		return powerUp;
	}

	public void setPowerUp(boolean powerUp) {
		this.powerUp = powerUp;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getPlayerWidth() {
		return width;
	}

	public int getPlayerHeight() {
		return height;
	}
}