package com.urise;

import com.urise.storage.methodGauss;
import com.urise.model.Matrix;

import java.util.Scanner;

public class Main {
    private static final methodGauss SLE = new methodGauss();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a dimension: ");
        int dimension = in.nextInt();
        Matrix matrix = new Matrix(dimension);
        double[] result = SLE.solution(matrix);
        SLE.printResult(result, dimension);
    }
}
