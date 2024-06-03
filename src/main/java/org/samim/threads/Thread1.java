package org.samim.threads;

public class Thread1 extends Thread {

    public Thread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Inside Thread 1 " + Thread.currentThread());
    }
}
