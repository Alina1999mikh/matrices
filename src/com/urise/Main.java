package com.urise;

import com.urise.storage.MethodGauss;
import com.urise.model.Matrix;
import com.urise.storage.MethodSimpleIterations;

import java.util.Scanner;

public class Main {
    private static final MethodSimpleIterations SLE = new MethodSimpleIterations();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input a dimension: ");
        int dimension = in.nextInt();
        final Matrix matrix = new Matrix(dimension);
        SLE.printMatrix(matrix);
        double[] result = SLE.solution(matrix);
        SLE.printResult(result, dimension);

    }
}
