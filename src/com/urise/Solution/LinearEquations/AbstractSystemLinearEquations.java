package com.urise.Solution.LinearEquations;

import com.urise.Solution.SolutionEquations;
import com.urise.model.Matrix;

abstract public class AbstractSystemLinearEquations implements SolutionEquations {

    @Override
    public void printMatrix(Object objectStorage) {
        Matrix storage = (Matrix) objectStorage;
        for (int i = 0; i < storage.dimension(); i++) {
            for (int j = 0; j < storage.dimension() + 1; j++) {
                System.out.printf("%.2f ", storage.getMatrix()[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void printResult(Object objectStorage) {
        Matrix storage = (Matrix) objectStorage;
        System.out.print("\nРезультат: ");
        for (int i = 0; i < storage.dimension(); i++) {
            System.out.printf("%.3f ", storage.getResult()[i]);
        }
        System.out.println();
    }

    @Override
    public void solution(Object immutableStorage) {
        Matrix storage = new Matrix((Matrix) immutableStorage);
        doSolution(storage);
    }

    protected abstract void doSolution(Matrix storage);
}