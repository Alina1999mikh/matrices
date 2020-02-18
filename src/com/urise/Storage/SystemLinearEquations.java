package com.urise.Storage;

import com.urise.model.Matrix;

public class SystemLinearEquations implements Equations {

    @Override
    public void printMatrix(Matrix matrix) {
        for (int i = 0; i < matrix.dimension(); i++) {
            for (int j = 0; j < matrix.dimension() + 1; j++) {
                System.out.print(matrix.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void methodGauss(Matrix matrix) {

    }
}
