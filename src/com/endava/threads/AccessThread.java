package com.endava.threads;


import com.endava.util.AccessThreadMethods;

public class AccessThread extends Thread {

    private AccessThreadMethods methods;

    public AccessThread(AccessThreadMethods methods) {
        this.methods = methods;
    }

    @Override
    public void run() {
        try {
            methods.atomicIncrement();
            System.out.println("Atomic = " + methods.getAtomicInt());
            Thread.sleep(100);

            methods.primitiveIncrement();
            System.out.println("Primitive = " + methods.getPrimitiveInt());
            Thread.sleep(100);

            methods.unsyncIncrement();
            System.out.println("unsyncIncrement = " +  methods.getUnsyncMeth());
            Thread.sleep(100);

            methods.syncIncrement();
            System.out.println("syncIncrement = " +  methods.getSyncMeth());
            Thread.sleep(100);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
