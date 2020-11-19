package com.company;

public class PrintSum implements Runnable{
    public static long sum;
    public void printSum() {
        System.out.println(this.sum);
    }

    @Override
    public void run() {
        printSum();
    }
}
