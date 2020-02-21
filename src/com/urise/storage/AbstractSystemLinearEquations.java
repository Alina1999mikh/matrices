package com.urise.storage;

import com.urise.model.Matrix;

abstract public class AbstractSystemLinearEquations implements Equations {

    @Override
    public void printMatrix(Matrix matrix) {
        for (int i = 0; i < matrix.dimension(); i++) {
            for (int j = 0; j < matrix.dimension() + 1; j++) {
                System.out.printf("%.2f ", matrix.getMatrix()[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public void printResult(double[] result, int n) {
        System.out.print("\nResult: ");
        for (int i = 0; i < n; i++) System.out.printf("%.3f ", result[i]);
        System.out.println();
    }

    @Override
    public double[] solution(Matrix immutableMatrix){
        Matrix matrix = new Matrix(immutableMatrix);
        double[] result = new double[matrix.dimension()];
        return doSolution(matrix,result);
    }

    protected abstract double[] doSolution(Matrix matrix, double[] result);
}