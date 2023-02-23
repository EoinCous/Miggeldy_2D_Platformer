package util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

//Could also be called level1

public class Level1 extends Level{
	private List<Platform> platforms;
	private List<GameObject> powerUps;
	
	private int cameraPosition;
	
	public Level1() {
		//setup game world 
				platforms = new ArrayList<>();
				//Ground platforms
				platforms.add(new Platform(0, 500, 500, 100, Color.black));
				platforms.add(new Platform(500, 450, 200, 150, Color.black));
				platforms.add(new Platform(700, 400, 200, 200, Color.black));
				platforms.add(new Platform(900, 500, 1100, 100, Color.black));
				
				//Platforms above ground
				platforms.add(new Platform(300, 250, 100, 50, Color.red));
				platforms.add(new Platform(600, 350, 100, 50, Color.red));
				platforms.add(new Platform(900, 300, 100, 50, Color.red));
				platforms.add(new Platform(1200, 100, 100, 50, Color.red));
				
				powerUps = new ArrayList<>();
				powerUps.add(new GameObject("res/Guinness_transparent.png", 50, 50, new Point3f(800, 350, 0)));
	}
	
	public List<Platform> getPlatforms(){
		return platforms;
	}
	
	public List<GameObject> getPowerUps(){
		return powerUps;
	}
	
	public void updateCameraPosition(int x) {
		for(Platform platform : platforms) {
			platform.setX(cameraPosition);
		}
	}

	
}
