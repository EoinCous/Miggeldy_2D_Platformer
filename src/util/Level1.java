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
		platforms.add(new Platform(0, 500, 1000, 100, Color.black));
		
		
		powerUps = new ArrayList<>();
		powerUps.add(new GameObject("res/Guinness_transparent.png", 50, 50, new Point3f(900, 450, 0)));
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