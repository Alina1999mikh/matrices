package com.urise.Solution.LinearEquations;

import com.urise.Solution.LinearEquations.AbstractGaussZeidel;
import com.urise.model.Matrix;

public class MethodSimpleIterations extends AbstractGaussZeidel {

    @Override
    protected void doDiagonal(Matrix storage) {
        singleDiagonal(storage);
        nullDiagonal(storage);
    }

    @Override
    protected boolean checkSolution(Matrix storage) {
        return getSolution(storage) < 1;
    }

    @Override
    protected double[] calculateVector(Matrix storage) {
        int n = storage.dimension();
        double[] vectorResult = new double[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vectorResult[i] = vectorResult[i] + (storage.getMatrix()[i][j] * storage.getResult()[j]);
            }
            vectorResult[i] = storage.getMatrix()[i][n] - vectorResult[i];
        }
        return vectorResult;
    }

    private void nullDiagonal(Matrix storage) {
        for (int i = 0; i < storage.dimension(); i++) {
            storage.getMatrix()[i][i]--;
        }
    }
}