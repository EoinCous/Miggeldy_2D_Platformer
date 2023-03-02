package levels;

import java.util.List;

import util.GameObject;
import util.MovingPlatform;
import util.Platform;

public class Level {
	private List<Platform> platforms;
	private List<MovingPlatform> movingPlatforms;
	private List<GameObject> powerUps;
	private GameObject checkpoint;
	private boolean platformsMove = false;
	
	public Level() {
		
	}

	public List<Platform> getPlatforms(){
		return platforms;
	}
	
	public List<MovingPlatform> getMovingPlatforms(){
		return movingPlatforms;
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

	public boolean isPlatformsMove() {
		return platformsMove;
	}

}
