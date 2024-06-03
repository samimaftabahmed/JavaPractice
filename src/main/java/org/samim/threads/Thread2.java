package org.samim.threads;

public class Thread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Inside Thread 2 " + Thread.currentThread());
    }
}
