package com.urise.Solution.LinearEquations;

import com.urise.Solution.LinearEquations.AbstractSystemLinearEquations;
import com.urise.model.Matrix;

public class MethodGauss extends AbstractSystemLinearEquations {

    @Override
    public void doSolution(Matrix storage) {
        int top = 0;
        int n = storage.dimension();
        while (top < n) {
            int max = getIndexMaxFirstElement(storage, top);
            if (max != top) changeLine(storage, max, top);
            divideTopElement(storage, top);
            subtractTopLine(storage, top);
            top++;
        }
        reverse(storage);
    }

    private int getIndexMaxFirstElement(Matrix storage, int top) {
        int max = top;
        int n = storage.dimension();
        for (int i = top + 1; i < n; i++) {
            if (Math.abs(storage.getMatrix()[i][top]) > Math.abs(storage.getMatrix()[max][top])) {
                max = i;
            }
        }
        return max;
    }

    private void changeLine(Matrix storage, int max, int top) {
        int m = storage.dimension() + 1;
        for (int i = top; i < m; i++) {
            double temp = storage.getMatrix()[max][i];
            storage.getMatrix()[max][i] = storage.getMatrix()[top][i];
            storage.getMatrix()[top][i] = temp;
        }
    }

    private void divideTopElement(Matrix storage, int top) {
        int n = storage.dimension();
        for (int i = top; i < n; i++) {
            for (int j = top + 1; j < n + 1; j++) {
                storage.getMatrix()[i][j] /= storage.getMatrix()[i][top];
            }
        }
    }

    private void subtractTopLine(Matrix storage, int top) {
        int n = storage.dimension();
        for (int i = top + 1; i < n; i++) {
            for (int j = top; j < n + 1; j++) {
                storage.getMatrix()[i][j] = storage.getMatrix()[i][j] - storage.getMatrix()[top][j];
            }
        }
    }

    private void reverse(Matrix storage) {
        int index;
        int n = storage.dimension();
        double[] result = new double[n];
        for (index = n - 1; index >= 0; index--) {
            result[index] = storage.getMatrix()[index][n];
            for (int i = 0; i < index; i++) {
                storage.getMatrix()[i][n] = storage.getMatrix()[i][n] - storage.getMatrix()[i][index] * result[index];
            }
        }
        storage.setResult(result);
    }
}