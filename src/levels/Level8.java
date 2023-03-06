package levels;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import util.GameObject;
import util.Platform;
import util.Point3f;

public class Level8 extends Level {
    private List<Platform> platforms;
    private List<GameObject> powerUps;
    private GameObject checkpoint;

    public Level8() {
        //setup game world
        platforms = new ArrayList<>();

        powerUps = new ArrayList<>();
        powerUps.add(new GameObject("res/guinness.png", 50, 50, new Point3f(100, 200, 0)));
        powerUps.add(new GameObject("res/guinness.png", 50, 50, new Point3f(400, 300, 0)));
        powerUps.add(new GameObject("res/guinness.png", 50, 50, new Point3f(700, 400, 0)));

        //Ground platforms
        platforms.add(new Platform(0, 500, 300, 100, Color.black));
        platforms.add(new Platform(600, 500, 400, 100, Color.black));

        //Floating platforms
        platforms.add(new Platform(200, 400, 100, 20, Color.blue));
        platforms.add(new Platform(400, 250, 100, 20, Color.blue));
        platforms.add(new Platform(600, 400, 100, 20, Color.blue));


        checkpoint = new GameObject("res/flagRed.png", 50, 50, new Point3f(900, 450, 0));
    }

    public List<Platform> getPlatforms() {
        return platforms;
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
}