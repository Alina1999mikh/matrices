package com.urise.storage;

import com.urise.model.Matrix;

public class MethodSimpleIterations extends AbstractGaussZeidel {
    @Override
    protected void doDiagonal(Matrix matrix) {
        singleDiagonal(matrix);
        nullDiagonal(matrix);
    }

    @Override
    protected double[] calculateVector(Matrix matrix, double[] vector) {
        int n = matrix.dimension();
        double[] vectorResult = new double[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vectorResult[i] = vectorResult[i] + (matrix.getMatrix()[i][j] * vector[j]);
            }
            vectorResult[i] = matrix.getMatrix()[i][n] - vectorResult[i];
        }
        return vectorResult;
    }

    @Override
    protected boolean checkSolution(Matrix matrix) {
        int n = matrix.dimension();
        double[] massiveMax = new double[n];
        double max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                massiveMax[i] = massiveMax[i] + Math.abs(matrix.getMatrix()[i][j]);
            }
            max = massiveMax[i];
        }
        return max < 1;
    }

    private void nullDiagonal(Matrix matrix) {
        for (int i = 0; i < matrix.dimension(); i++) {
            matrix.getMatrix()[i][i]--;
        }
    }

}