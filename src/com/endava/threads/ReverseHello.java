package com.endava.threads;


/**
 * Recursive run call for creating new Thread in first Thread
 */

public class ReverseHello extends Thread {

    private int num;
    private int ls;

    public ReverseHello(int num) {
        this.num = num;
        this.ls = num;
    }

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
