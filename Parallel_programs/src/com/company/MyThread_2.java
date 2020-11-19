package com.company;

public class MyThread_2 extends Thread {
    private long[] arr;
    private int firstIndex;
    private int secondIndex;
    private long partialSum;

    public MyThread_2(long[] arr, int firstIndex, int secondIndex) {
        this.arr = arr;
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
    }

    public long getPartialSum() {
        return this.partialSum;
    }

    @Override
    public void run() {
        if (firstIndex == secondIndex) {
            partialSum = arr[firstIndex];
        } else {
            partialSum = arr[firstIndex] + arr[secondIndex];
        }
    }
}
