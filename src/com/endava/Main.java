package com.endava;

import com.endava.util.Initializer;

/**
 * 4/7/2017
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Initializer initializer = new Initializer();

        int[] arr = initializer.randomGenerator();
        Thread.sleep(10000);
        System.out.println("Max Value " + initializer.maxValue(arr));
/*        System.out.println("Max Value " + initializer.sum(arr));*/

    }
}
