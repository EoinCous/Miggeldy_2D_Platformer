package util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Level5 extends Level {
    private List<Platform> platforms;
    private List<GameObject> powerUps;
    private GameObject checkpoint;

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
        platforms.add(new MovingPlatform(200, 350, 100, 20, Color.green, 200, 600, 120));
        platforms.add(new MovingPlatform(600, 350, 100, 20, Color.green, 600, 200, 120));

        checkpoint = new GameObject("res/Guinness_transparent.png", 50, 50, new Point3f(900, 450, 0));
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
}
