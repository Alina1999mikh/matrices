package com.urise;

import com.urise.storage.MethodGauss;
import com.urise.model.Matrix;
import com.urise.storage.MethodSimpleIterations;

import java.util.Scanner;


public class Main {

    public static void main(String[] args)  {

        Scanner in = new Scanner(System.in);
        System.out.print("Input a dimension: ");
        int dimension = in.nextInt();
        final Matrix matrix = new Matrix(dimension);
        while (true) {
            Scanner inLine = new Scanner(System.in);
            System.out.print("\nВведите одну из команд - ( Gauss | Simple | exit): ");
            String command = inLine.nextLine();

            switch (command) {
                case "Gauss":
                    final MethodGauss gauss = new MethodGauss();
                    gauss.printMatrix(matrix);
                    double[] result = gauss.solution(matrix);
                    gauss.printResult(result, dimension);
                    break;
                case "Simple":
                    final MethodSimpleIterations simpleIteration = new MethodSimpleIterations();
                    simpleIteration.printMatrix(matrix);
                    result = simpleIteration.solution(matrix);
                    simpleIteration.printResult(result, dimension);
                    break;
                case "exit":
                    System.out.println("See you later!\n");
                    System.exit(0);
                default:
                    System.out.println("Неверная команда.");
                    break;
            }
        }
    }
}
