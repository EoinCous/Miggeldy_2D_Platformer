package levels;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import util.GameObject;
import util.MovingPlatform;
import util.Platform;
import util.Point3f;


public class Level2 extends Level{
	private List<Platform> platforms;
    private List<MovingPlatform> movingPlatforms;
	private List<GameObject> powerUps;
	private GameObject checkpoint;
	
	public Level2() {
		//setup game world 
				platforms = new ArrayList<>();
				//Ground platforms
				platforms.add(new Platform(0, 500, 300, 100, Color.black));
				platforms.add(new Platform(400, 500, 100, 100, Color.black));
				platforms.add(new Platform(500, 450, 200, 150, Color.black));
				platforms.add(new Platform(700, 400, 200, 200, Color.black));
				platforms.add(new Platform(900, 500, 100, 100, Color.black));
				
				powerUps = new ArrayList<>();
				
				checkpoint = new GameObject("res/Guinness_transparent.png", 50, 50, new Point3f(900, 450, 0));
				//powerUps.add(new GameObject("res/Guinness_transparent.png", 50, 50, new Point3f(600, 300, 0)));
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

	
}
