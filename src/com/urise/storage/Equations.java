package com.urise.storage;

import com.urise.model.Matrix;

public interface Equations {
    void printMatrix(Matrix matrix);

    double[] solution(Matrix matrix);

    void printResult(double[] result);
}