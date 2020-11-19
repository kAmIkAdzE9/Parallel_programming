package com.company;

public class ParallelSum {
    private  MyThread[] sums;
    private int numOfThreads;

    public ParallelSum(int numOfThreads) {
        this.numOfThreads = numOfThreads;
        this.sums = new MyThread[numOfThreads];
    }

    public long getSum(long[] arr) {
        int step = (int) Math.ceil(arr.length * 1.0 / numOfThreads);

        for (int i = 0; i < numOfThreads; i++) {
            sums[i] = new MyThread(arr, i * step, (i + 1) * step);
            sums[i].start();
        }

        try {
            for(MyThread worker : sums) {
                worker.join();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        long total = 0;

        for(MyThread worker : sums) {
            total += worker.getPartialSum();
        }

        return total;
    }
}
