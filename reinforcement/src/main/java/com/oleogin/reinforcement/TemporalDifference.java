package com.oleogin.reinforcement;

import com.google.common.collect.EvictingQueue;

public class TemporalDifference implements AdaptivityAlgorithm {

    StateValueFnc stateValueFnc;
    EvictingQueue<State> states;

    double cumulativeReward;

    public TemporalDifference(StateValueFnc stateValueFnc, int n) {
        this.stateValueFnc = stateValueFnc;
        this.states = EvictingQueue.create(n);
    }

    public void adapt(Step step)
    {
        states.add(step.getState());
        cumulativeReward += step.getReward();

        if (states.remainingCapacity() == 0)
        {
            double expectedValue = cumulativeReward + stateValueFnc.eval(step.getNextState());

            stateValueFnc.adapt(states.peek(), expectedValue);
        }
    }
}
