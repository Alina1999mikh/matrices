package com.urise.storage;

import com.urise.model.Matrix;

import java.util.Arrays;

public class MethodSimpleIterations extends AbstractGaussZeidel {
    @Override
    public double[] doSolution(Matrix matrix, double[] result) {
        singleDiagonal(matrix);
        nullDiagonal(matrix);
        if (convergesIteratively(matrix)) {
            result = vectorX(matrix);
        } else {
            System.out.println("Cannot be solved by method iteration!\n");
            System.exit(0);
        }
        return result;
    }

    private boolean convergesIteratively(Matrix matrix) {
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

    private double[] vectorX(Matrix matrix) {
        int n = matrix.dimension();
        double[] vector = new double[n];
        Arrays.fill(vector, 0);
        double e;
        e = 5; //TODO exactitude
        double exactitude = 8;
        do {
            vector = calculateVector(matrix, vector);
            exactitude--;
        }
        while (e < exactitude);
        return vector;
    }

    private double[] calculateVector(Matrix matrix, double[] vector) {
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
}