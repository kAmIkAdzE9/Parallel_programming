package com.company;

public class Main {

    private static long[] createArr(int n) {
        long[] arr = new long[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    private static final int N = 10000;

    public static void main(String[] args) {
        long[] arr = createArr(N);
        int numOfThreads = 4;


	    // Task_1
        System.out.println(new ParallelSum(numOfThreads).getSum(arr));


        // Task_2
        ParallelSum_2 parallelSum_2;
        if (N % 2 == 0) {
            parallelSum_2 = new ParallelSum_2(N / 2);
        } else {
            parallelSum_2 = new ParallelSum_2(N / 2 + 1);
        }
        System.out.println(parallelSum_2.getSum(arr));


        // Task_3_1
        new Parallel_Sum_3_1(numOfThreads).getSum(arr);


        // Task_3_2

    }
}
