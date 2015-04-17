package oleogin;

import oleogin.domain.RobocodeAction;
import oleogin.domain.RobocodeActionParameter;
import oleogin.domain.RobocodeState;
import oleogin.domain.RobocodeStateParameter;
import robocode.*;

import java.util.HashMap;
import java.util.Map;

import static oleogin.domain.RobocodeActionParameter.rotateGun;
import static oleogin.domain.RobocodeActionParameter.rotateRadar;
import static oleogin.domain.RobocodeActionParameter.shotPower;
import static oleogin.domain.RobocodeStateParameter.*;

/**
 * Created by user50 on 09.04.2015.
 */
public class BaseRobot extends AdvancedRobot {

    RobocodeBrain brain = new RadarController();

    private boolean stop = false;

    StateAggregator stateAggregator = new StateAggregator();

    private ScannedRobotEvent lastScannedEnemy;

    @Override
    public void run() {

        turnRadarLeftRadians(6);

        while (!stop)
        {
            RobocodeState state = getState();
            RobocodeAction action = brain.askAction(state);

            applyActions(action);

            stateAggregator.aggregate(state, action);
            execute();
        }
    }

    private void applyActions(RobocodeAction action)
    {
        for (RobocodeActionParameter actionParameter : RobocodeActionParameter.values()) {
            if (action.getAction(actionParameter) != null)
                actionParameter.apply(action.getAction(actionParameter), this);
        }
    }

    private RobocodeState getState()
    {
        Map<RobocodeStateParameter, Double> stateParameters = new HashMap<RobocodeStateParameter, Double>();

        stateParameters.put(gunHearing, getGunHeadingRadians() );
        stateParameters.put(radarHearing, getRadarHeadingRadians() );
        stateParameters.put(agentHearing, getHeadingRadians() );

        if (lastScannedEnemy!=null)
        {
            stateParameters.put(enemyBearing, lastScannedEnemy.getBearingRadians() );
        }

        return new RobocodeState(stateParameters);
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
