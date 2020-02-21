package com.urise.storage;

import com.urise.model.Matrix;

import java.util.Scanner;

abstract public class AbstractGaussZeidel extends AbstractSystemLinearEquations {

    @Override
    protected double[] doSolution(Matrix matrix, double[] result) {
        doDiagonal(matrix);
        if (checkSolution(matrix)) {
            result = getVectorX(matrix, result);
        } else {
            System.out.println("Cannot be solved by this method!\n");
            System.exit(0);
        }
        return result;
    }

    protected void singleDiagonal(Matrix matrix) {
        int n = matrix.dimension();
        for (int i = 0; i < n; i++) {
            double mainElement = matrix.getMatrix()[i][i];
            for (int j = 0; j < n + 1; j++) {
                matrix.getMatrix()[i][j] /= mainElement;
            }
        }
    }

    protected double[] getVectorX(Matrix matrix, double[] result) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a exactitude: ");
        double e = ((-1)*in.nextInt()-1);
        double exactitude = 0;
        do {
            result = calculateVector(matrix, result);
            exactitude++;
        }
        while (e > exactitude);
        return result;
    }

    protected abstract double[] calculateVector(Matrix matrix, double[] result);

    protected abstract void doDiagonal(Matrix matrix);

    protected abstract boolean checkSolution(Matrix matrix);

}
