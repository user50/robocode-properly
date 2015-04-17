package oleogin;

import algebra.Vector;
import oleogin.domain.RobocodeAction;
import oleogin.domain.RobocodeActionParameter;
import oleogin.domain.RobocodeState;
import oleogin.domain.RobocodeStateParameter;

import java.util.HashMap;
import java.util.Map;

import static algebra.VectorAlgebra.getAngleBetween;
import static algebra.VectorAlgebra.rotate;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static oleogin.domain.RobocodeStateParameter.agentHearing;
import static oleogin.domain.RobocodeStateParameter.enemyBearing;
import static oleogin.domain.RobocodeStateParameter.radarHearing;

/**
 * Created by user50 on 17.04.2015.
 */
public class RadarController implements RobocodeBrain {
    @Override
    public RobocodeAction askAction(RobocodeState state) {
        if (state.getState(enemyBearing) == null)
            return new RobocodeAction(new HashMap<RobocodeActionParameter, Double>());

        Vector radarDirection = new Vector(sin(state.getState(radarHearing)), cos(state.getState(radarHearing)));
        Vector myDirection = new Vector(sin(state.getState(agentHearing)), cos(state.getState(agentHearing)));

        Vector enemyDirection = rotate(myDirection, -state.getState(enemyBearing));

        Double radarRotateAngle = getAngleBetween(radarDirection, enemyDirection);

        Map<RobocodeActionParameter,Double> actionParameters = new HashMap<RobocodeActionParameter, Double>();
        actionParameters.put( RobocodeActionParameter.rotateRadar, radarRotateAngle + Math.signum(radarRotateAngle) * 10 * Math.PI / 180);

        return new RobocodeAction(actionParameters);
    }
}
