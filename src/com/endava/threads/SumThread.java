package com.endava.threads;

public class SumThread extends Thread{

    private int lo, hi;
    private int[] arr;
    private int ans = 0;

    public SumThread(int[] arr, int lo, int hi) {
        this.lo = lo;
        this.hi = hi;
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = lo; i < hi; i++) {
            ans += arr[i];
        }
    }

    public int getAns() {
        return ans;
    }

}
