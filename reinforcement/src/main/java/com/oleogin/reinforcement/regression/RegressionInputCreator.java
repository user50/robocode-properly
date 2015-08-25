package com.oleogin.reinforcement.regression;

import com.oleogin.reinforcement.State;

import java.util.Map;

public interface RegressionInputCreator<S extends State> {

    Map<String,Double> create(S state);
}
