package com.company;

public class ParallelWorker extends Thread {
    private int[] arr;
    private int firstIndex;
    private int secondIndex;
    private long partialSum;

    public ParallelWorker(int[] arr, int firstIndex, int secondIndex) {
        this.arr = arr;
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
    }

    public long getPartialSum() {
        return this.partialSum;
    }

    @Override
    public void run() {
        partialSum = 0;
        for (int i = firstIndex; i < secondIndex; i++) {
            partialSum += arr[i];
        }
    }
}
