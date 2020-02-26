package com.urise.model;

public class Matrix {
    private double[][] matrix;
    private int dimension;
    private static double[] result;

    public Matrix(int dimension) {
        this.dimension = dimension;
        this.matrix = new double[dimension][dimension + 1];
        result = new double[dimension()];

      /*  for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension + 1; j++) {
                matrix[i][j] = 1 + (int) (Math.random() * 20);
                if (i == j) matrix[i][j] *= 10;
            }
        }*/
        matrix[0][0] = 5;
        matrix[0][1] = -1;
        matrix[0][2] = 2;
        matrix[0][3] = 3;
        matrix[1][0] = -2;
        matrix[1][1] = -10;
        matrix[1][2] = 3;
        matrix[1][3] = -4;
        matrix[2][0] = 1;
        matrix[2][1] = 2;
        matrix[2][2] = 5;
        matrix[2][3] = 12;
    }

    public Matrix(Matrix matrix) {
        this.dimension = matrix.dimension;
        this.matrix = new double[dimension][dimension + 1];
        result = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension + 1; j++) {
                assert false;
                this.matrix[i][j] = matrix.matrix[i][j];
            }
        }
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public double[] getResult() {
        return result;
    }

    public void setResult(double[] result2) {
        if (dimension >= 0) System.arraycopy(result2, 0, result, 0, dimension);

    }

    public int dimension() {
        return dimension;
    }
}