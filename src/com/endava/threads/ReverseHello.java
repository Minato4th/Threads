package com.endava.threads;

/**
 * Create threads with messages that printed in reverse order
 * All comments is Recursive run call for the same issue
 */
public class ReverseHello extends Thread {

    private int num;
    //private int ls;

    public ReverseHello(int num) {
        this.num = num;
        //this.ls = num;
    }

    @Override
    public void run() {

        /*Thread one = new Thread(() -> {
            System.out.println("Hello from Thread " + ls);
            ls--;
        });*/

        num--;
        ReverseHello one = new ReverseHello(num);

        if (num > 0){
            one.start();
            //one.run();
        }

        try {
            one.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hello from  " + Thread.currentThread());

    }


}
