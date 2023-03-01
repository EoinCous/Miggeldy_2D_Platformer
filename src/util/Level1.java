package util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

//Could also be called level1

public class Level1 extends Level{
	private List<Platform> platforms;    
	private List<MovingPlatform> movingPlatforms;
	private List<GameObject> powerUps;
	private GameObject checkpoint;
	//private boolean platformsMove = false;
	
	public Level1() {
		//setup game world 
		platforms = new ArrayList<>();
		
		powerUps = new ArrayList<>();
		powerUps.add(new GameObject("res/Guinness_transparent.png", 50, 50, new Point3f(300, 350, 0)));

		//Ground platforms
		platforms.add(new Platform(0, 500, 1000, 100, Color.black));
		
		movingPlatforms = new ArrayList<>();
		
		checkpoint = new GameObject("res/Guinness_transparent.png", 50, 50, new Point3f(700, 450, 0));
	}
	
	public List<Platform> getPlatforms(){
		return platforms;
	}
	
	public List<GameObject> getPowerUps(){
		return powerUps;
	}
	
	public GameObject getCheckpoint() {
		return checkpoint;
	}
	
	public void removePowerUp(GameObject powerUp) {
		powerUps.remove(powerUp);
	}

	
}
