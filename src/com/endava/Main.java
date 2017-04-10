package com.endava;

import com.endava.service.Menu;
import com.endava.threads.AccessThread;
import com.endava.threads.ReverseHello;
import com.endava.util.Initializer;
import com.endava.util.ThreadMethods;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 4/7/2017
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        /*Initializer initializer = new Initializer();

        int[] arr = initializer.randomGenerator();
        System.out.println("Max Value " + initializer.maxValue(arr));

        Thread.sleep(1000);

        /*Thread one = new Thread(new ReverseHello(50));
        one.start();

        Thread.sleep(1000);

        ThreadMethods thread = new ThreadMethods();

        for (int i = 0; i < 3; i++) {
            AccessThread act1 = new AccessThread(thread);
            act1.start();
        }

        Thread.sleep(1000);
        System.out.println(thread.getPrimitiveInt() + " = " + thread.getAtomicInt());
        System.out.println(thread.getUnsyncMeth() + " = " + thread.getSyncMeth());*/

        Runnable tr = () -> {
            AtomicInteger n = new AtomicInteger();

        };

        Menu m = new Menu();
        m.mainMenu();

    }
}
