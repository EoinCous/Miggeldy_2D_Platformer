package util;

import java.util.List;

public class Level {
	private List<Platform> platforms;
	private List<GameObject> powerUps;
	private int cameraPosition;
	
	public Level() {
		
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
