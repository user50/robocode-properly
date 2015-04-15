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

/**
 * Created by user50 on 09.04.2015.
 */
public class BaseRobot extends AdvancedRobot {

    RobocodeBrain brain;

    private boolean stop = false;

    StateAggregator stateAggregator = new StateAggregator();

    @Override
    public void run() {
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
        setTurnGunLeftRadians(action.getAction(rotateGun));
        setTurnRadarLeftRadians(action.getAction(rotateRadar));
        fire(action.getAction(shotPower));
    }

    private RobocodeState getState()
    {
        Map<RobocodeStateParameter, Double> stateParameters = new HashMap<RobocodeStateParameter, Double>();

        stateParameters.put(RobocodeStateParameter.gunHearing, getGunHeadingRadians() );
        stateParameters.put(RobocodeStateParameter.radarHearing, getRadarHeadingRadians() );

        return new RobocodeState(stateParameters);
    }

    @Override
    public void onRobotDeath(RobotDeathEvent event) {
        stop = true;
    }

    @Override
    public void onRoundEnded(RoundEndedEvent event) {

    }

    @Override
    public void onBulletHit(BulletHitEvent event) {

    }
}
