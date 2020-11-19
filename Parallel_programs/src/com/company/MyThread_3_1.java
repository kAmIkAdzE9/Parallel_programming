package com.company;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThread_3_1 implements  Runnable {
    private CyclicBarrier cyclicBarrier;
    private long[] arr;
    private int firstIndex;
    private int secondIndex;
    private long partialSum;

    public MyThread_3_1(CyclicBarrier cyclicBarrier, long[] arr, int firstIndex, int secondIndex) {
        this.cyclicBarrier = cyclicBarrier;
        this.arr = arr;
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
        new Thread(this).start();
    }

    public long getPartialSum() {
        return this.partialSum;
    }

    private void calculateSum() {
        partialSum = 0;
        for (int i = firstIndex; i < secondIndex; i++) {
            partialSum += arr[i];
        }
    }

    @Override
    public void run() {
        calculateSum();
        PrintSum.sum += partialSum;

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
