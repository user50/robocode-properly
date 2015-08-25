package com.oleogin.reinforcement;

public class Step {

    State state;
    Action action;
    State nextState;
    double reward;

    public Step(State state, Action action, State nextState, double reward) {
        this.state = state;
        this.action = action;
        this.nextState = nextState;
        this.reward = reward;
    }

    public State getState() {
        return state;
    }

    public Action getAction() {
        return action;
    }

    public State getNextState() {
        return nextState;
    }

    public double getReward() {
        return reward;
    }
}
