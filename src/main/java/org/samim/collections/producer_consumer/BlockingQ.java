package org.samim.collections.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A Program to demonstrate Thread synchronisation of Producer-Consumer problem using ArrayBlockingQueue,
 * with the Consumer being slow consuming than the Producer producing.
 */
public class BlockingQ {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(1);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ExecutorService service = Executors.newCachedThreadPool();
        int maxExecution = 5;
//        int sleepTime = 500;

        Runnable producer = () -> {
            while (atomicInteger.get() < maxExecution) {
                try {
                    int random = ThreadLocalRandom.current().nextInt(1, 10000000);
                    blockingQueue.put(random);
                    System.out.println("Inserting " + random);
//                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable consumer = () -> {
            while (atomicInteger.getAndAdd(1) < maxExecution) {
                try {
//                    Thread.sleep(500);
                    Integer take = blockingQueue.take();
                    System.out.println("- Consuming " + take);
//                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        service.submit(producer);
        service.submit(consumer);
        service.shutdown();

        while (true) {
            if (service.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("--- Program complete ---");
                break;
            }
        }

    }
}
