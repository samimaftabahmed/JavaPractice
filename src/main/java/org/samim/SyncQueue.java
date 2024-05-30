package org.samim;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * A Program to demonstrate Thread synchronisation of Producer-Consumer problem using SynchronousQueue,
 * with the Consumer being slow consuming than the Producer producing.
 */
public class SyncQueue {

    public static void main(String[] args) {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>(true);

        Runnable producer = () -> {
            int value = ThreadLocalRandom.current().nextInt(1, 10000000);
            try {
//                queue.put(value);
//                System.out.println("Value put: " + value);

                // offer() is similar to put() except it returns a boolean value stating whether the value is really inserted to the queue.
                boolean status = queue.offer(value);
                System.out.println("Value offered: %s, status: %s ".formatted(value, status));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        Runnable consumer = () -> {
            try {
                Integer take = queue.take();
                System.out.println("---- Value take: " + take);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        ExecutorService service = Executors.newCachedThreadPool();
        final int maxExecution = 5;

        Thread producerThread = new Thread(() -> {
            int producerCount = 0;
            while (true) {
                if (producerCount == maxExecution) {
                    break;
                }

                producerCount++;
                service.submit(producer);
                int random = ThreadLocalRandom.current().nextInt(1, 3);
                try {
                    System.out.println("Sleeping Producer Thread for %s seconds".formatted(random));
                    TimeUnit.SECONDS.sleep(random);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumerThread = new Thread(() -> {
            int consumerCount = 0;
            while (true) {
                if (consumerCount == maxExecution) {
                    service.shutdown();
                    break;
                }
                service.submit(consumer);
                consumerCount++;
                int random = ThreadLocalRandom.current().nextInt(2, 8);
                try {
                    System.out.println("- Sleeping Consumer Thread for %s seconds".formatted(random));
                    TimeUnit.SECONDS.sleep(random);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producerThread.setName("Producer");
        producerThread.start();
        consumerThread.setName("Consumer");
        consumerThread.start();

        try {
            // waiting for the sub threads to complete before the main thread
            producerThread.join();
            consumerThread.join();
            System.out.println("----- Program complete -----");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
