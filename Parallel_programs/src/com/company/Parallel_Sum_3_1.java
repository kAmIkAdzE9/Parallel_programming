package com.company;

import java.util.concurrent.CyclicBarrier;

public class Parallel_Sum_3_1 {
    private int numOfThreads;

    public Parallel_Sum_3_1(int numOfThreads) {
        this.numOfThreads = numOfThreads;
    }

    public void getSum(long[] arr) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(numOfThreads, new PrintSum());

        int step = (int) Math.ceil(arr.length * 1.0 / numOfThreads);
        for (int i = 0; i < numOfThreads; i++) {
            new MyThread_3_1(cyclicBarrier, arr, i * step, (i + 1) * step);
        }
    }
}
