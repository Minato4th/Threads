package com.endava.threads;


import com.endava.util.AccessThreadMethods;

public class AccessThread extends Thread {

    private AccessThreadMethods methods;

    public AccessThread(AccessThreadMethods methods) {
        this.methods = methods;
    }

    @Override
    public void run() {

        methods.atomicIncrement();

        methods.primitiveIncrement();

        methods.unsyncIncrement();

        methods.syncIncrement();

    }
}
