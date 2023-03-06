package levels;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import util.GameObject;
import util.MovingPlatform;
import util.Platform;
import util.Point3f;

public class Level8 extends Level {
    private List<Platform> platforms;
    private List<MovingPlatform> movingPlatforms;
    private List<GameObject> powerUps;
    private GameObject checkpoint;
    private boolean platformsMove = true;

    public Level8() {
        //setup game world
        platforms = new ArrayList<>();

        powerUps = new ArrayList<>();

        //Ground platforms
        platforms.add(new Platform(0, 500, 140, 100, Color.black));
        platforms.add(new Platform(600, 150, 150, 500, Color.black));
        platforms.add(new Platform(250, 350, 150, 20, Color.black));
        platforms.add(new Platform(500, 400, 100, 20, Color.black));
        platforms.add(new Platform(50, 300, 100, 20, Color.black));
        platforms.add(new Platform(250, 250, 150, 20, Color.black));
        platforms.add(new Platform(500, 200, 100, 20, Color.black));

        //Moving platforms
        movingPlatforms = new ArrayList<>();
        movingPlatforms.add(new MovingPlatform(200, 450, 100, 20, Color.green, 150, 500, 1));

        checkpoint = new GameObject("res/flagRed.png", 50, 50, new Point3f(900, 450, 0));
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
