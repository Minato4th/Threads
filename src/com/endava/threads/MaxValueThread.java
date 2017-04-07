package com.endava.threads;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * 4/7/2017
 */
public class MaxValueThread extends Thread{
    private int[] arr;
    private int lo, hi;
    private int max;

    public MaxValueThread(int[] arr, int lo, int hi) {
        this.arr = arr;
        this.lo = lo;
        this.hi = hi;
        this.max = Integer.MIN_VALUE;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = lo; i < hi; i++) {
            //System.out.println(Thread.currentThread() + "     " + arr[i]);
            //System.out.println(arr[i]);
            if (arr[i] > max){
                max = arr[i];
            }
        }

    }

    public int getMax() {
        return max;
    }
}
