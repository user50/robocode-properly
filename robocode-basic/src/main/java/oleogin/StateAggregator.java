package oleogin;

import oleogin.domain.RobocodeAction;
import oleogin.domain.RobocodeState;
import oleogin.domain.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user50 on 09.04.2015.
 */
public class StateAggregator {

    private RobocodeAction previousActions;
    private RobocodeState previousState;

    private List<Step> steps = new ArrayList<Step>();

    public void aggregate(RobocodeState state, RobocodeAction action)
    {
        if (previousState != null && previousActions != null) {
            steps.add(new Step(previousState, previousActions, state));
        }

        previousState = state;
        previousActions = action;
    }

    public List<Step> getSteps() {
        return steps;
    }
}
