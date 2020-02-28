package com.urise.solution.NoLinearEquations;

import com.urise.model.Massive;

public class MethodHoard extends AbstractSystemHalfDivisionHoard {

    @Override
    protected double newInterval(Massive storage) {
        double a = storage.getInterval()[0];
        double b = storage.getInterval()[1];
        return (a * productPoint(storage, b) - b * productPoint(storage, a)) / ((productPoint(storage, b)) - productPoint(storage, a));
    }
}