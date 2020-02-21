package com.urise.storage;

import com.urise.model.Matrix;

abstract public class AbstractGaussZeidel extends AbstractSystemLinearEquations {

    protected void singleDiagonal(Matrix matrix) {
        int n = matrix.dimension();
        for (int i = 0; i < n; i++) {
            double mainElement = matrix.getMatrix()[i][i];
            for (int j = 0; j < n + 1; j++) {
                matrix.getMatrix()[i][j] /= mainElement;
            }
        }
    }
    @Override
    protected abstract double[] doSolution(Matrix matrix, double[] result);
}
