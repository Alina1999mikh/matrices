package com.urise.Solution.NoLinearEquations;

import com.urise.Solution.SolutionEquations;
import com.urise.model.Massive;

import java.util.Scanner;

public abstract class AbstractSystemNoLinearEquations implements SolutionEquations {

    @Override
    public void printMatrix(Object objectStorage) {
        Massive storage=(Massive) objectStorage;
        for (int j = 0; j < storage.dimension() + 2; j++) {
            if (j < storage.dimension()) {
                if (storage.getMatrix()[j] != 1)
                    System.out.printf("%.2f * x^%d + ", storage.getMatrix()[j], storage.dimension() + 1 - j);
                else System.out.printf("x^%d + ", storage.dimension() + 1 - j);
            } else {
                if (j == storage.dimension() + 1) System.out.print(" = ");
                System.out.printf("%.2f ", storage.getMatrix()[j]);
            }
        }
        System.out.println();
    }

    @Override
    public void solution(Object objectStorage) {
        Massive storage=(Massive) objectStorage;
        Scanner in = new Scanner(System.in);
        System.out.print("\nВВедите точность : ");
        double e = in.nextDouble();
        doSolution(storage, e);
    }

    @Override
    public void printResult(Object objectStorage) {
        Massive storage=(Massive) objectStorage;
        System.out.println("x= " + storage.getX());
        System.out.print("\nРезультат: ");
        System.out.printf("%.4f*(%.4f)^2 + %.4f = %.4f", storage.getMatrix()[0], storage.getX(), storage.getMatrix()[1], storage.getResult());
        System.out.println();
    }

    protected double productPoint(Massive storage, double point) {
        return storage.getMatrix()[0] * Math.pow(point, 2) + storage.getMatrix()[1];
    }

    protected abstract void doSolution(Massive storage, double e);
}
