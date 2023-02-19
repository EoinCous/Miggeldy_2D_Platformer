package util;

//Used to create player and enemy objects
public class CharacterObject extends GameObject {

	private int gravity = 5;
	private int jumpHeight = 100;
	private boolean jumping = false;
	
	public CharacterObject() {
		
	}
	
	public CharacterObject(String textureLocation,int width,int height,Point3f centre) {
	}

	public int getJumpHeight() {
		return jumpHeight;
	}

	public void setJumpHeight(int jumpHeight) {
		this.jumpHeight = jumpHeight;
	}

	public int getGravity() {
		return gravity;
	}

	public void setGravity(int gravity) {
		this.gravity = gravity;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
}
