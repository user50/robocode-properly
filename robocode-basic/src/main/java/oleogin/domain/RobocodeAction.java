package oleogin.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user50 on 09.04.2015.
 */
public class RobocodeAction {

    Map<RobocodeActionParameter,Double> actions = new HashMap<RobocodeActionParameter, Double>();

    public double getAction(RobocodeActionParameter actionParameter)
    {
        return actions.get(actionParameter);
    }
}
