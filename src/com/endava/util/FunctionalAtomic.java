package com.endava.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created in order to call AtomicInteger methods
 */
public interface FunctionalAtomic {

    int incrementAndGet(AtomicInteger atomicInteger);
}
