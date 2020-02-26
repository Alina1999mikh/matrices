package com.urise.storage;

import com.urise.model.Matrix;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

abstract public class AbstractGaussZeidel extends AbstractSystemLinearEquations {

    private int needExactitude;

    @Override
    protected void doSolution(Matrix matrix) {
        doDiagonal(matrix);
        if (checkSolution(matrix)) {
            getVectorX(matrix);
        } else {
            System.out.println("Cannot be solved by this method!\n");
            System.exit(-1);
        }
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

    protected double getSolution(Matrix matrix) {
        int n = matrix.dimension();
        double[] massiveMax = new double[n];
        double max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) massiveMax[i] = massiveMax[i] + Math.abs(matrix.getMatrix()[i][j]);
            }
            if (massiveMax[i] > max) max = massiveMax[i];
        }
        return max;
    }

    private double getB(Matrix matrix) {
        int n = matrix.dimension();
        double max = 0;
        for (int i = 0; i < n; i++) {
            if (Math.abs(matrix.getMatrix()[i][n]) > max) max = Math.abs(matrix.getMatrix()[i][n]);
        }
        return max;
    }

    private void getVectorX(Matrix matrix) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a exactitude: ");
        needExactitude = ((-1) * in.nextInt());
        double steps = qualitySteps(matrix);
        int i = 0;
        do {
            matrix.setResult(calculateVector(matrix));
            i++;
        }
        while (i < steps);
    }

    private double qualitySteps(Matrix matrix) {
        double C = getSolution(matrix);
        double B = getB(matrix);
        return Math.ceil(Math.log((1 - C) / (B * Math.pow(10, needExactitude))) / Math.log(C) + 1);
    }

    protected abstract boolean checkSolution(Matrix matrix);

    protected abstract double[] calculateVector(Matrix matrix);

    protected abstract void doDiagonal(Matrix matrix);
}