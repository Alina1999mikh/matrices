package com.urise.storage;

import com.urise.model.Matrix;

public class methodGauss extends SystemLinearEquations {
    @Override
    public double[] solution(Matrix matrix) {
        printMatrix(matrix);
        int top = 0;
        int n = matrix.dimension();
        int m = n + 1;
        while (top < n) {
            int max = getIndexMaxFirstElement(matrix.getMatrix(), n, top);
            if (max != top) changeLine(matrix.getMatrix(), max, m, top);
            normalize(matrix.getMatrix(), n, top);
            subtractTopLine(matrix.getMatrix(), n, top);
            top++;
        }
        printMatrix(matrix);
        double[] result = new double[n];
        reverse(matrix.getMatrix(), result, n);
        return result;
    }

    private int getIndexMaxFirstElement(double[][] matrix, int n, int top) {
        int max = top;
        for (int i = top + 1; i < n; i++) {
            if (Math.abs(matrix[i][top]) > Math.abs(matrix[max][top])) {
                max = i;
            }
        }
        return max;
    }

    private void changeLine(double[][] matrix, int max, int m, int top) {
        for (int i = top; i < m; i++) {
            double temp = matrix[max][i];
            matrix[max][i] = matrix[top][i];
            matrix[top][i] = temp;
        }
    }

    private void normalize(double[][] matrix, int n, int top) {
        int m = n + 1;
        for (int i = top; i < n; i++) {
            for (int j = top + 1; j < m; j++) {
                matrix[i][j] = matrix[i][j] / matrix[i][top];
            }
        }
        for (int i = top; i < n; i++) {
            matrix[i][top] = matrix[i][top] / matrix[i][top];
        }
        System.out.println();
    }

    private void subtractTopLine(double[][] matrix, int n, int top) {
        int m = n + 1;
        for (int i = top + 1; i < n; i++) {
            for (int j = top; j < m; j++) {
                matrix[i][j] = matrix[i][j] - matrix[top][j];
            }
        }
    }

    private void reverse(double[][] matrix, double[] result, int n) {
        int index;
        for (index = n - 1; index >= 0; index--) {
            result[index] = matrix[index][n];
            for (int i = 0; i < index; i++)
                matrix[i][n] = matrix[i][n] - matrix[i][index] * result[index];
        }
    }
}
