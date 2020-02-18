package com.urise;

import com.urise.Storage.Equations;
import com.urise.Storage.SystemLinearEquations;
import com.urise.model.Matrix;

public class Main {
    private static final SystemLinearEquations SLE = new SystemLinearEquations();
    public static void main(String[] args) {
        Matrix matrix = new Matrix(3);
        SLE.printMatrix(matrix);
    }


}
