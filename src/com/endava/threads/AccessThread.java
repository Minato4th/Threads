package com.endava.threads;


import com.endava.util.ThreadMethods;

public class AccessThread extends Thread {

    private ThreadMethods methods;

    public AccessThread(ThreadMethods methods) {
        this.methods = methods;
    }

    @Override
    public void run() {

        methods.atomicIncrement();
        System.out.println("Atomic = " + methods.getAtomicInt());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        methods.primitiveIncrement();
        System.out.println("Primitive = " + methods.getPrimitiveInt());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        methods.unsyncIncrement();
        System.out.println("unsyncIncrement = " +  methods.getUnsyncMeth());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        methods.syncIncrement();
        System.out.println("syncIncrement = " +  methods.getSyncMeth());

    }
}
