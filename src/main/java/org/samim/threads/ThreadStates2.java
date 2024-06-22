package org.samim.threads;

/**
 * Program to demonstrate Thread Synchronisation and their states during the process.
 */
public class ThreadStates2 {
    public static void main(String[] args) throws InterruptedException {
        Object object1 = new Object();
        Object object2 = new Object();
        Object object3 = new Object();

        Thread thread1 = new Thread(new SynchroniseThread(object1, object2), "thread1");
        Thread thread2 = new Thread(new SynchroniseThread(object2, object3), "thread2");

        Thread monitorThread = getMonitorThread(thread1, thread2);
        monitorThread.start();

        thread1.start();
        Thread.sleep(2000);

        thread2.start();
        Thread.sleep(2000);
    }

    static Thread getMonitorThread(Thread thread1, Thread thread2) {
        return new Thread(() -> {
            while (true) {
                Thread.State state1 = thread1.getState();
                Thread.State state2 = thread2.getState();
                System.out.println("--" + Thread.currentThread().getName() +
                        " state1: " + state1 + ", state2: " + state2);
                if (state1 == Thread.State.TERMINATED && state2 == Thread.State.TERMINATED) {
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Monitor Thread");
    }

    static class SynchroniseThread implements Runnable {
        private final Object object1;
        private final Object object2;

        public SynchroniseThread(Object o1, Object o2) {
            this.object1 = o1;
            this.object2 = o2;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + " acquire lock on " + object1);
            synchronized (object1) {
                System.out.println(name + " acquired lock on " + object1);
                //calling work() method
                work();
            }
            System.out.println(name + " RELEASED lock of " + object1);
            System.out.println(name + " acquire lock on " + object2);
            synchronized (object2) {
                System.out.println(name + " acquire lock on " + object2);
                work();
            }
            System.out.println(name + " RELEASED lock of " + object2);
            System.out.println(name + " execution is completed.");
        }

        private void work() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
