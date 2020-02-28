package com.urise;

import com.urise.Solution.LinearEquations.MethodGauss;
import com.urise.Solution.NoLinearEquations.MethodHalfDivision;
import com.urise.Solution.NoLinearEquations.MethodHoard;
import com.urise.Solution.NoLinearEquations.MethodNuton;
import com.urise.model.Massive;
import com.urise.model.Matrix;
import com.urise.Solution.LinearEquations.MethodSimpleIterations;
import com.urise.Solution.LinearEquations.MethodZeidel;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner inType = new Scanner(System.in);
        System.out.print("\nВведите одну из команд - ( 1- линейное уравнение | 2- нелинейное уравнение | exit ): ");
        String typeEquations = inType.nextLine();
        switch (typeEquations) {
            case "1":
                Scanner in = new Scanner(System.in);
                System.out.print("Input a dimension: ");
                int dimension = in.nextInt();
                final Matrix matrix = new Matrix(dimension);
                switchLinear(matrix);
            case "2":
                final Massive massive = new Massive();
                switchLNoLinear(massive);
            case "exit":
                System.out.println("\nSee you later!\n");
                System.exit(0);
            default:
                System.out.println("Неверная команда.");
                break;
        }
    }

    private static void switchLinear(Matrix matrix) {
        while (true) {
            Scanner inLine = new Scanner(System.in);
            System.out.print("\nВыберите метод - ( 1- Гаусса | 2- простых итераций | 3- Зейделя | exit ): ");
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
                case "4":
                    final Massive m = new Massive();
                    final MethodNuton nuton = new MethodNuton();
                    nuton.printMatrix(m);
                    m.setInterval(1, 2);
                    nuton.solution(m);
                    nuton.printResult(m);
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

    private static void switchLNoLinear(Massive massive) {
        while (true) {
            Scanner inLine = new Scanner(System.in);
            System.out.print("\nВыберите метод - ( 1- половинного деления | 2- Хорд | 3-Ньютона | exit ): ");
            String command = inLine.nextLine();

            Scanner inInterval = new Scanner(System.in);
            System.out.print("\nВведите интервал - ");
            double intervalA = inInterval.nextDouble();
            double intervalB = inInterval.nextDouble();
            massive.setInterval(intervalA, intervalB);
            switch (command) {
                case "1":
                    final MethodHalfDivision halfDivision = new MethodHalfDivision();
                    halfDivision.printMatrix(massive);
                    halfDivision.solution(massive);
                    halfDivision.printResult(massive);
                    break;
                case "2":
                    final MethodHoard hoard = new MethodHoard();
                    hoard.printMatrix(massive);
                    hoard.solution(massive);
                    hoard.printResult(massive);
                    break;
                case "3":
                    final MethodNuton nuton = new MethodNuton();
                    nuton.printMatrix(massive);
                    nuton.solution(massive);
                    nuton.printResult(massive);
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