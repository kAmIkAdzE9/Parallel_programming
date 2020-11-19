package com.company;

public class MyThread extends Thread {
    private long[] arr;
    private int firstIndex;
    private int secondIndex;
    private long partialSum;

    public MyThread(long[] arr, int firstIndex, int secondIndex) {
        this.arr = arr;
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
    }

    public long getPartialSum() {
        return this.partialSum;
    }

    private void calculateSum () {
        partialSum = 0;
        for (int i = firstIndex; i < secondIndex; i++) {
            partialSum += arr[i];
        }
    }

    @Override
    public void run() {
       calculateSum();
    }
}
