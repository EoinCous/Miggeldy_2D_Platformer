package levels;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import util.GameObject;
import util.MovingPlatform;
import util.Platform;
import util.Point3f;

public class Level7 extends Level {
    private List<Platform> platforms;
    private List<MovingPlatform> movingPlatforms;
    private List<GameObject> powerUps;
    private GameObject checkpoint;
    private boolean platformsMove = true;

    public Level7() {
        //setup game world
        platforms = new ArrayList<>();

        powerUps = new ArrayList<>();

        //Ground platforms
        platforms.add(new Platform(0, 500, 140, 100, Color.black));
        platforms.add(new Platform(850, 500, 150, 100, Color.black));

        
        //Moving platforms
        movingPlatforms = new ArrayList<>();
        movingPlatforms.add(new MovingPlatform(600, 450, 100, 20, Color.green, 150, 800, 1));


        checkpoint = new GameObject("res/flagGreen.png", 50, 50, new Point3f(900, 450, 0));
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }
    
    public List<MovingPlatform> getMovingPlatforms() {
        return movingPlatforms;
    }

    public List<GameObject> getPowerUps() {
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