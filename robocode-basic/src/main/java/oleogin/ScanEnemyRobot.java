package oleogin;

import algebra.Vector;
import robocode.AdvancedRobot;
import robocode.RobotDeathEvent;
import robocode.ScannedRobotEvent;

import static algebra.VectorAlgebra.getAngleBetween;
import static algebra.VectorAlgebra.rotate;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Created by user50 on 15.04.2015.
 */
public class ScanEnemyRobot extends AdvancedRobot {

    private boolean stop = false;

    private ScannedRobotEvent lastScannedEnemy;

    @Override
    public void run() {

        turnRadarLeftRadians(100);

        while (!stop)
        {
            Vector radarDirection = new Vector(sin(getRadarHeadingRadians()), cos(getRadarHeadingRadians()));
            Vector myDirection = new Vector(sin(getHeadingRadians()), cos(getHeadingRadians()));

            Vector enemyDirection = rotate(myDirection, -lastScannedEnemy.getBearingRadians());

            Double radarRotateAngle = getAngleBetween(radarDirection, enemyDirection);

            setTurnRadarLeftRadians(radarRotateAngle);
        }
    }

    @Override
    public void onRobotDeath(RobotDeathEvent event) {
        stop = true;
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        lastScannedEnemy = event;
    }
}
