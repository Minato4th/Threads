package com.endava;

import com.endava.threads.ReverseHello;
import com.endava.util.Initializer;

/**
 * 4/7/2017
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Initializer initializer = new Initializer();

        //int[] arr = initializer.randomGenerator();
        //System.out.println("Max Value " + initializer.maxValue(arr));
        //initializer.ReverseHello(50);

        Thread one = new Thread(new ReverseHello());
        one.run();
    }
}
