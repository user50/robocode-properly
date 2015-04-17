package oleogin.domain;

import oleogin.BrainControllingRobot;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user50 on 09.04.2015.
 */
public class RobocodeAction {

    Map<RobocodeActionParameter,Double> actions = new HashMap<RobocodeActionParameter, Double>();

    public RobocodeAction(Map<RobocodeActionParameter, Double> actions) {
        this.actions = actions;
    }

    public Double getAction(RobocodeActionParameter actionParameter)
    {
        return actions.get(actionParameter);
    }

    public void apply(BrainControllingRobot brainControllingRobot)
    {

    }
}
