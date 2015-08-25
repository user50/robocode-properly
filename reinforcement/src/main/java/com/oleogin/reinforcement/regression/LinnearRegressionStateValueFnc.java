package com.oleogin.reinforcement.regression;

import com.oleogin.regression.Regression;
import com.oleogin.reinforcement.State;
import com.oleogin.reinforcement.StateValueFnc;

public class LinnearRegressionStateValueFnc<S extends State> implements StateValueFnc<S> {

    Regression regression;
    RegressionInputCreator<S> inputCreator;
    double alpha;

    public LinnearRegressionStateValueFnc(Regression regression, RegressionInputCreator<S> inputCreator, double alpha) {
        this.regression = regression;
        this.inputCreator = inputCreator;
        this.alpha = alpha;
    }

    @Override
    public double eval(S state) {
        return regression.calculate(inputCreator.create(state));
    }

    @Override
    public void adapt(S state, double value) {
        regression.adapt(inputCreator.create(state), value, alpha);
    }
}
