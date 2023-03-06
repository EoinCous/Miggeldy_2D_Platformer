package levels;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import util.GameObject;
import util.MovingPlatform;
import util.Platform;
import util.Point3f;


public class Level3 extends Level{
	private List<Platform> platforms;
    private List<MovingPlatform> movingPlatforms;
	private List<GameObject> powerUps;
	private GameObject checkpoint;
	
	public Level3() {
		//setup game world 
				platforms = new ArrayList<>();
				//Ground platforms
				platforms.add(new Platform(0, 500, 500, 100, Color.black));
				platforms.add(new Platform(800, 500, 200, 150, Color.black));
				
				//Platforms above ground
				platforms.add(new Platform(600, 400, 100, 20, Color.red));
				
				powerUps = new ArrayList<>();
				powerUps.add(new GameObject("res/guinness.png", 50, 50, new Point3f(300, 350, 0)));
				
				checkpoint = new GameObject("res/flagGreen.png", 50, 50, new Point3f(900, 450, 0));
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
