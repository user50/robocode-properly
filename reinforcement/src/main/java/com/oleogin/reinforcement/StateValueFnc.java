package com.oleogin.reinforcement;

public interface StateValueFnc<S extends State>  {

    double eval(S state);

    void adapt(S state, double value);

}
