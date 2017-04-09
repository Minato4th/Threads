package com.endava.threads;

import com.endava.util.Initializer;

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

        for (int i = lo; i < hi; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }

        System.out.println(Thread.currentThread() + "     Max number : " + max );

        try {
            Thread.sleep(1000 + (int)Math.random()*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Initializer.maxarr.add(max);

    }

}
