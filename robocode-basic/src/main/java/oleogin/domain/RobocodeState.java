package oleogin.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user50 on 09.04.2015.
 */
public class RobocodeState {

    Map<RobocodeStateParameter, Double> stateParameters;

    public RobocodeState(Map<RobocodeStateParameter, Double> stateParameters) {
        this.stateParameters = stateParameters;
    }

    public Double getState(RobocodeStateParameter parameter)
    {
        return stateParameters.get(parameter);
    }
}
