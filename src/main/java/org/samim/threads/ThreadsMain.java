package org.samim.threads;

public class ThreadsMain {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1("Thread-1");
        thread1.start();

        Thread thread2 = new Thread(new Thread2(), "Thread-2");
        thread2.start();

        System.out.println("min val " + Integer.MIN_VALUE);

        SingletonDoubleCheckedInit doubleCheckedInit1 = SingletonDoubleCheckedInit.getInstance();
        SingletonDoubleCheckedInit doubleCheckedInit2 = SingletonDoubleCheckedInit.getInstance();
        doubleCheckedInit2.setMsg("Hello There");
        System.out.println(doubleCheckedInit1.getMsg());

        SingletonEagerInit eagerInit1 = SingletonEagerInit.getInstance();
        SingletonEagerInit eagerInit2 = SingletonEagerInit.getInstance();
        eagerInit2.setMsg("Hello Team");
        System.out.println(eagerInit1.getMsg());
    }
}