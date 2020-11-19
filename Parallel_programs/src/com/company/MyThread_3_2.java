package com.company;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThread_3_2 implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private long[] arr;
    private int firstElemInd;
    private int lastElemInd;
    private long partSum;

    public MyThread_3_2(CyclicBarrier cyclicBarrier, long[] arr, int firstIndex, int secondIndex) {
        this.cyclicBarrier = cyclicBarrier;
        this.arr = arr;
        this.firstElemInd = firstElemInd;
        this.lastElemInd = lastElemInd;
    }

    public long getPartialSum() {
        return this.partSum;
    }

    private void calculateSum() {
        if (firstElemInd == lastElemInd) {
            partSum = arr[firstElemInd];
        } else {
            partSum = arr[firstElemInd] + arr[lastElemInd];
        }
    }

    @Override
    public void run() {
        calculateSum();
        PrintSum.sum += this.partSum;

        try {
            cyclicBarrier.await();
        }
        catch (BrokenBarrierException e) {
            System.out.println(e);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
