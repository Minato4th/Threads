package com.endava.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 4/10/2017
 */
public class AccessThreadMethods {
    private int syncMeth;
    private int unsyncMeth;
    private int primitiveInt;
    private AtomicInteger atomicInt;

    public AccessThreadMethods() {
        atomicInt = new AtomicInteger();
    }

    public int getSyncMeth() {
        return syncMeth;
    }

    public int getUnsyncMeth() {
        return unsyncMeth;
    }

    public int getPrimitiveInt() {
        return primitiveInt;
    }

    public int getAtomicInt() {
        return atomicInt.get();
    }

    /**
     * Increments 10000 times primitive integer type
     */
    public void primitiveIncrement(){
        for (int i = 0; i < 10000; i++) {
            primitiveInt++;
        }
    }

    /**
     * Increments 10000 times AtomicInteger type
     */
    public void atomicIncrement(){
        for (int i = 0; i < 10000; i++) {
            atomicInt.getAndIncrement();
        }
    }

    /**
     * Unsynchronized method that increments 100 times primitive integer type by 5
     */
    public void unsyncIncrement(){
        for (int i = 0; i < 100; i++) {
            unsyncMeth += 5;
        }
    }

    /**
     * Synchronized method that increments 100 times primitive integer type by 5
     */
    public synchronized void syncIncrement(){
        for (int i = 0; i < 100; i++) {
            syncMeth += 5;
        }
    }
}
