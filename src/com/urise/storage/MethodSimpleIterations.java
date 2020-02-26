package com.urise.storage;

import com.urise.model.Matrix;

public class MethodSimpleIterations extends AbstractGaussZeidel {

    @Override
    protected void doDiagonal(Matrix matrix) {
        singleDiagonal(matrix);
        nullDiagonal(matrix);
    }

    @Override
    protected boolean checkSolution(Matrix matrix) {
        return getSolution(matrix) < 1;
    }

    @Override
    protected double[] calculateVector(Matrix matrix) {
        int n = matrix.dimension();
        double[] vectorResult = new double[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vectorResult[i] = vectorResult[i] + (matrix.getMatrix()[i][j] * matrix.getResult()[j]);
            }
            vectorResult[i] = matrix.getMatrix()[i][n] - vectorResult[i];
        }
        return vectorResult;
    }

    private void nullDiagonal(Matrix matrix) {
        for (int i = 0; i < matrix.dimension(); i++) {
            matrix.getMatrix()[i][i]--;
        }
    }
}