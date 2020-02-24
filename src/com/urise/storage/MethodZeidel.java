package com.urise.storage;

import com.urise.model.Matrix;

public class MethodZeidel extends AbstractGaussZeidel {

    @Override
    protected void doDiagonal(Matrix matrix) {
        singleDiagonal(matrix);
    }

    @Override
    protected boolean checkSolution(Matrix matrix) {
        return true;
    }

    protected double[] calculateVector(Matrix matrix, double[] result) {
        for (int i = 0; i < matrix.dimension(); i++) {
            result[i] = matrix.getMatrix()[i][matrix.dimension()] - calculateLineElements(matrix, i, result);
        }
        return result;
    }

    private double calculateLineElements(Matrix matrix, int indexNotMultiply, double[] result) {
        int i = 0;
        double sum = 0;
        if (indexNotMultiply == 0) i = 1;
        while (i < matrix.dimension()) {
            sum = sum + matrix.getMatrix()[indexNotMultiply][i] * result[i];
            i++;
            if (i == indexNotMultiply) i++;
        }
        return sum;
    }
}