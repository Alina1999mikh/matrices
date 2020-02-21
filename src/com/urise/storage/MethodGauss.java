package com.urise.storage;

import com.urise.model.Matrix;

public class MethodGauss extends AbstractSystemLinearEquations {

    @Override
    public double[] doSolution(Matrix matrix, double[] result) {
        int top = 0;
        int n=matrix.dimension();
        while (top < n) {
            int max = getIndexMaxFirstElement(matrix, top);
            if (max != top) changeLine(matrix, max, top);
            divideTopElement(matrix, top);
            subtractTopLine(matrix, top);
            top++;
        }
        return reverse(matrix, result, n);
    }

    @Override
    protected void printResultNumber(double result) {
        System.out.printf("%.10f ", result);
    }

    private int getIndexMaxFirstElement(Matrix matrix, int top) {
        int max = top;
        int n = matrix.dimension();
        for (int i = top + 1; i < n; i++) {
            if (Math.abs(matrix.getMatrix()[i][top]) > Math.abs(matrix.getMatrix()[max][top])) {
                max = i;
            }
        }
        return max;
    }

    private void changeLine(Matrix matrix, int max, int top) {
        int m = matrix.dimension() + 1;
        for (int i = top; i < m; i++) {
            double temp = matrix.getMatrix()[max][i];
            matrix.getMatrix()[max][i] = matrix.getMatrix()[top][i];
            matrix.getMatrix()[top][i] = temp;
        }
    }

    private void divideTopElement(Matrix matrix, int top) {
        int n = matrix.dimension();
        for (int i = top; i < n; i++) {
            for (int j = top + 1; j < n + 1; j++) {
                matrix.getMatrix()[i][j] /= matrix.getMatrix()[i][top];
            }
        }
    }

    private void subtractTopLine(Matrix matrix, int top) {
        int n = matrix.dimension();
        for (int i = top + 1; i < n; i++) {
            for (int j = top; j < n+1; j++) {
                matrix.getMatrix()[i][j] = matrix.getMatrix()[i][j] - matrix.getMatrix()[top][j];
            }
        }
    }

    private double[] reverse(Matrix matrix, double[] result, int n) {
        int index;
        for (index = n - 1; index >= 0; index--) {
            result[index] = matrix.getMatrix()[index][n];
            for (int i = 0; i < index; i++)
                matrix.getMatrix()[i][n] = matrix.getMatrix()[i][n] - matrix.getMatrix()[i][index] * result[index];
        }
        return result;
    }
}
