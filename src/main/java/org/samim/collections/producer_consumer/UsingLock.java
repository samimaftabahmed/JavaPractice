package org.samim.collections.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class UsingLock {

    private static final int MAX_SIZE = 1;
    private static final Queue<Integer> QUEUE = new LinkedList<>();

    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition notFull = lock.newCondition();
    private static final Condition notEmpty = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger producerCount = new AtomicInteger(0);
        AtomicInteger consumerCount = new AtomicInteger(0);

        Runnable producer = () -> {
            try {
                while (producerCount.get() < 10) {
                    int i = ThreadLocalRandom.current().nextInt(1, 1000000);
                    put(i);
                    producerCount.addAndGet(1);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable consumer = () -> {
            try {
                while (consumerCount.get() < 10) {
                    take();
                    consumerCount.addAndGet(1);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread p = new Thread(producer);
        Thread c = new Thread(consumer);
        p.start();
        c.start();

        p.join();
        c.join();
        System.out.println("--- Program Complete ---");
    }

    private static void put(Integer i) throws InterruptedException {
        lock.lock();
        try {
            if (QUEUE.size() == MAX_SIZE) {
                notFull.await();
            }

            // While using java.util.concurrent.locks.Condition, always use await-signalAll instead of wait-notify.
            // Also do not mis and match them.

            QUEUE.add(i);
            System.out.println("Inserted: " + i);
            notEmpty.signalAll();

        } finally {
            lock.unlock();
        }
    }

    private static Integer take() throws InterruptedException {
        lock.lock();
        Integer remove;
        try {
            if (QUEUE.isEmpty()) {
                notEmpty.await();
            }

            remove = QUEUE.remove();
            System.out.println("- Removed: " + remove);
            notFull.signalAll();

        } finally {
            lock.unlock();
        }
        return remove;
    }

}
