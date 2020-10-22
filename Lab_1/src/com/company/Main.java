package com.company;

public class Main {

    private static int[] createArr(int n) {
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        return arr;
    }

    private static final int N = 1000000;

    public static void main(String[] args) {
        ParallelSum parallelSum = new ParallelSum(4);
        System.out.println(parallelSum.getSum(createArr(N)));
    }
}
