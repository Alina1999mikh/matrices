package com.urise.Solution.NoLinearEquations;

import com.urise.model.Massive;
import com.urise.model.Matrix;

import java.util.Scanner;

public class MethodNuton extends AbstractSystemNoLinearEquations {

    protected void doSolution(Massive storage, double e) {
        storage.setX(storage.getMatrix()[0] * 2);
        while (getF(storage) > e) {
            getX(storage);
        }
    }

    private void getX(Massive storage) {
        double x = storage.getX();
        x = x - ((productPoint(storage, x)) / (x * storage.getMatrix()[0] * 2));
        storage.setX(x);
        System.out.println(x);
    }

    private double getF(Massive storage){
        return (productPoint(storage, storage.getX()) / (storage.getX() * storage.getMatrix()[0] * 2));
    }
}