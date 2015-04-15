package oleogin.domain;

/**
 * Created by user50 on 09.04.2015.
 */
public class Step {
    private RobocodeState state;
    private RobocodeAction action;
    private RobocodeState nextState;

    public Step(RobocodeState state, RobocodeAction action, RobocodeState nextState) {
        this.state = state;
        this.action = action;
        this.nextState = nextState;
    }

    public RobocodeState getState() {
        return state;
    }

    public RobocodeAction getAction() {
        return action;
    }

    public RobocodeState getNextState() {
        return nextState;
    }
}
