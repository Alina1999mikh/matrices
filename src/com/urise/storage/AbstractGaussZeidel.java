package com.urise.storage;

import com.urise.model.Matrix;

import java.math.BigDecimal;
import java.util.Scanner;

abstract public class AbstractGaussZeidel extends AbstractSystemLinearEquations {
    private int needExactitude;

    @Override
    protected double[] doSolution(Matrix matrix, double[] result) {
        doDiagonal(matrix);
        if (checkSolution(matrix)) {
            result = getVectorX(matrix, result);
        } else {
            System.out.println("Cannot be solved by this method!\n");
            return null;
        }
        return result;
    }

    @Override
    public void printResultNumber(double result) {
        BigDecimal number = new BigDecimal(result);
        number = number.setScale(needExactitude, BigDecimal.ROUND_HALF_EVEN);
        System.out.print(number+" ");
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

    private double[] getVectorX(Matrix matrix, double[] result) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a exactitude: ");
        needExactitude = ((-1) * in.nextInt());
        int exactitude;
        System.out.println(needExactitude);
        do {
            result = calculateVector(matrix, result);
            exactitude = getExactitude(result);
        }
        while (exactitude < needExactitude);
        return result;
    }

    private int getExactitude(double[] result) {
        int minExactitude = 0;
        for (int i = 0; i < result.length; i++) {
            int exactitude = 0;
            BigDecimal number = new BigDecimal(result[i]);
            number = number.setScale(needExactitude + 1, BigDecimal.ROUND_CEILING);
            BigDecimal wholePart = number.setScale(0, BigDecimal.ROUND_DOWN);
            while (wholePart.compareTo(number) != 0) {
                exactitude++;
                BigDecimal onMultiply = new BigDecimal(10);
                number = number.multiply(onMultiply);
                wholePart = number.setScale(0, BigDecimal.ROUND_DOWN);
            }
            if (i == 0) minExactitude = exactitude;
            else {
                if (exactitude < minExactitude) minExactitude = exactitude;
            }
        }
        return minExactitude;
    }

    protected abstract double[] calculateVector(Matrix matrix, double[] result);

    protected abstract void doDiagonal(Matrix matrix);

    protected abstract boolean checkSolution(Matrix matrix);
}