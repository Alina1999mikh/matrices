package com.urise.Solution.NoLinearEquations;

import com.urise.model.Massive;

public class MethodHalfDivision extends AbstractSystemHalfDivisionHoard {

    @Override
    protected double newInterval(Massive storage) {
        return (storage.getInterval()[0]+storage.getInterval()[1])/2;
    }
}