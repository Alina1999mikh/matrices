package com.urise.Solution.NoLinearEquations;

import com.urise.model.Massive;

abstract public class AbstractSystemHalfDivisionHoard extends AbstractSystemNoLinearEquations {

    protected void doSolution(Massive storage, double e) {
        if (multiplyExtremePoints(storage, storage.getInterval()) != 0) {
            while (stepInterval(storage) > e) {
                steps(storage);
            }
        }
        storage.setX((storage.getInterval()[0] + storage.getInterval()[1]) / 2);
    }

    private void steps(Massive storage) {
        double newInterval = newInterval(storage);
        double[] leftInterval = {storage.getInterval()[0], newInterval};
        double[] rightInterval = {newInterval, storage.getInterval()[1]};
        if (multiplyExtremePoints(storage, leftInterval) < 0)
            storage.setInterval(leftInterval[0], leftInterval[1]);
        else if (multiplyExtremePoints(storage, rightInterval) < 0)
            storage.setInterval(rightInterval[1], rightInterval[0]);
    }

    private double stepInterval(Massive storage) {
        return Math.abs(storage.getInterval()[1] - storage.getInterval()[0]) / 2;
    }

    protected double multiplyExtremePoints(Massive storage, double[] interval) {
        return productPoint(storage, interval[0]) * productPoint(storage, interval[1]);
    }

    protected abstract double newInterval(Massive storage);
}