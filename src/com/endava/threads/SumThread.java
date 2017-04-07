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

    /*public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int sum = sum(arr);
        System.out.println("Sum: " + sum);
    }*/

}
