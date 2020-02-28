package com.urise.Solution.LinearEquations;

import com.urise.Solution.LinearEquations.AbstractGaussZeidel;
import com.urise.model.Matrix;

public class MethodZeidel extends AbstractGaussZeidel {

    @Override
    protected void doDiagonal(Matrix storage) {
        singleDiagonal(storage);
    }

    @Override
    protected boolean checkSolution(Matrix storage) {
        return true;
    }

    protected double[] calculateVector(Matrix storage) {
        double[] result = new double[storage.dimension()];
        for (int i = 0; i < storage.dimension(); i++) {
            result[i] = storage.getMatrix()[i][storage.dimension()] - calculateLineElements(storage, i);
        }
        return result;
    }

    private double calculateLineElements(Matrix storage, int indexNotMultiply) {
        int i = 0;
        double sum = 0;
        if (indexNotMultiply == 0) i = 1;
        while (i < storage.dimension()) {
            sum = sum + storage.getMatrix()[indexNotMultiply][i] * storage.getResult()[i];
            i++;
            if (i == indexNotMultiply) i++;
        }
        return sum;
    }
}