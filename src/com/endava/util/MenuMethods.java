package com.endava.util;

import com.endava.threads.AccessThread;
import com.endava.threads.MaxValueThread;
import com.endava.threads.ReverseHello;
import com.endava.threads.SumThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class MenuMethods {

    public static int nonAtomic;
    public static AtomicInteger atom;
    public static List<Integer> maxarr;

    public MenuMethods() {
        nonAtomic = 0;
        atom = new AtomicInteger(0);
        maxarr = new ArrayList<>();
    }

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

    /**
     * Printing "Hello from Thread#" from last run Thread to first
     *
     * @throws InterruptedException shouldn't happen
     */
    public void reverseHelloMethod() throws InterruptedException {
        ReverseHello reverseHello = new ReverseHello(50);
        reverseHello.start();

        Thread.sleep(1000);
    }

    /**
     * Printing results of running Threads with Atomic and Primitives variables,
     * Synchronized and Unsynchronized methods.
     *
     * @throws InterruptedException shouldn't happen
     */
    public void accessPriority() throws InterruptedException {
        AccessThreadMethods thread = new AccessThreadMethods();

        for (int i = 0; i < 3; i++) {
            AccessThread act1 = new AccessThread(thread);
            act1.start();
        }

        Thread.sleep(1000);
        System.out.println(thread.getPrimitiveInt() + " = " + thread.getAtomicInt());
        System.out.println(thread.getUnsyncMeth() + " = " + thread.getSyncMeth());
    }


    /**
     * Shows two different techniques of using Lambda:
     * 1. Uncommented part of method use created FunctionalAtomic interface
     * 2. Commented part of method use built-in interface UnaryOperator
     *
     * Printing difference between increments of atomic and primitive variable
     * @throws InterruptedException shouldn't happen
     */
    public void lmbdaFunctionality() throws InterruptedException {

        FunctionalAtomic functionalAtomic = AtomicInteger::incrementAndGet;
        for (int i = 0; i < 10; i++) {
            Thread r = new Thread( () -> {
                for (int j = 0; j < 1000; j++) {
                    functionalAtomic.incrementAndGet(atom);
                    nonAtomic++;
                }
            });
            r.start();
        }

        /*UnaryOperator<AtomicInteger> at = (AtomicInteger x) -> {
            x.getAndIncrement();
            return x;
        };

        for (int i = 0; i < 10; i++) {
            Thread r = new Thread( () -> {
                for (int j = 0; j < 1000; j++) {
                    at.apply(atom);
                    nonAtomic++;
                }
            });
            r.start();
        }*/

        Thread.sleep(1000);

        System.out.println(atom);
        System.out.println(nonAtomic);
    }

}
