package com.urise.model;

public class Matrix {
    public double[][] matrix;
    private int dimension;

    public Matrix(int dimension) {
        this.dimension = dimension;
        matrix = new double[dimension][dimension + 1];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension + 1; j++) {
                matrix[i][j] = 1 + (int) (Math.random() * 20);
            }
        }
    }

    public int dimension() {
        return dimension;
    }
}
