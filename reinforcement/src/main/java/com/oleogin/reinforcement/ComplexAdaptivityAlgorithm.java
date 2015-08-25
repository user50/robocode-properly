package com.oleogin.reinforcement;

public class ComplexAdaptivityAlgorithm implements AdaptivityAlgorithm {

    Iterable<AdaptivityAlgorithm> adaptivityAlgorithms;

    public ComplexAdaptivityAlgorithm(Iterable<AdaptivityAlgorithm> adaptivityAlgorithms) {
        this.adaptivityAlgorithms = adaptivityAlgorithms;
    }

    @Override
    public void adapt(Step step) {

        for (AdaptivityAlgorithm adaptivityAlgorithm : adaptivityAlgorithms)
            adaptivityAlgorithm.adapt(step);
    }
}
