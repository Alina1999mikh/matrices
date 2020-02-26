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
        System.out.println();
    }

    @Override
    public void printResult(Matrix matrix) {
        System.out.print("\nResult: ");
        for (int i = 0; i < matrix.dimension(); i++) {
            System.out.printf("%.3f ", matrix.getResult()[i]);
        }
        System.out.println();
    }

    @Override
    public void solution(Matrix immutableMatrix) {
        Matrix matrix = new Matrix(immutableMatrix);
        doSolution(matrix);
    }

    protected abstract void doSolution(Matrix matrix);
}