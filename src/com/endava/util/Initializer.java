package com.endava.util;

import com.endava.threads.MaxValueThread;
import com.endava.threads.SumThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Initializer {

    public static List<Integer> maxarr = new ArrayList<>();

    /**
     * Generate random int values in array
     *
     * @return arr filled with random numbers
     */
    public int[] randomGenerator(){
        int[] arr = new int[100];

        for (int i = 0; i < 100; i++) {
            arr[i] = (int)(Math.random()*100);
        }

        return arr;
    }


    /**
     * Sum the elements of an array.
     *
     * @param arr array to sum
     * @return sum of the array's elements
     * @throws InterruptedException shouldn't happen
     */
    public int sum(int[] arr) throws InterruptedException {
        int len = arr.length;
        int ans = 0;

        // Create and start 4 threads.
        SumThread[] ts = new SumThread[4];
        for (int i = 0; i < 4; i++) {
            ts[i] = new SumThread(arr, (i * len) / 4, ((i + 1) * len / 4));
            ts[i].start();
        }

        // Wait for the threads to finish and sum their results.
        for (int i = 0; i < 4; i++) {
            ts[i].join();
            ans += ts[i].getAns();
        }
        return ans;
    }

    /**
     * Find max elements in array, using ThreadPool with max 4 Thread in run.
     * In order to show functionality of ThreadPool, generates 10 Threads with random Thread.sleep().
     * Each Thread analyze 1/10 of the array numbers.
     *
     * @param arr array where need to find max value
     * @return max of the array's elements
     * @exception InterruptedException shouldn't happen
     */
    public int maxValue(int[] arr) throws InterruptedException {
        int max = 0;

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < arr.length/10; i++) {
            System.out.println("I am Thread " + (i + 1) + ", in the Pool queue");
            MaxValueThread maxThr = new MaxValueThread(arr, i * arr.length/10, (i+1)*arr.length/10);
            executorService.execute(maxThr);
        }

        Thread.sleep(5000);

        for (Integer maxi : maxarr) {
            if (maxi > max){
                max = maxi;
            }
        }

        executorService.shutdown();
        return max;
    }



}
