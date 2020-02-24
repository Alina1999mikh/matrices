package com.urise.model;

public class Matrix {
    private double[][] matrix;
    private int dimension;

    public Matrix(int dimension) {
        this.dimension = dimension;
        matrix = new double[dimension][dimension + 1];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension + 1; j++) {
                matrix[i][j] = 1 + (int) (Math.random() * 20);
                if (i == j) matrix[i][j] *= 10;
            }
        }
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