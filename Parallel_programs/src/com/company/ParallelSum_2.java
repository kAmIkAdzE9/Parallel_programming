package com.company;

public class ParallelSum_2 {
    private MyThread_2[] sums;

    public ParallelSum_2(int numOfThreads) {
        this.sums = new  MyThread_2[numOfThreads];
    }

    public long getSum(long[] arr) {
        int threads;

        if (arr.length % 2 == 0) {
            threads = arr.length / 2;
        } else {
            threads = arr.length / 2 + 1;
        }

        for (int i = 0; i < threads; i++) {
            sums[i] = new MyThread_2(arr, i, arr.length - i - 1);
            sums[i].start();
        }

        try {
            for (MyThread_2 thread : sums) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.getCause();
        }

        long[] arr2 = new long[threads];

        for (int i = 0; i < threads; i++) {
            arr2[i] = sums[i].getPartialSum();
        }

        if (arr2.length > 1) {
            return getSum(arr2);
        } else {
            return arr2[0];
        }
    }
}
