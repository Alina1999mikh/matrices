package com.urise.model;

public class Matrix {
    private double[][] matrix;
    private int dimension;
    public Matrix(int dimension) {
        this.dimension = dimension;
        matrix = new double[dimension][dimension + 1];
       /* for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension + 1; j++) {
                matrix[i][j] = 1 + (int) (Math.random() * 20);
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

    public int dimension() {
        return dimension;
    }
}
