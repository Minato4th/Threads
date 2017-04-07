package com.endava.util;

import com.endava.threads.MaxValueThread;
import com.endava.threads.SumThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Initializer {

    /**
     * Generate random int values in array
     *
     * @return arr filled with random numbers
     */
    public int[] randomGenerator(){
        int[] arr = new int[100];

        for (int i = 0; i < 100; i++) {
            arr[i] = (int)(Math.random()*100);
            //arr[i] = i;
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
     * Find max elements in array, using ThreadPool with 4 Thread.
     *
     * @param arr array where need to find max value
     * @return max of the array's elements
     */
    public int maxValue(int[] arr) throws InterruptedException {
        int max = 0;

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < arr.length/10; i++) {
            MaxValueThread maxThr = new MaxValueThread(arr, i * arr.length/10, (i+1)*arr.length/10);
            //MaxValueThread maxThr = new MaxValueThread(arr, 0, 5);
            executorService.execute(maxThr);
            maxThr.start();
            maxThr.join();


            if (maxThr.getMax() > max){
                max = maxThr.getMax();
            }

            System.out.println(maxThr.getMax());
        }

        /*MaxValueThread maxThr = new MaxValueThread(arr, 0, 5);
        maxThr.start();
        maxThr.join();*/

        /*executorService.execute(maxThr);

        executorService.shutdown();*/
        //System.out.println(maxThr.getMax());

        return max;
    }
}
