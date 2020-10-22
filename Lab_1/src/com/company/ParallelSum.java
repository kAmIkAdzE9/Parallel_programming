package com.company;

public class ParallelSum {
    private  ParallelWorker[] sums;
    private int numOfThreads;

    public ParallelSum(int numOfThreads) {
        this.numOfThreads = numOfThreads;
        this.sums = new ParallelWorker[numOfThreads];
    }

    public long getSum(int[] arr) {
        int step = (int) Math.ceil(arr.length * 1.0 / numOfThreads);

        for (int i = 0; i < numOfThreads; i++) {
            sums[i] = new ParallelWorker(arr, i * step, (i + 1) * step);
            sums[i].start();
        }

        try {
            for(ParallelWorker worker : sums) {
                worker.join();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        long total = 0;

        for(ParallelWorker worker : sums) {
            total += worker.getPartialSum();
        }

        return total;
    }
}
