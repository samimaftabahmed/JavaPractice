package org.samim.threads;

/**
 * Program to create a Deadlock.
 */
public class DeadLockSimulation {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main starting");
        String lock1 = "john";
        String lock2 = "doe";

        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " lock1 acquired");

                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " lock2 acquired");
                }
            }
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " lock2 acquired");

                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + " lock1 acquired");
                }
            }
        }, "Thread-2");

        Thread threadMonitor = getThreadMonitor(thread1, thread2);

        threadMonitor.start();
        thread1.start();
        thread2.start();

        threadMonitor.join();
        System.out.println("Main exiting");
    }

    private static Thread getThreadMonitor(Thread thread1, Thread thread2) {
        Thread threadMonitor = new Thread(() -> {
            while (true) {
                System.out.println(thread1.getState());
                System.out.println(thread2.getState());
                System.out.println("=================");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                if (thread1.getState() == Thread.State.TERMINATED && thread2.getState() == Thread.State.TERMINATED) {
                    break;
                }
            }
        }, "Monitor-Thread");

        return threadMonitor;
    }

}
