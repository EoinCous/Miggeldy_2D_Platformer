package util;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject{
	
	private int jumpTime = 0; //to stop player floating
	private int max_jump_time = 30; // Change this value to adjust the maximum jump time
	private int jumpDelay = 0; //to prevent player jumping continuously
	private int lives = 3;
	private int score = 0; 
	private int width = 30;
	private int height = 45;
	private boolean powerUp = false;
	private int speed = 2;
	private int id;
	
	private Point3f centre = new Point3f(0,0,0);
	private boolean hasTextured = false;
	private String textureLocation; 
	private String blanktexture="res/blankSprite.png";
	
	private boolean down = false;
	
	public Player(String textureLocation, Point3f centre) {
		hasTextured=true;
   	 	this.textureLocation = textureLocation;
		this.centre = centre;
	}
	
	public Player(int id, String textureLocation, Point3f centre, int width, int height) {
		this.id = id;
		hasTextured=true;
   	 	this.textureLocation = textureLocation;
		this.centre = centre;
		this.width = width;
		this.height = height;
	}
	
	
	public void powerUp() {
		powerUp = true;
		textureLocation = "res/miggeldy_on_bike.png";
		width = 45;
		max_jump_time = 60;
		//speed *= 2;
		lives++;
		score++;
	}
	
	public void powerUp2() {
		powerUp = true;
		textureLocation = "res/dog_on_bike.png";
		width = 45;
		max_jump_time = 60;
		//speed *= 2;
		lives++;
		score++;
	}
	
	public void powerDown() {
		powerUp = false;
		max_jump_time = 30;
		width = 30;
	}
	
	public void draw(int x, int y, int width, int height, String texture,Graphics g) {
		super.draw(x, y, width, height, texture, g);
	}
	
	public void setDown(boolean down) {
		this.down = down;
	}
	
	public boolean isDown() {
		return down;
	}
	
	public int getID() {
		return id;
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
	
	public void incrementJumpTime() {
		this.jumpTime++;
	}

	public int getMaxJumpTime() {
		return max_jump_time;
	}

	public void setMaxJumpTime(int maxJumpTime) {
		max_jump_time = maxJumpTime;
	}

	public int getJumpDelay() {
		return jumpDelay;
	}

	public void setJumpDelay(int jumpDelay) {
		this.jumpDelay = jumpDelay;
	}
	
	public void decrementJumpDelay() {
		this.jumpDelay--;
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
