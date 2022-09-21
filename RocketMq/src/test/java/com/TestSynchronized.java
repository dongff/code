package com;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-09-20 18:38
 * @modified By:
 */
public class TestSynchronized {

    public void sync() {
        synchronized (this) {
            System.out.println("sync");
        }
    }
}
