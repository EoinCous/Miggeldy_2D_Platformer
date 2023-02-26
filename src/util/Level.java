package util;

import java.util.List;

public class Level {
	private List<Platform> platforms;
	private List<GameObject> powerUps;
	private GameObject checkpoint;
	private int cameraPosition;
	
	public Level() {
		
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
	
	public void updateCameraPosition(int x) {
		for(Platform platform : platforms) {
			platform.setX(cameraPosition);
		}
	}

	public void removePowerUp(GameObject powerUp) {
		powerUps.remove(powerUp);
	}

}
