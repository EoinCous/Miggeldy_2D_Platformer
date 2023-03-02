package levels;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import util.GameObject;
import util.MovingPlatform;
import util.Platform;
import util.Point3f;

public class Level5 extends Level {
    private List<Platform> platforms;
    private List<MovingPlatform> movingPlatforms;
    private List<GameObject> powerUps;
    private GameObject checkpoint;
    private boolean platformsMove = true;

    public Level5() {
        //setup game world
        platforms = new ArrayList<>();

        powerUps = new ArrayList<>();
        powerUps.add(new GameObject("res/bullet.png", 50, 50, new Point3f(100, 400, 0)));
        powerUps.add(new GameObject("res/bullet.png", 50, 50, new Point3f(400, 250, 0)));
        powerUps.add(new GameObject("res/bullet.png", 50, 50, new Point3f(700, 400, 0)));

        //Ground platforms
        platforms.add(new Platform(0, 500, 1000, 100, Color.black));

        //Moving platforms
        movingPlatforms = new ArrayList<>();
        movingPlatforms.add(new MovingPlatform(200, 425, 100, 20, Color.green, 200, 600, 1));
        movingPlatforms.add(new MovingPlatform(400, 400, 100, 20, Color.green, 400, 800, 1));

        checkpoint = new GameObject("res/Guinness_transparent.png", 50, 50, new Point3f(900, 450, 0));
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
    
    public void removePowerUp(GameObject powerUp) {
		powerUps.remove(powerUp);
	}

    public GameObject getCheckpoint() {
        return checkpoint;
    }
    
    public boolean isPlatformsMove() {
		return platformsMove;
	}
}
