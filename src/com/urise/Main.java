package com.urise;

import com.urise.model.Matrix;

public class Main {
    private final static Matrix MATRIX = new Matrix(3);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 + 1; j++) {
                System.out.print(MATRIX.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
