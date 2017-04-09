package com.endava.threads;


/**
 * Recursive run call for creating new Thread in first Thread
 */

public class ReverseHello extends Thread {

    private int num = 50;
    private int ls = 50;

    @Override
    public void run() {

        Thread one = new Thread(() -> {
            System.out.println("Hello from Thread " + ls);
            ls--;
        });

        if (--num > 0){
            run();
        }

        one.start();

        try {
            one.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
