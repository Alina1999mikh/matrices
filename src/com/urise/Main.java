package com.urise;

import com.urise.Storage.methodGauss;
import com.urise.model.Matrix;

public class Main {
    private static final methodGauss SLE = new methodGauss();

    public static void main(String[] args) {
        Matrix matrix = new Matrix(2);
        SLE.solution(matrix);
    }
}
