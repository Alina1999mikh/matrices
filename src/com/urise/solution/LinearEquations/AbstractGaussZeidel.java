package com.urise.solution.LinearEquations;

import com.urise.model.Matrix;

import java.util.Scanner;

abstract public class AbstractGaussZeidel extends AbstractSystemLinearEquations {

    private double needExactitude;

    @Override
    protected void doSolution(Matrix storage) {
        doDiagonal(storage);
        if (checkSolution(storage)) {
            getVectorX(storage);
        } else {
            System.out.println("Cannot be solved by this method!\n");
            System.exit(-1);
        }
    }

    protected void singleDiagonal(Matrix storage) {
        int n = storage.dimension();
        for (int i = 0; i < n; i++) {
            double mainElement = storage.getMatrix()[i][i];
            for (int j = 0; j < n + 1; j++) {
                storage.getMatrix()[i][j] /= mainElement;
            }
        }
    }

    protected double getSolution(Matrix storage) {
        int n = storage.dimension();
        double[] massiveMax = new double[n];
        double max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) massiveMax[i] = massiveMax[i] + Math.abs(storage.getMatrix()[i][j]);
            }
            if (massiveMax[i] > max) max = massiveMax[i];
        }
        return max;
    }

    private double getB(Matrix storage) {
        int n = storage.dimension();
        double max = 0;
        for (int i = 0; i < n; i++) {
            if (Math.abs(storage.getMatrix()[i][n]) > max) max = Math.abs(storage.getMatrix()[i][n]);
        }
        return max;
    }

    private void getVectorX(Matrix storage) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a exactitude: ");
        needExactitude = in.nextDouble();
        double steps = qualitySteps(storage);
        int i = 0;
        do {
            storage.setResult(calculateVector(storage));
            i++;
        }
        while (i < steps);
    }

    private double qualitySteps(Matrix storage) {
        double C = getSolution(storage);
        double B = getB(storage);
        return Math.ceil(Math.log((1 - C) / (B * (1 / needExactitude))) / Math.log(C) + 1);
    }

    protected abstract boolean checkSolution(Matrix storage);

    protected abstract double[] calculateVector(Matrix storage);

    protected abstract void doDiagonal(Matrix storage);
}