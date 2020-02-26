package com.urise;

import com.urise.storage.MethodGauss;
import com.urise.model.Matrix;
import com.urise.storage.MethodSimpleIterations;
import com.urise.storage.MethodZeidel;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input a dimension: ");
        int dimension = in.nextInt();
        final Matrix matrix = new Matrix(dimension);
        while (true) {
            Scanner inLine = new Scanner(System.in);
            System.out.print("\nВведите одну из команд - ( 1-Gauss | 2-Simple iteration | 3-Zeidel | exit ): ");
            String command = inLine.nextLine();

            switch (command) {
                case "1":
                    final MethodGauss gauss = new MethodGauss();
                    gauss.printMatrix(matrix);
                    gauss.solution(matrix);

                    gauss.printResult(matrix);
                    break;
                case "2":
                    final MethodSimpleIterations simpleIteration = new MethodSimpleIterations();
                    simpleIteration.printMatrix(matrix);
                    simpleIteration.solution(matrix);
                    simpleIteration.printResult(matrix);
                    break;
                case "3":
                    final MethodZeidel zeidel = new MethodZeidel();
                    zeidel.printMatrix(matrix);
                    zeidel.solution(matrix);
                    zeidel.printResult(matrix);
                    break;
                case "exit":
                    System.out.println("\nSee you later!\n");
                    System.exit(0);
                default:
                    System.out.println("Неверная команда.");
                    break;
            }
        }
    }
}