package com.urise.model;

import java.util.Scanner;

public class Massive {
    private double[] matrix;
    private int dimension;
    private double[] interval=new double[2];
    private double x, result;

    public Massive() {
        this.dimension = 1;
        matrix = new double[dimension+2];
        System.out.println("Введите коэффициенты - ");
        Scanner in = new Scanner(System.in);
        setMatrix(0, in.nextInt());
        setMatrix(1, in.nextInt());
        setMatrix(2, in.nextInt());
        Scanner inInterval = new Scanner(System.in);
        System.out.print("\nВведите интервал - ");
        double intervalA = inInterval.nextDouble();
        double intervalB = inInterval.nextDouble();
        setInterval(intervalA, intervalB);
        if(matrix[2]!=0) {
            matrix[1]=matrix[1]-matrix[2];
            matrix[2]=0;
        }
    }

    public void setX(double x){
        this.x=x;
        this.result=(matrix[0] * Math.pow(x, 2) + matrix[1]);
    }

    public double getX(){
        return x;
    }

    public double getResult(){
        return result;
    }

    public void setInterval(double a, double b){
        this.interval[0]=a;
        this.interval[1]=b;
    }

    public double[] getInterval(){
        return interval;
    }

    public double[] getMatrix() {
        return matrix;
    }

    public void setMatrix(int i, int val) {
        this.matrix[i]=val;
    }

    public int dimension() {
        return dimension;
    }
}